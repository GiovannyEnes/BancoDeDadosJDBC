package application;

import db.DB;
import db.DbException;

import java.sql.*;


public class Program {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;

        // under no circumstances, we can forget to specify the WHERE in a Data Update.
        try{
            conn = DB.getConnection();

            conn.setAutoCommit(false);

            st = conn.createStatement();

            int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");

            /* int x = 1;

            if (x < 2){
                throw new SQLException("Fake Error");
            } */

            int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");

            conn.commit();

            System.out.println("Rows1  " + rows1);
            System.out.println("Rows2  " + rows2);
        }
        catch(SQLException e) {
            try {
                conn.rollback();
                throw new DbException("Transaction Rollback back! Caused by: " + e.getMessage());
            } catch (SQLException e1) {
                throw new DbException("Error trying to rollback! Caused by: " + e1.getMessage());
            }
        }
        finally{
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
