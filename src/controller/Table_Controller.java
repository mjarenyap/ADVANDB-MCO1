package controller;

import model.Book_Authors;
import model.Book_Loans;
import model.Table;
import model.Book;
import service.Book_Authors_Service;
import service.Book_Loans_Service;
import service.Book_Service;
import service.DBConnection;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;

public class Table_Controller {

    public Table execute(int queryNum, String input){
        switch(queryNum){
            case 1: return execute_query1_table(input);
            case 2: return execute_query2_table(input);
            case 3: return execute_query3_table(input);
            case 4: return execute_query4_table(input);
            case 5: return execute_query5_table(input);
            case 6: return execute_query6_table(input);
            case 7: return execute_query7_table(input);
            case 8: return execute_query8_table(input);
            default: return null;
        }
    }

    public Table execute_query1_table(String input){
        String[] headers = {"PublisherName", "count(BookID)"};
        Table theTable = new Table(headers);

        Book_Service bookService = new Book_Service();
        ArrayList<Book> books = bookService.getAll();
        int n = 0;
        Book theBook = books.get(0);

        for(Book b : books){
            if(b.getPublisher_name().equals(input)){
                n++;
                theBook = b;
            }
        }

        theTable.addData(1, theBook.getPublisher_name());
        theTable.addData(2, String.valueOf(n));
        theTable.addData(3, "");
        theTable.addData(4, "");
        theTable.addData(5, "");
        theTable.addData(6, "");
        theTable.addData(7, "");
        theTable.addData(8, "");

        return theTable;
    }

    public Table execute_query2_table(String input){
        String[] headers = {"PublisherName", "Title"};
        Table theTable = new Table(headers);

        Book_Service bookService = new Book_Service();
        ArrayList<Book> books = bookService.getAll();

        for(Book b : books){
            if(b.getPublisher_name().equals(input)){
                theTable.addData(1, b.getPublisher_name());
                theTable.addData(2, b.getTitle());
                theTable.addData(3, "");
                theTable.addData(4, "");
                theTable.addData(5, "");
                theTable.addData(6, "");
                theTable.addData(7, "");
                theTable.addData(8, "");
            }
        }

        return theTable;
    }

