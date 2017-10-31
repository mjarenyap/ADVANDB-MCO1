package controller;

import java.util.ArrayList;

public class Query_Controller {

    public Query_Controller(){}

    public ArrayList<String> getAllQueries(){
        ArrayList<String> queryList = new ArrayList<>();

        queryList.add("Query 1: I want to count the number of books published by a certain publisher.");
        queryList.add("Query 2: I want to find all the book titles published by a certain publisher.");
        queryList.add("Query 3: I want to view the book titles written by a certain author.");
        queryList.add("Query 4: I want to count all book loans made by a certain borrower.");
        queryList.add("Query 5: I want to find all book titles that are loaned from a certain branch.");
        queryList.add("Query 6: For a certain branch, I want to find the borrowers who borrowed at least 10 books.");
        queryList.add("Query 7: I want to count the number of times a borrower returned their books late. I also want to see the titles of these books");
        queryList.add("Query 8: I want to find the number of times a borrower returned a certain book on time");

        return queryList;
    }
}
