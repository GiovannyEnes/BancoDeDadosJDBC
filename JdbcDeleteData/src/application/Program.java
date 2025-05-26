package application;

import db.DB;

import java.sql.*;


public class Program {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;

        // under no circumstances, we can forget to specify the WHERE in a Data Update.
        try{
            conn = DB.getConnection();

            st = conn.prepareStatement(
                    "UPDATE seller "
                    + "SET BaseSalary = BaseSalary + ? "
                    + "WHERE "
                    + "(DepartmentId = ?)");
            st.setDouble(1, 200);
            st.setInt(2, 2);

            int rowsAffected = st.executeUpdate();
            System.out.println("Done! Rows affected: " + rowsAffected);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