    public Table execute_query3_table(String input){
        String[] headers = {"Title", "AuthorLastName", "AuthorFirstName"};
        Table theTable = new Table(headers);

        String[] name = input.split(" ");
        DBConnection dbConnection = new DBConnection();

        try{
            ResultSet rs;
            String query = "select b.Title, ba.AuthorLastName, ba.AuthorFirstName" + " " +
                    "from book_authors ba, book b" + " " +
                    "where ba.BookID = b.BookID and ba.AuthorLastName = \'" + name[1] + "\' " +
                    "and ba.AuthorFirstName = \'" + name[0] + "\';";

            Statement stmnt = dbConnection.getConnection().createStatement();
            rs = stmnt.executeQuery(query);

            while(rs.next()){
                theTable.addData(1, rs.getString("Title"));
                theTable.addData(2, rs.getString("AuthorLastName"));
                theTable.addData(3, rs.getString("AuthorFirstName"));
                theTable.addData(4, "");
                theTable.addData(5, "");
                theTable.addData(6, "");
                theTable.addData(7, "");
                theTable.addData(8, "");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return theTable;
    }

    public Table execute_query4_table(String input){
        String[] headers = {"BorrowerFName", "BorrowerLName", "count(BookID)"};
        Table theTable = new Table(headers);

        String[] name = input.split(" ");

        DBConnection dbConnection = new DBConnection();
        try{

            ResultSet rs;
            String query = "select br.BorrowerFName, br.BorrowerLName, count(bl.BookID) as \'count(BookID)\' " +
                    "from borrower br, book_loans bl " +
                    "where br.CardNo = bl.CardNo and br.BorrowerFName = \'" + name[0] + "\' " +
                    "and br.BorrowerLName = \'" + name[1] + "\' " +
                    "group by br.BorrowerFName, br.BorrowerLName;";

            Statement stmnt = dbConnection.getConnection().createStatement();
            rs = stmnt.executeQuery(query);

            while(rs.next()){
                theTable.addData(1, rs.getString("BorrowerFName"));
                theTable.addData(2, rs.getString("BorrowerLName"));
                theTable.addData(3, rs.getString("count(BookID)"));
                theTable.addData(4, "");
                theTable.addData(5, "");
                theTable.addData(6, "");
                theTable.addData(7, "");
                theTable.addData(8, "");
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return theTable;
    }

    public Table execute_query5_table(String input){
        String[] headers = {"BookID", "Title", "BranchName", "BranchID"};
        Table theTable = new Table(headers);

        DBConnection dbConnection = new DBConnection();
        try{
            ResultSet rs;
            String query = "select distinct(book.BookID), book.Title, library_branch.BranchName, book_loans.BranchID " +
                    "from book, book_loans " + "inner join library_branch on book_loans.BranchID = library_branch.BranchID" + " " +
                    "where book.BookID = book_loans.BookID and BranchName = \'" + input + "\'";

            Statement stmnt = dbConnection.getConnection().createStatement();
            rs = stmnt.executeQuery(query);

            while(rs.next()){
                theTable.addData(1, rs.getString("BookID"));
                theTable.addData(2, rs.getString("Title"));
                theTable.addData(3, rs.getString("BranchName"));
                theTable.addData(4, rs.getString("BranchID"));
                theTable.addData(5, "");
                theTable.addData(6, "");
                theTable.addData(7, "");
                theTable.addData(8, "");
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return theTable;
    }

    public Table execute_query6_table(String input){
        String[] headers = {"BorrowerLName", "BorrowerFName", "Total Borrowed", "BranchName"};
        Table theTable = new Table(headers);

        DBConnection dbConnection = new DBConnection();

        try{
            ResultSet rs;
            String query = "select br.BorrowerLName, br.BorrowerFName, count(bl.BookID) as \'Total Borrowed\', lb.BranchName" + " " +
                    "from library_branch lb, book_loans bl, borrower br" + " " +
                    "where bl.CardNo = br.CardNo and lb.BranchID = bl.BranchID" + " " +
                    "and lb.BranchName = \'" + input + "\' " +
                    "group by br.BorrowerLName, br.BorrowerFName" + " " +
                    "having count(bl.bookID) >= 10";

            Statement stmnt = dbConnection.getConnection().createStatement();
            rs = stmnt.executeQuery(query);

            while(rs.next()){
                theTable.addData(1, rs.getString("BorrowerLName"));
                theTable.addData(2, rs.getString("BorrowerFName"));
                theTable.addData(3, rs.getString("Total Borrowed"));
                theTable.addData(4, rs.getString("BranchName"));
                theTable.addData(5, "");
                theTable.addData(6, "");
                theTable.addData(7, "");
                theTable.addData(8, "");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return theTable;
    }

    public Table execute_query7_table(String input){
        String[] headers = {"BranchName", "BranchID", "OverDueCount", "Title", "BorrowerLName", "BorrowerFName"};
        Table theTable = new Table(headers);

        String[] name = input.split(" ");

        DBConnection dbConnection = new DBConnection();
        try{
            ResultSet rs;
            String query = "select lb.BranchName, lb.BranchID, count(bl.DateReturned-bl.DueDate)" + " " +
                    "as \'OverDueCount\', b.Title, br.BorrowerLName, br.BorrowerFName" + " " +
                    "from book b, book_loans bl, library_branch lb, borrower br" + " " +
                    "where b.BookID = bl.BookID and bl.CardNo = br.CardNo" + " " +
                    "and bl.BranchID = lb.BranchID and (bl.DateReturned - bl.DueDate) > 0" + " " +
                    "and br. BorrowerLName = \'" + name[1] + "\' " +
                    "and br.BorrowerFName = \'" + name[0] + "\' " +
                    "group by lb.BranchName, b.Title, lb.BranchID, br.BorrowerLName, br.BorrowerFName;";

            Statement stmnt = dbConnection.getConnection().createStatement();
            rs = stmnt.executeQuery(query);

            while(rs.next()){
                theTable.addData(1, rs.getString("BranchName"));
                theTable.addData(2, rs.getString("BranchID"));
                theTable.addData(3, rs.getString("OverDueCount"));
                theTable.addData(4, rs.getString("Title"));
                theTable.addData(5, rs.getString("BorrowerLName"));
                theTable.addData(6, rs.getString("BorrowerFName"));
                theTable.addData(7, "");
                theTable.addData(8, "");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return theTable;
    }

    public Table execute_query8_table(String input){
        String[] headers = {"BranchName", "BranchID", "OnTimeCount", "Title", "BorrowerLName", "BorrowerFName"};
        Table theTable = new Table(headers);

        String[] name = input.split(" ");

        DBConnection dbConnection = new DBConnection();
        try{
            ResultSet rs;
            String query = "select lb.BranchName, lb.BranchID, count(bl.DateReturned-bl.DueDate)" + " " +
                    "as \'OnTimeCount\', b.Title, br.BorrowerLName, br.BorrowerFName" + " " +
                    "from book b, book_loans bl, library_branch lb, borrower br" + " " +
                    "where b.BookID = bl.BookID and bl.CardNo = br.CardNo" + " " +
                    "and bl.BranchID = lb.BranchID and (bl.DateReturned - bl.DueDate) <= 0" + " " +
                    "and br. BorrowerLName = \'" + name[1] + "\' " +
                    "and br.BorrowerFName = \'" + name[0] + "\' " +
                    "group by lb.BranchName, b.Title, lb.BranchID, br.BorrowerLName, br.BorrowerFName;";

            Statement stmnt = dbConnection.getConnection().createStatement();
            rs = stmnt.executeQuery(query);

            while(rs.next()){
                theTable.addData(1, rs.getString("BranchName"));
                theTable.addData(2, rs.getString("BranchID"));
                theTable.addData(3, rs.getString("OnTimeCount"));
                theTable.addData(4, rs.getString("Title"));
                theTable.addData(5, rs.getString("BorrowerLName"));
                theTable.addData(6, rs.getString("BorrowerFName"));
                theTable.addData(7, "");
                theTable.addData(8, "");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return theTable;
    }
}
