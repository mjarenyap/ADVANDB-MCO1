package model;

public class Book_Authors {
    private int bookID;
    private String author_fname;
    private String author_lname;


    public Book_Authors(int id, String author_fname, String author_lname) {
        this.bookID = id;
        this.author_fname = author_fname;
        this.author_lname = author_lname;
    }

    public int getBookID() {
        return bookID;
    }

    public void getBookID(int id) {
        this.bookID = id;
    }

    public String getAuthor_fname() {
        return author_fname;
    }

    public void setAuthor_fname(String author_fname) {
        this.author_fname = author_fname;
    }

    public String getAuthor_lname() {
        return author_lname;
    }

    public void setAuthor_lname(String author_lname) {
        this.author_lname = author_lname;
    }
}
