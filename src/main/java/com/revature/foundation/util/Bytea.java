//package com.revature.foundation.util;
//
//import java.io.ByteArrayInputStream;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.sql.Blob;
//import java.sql.SQLException;
//import java.util.Arrays;
//import java.io.UnsupportedEncodingException;
//import java.util.Base64;
//
//public class Bytea implements Blob {
//
//    private String blob;
//
//    public Bytea(String blob) {
//        this.blob = blob;
//    }
//
//    public Bytea(String blob) {
//        try {
//            String decodedString = Base64.getDecoder().decode(blob.getBytes("UTF-8"));
//            this.blob = decodedString;
//        } catch (UnsupportedEncodingException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
//
//    public String getBlob() {
//        return blob;
//    }
//
//    public void setBlob(String blob) {
//        this.blob = blob;
//    }
//
//    @Override
//    public long length() throws SQLException {
//        return 0;
//    }
//
//    @Override
//    public String getBytes(long pos, int length) throws SQLException {
//        return new byte[0];
//    }
//
//    @Override
//    public InputStream getBinaryStream() throws SQLException {
//        InputStream targetStream = new ByteArrayInputStream(this.blob);
//        return targetStream;
//    }
//
//    @Override
//    public long position(String pattern, long start) throws SQLException {
//        return 0;
//    }
//
//    @Override
//    public long position(Blob pattern, long start) throws SQLException {
//        return 0;
//    }
//
//    @Override
//    public int setBytes(long pos, String bytes) throws SQLException {
//        return 0;
//    }
//
//    @Override
//    public int setBytes(long pos, String bytes, int offset, int len) throws SQLException {
//        return 0;
//    }
//
//    @Override
//    public OutputStream setBinaryStream(long pos) throws SQLException {
//        return null;
//    }
//
//    @Override
//    public void truncate(long len) throws SQLException {
//
//    }
//
//    @Override
//    public void free() throws SQLException {
//
//    }
//
//    @Override
//    public InputStream getBinaryStream(long pos, long length) throws SQLException {
//        return null;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Bytea)) return false;
//        Bytea bytea = (Bytea) o;
//        return Arrays.equals(getBlob(), bytea.getBlob());
//    }
//
//    @Override
//    public int hashCode() {
//        return Arrays.hashCode(getBlob());
//    }
//
//    @Override
//    public String toString() {
//        return "Bytea{" +
//                "blob=" + Arrays.toString(blob) +
//                '}';
//    }
//}