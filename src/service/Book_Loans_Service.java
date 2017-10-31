package service;

import model.Book_Loans;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

public class Book_Loans_Service {
    public ArrayList<Book_Loans> getAll(){

        ArrayList<Book_Loans> applySet = new ArrayList<Book_Loans>();
        DBConnection con = new DBConnection();
        try{
            ResultSet rs;
            String query = "select * from book_loans";
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
            String query = "select " + column + " from book_loans";
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
            String query = "select " + column + " from book_loans";
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

    public ArrayList<Calendar> getDateColumn(String column){

        ArrayList<Calendar> applySet = new ArrayList<>();
        DBConnection con = new DBConnection();
        try{
            ResultSet rs;
            String query = "select " + column + " from book_loans";
            Statement stmnt = con.getConnection().createStatement();
            rs = stmnt.executeQuery(query);

            while(rs.next()){
                Calendar date = Calendar.getInstance();
                String[] dbDateOut = rs.getString("DateOut").split("-");
                date.set(Integer.parseInt(dbDateOut[0]), Integer.parseInt(dbDateOut[1]), Integer.parseInt(dbDateOut[2]));

                applySet.add(date);
            }

            con.close();

        }catch(Exception e){
            e.printStackTrace();
        }

        return applySet;
    }

    public Book_Loans toObject(ResultSet rs) throws SQLException{
        int bookID = Integer.parseInt(rs.getString("BookID"));
        int branchID = Integer.parseInt(rs.getString("BranchID"));
        int cardNo = Integer.parseInt(rs.getString("CardNo"));

        Calendar dateOut = Calendar.getInstance();
        String[] dbDateOut = rs.getString("DateOut").split("-");
        dateOut.set(Integer.parseInt(dbDateOut[0]), Integer.parseInt(dbDateOut[1]), Integer.parseInt(dbDateOut[2]));

        Calendar dueDate = Calendar.getInstance();
        String[] dbDueDate = rs.getString("DueDate").split("-");
        dueDate.set(Integer.parseInt(dbDueDate[0]), Integer.parseInt(dbDueDate[1]), Integer.parseInt(dbDueDate[2]));

        Calendar dateReturned = Calendar.getInstance();
        String[] dbDateReturned = rs.getString("DateReturned").split("-");
        dateReturned.set(Integer.parseInt(dbDateReturned[0]), Integer.parseInt(dbDateReturned[1]), Integer.parseInt(dbDateReturned[2]));

        return new Book_Loans(bookID, branchID, cardNo, dateOut, dueDate, dateReturned);
    }
}
