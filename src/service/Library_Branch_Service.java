package service;

import model.Library_Branch;
import java.sql.*;
import java.util.ArrayList;
public class Library_Branch_Service {
    public ArrayList<Library_Branch> getAll(){

        ArrayList<Library_Branch> applySet = new ArrayList<Library_Branch>();
        DBConnection con = new DBConnection();
        try{
            ResultSet rs;
            String query = "select * from library_branch";
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
            String query = "select " + column + " from library_branch";
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
            String query = "select " + column + " from library_branch";
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

    public Library_Branch toObject(ResultSet rs) throws SQLException{
        int branchID = Integer.parseInt(rs.getString("BranchID"));
        String branchName = rs.getString("BranchName");
        String branchAddress = rs.getString("BranchAddress");

        return new Library_Branch(branchID, branchName, branchAddress);
    }
}
