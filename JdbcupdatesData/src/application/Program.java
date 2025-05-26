package application;



import db.DB;

import java.sql.*;

public class Program {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement(
                    "UPDATE seller "
                    + "SET BaseSalary"
            );
        }
    }
}
