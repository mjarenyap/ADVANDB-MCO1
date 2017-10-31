package service;

import model.Borrower;
import java.sql.*;
import java.util.ArrayList;
public class Borrower_Service {
    public ArrayList<Borrower> getAll(){

        ArrayList<Borrower> applySet = new ArrayList<Borrower>();
        DBConnection con = new DBConnection();
        try{
            ResultSet rs;
            String query = "select * from borrower";
            Statement stmnt = con.getConnection().createStatement();
            rs = stmnt.executeQuery(query);

            while(rs.next()){
                applySet.add(toObject(rs));
            }

            con.close();

        }catch(Exception e){
            e.printStackTrace();
        }

        return applySet;
    }

    public ArrayList<String> getColumn(String column){

        ArrayList<String> applySet = new ArrayList<>();
        DBConnection con = new DBConnection();
        try{
            ResultSet rs;
            String query = "select " + column + " from borrower";
            Statement stmnt = con.getConnection().createStatement();
            rs = stmnt.executeQuery(query);

            while(rs.next()){
                applySet.add(rs.getString(column));
            }

            con.close();

        }catch(Exception e){
            e.printStackTrace();
        }

        return applySet;
    }

    public ArrayList<Integer> getIntColumn(String column){

        ArrayList<Integer> applySet = new ArrayList<>();
        DBConnection con = new DBConnection();
        try{
            ResultSet rs;
            String query = "select " + column + " from borrower";
            Statement stmnt = con.getConnection().createStatement();
            rs = stmnt.executeQuery(query);

            while(rs.next()){
                applySet.add(Integer.parseInt(rs.getString(column)));
            }

            con.close();

        }catch(Exception e){
            e.printStackTrace();
        }

        return applySet;
    }

    public Borrower toObject(ResultSet rs) throws SQLException{
        int cardNo = Integer.parseInt(rs.getString("CardNo"));
        String lname = rs.getString("BorrowerLName");
        String fname = rs.getString("BorrowerFName");
        String address = rs.getString("Address");
        String phone = rs.getString("Phone");

        return new Borrower(cardNo, fname, lname, address, phone);
    }
}
