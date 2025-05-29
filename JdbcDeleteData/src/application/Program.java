package application;

import db.DB;
import db.DBIntegretyException;

import java.sql.*;


public class Program {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;

        // under no circumstances, we can forget to specify the WHERE in a Data Update.
        try{
            conn = DB.getConnection();

            st = conn.prepareStatement(
                    "DELETE FROM department "
                    + "WHERE Id = ?  ");

            st.setInt(1, 2);

            int rowsAffected = st.executeUpdate();
            System.out.println("Done! Rows affected: " + rowsAffected);
        }
        catch(SQLException e){
            throw new DBIntegretyException(e.getMessage());
        }
        finally{
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
