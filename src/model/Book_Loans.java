package model;
import java.util.Calendar;

public class Book_Loans {
    private int bookID;
    private int branchID;
    private int cardNo;
    private Calendar date_out;
    private Calendar due_date;
    private Calendar date_returned;

    public Book_Loans(int bookID, int branchID, int cardNo, Calendar date_out, Calendar due_date, Calendar returned) {
        this.bookID = bookID;
        this.branchID = branchID;
        this.cardNo = cardNo;
        this.date_out = date_out;
        this.due_date = due_date;
        this.date_returned = returned;
    }


    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public int getBranchID() {
        return branchID;
    }

    public void setBranchID(int branchID) {
        this.branchID = branchID;
    }

    public int getCardNo() {
        return cardNo;
    }

    public void setCardNo(int cardNo) {
        this.cardNo = cardNo;
    }

    public Calendar getDate_out() {
        return date_out;
    }

    public void setDate_out(Calendar date_in) {
        this.date_out = date_in;
    }

    public Calendar getDue_date() {
        return due_date;
    }

    public void setDue_date(Calendar due_date) {
        this.due_date = due_date;
    }

    public Calendar getReturned() {
        return date_returned;
    }

    public void setReturned(Calendar returned) {
        this.date_returned = returned;
    }
}
