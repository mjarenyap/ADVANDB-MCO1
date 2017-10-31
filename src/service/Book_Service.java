package service;

import model.Book;
import java.sql.*;
import java.util.ArrayList;
public class Book_Service {
    public ArrayList<Book> getAll(){

        ArrayList<Book> applySet = new ArrayList<Book>();
        DBConnection con = new DBConnection();
        try{
            ResultSet rs;
            String query = "select * from book";
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
            String query = "select " + column + " from book";
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
            String query = "select " + column + " from book";
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

    public Book toObject(ResultSet rs) throws SQLException{
        int bookID = Integer.parseInt(rs.getString("BookID"));
        String title = rs.getString("Title");
        String publisher = rs.getString("PublisherName");

        return new Book(bookID, title, publisher);
    }
}
