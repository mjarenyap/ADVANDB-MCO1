package service;

import model.Book_Authors;
import java.sql.*;
import java.util.ArrayList;
public class Book_Authors_Service {
    public ArrayList<Book_Authors> getAll(){

        ArrayList<Book_Authors> applySet = new ArrayList<Book_Authors>();
        DBConnection con = new DBConnection();
        try{
            ResultSet rs;
            String query = "select * from book_authors";
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
            String query = "select " + column + " from book_authors";
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
            String query = "select " + column + " from book_authors";
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

    public Book_Authors toObject(ResultSet rs) throws SQLException{
        int bookID = Integer.parseInt(rs.getString("BookID"));
        String lname = rs.getString("AuthorLastName");
        String fname = rs.getString("AuthorFirstName");

        return new Book_Authors(bookID, fname, lname);
    }
}
