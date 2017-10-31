package model;

public class Book{
    private int bookID;
    private String title;
    private String publisher_name;

    public Book(int bookID, String title, String publisher_name){
        this.bookID = bookID;
        this.title = title;
        this.publisher_name = publisher_name;
    }

    public void setBookID(int id){
        this.bookID = id;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setPublisher_name(String publisher_name){
        this.publisher_name = publisher_name;
    }

    public int getBookID(){
        return bookID;
    }

    public String getTitle(){
        return title;
    }

    public String getPublisher_name(){
        return publisher_name;
    }
}
