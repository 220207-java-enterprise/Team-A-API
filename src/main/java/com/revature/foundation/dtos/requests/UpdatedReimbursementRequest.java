//package com.revature.foundation.dtos.requests;
//
//import com.revature.foundation.daos.Re;
//import com.revature.foundation.models.*;
//
//import java.sql.Timestamp;
//
//public class UpdatedReimbursementRequest {
//
//        private String reimbId;
//        private double amount;
//        private Timestamp submitted;
//        private Timestamp resolved;
//        private String description;
//        private String receipt;
//    //TODO ctr + z
//        private String paymentId;
//        private User authorId;
//        private User resolverId;
//        private String statusId;
//        private String typeId;
//
//        public UpdatedReimbursementRequest() {
//            super();
//        }
//
//        public UpdatedReimbursementRequest(String reimbId, double amount, Timestamp submitted, Timestamp resolved, String description, String receipt, String paymentId, User authorId, User resolverId, String statusId, String typeId) {
//            this.reimbId = reimbId;
//            this.amount = amount;
//            this.submitted = submitted;
//            this.resolved = resolved;
//            this.description = description;
//            this.receipt = receipt;
//            this.paymentId = paymentId;
//            this.authorId = authorId;
//            this.resolverId = resolverId;
//            this.statusId = statusId;
//            this.typeId = typeId;
//        }
//
//        public String getReimbId() {
//            return reimbId;
//        }
//
//        public void setReimbId(String reimbId) {
//            this.reimbId = reimbId;
//        }
//
//        public double getAmount() {
//            return amount;
//        }
//
//        public void setAmount(double amount) {
//            this.amount = amount;
//        }
//
//        public Timestamp getSubmitted() {
//            return submitted;
//        }
//
//        public void setSubmitted(Timestamp submitted) {
//            this.submitted = submitted;
//        }
//
//        public Timestamp getResolved() {
//            return resolved;
//        }
//
//        public void setResolved(Timestamp resolved) {
//            this.resolved = resolved;
//        }
//
//        public String getDescription() {
//            return description;
//        }
//
//        public void setDescription(String description) {
//            this.description = description;
//        }
//
//    public String getReceipt() {
//        //TODO ctr + z  {receipt;
//        return receipt;
//    }
//
//        public void setReceipt(String receipt) {
//            this.receipt = receipt;
//        }
//
//        public String getPaymentId() {
//            return paymentId;
//        }
//
//        public void setPaymentId(String paymentId) {
//            this.paymentId = paymentId;
//        }
//
//        public User getAuthorId() {
//            return authorId;
//        }
//
//        public void setAuthorId(User authorId) {
//            this.authorId = authorId;
//        }
//
//        public User getResolverId() {
//            return resolverId;
//        }
//
//        public void setResolverId(User resolverId) {
//            this.resolverId = resolverId;
//        }
//
//        public String getStatusId() {
//            return statusId;
//        }
//
//        public void setStatusId(String statusId) {
//            this.statusId = statusId;
//        }
//
//        public String getTypeId() {
//            return typeId;
//        }
//
//        public void setTypeId(String typeId) {
//            this.typeId = typeId;
//        }
//
//    public Reimbursements extractReimbursement() {
//
//        ReimbursementsDAO daoToPullUserForRole_Id = new ReimbursementsDAO();
//        Reimbursements pulledReimbursement = daoToPullUserForRole_Id.getById(this.reimbId);
//
//        ReimbursementStatuses aStatus = new ReimbursementStatuses(pulledReimbursement.getStatusId().getStatus(), statusId);
//        ReimbursementType aType = new ReimbursementType(pulledReimbursement.getTypeId().getType(), statusId);
//        return new Reimbursements(this.reimbId, this.amount, this.submitted, this.resolved, this.description, this.receipt, this.paymentId, this.authorId, this.resolverId, aStatus, aType);
//    }
//
//    @Override
//    public String toString() {
//        return "NewReimbursementRequest{" +
//                "reimbId='" + reimbId + '\'' +
//                ", amount=" + amount +
//                ", submitted=" + submitted +
//                ", resolved=" + resolved +
//                ", description='" + description + '\'' +
//                ", receipt=" + receipt +
//                ", paymentId='" + paymentId + '\'' +
//                ", authorId='" + authorId + '\'' +
//                ", resolverId='" + resolverId + '\'' +
//                ", statusId='" + statusId + '\'' +
//                ", typeId='" + typeId + '\'' +
//                '}';
//    }
//}
