//package com.revature.foundation.daos;
//
//import com.revature.foundation.models.ReimbursementStatuses;
//import com.revature.foundation.models.ReimbursementType;
//import com.revature.foundation.models.Reimbursements;
//import com.revature.foundation.models.User;
//import com.revature.foundation.util.ConnectionFactory;
//import com.revature.foundation.util.exceptions.DataSourceException;
//import com.revature.foundation.util.exceptions.ResourcePersistenceException;
//import org.springframework.stereotype.Repository;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//public class ReimbursementsDAO implements CrudDAO<Reimbursements> {
//
//    private static final String rootSelect = "SELECT " +
//            "er.reimb_id, er.amount, er.submitted, er.resolved, er.description, er.receipt, er.payment_id, er.author_id, er.resolver_id, er.status_id, er.type_id , et.type, ers.status " +
//            "FROM ers_reimbursements er " +
//            "JOIN ers_reimbursement_types et " +
//            "ON er.type_id = et.type_id " +
//            "JOIN ers_reimbursement_statuses ers " +
//            "ON er.status_id = ers.status_id ";
//
//    private static final String getAllRootSelect = "SELECT * FROM ERS_REIMBURSEMENTS WHERE AUTHOR_ID = ";
//
//
//
//    public Reimbursements filterReimbursementByType(String username, String password) {
//
//
//        return null;
//
//    }
//
//    public Reimbursements filterReimbursementByStatus(String username, String password) {
//
//
//        return null;
//
//    }
//
//    @Override
//    public void save(Reimbursements newObject) {
//
//        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
//
//            conn.setAutoCommit(false);
//            PreparedStatement pstmt3 = conn.prepareStatement("INSERT INTO ers_reimbursements VALUES (?, ?, ?, ?, ?, null, ?, ?, ?, ?, ?)");
//            pstmt3.setString(1, newObject.getId());
//            pstmt3.setDouble(2, newObject.getAmount());
//            pstmt3.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
//            pstmt3.setTimestamp(4, null);
//            pstmt3.setString(5, newObject.getDescription());
////            pstmt3.setString(, null);
//            pstmt3.setString(6, newObject.getPaymentId());
//            pstmt3.setString(7, newObject.getAuthorId().toString());
//            pstmt3.setString(8, newObject.getResolverId().toString());
//            pstmt3.setString(9, newObject.getStatusId().getId());
//            pstmt3.setString(10, newObject.getTypeId().getId());
//            System.out.println(pstmt3);
//            int rowsInserted3 = pstmt3.executeUpdate();
//            if (rowsInserted3 != 1) {
//                conn.rollback();
//                throw new ResourcePersistenceException("Failed to persist user to data source");
//            }
//
//            conn.commit();
//
//        } catch (SQLException e) {
//            throw new DataSourceException(e);
//        }
//    }
//
////    @Override
////    public Reimbursements getById(String id) {
////        Reimbursements reimbursements = null;
////
////        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
////
////            PreparedStatement pstmt = conn.prepareStatement(rootSelect + "WHERE reimb_id = ?");
////            pstmt.setString(1, id);
////
////            ResultSet rs = pstmt.executeQuery();
////            if (rs.next()) {
////                reimbursements = new Reimbursements();
////
////                reimbursements.setId(rs.getString("reimb_id"));
////                reimbursements.setAmount(rs.getInt("amount"));
////                reimbursements.setSubmitted(rs.getTimestamp("submitted"));
////                reimbursements.setResolved(rs.getTimestamp("resolved"));
////                reimbursements.setDescription(rs.getString("description"));
//////                reimbursements.setReceipt(new Bytea(rs.getBytes("receipt")));
////                reimbursements.setPaymentId(rs.getString("payment_id"));
////                reimbursements.setAuthorId(rs.getObject("author_id"));
////                newObject.getAuthorId().toString()
////                reimbursements.setResolverId(rs.getString("resolver_id"));
////                reimbursements.setStatusId(new ReimbursementStatuses(rs.getString("status_id"), rs.getString("status")));
////                reimbursements.setTypeId(new ReimbursementType(rs.getString("type_id"), rs.getString("type")));
////            }
////
////        } catch (SQLException e) {
////            throw new DataSourceException(e);
////        }
////        return reimbursements;
//
////    }*/
//
////    public static Reimbursements getByIdOk(String id) {
////        Reimbursements reimbursements = null;
////
////        try (Connection conn = connectionFactory.getInstance().getConnection()) {
////
////            PreparedStatement pstmt = conn.prepareStatement(rootSelect + "WHERE reimb_id = ?");
////            pstmt.setString(1, id);
////
////            ResultSet rs = pstmt.executeQuery();
////            if (rs.next()) {
////                reimbursements = new Reimbursements();
////
////                reimbursements.setReimbId(rs.getString("reimb_id"));
////                reimbursements.setAmount(rs.getInt("amount"));
////                reimbursements.setSubmitted(rs.getString("submitted"));
////                reimbursements.setResolved(rs.getString("resolved"));
////                reimbursements.setDescription(rs.getString("description"));
//////                reimbursements.setReceipt(new Bytea(rs.getBytes("receipt")));
////                reimbursements.setPaymentId(rs.getString("payment_id"));
////                reimbursements.setAuthorId(rs.getString("author_id"));
////                reimbursements.setResolverId(rs.getString("resolver_id"));
////                reimbursements.setStatusId(new ReimbursementStatuses(rs.getString("status_id"), rs.getString("status")));
////                reimbursements.setTypeId(new ReimbursementTypes(rs.getString("type_id"), rs.getString("type")));
////            }
////
////        } catch (SQLException e) {
////            throw new DataSourceException(e);
////        }
////        return reimbursements;
////
////    }
//
//
////    public static List<Reimbursements> getAllById(String id) throws SQLException {
////        List<Reimbursements> reimbursements1 = new ArrayList<>();
////        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
////
////            conn.setAutoCommit(false);
////            PreparedStatement pstmt4 = conn.prepareStatement(rootSelect + "WHERE AUTHOR_ID = ?");
////            pstmt4.setString(1, id);
////            ResultSet rs = pstmt4.executeQuery();
////            while (rs.next()) {
////                Reimbursements reimbursement = new Reimbursements();
////                reimbursement.setId(rs.getString("reimb_id"));
////                reimbursement.setAmount(rs.getInt("amount"));
////                reimbursement.setSubmitted(rs.getTimestamp("submitted"));
////                reimbursement.setResolved(rs.getTimestamp("resolved"));
////                reimbursement.setDescription(rs.getString("description"));
//////                reimbursemets.setReceipt(new Bytea(rs.getBytes("receipt")));
////                reimbursement.setPaymentId(rs.getString("payment_id"));
////                reimbursement.setAuthorId(rs.getString("author_id"));
////                reimbursement.setResolverId(rs.getString("resolver_id"));
////                reimbursement.setStatusId(new ReimbursementStatuses(rs.getString("status_id"), rs.getString("status")));
////                reimbursement.setTypeId(new ReimbursementType(rs.getString("type_id"), rs.getString("type")));
//////                System.out.println(reimbursement);
////                reimbursements1.add(reimbursement);
////            }
////            System.out.println(reimbursements1);
////            return reimbursements1;
////        }
////    }
//    @Override
//    public List<Reimbursements> getAll() {
//        List<Reimbursements> reimbursements = new ArrayList<>();
//
//        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
//
//            ResultSet rs = conn.createStatement().executeQuery(rootSelect);
//            while (rs.next()) {
//                Reimbursements reimbursement = new Reimbursements();
//                reimbursement.setId(rs.getString("reimb_id"));
//                reimbursement.setAmount(rs.getInt("amount"));
//                reimbursement.setSubmitted(rs.getTimestamp("submitted"));
//                reimbursement.setResolved(rs.getTimestamp("resolved"));
//                reimbursement.setDescription(rs.getString("description"));
////                reimbursement.setReceipt(new Bytea(rs.getBytes("receipt")));
//                reimbursement.setPaymentId(rs.getString("payment_id"));
//                reimbursement.setAuthorId(rs.getUser("author_id"));
//                reimbursement.setResolverId(rs.getUser("resolver_id"));
//                reimbursement.setStatusId(new ReimbursementStatuses(rs.getString("status_id"), rs.getString("status")));
//                reimbursement.setTypeId(new ReimbursementType(rs.getString("type_id"), rs.getString("type")));
//                reimbursements.add(reimbursement);
//            }
//        } catch (SQLException e) {
//            throw new DataSourceException(e);
//        }
//
//        return reimbursements;
//    }
//
//   /* @Override
//    public void update(Reimbursements updatedObject) {
//
//        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
//
//            conn.setAutoCommit(false);
//            PreparedStatement pstmt = conn.prepareStatement("UPDATE ers_reimbursements " +
//                    "SET amount = ?, " +
//                    "resolved = NULL, " +
//                    "description = ?, " +
//                    "receipt = NULL, " +
//                    "payment_id = ?, " +
//                    "author_id = ?, " +
//                    "resolver_id = ?, " +
//                    "status_id = ?, " +
//                    "type_id = ? " +
//                    "WHERE reimb_id = ?");
//
//            pstmt.setDouble(1, updatedObject.getAmount());
////            pstmt.setString(2, updatedObject.getResolved());
//            pstmt.setString(2, updatedObject.getDescription());
////            pstmt.setBinaryStream(4, updatedObject.getReceipt().getBinaryStream());
//            pstmt.setString(3, updatedObject.getPaymentId());
//            pstmt.setUser(4,updatedObject.getAuthorId());
//            pstmt.setUser(5, updatedObject.getResolverId());
//            pstmt.setString(6, updatedObject.getStatusId().getStatus());
//            pstmt.setString(7, updatedObject.getTypeId().getType());
//            pstmt.setString(8, updatedObject.getId());
//
//
//
//            // TODO allow role to be updated as well
//
//            int rowsInserted = pstmt.executeUpdate();
//            if (rowsInserted != 1) {
//                throw new ResourcePersistenceException("Failed to update user data within datasource.");
//            }
//
//            conn.commit();
//
//        } catch (SQLException e) {
//            throw new DataSourceException(e);
//        }
//
//    }*/
//
//    @Override
//    public void deleteById(String id) {
//
//    }
//}
