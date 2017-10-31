package service;

import model.Publisher;
import java.sql.*;
import java.util.ArrayList;
public class Publisher_Service {
    public ArrayList<Publisher> getAll(){

        ArrayList<Publisher> applySet = new ArrayList<Publisher>();
        DBConnection con = new DBConnection();
        try{
            ResultSet rs;
            String query = "select * from publisher";
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
            String query = "select " + column + " from publisher";
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
            String query = "select " + column + " from publisher";
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

    public Publisher toObject(ResultSet rs) throws SQLException{

        String publisherName = rs.getString("PublisherName");
        String address = rs.getString("Address");
        String phone = rs.getString("Phone");

        return new Publisher(publisherName, address, phone);
    }
}
