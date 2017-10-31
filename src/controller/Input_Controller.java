package controller;

import model.Library_Branch;
import service.Book_Authors_Service;
import service.Borrower_Service;
import service.Library_Branch_Service;
import service.Publisher_Service;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
public class Input_Controller {

    public Input_Controller(){}

    public ArrayList<String> getInputs(int queryID){
        switch(queryID){
            case 1: return fetch_query1_inputs();
            case 2: return fetch_query2_inputs();
            case 3: return fetch_query3_inputs();
            case 4: return fetch_query4_inputs();
            case 5: return fetch_query5_inputs();
            case 6: return fetch_query6_inputs();
            case 7: return fetch_query7_inputs();
            case 8: return fetch_query8_inputs();
            default: return null;
        }
    }

    private ArrayList<String> fetch_query1_inputs(){
        Publisher_Service publisherService = new Publisher_Service();
        ArrayList<String> inputList = publisherService.getColumn("publisherName");

        return inputList;
    }

    private ArrayList<String> fetch_query2_inputs(){
        Publisher_Service publisherService = new Publisher_Service();
        ArrayList<String> inputList = publisherService.getColumn("publisherName");

        return inputList;
    }

    private ArrayList<String> fetch_query3_inputs(){
        Book_Authors_Service bookAuthorsService = new Book_Authors_Service();
        ArrayList<String> lastList = bookAuthorsService.getColumn("authorLastName");
        ArrayList<String> firstList = bookAuthorsService.getColumn("authorFirstName");
        ArrayList<String> inputList = new ArrayList<>();

        for(int i = 0; i < lastList.size(); i++)
            inputList.add(firstList.get(i) + " " + lastList.get(i));

        return inputList;
    }

    private ArrayList<String> fetch_query4_inputs(){
        Borrower_Service borrower_service = new Borrower_Service();
        ArrayList<String> lastList = borrower_service.getColumn("borrowerLName");
        ArrayList<String> firstList = borrower_service.getColumn("borrowerFName");
        ArrayList<String> inputList = new ArrayList<>();

        for(int i = 0; i < lastList.size(); i++)
            inputList.add(firstList.get(i) + " " + lastList.get(i));

        return inputList;
    }

    private ArrayList<String> fetch_query5_inputs(){
        Library_Branch_Service libraryBranchService = new Library_Branch_Service();
        ArrayList<String> inputList = libraryBranchService.getColumn("branchName");

        return inputList;
    }

    private ArrayList<String> fetch_query6_inputs(){
        Library_Branch_Service libraryBranchService = new Library_Branch_Service();
        ArrayList<String> inputList = libraryBranchService.getColumn("branchName");

        return inputList;
    }

    private ArrayList<String> fetch_query7_inputs(){
        Borrower_Service borrower_service = new Borrower_Service();
        ArrayList<String> lastList = borrower_service.getColumn("borrowerLName");
        ArrayList<String> firstList = borrower_service.getColumn("borrowerFName");
        ArrayList<String> inputList = new ArrayList<>();

        for(int i = 0; i < lastList.size(); i++)
            inputList.add(firstList.get(i) + " " + lastList.get(i));

        return inputList;
    }

    private ArrayList<String> fetch_query8_inputs(){
        Borrower_Service borrower_service = new Borrower_Service();
        ArrayList<String> lastList = borrower_service.getColumn("borrowerLName");
        ArrayList<String> firstList = borrower_service.getColumn("borrowerFName");
        ArrayList<String> inputList = new ArrayList<>();

        for(int i = 0; i < lastList.size(); i++)
            inputList.add(firstList.get(i) + " " + lastList.get(i));

        return inputList;
    }
}
