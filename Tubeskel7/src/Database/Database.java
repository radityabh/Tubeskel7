/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author The Keong's
 */
public class Database {
    private Statement stmt = null;
    private Connection con = null;
    private ResultSet rs = null;
    
    public Database(){
        try{
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (Exception e){
            System.out.println(e);
        }
        try{
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:system","data","data");
        } catch (Exception e){
            System.out.println(e);
        }
    }
    public ResultSet getData(String SQLString){
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQLString);
        } catch (Exception e) {
            System.out.println(e);
        }
        return  rs;
    }
    public void query(String SQLString){
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(SQLString);
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
