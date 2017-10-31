package controller;

import java.util.ArrayList;

public class Statement_Controller {

    public ArrayList<String> getStatement(int query, int method){
        switch(method){
            case 1: return get_Normal_Query(query);
            case 2: return get_one_index(query);
            case 3: return get_two_indexes(query);
            case 4: return get_one_view(query);
            case 5: return get_two_views(query);
            case 6: return get_one_temporary_table(query);
            default: return null;
        }
    }

    private ArrayList<String> get_Normal_Query(int queryID){
        ArrayList<String> lineSet = new ArrayList<>();

        switch(queryID){
            case 1:
                lineSet.add("select PublisherName, count(BookID)");
                lineSet.add("from book");
                lineSet.add("where PublisherName = ");
                lineSet.add("group by PublisherName;");
                break;

            case 2:
                lineSet.add("select PublisherName, Title");
                lineSet.add("from book");
                lineSet.add("where PublisherName = ");
                break;

            case 3:
                lineSet.add("select b.Title, ba.AuthorLastName, ba.AuthorFirstName");
                lineSet.add("from book_authors ba, book b");
                lineSet.add("where ba.BookID = b.BookID and ba.AuthorLastName = ");
                lineSet.add("and ba.AuthorFirstName = ");
                break;

            case 4:
                lineSet.add("select br.BorrowerFName, br.BorrowerLName, count(bl.BookID)");
                lineSet.add("from borrower br, book_loans bl");
                lineSet.add("where br.CardNo = bl.CardNo and br.BorrowerFName = ");
                lineSet.add("and br.BorrowerLName = ");
                lineSet.add("group by br.BorrowerFName, br.BorrowerLName;");
                break;

            case 5:
                lineSet.add("select distinct(book.BookID), book.Title, library_branch.BranchName, book_loans.BranchID");
                lineSet.add("from book, book_loans");
                lineSet.add("inner join library_branch on book_loans.BranchID = library_branch.BranchID");
                lineSet.add("where book.BookID = book_loans.BookID and BranchName = ");
                break;

            case 6:
                lineSet.add("select br.BorrowerLName, br.BorrowerFName,");
                lineSet.add("count(bl.BookID) as \'Total Borrowed\', lb.BranchName");
                lineSet.add("from library_branch lb, book_loans bl, borrower br");
                lineSet.add("where bl.CardNo = br.CardNo and lb.BranchID = bl.BranchID");
                lineSet.add("and lb.BranchName = ");
                lineSet.add("group by br.BorrowerLName, br.BorrowerFName");
                lineSet.add("having count(bl.bookID) >= 10");
                break;

            case 7:
                lineSet.add("select lb.BranchName, lb.BranchID, count(bl.DateReturned-bl.DueDate)");
                lineSet.add("as \'OverDueCount\', b.Title, br.BorrowerLName, br.BorrowerFName");
                lineSet.add("from book b, book_loans bl, library_branch lb, borrower br");
                lineSet.add("where b.BookID = bl.BookID and bl.CardNo = br.CardNo");
                lineSet.add("and bl.BranchID = lb.BranchID and (bl.DateReturned - bl.DueDate) > 0");
                lineSet.add("and br. BorrowerLName = ");
                lineSet.add("and br.BorrowerFName = ");
                lineSet.add("group by lb.BranchName, b.Title, lb.BranchID, br.BorrowerLName, br.BorrowerFName;");
                break;

            case 8:
                lineSet.add("select lb.BranchName, lb.BranchID, count(bl.DateReturned-bl.DueDate) as");
                lineSet.add("\'OnTimeCount\', b.Title, br.BorrowerLName, br.BorrowerFName");
                lineSet.add("from book b, book_loans bl, library_branch lb, borrower br");
                lineSet.add("where b.BookID = bl.BookID and bl.CardNo = br.CardNo");
                lineSet.add("and bl.BranchID = lb.BranchID and (bl.DateReturned - bl.DueDate) <= 0");
                lineSet.add("and br. BorrowerLName = ");
                lineSet.add("and br.BorrowerFName = ");
                lineSet.add("group by lb.BranchName, b.Title, lb.BranchID, br.BorrowerLName, br.BorrowerFName;");
                break;
        }

        return lineSet;
    }

    private ArrayList<String> get_one_index(int queryID){
        ArrayList<String> lineSet = new ArrayList<>();

        switch(queryID){
            case 1:
                lineSet.add("create index publisherindex on book(BookId,PublisherName(25));");
                lineSet.add("select PublisherName, count(BookID)");
                lineSet.add("from book use index(publisherindex)");
                lineSet.add("where PublisherName = ");
                break;

            case 2:
                lineSet.add("create index publishertitles on book(PublisherName(25), Title(100));");
                lineSet.add("select PublisherName, Title");
                lineSet.add("from book use index(publishertitles)");
                lineSet.add("where PublisherName = ");
                break;

            case 3:
                lineSet.add("create index booktitles on book(BookID, Title(45));");
                lineSet.add("select Title, ba.AuthorLastName, ba.AuthorFirstName");
                lineSet.add("from book ba use index(booktitles)");
                lineSet.add("where ba.BookID = book.BookID and ba.AuthorLastName = ");
                lineSet.add("and ba.AuthorFirstName = ");
                break;

            case 4:
                lineSet.add("create index borrowercards on borrower(CardNo, BorrowerFName(25), BorrowerLName(25));");
                lineSet.add("select br.BorrowerFName, br.BorrowerLName, count(bl.BookID)");
                lineSet.add("from borrower br use index(borrowercards), book_loans bl");
                lineSet.add("where br.CardNo = bl.CardNo and br.BorrowerFName = ");
                lineSet.add("and br.BorrowerLName = ");
                break;

            case 5:
                lineSet.add("create index branchIDname on library_branch(BranchID, BranchName(25));");
                lineSet.add("select distinct(book.BookID), book.Title, library_branch.BranchName, book_loans.BranchID");
                lineSet.add("from book, book_loans inner join library_branch use index(branchIDName)");
                lineSet.add("on book_loans.BranchID = library_branch.BranchID");
                lineSet.add("where book.BookID = book_loans.BookID and BranchName = ");
                break;

            case 6:
                lineSet.add("create index borrowercards on borrower(cardNo, borrowerFName, borrowerLName);");
                lineSet.add("select br.BorrowerLName, br.BorrowerFName,");
                lineSet.add("count(bl.BookID) as \'Total Borrowed\', lb.BranchName");
                lineSet.add("from library_branch lb, book_loans bl, borrower br use index(borrowercards)");
                lineSet.add("where bl.CardNo = br.CardNo and lb.BranchID = bl.BranchID");
                lineSet.add("and lb.BranchName = ");
                lineSet.add("group by br.BorrowerLName, br.BorrowerFName");
                lineSet.add("having count(bl.bookID) >= 10;");
                break;

            case 7:
                lineSet.add("create index branchIDname on library_branch(BranchID, BranchName(25));");
                lineSet.add("select lb.BranchName, lb.BranchID, count(bl.DateReturned-bl.DueDate) as");
                lineSet.add("\'OverDueCount\', b.Title, br.BorrowerLName, br.BorrowerFName");
                lineSet.add("from book b, book_loans bl, library_branch lb use index(branchIDname), borrower br");
                lineSet.add("where b.BookID = bl.BookID and bl.CardNo = br.CardNo");
                lineSet.add("and bl.BranchID = lb.BranchID and (bl.DateReturned - bl.DueDate) > 0");
                lineSet.add("and b.Title = ");
                lineSet.add("group by lb.BranchName, lb.BranchID,br.BorrowerLName, br.BorrowerFName;");
                break;

            case 8:
                lineSet.add("create index branchIDname on library_branch(BranchID, BranchName(25));");
                lineSet.add("select lb.BranchName, lb.BranchID, count(bl.DateReturned-bl.DueDate) as");
                lineSet.add("\'OnTimeCount\', b.Title, br.BorrowerLName, br.BorrowerFName");
                lineSet.add("from book b, book_loans bl, library_branch lb use index(branchIDname), borrower br");
                lineSet.add("where b.BookID = bl.BookID and bl.CardNo = br.CardNo");
                lineSet.add("and bl.BranchID = lb.BranchID and (bl.DateReturned - bl.DueDate) <= 0");
                lineSet.add("and b.Title = ");
                lineSet.add("group by lb.BranchName, lb.BranchID,br.BorrowerLName, br.BorrowerFName;");
                break;
        }

        return lineSet;
    }

    private ArrayList<String> get_two_indexes(int queryID){
        ArrayList<String> lineSet = new ArrayList<>();

        switch(queryID){
            case 1:
                lineSet.add("N/A");
                break;

            case 2:
                lineSet.add("N/A");
                break;

            case 3:
                lineSet.add("create index booktitles on book(BookID, Title(100));");
                lineSet.add("create index authordetails on book_authors(AuthorLastName(25), AuthorFirstName(25));");
                lineSet.add("select b.Title, ba.AuthorLastName, ba.AuthorFirstName");
                lineSet.add("from book_authors ba use index(authordetails), book b use index(booktitles)");
                lineSet.add("where ba.BookID = b.BookID and ba.AuthorLastName = ");
                lineSet.add("and ba.AuthorFirstName = ");
                break;

            case 4:
                lineSet.add("create index borrowercards on borrower(CardNo, BorrowerFName(25), BorrowerLName(25));");
                lineSet.add("create index loans on book_loans(BookID, CardNo);");
                lineSet.add("select br.BorrowerFName, br.BorrowerLName, count(bl.BookID)");
                lineSet.add("from borrower br use index(borrowercards), book_loans bl use index(loans)");
                lineSet.add("where br.CardNo = bl.CardNo and br.BorrowerFName = ");
                lineSet.add("and br.BorrowerLName = ");
                break;

            case 5:
                lineSet.add("create index branchIDname on library_branch(BranchID, BranchName(25));");
                lineSet.add("create index branchloans on book_loans(BookID, BranchID);");
                lineSet.add("select distinct(book.BookID), book.Title, library_branch.BranchName, book_loans.BranchID");
                lineSet.add("from book, book_loans use index(branchloans)");
                lineSet.add("inner join library_branch use index(branchIDName)");
                lineSet.add("on book_loans.BranchID = library_branch.BranchID");
                lineSet.add("where book.BookID = book_loans.BookID and BranchName = ");
                break;

            case 6:
                //todo testing
                lineSet.add("create index borrowercards on borrower(cardNo, borrowerFName, borrowerLName);");
                lineSet.add("create index borrowerloans on book_loans(CardNo, BranchID, BookID);");
                lineSet.add("select br.BorrowerLName, br.BorrowerFName,");
                lineSet.add("count(bl.BookID) as \'Total Borrowed\', lb.BranchName");
                lineSet.add("from library_branch lb, book_loans bl use index(borrowerloans),");
                lineSet.add("borrower br use index(borrowercards)");
                lineSet.add("where bl.CardNo = br.CardNo and lb.BranchID = bl.BranchID");
                lineSet.add("and lb.BranchName = ");
                lineSet.add("group by br.BorrowerLName, br.BorrowerFName");
                lineSet.add("having count(bl.BookID) >= 10;");
                break;

            case 7:
                lineSet.add("create index branchIDname on library_branch(BranchID, BranchName(25));");
                lineSet.add("create index borrowercards on borrower(cardNo, borrowerFName, borrowerLName);");
                lineSet.add("select lb.BranchName, lb.BranchID, count(bl.DateReturned-bl.DueDate) as");
                lineSet.add("\'OverDueCount\', b.Title, br.BorrowerLName, br.BorrowerFName");
                lineSet.add("from book b, book_loans bl, library_branch lb use index(branchIDname),");
                lineSet.add("borrower br use index(borrowercards)");
                lineSet.add("where b.BookID = bl.BookID and bl.CardNo = br.CardNo");
                lineSet.add("and bl.BranchID = lb.BranchID and (bl.DateReturned - bl.DueDate) > 0");
                lineSet.add("and b.Title = ");
                lineSet.add("group by lb.BranchName, lb.BranchID,br.BorrowerLName, br.BorrowerFName;");
                break;

            case 8:
                lineSet.add("create index branchIDname on library_branch(BranchID, BranchName(25));");
                lineSet.add("create index borrowercards on borrower(cardNo, borrowerFName, borrowerLName);");
                lineSet.add("select lb.BranchName, lb.BranchID, count(bl.DateReturned-bl.DueDate) as");
                lineSet.add("\'OnTimeCount\', b.Title, br.BorrowerLName, br.BorrowerFName");
                lineSet.add("from book b, book_loans bl, library_branch lb use index(branchIDname),");
                lineSet.add("borrower br use index(borrowercards)");
                lineSet.add("where b.BookID = bl.BookID and bl.CardNo = br.CardNo");
                lineSet.add("and bl.BranchID = lb.BranchID and (bl.DateReturned - bl.DueDate) <= 0");
                lineSet.add("and b.Title = ");
                lineSet.add("group by lb.BranchName, lb.BranchID,br.BorrowerLName, br.BorrowerFName;");
                break;
        }

        return lineSet;
    }

    private ArrayList<String> get_one_view(int queryID){
        ArrayList<String> lineSet = new ArrayList<>();

        switch(queryID){
            case 1:
                lineSet.add("create view publisherview as select BookID, PublisherName from book;");
                lineSet.add("select PublisherName, count(BookID)");
                lineSet.add("from publisherview");
                lineSet.add("where PublisherName = ");
                break;

            case 2:
                lineSet.add("create view titleview as select PublisherName, Title from book;");
                lineSet.add("select PublisherName, Title");
                lineSet.add("from titleview");
                lineSet.add("where PublisherName = ");
                break;

            case 3:
                lineSet.add("create view harperlee as select BookID, AuthorLastName, AuthorFirstName");
                lineSet.add("from book_authors where AuthorLastName = ");
                lineSet.add("and AuthorFirstName = ");
                lineSet.add("select b.Title, h.AuthorLastName, h.AuthorFirstName");
                lineSet.add("from harperlee h, book b");
                lineSet.add("where b.BookID = h.BookID;");
                break;

            case 4:
                lineSet.add("create view borrowerview as");
                lineSet.add("select bl.CardNo, br.BorrowerFName, br.BorrowerLName, count(bl.BookID) as \'BookCount\'");
                lineSet.add("from borrower br, book_loans bl");
                lineSet.add("where bl.CardNo = br.CardNo");
                lineSet.add("group by br.CardNo");
                lineSet.add("select BorrowerFName, BorrowerLName, BookCount");
                lineSet.add("from borrowerview");
                lineSet.add("where BorrowerFName = ");
                lineSet.add("and BorrowerLName = ");
                break;

            case 5:
                lineSet.add("create view loaningbranch as select bl.BookID, bl.BranchID, lb.BranchName");
                lineSet.add("from book_loans bl, library_branch lb");
                lineSet.add("where bl.BranchID = lb.BranchID;");
                lineSet.add("select distinct(b.BookID), b.Title, lb.BranchName, lb.BranchID");
                lineSet.add("from book b, loaningbranch lb");
                lineSet.add("where b.BookID = lb.BookID and lb.BranchName = ");
                break;

            case 6:
                lineSet.add("create view borrowercards as select br.CardNo, br.BorrowerLName,");
                lineSet.add("br.BorrowerFName, bl.BranchID, bl.BookID");
                lineSet.add("from borrower br, book_loans bl");
                lineSet.add("where bl.CardNo = br.CardNo;");
                lineSet.add("select bc.BorrowerLName, bc.BorrowerFName,");
                lineSet.add("count(bc.BookID) as \'Total Borrowed\', lb.BranchName");
                lineSet.add("from library_branch lb, borrowercards bc");
                lineSet.add("where lb.BranchID = bc.BranchID and lb.BranchName = ");
                lineSet.add("group by bc.BorrowerLName, bc.BorrowerFName");
                lineSet.add("having count(bc.BookID) >= 10;");
                break;

            case 7:
                lineSet.add("create view overdueview as select bl.BookID, bl.BranchID, bl.CardNo,");
                lineSet.add("bl.DateReturned, bl.DueDate, (bl.DateReturned-bl.DueDate) as");
                lineSet.add("\'OverDueCount\' from book_loans bl where (bl.DateReturned - bl.DueDate) > 0;");
                lineSet.add("select lb.BranchName, lb.BranchID, count(bl.OverDueCount) as \'OverDueCount\',");
                lineSet.add("b.Title, br.BorrowerLName, br.BorrowerFName");
                lineSet.add("from book b, overdueview bl, library_branch lb, borrower br");
                lineSet.add("where b.BookID = bl.BookID and bl.CardNo = br.CardNo");
                lineSet.add("and bl.BranchID = lb.BranchID and b.Title = ");
                lineSet.add("group by lb.BranchName, lb.BranchID,br.BorrowerLName, br.BorrowerFName;");
                break;

            case 8:
                lineSet.add("create view ontimeview as select bl.BookID, bl.BranchID, bl.CardNo,");
                lineSet.add("bl.DateReturned, bl.DueDate, (bl.DateReturned-bl.DueDate) as");
                lineSet.add("\'OnTime\' from book_loans bl where (bl.DateReturned - bl.DueDate) <= 0;");
                lineSet.add("select lb.BranchName, lb.BranchID, count(bl.OnTime) as \'OnTimeCount\',");
                lineSet.add("b.Title, br.BorrowerLName, br.BorrowerFName");
                lineSet.add("from book b, ontimeview bl, library_branch lb, borrower br");
                lineSet.add("where b.BookID = bl.BookID and bl.CardNo = br.CardNo");
                lineSet.add("and bl.BranchID = lb.BranchID and b.Title = ");
                lineSet.add("group by lb.BranchName, lb.BranchID,br.BorrowerLName, br.BorrowerFName;");
                break;
        }

        return lineSet;
    }

    private ArrayList<String> get_two_views(int queryID){
        ArrayList<String> lineSet = new ArrayList<>();

        switch(queryID){
            case 1:
                lineSet.add("create view publisherview as select BookID, PublisherName from book;");
                lineSet.add("create view bookID_view as select BookID from book;");
                lineSet.add("select p.PublisherName, count(bv.BookID)");
                lineSet.add("from publisherview p, bookID_view bv");
                lineSet.add("where bv.BookID = p.BookID and PublisherName = ");
                break;

            case 2:
                lineSet.add("create view publisherview as select BookID, PublisherName;");
                lineSet.add("create view booknames as select BookID, Title from book;");
                lineSet.add("select p.PublisherName, b.Title");
                lineSet.add("from publisherview p, booknames b");
                lineSet.add("where p.BookID = b.BookID and PublisherName = ");
                break;

            case 3:
                lineSet.add("create view harperlee as select BookID, AuthorLastName, AuthorFirstName");
                lineSet.add("from book_authors where AuthorLastName = ");
                lineSet.add("and AuthorFirstName = ");
                lineSet.add("create view booktitleview as select BookID, Title from book;");
                lineSet.add("select bv.Title, h.AuthorLastName, h.AuthorFirstName");
                lineSet.add("from harperlee h, booktitleview bv");
                lineSet.add("where bv.BookID = h.BookID;");
                break;

            case 4:
                lineSet.add("create view borrowerview as");
                lineSet.add("select bl.CardNo, br.BorrowerFName, br.BorrowerLName, count(bl.BookID) as \'BookCount\'");
                lineSet.add("from borrower br, book_loans bl");
                lineSet.add("where bl.CardNo = br.CardNo");
                lineSet.add("group by br.CardNo");
                lineSet.add("create view bookcards as select CardNo, count(BookID) as \'blBookCount\'");
                lineSet.add("from book_loans group by CardNo;");
                lineSet.add("select bv.BorrowerFName, bv.BorrowerLName, bc.blBookCount");
                lineSet.add("from borrowerview bv, bookcards bc");
                lineSet.add("where bv.CardNo = bc.CardNo and BorrowerFName = ");
                lineSet.add("and BorrowerLName = ");
                break;

            case 5:
                lineSet.add("create view loaningbranch as select bl.BookID, bl.BranchID, lb.BranchName");
                lineSet.add("from book_loans bl, library_branch lb");
                lineSet.add("where bl.BranchID = lb.BranchID;");
                lineSet.add("create view booksloaned as select distinct(book.BookID), book.Title");
                lineSet.add("from book inner join book_loans on book.BookID = book_loans.BookID;");
                lineSet.add("select distinct(bl.BookID), bl.Title, lb.BranchName, bl.BranchID");
                lineSet.add("from booksloaned bl, loaningbranch lb");
                lineSet.add("where lb.BranchName = ");
                break;

            case 6:
                lineSet.add("create view borrowercards as select br.CardNo, br.BorrowerLName,");
                lineSet.add("br.BorrowerFName, bl.BranchID, bl.BookID");
                lineSet.add("from borrower br, book_loans bl");
                lineSet.add("where bl.CardNo = br.CardNo;");
                lineSet.add("create view branchloans as select bl.BranchID, lb.BranchName");
                lineSet.add("from book_loans bl, library_branch lb");
                lineSet.add("where bl.BranchID = lb.BranchID;");
                lineSet.add("select bc.BorrowerLName, bc.BorrowerFName,");
                lineSet.add("count(bc.BookID) as \'Total Borrowed\', lb.BranchName");
                lineSet.add("from branchloans lb, borrowercards bc");
                lineSet.add("where lb.BranchID = bc.BranchID and lb.BranchName = ");
                lineSet.add("group by bc.BorrowerLName, bc.BorrowerFName");
                lineSet.add("having count(bc.BookID) >= 10;");
                break;

            case 7:
                lineSet.add("create view overdueview as select bl.BookID, bl.BranchID, bl.CardNo,");
                lineSet.add("bl.DateReturned, bl.DueDate, (bl.DateReturned-bl.DueDate) as");
                lineSet.add("\'OverDueCount\' from book_loans bl where (bl.DateReturned - bl.DueDate) > 0;");
                lineSet.add("create view booknames as select BookID, Title from book;");
                lineSet.add("select lb.BranchName, lb.BranchID, count(bl.OverDueCount) as 'OverDueCount',");
                lineSet.add("b.Title, br.BorrowerLName, br.BorrowerFName");
                lineSet.add("from booknames b, overdueview bl, library_branch lb, borrower br");
                lineSet.add("where b.BookID = bl.BookID and bl.CardNo = br.CardNo");
                lineSet.add("and bl.BranchID = lb.BranchID and b.Title = ");
                lineSet.add("group by lb.BranchName, lb.BranchID,br.BorrowerLName, br.BorrowerFName;");
                break;

            case 8:
                lineSet.add("create view ontimeview as select bl.BookID, bl.BranchID, bl.CardNo,");
                lineSet.add("bl.DateReturned, bl.DueDate, (bl.DateReturned-bl.DueDate) as");
                lineSet.add("\'OnTime\' from book_loans bl where (bl.DateReturned - bl.DueDate) <= 0;");
                lineSet.add("create view booknames as select BookID, Title from book;");
                lineSet.add("select lb.BranchName, lb.BranchID, count(bl.OnTime) as 'OnTimeCount',");
                lineSet.add("b.Title, br.BorrowerLName, br.BorrowerFName");
                lineSet.add("from booknames b, ontimeview bl, library_branch lb, borrower br");
                lineSet.add("where b.BookID = bl.BookID and bl.CardNo = br.CardNo");
                lineSet.add("and bl.BranchID = lb.BranchID and b.Title = ");
                lineSet.add("group by lb.BranchName, lb.BranchID,br.BorrowerLName, br.BorrowerFName;");
                break;
        }

        return lineSet;
    }

    private ArrayList<String> get_one_temporary_table(int queryID){
        ArrayList<String> lineSet = new ArrayList<>();

        switch(queryID){
            case 1:
                lineSet.add("create temporary table bookpub as select PublisherName, BookID from book;");
                lineSet.add("drop temporary table bookpub");
                lineSet.add("");
                lineSet.add("select PublisherName, count(BookID)");
                lineSet.add("from bookpub");
                lineSet.add("where PublisherName = ");
                break;

            case 2:
                lineSet.add("create temporary table publishertitles as select PublisherName, Title from book;");
                lineSet.add("drop temporary table publishertitles");
                lineSet.add("");
                lineSet.add("select PublisherName, Title");
                lineSet.add("from publishertitles");
                lineSet.add("where PublisherName = ");
                break;

            case 3:
                lineSet.add("create temporary table authorbook as select BookID, AuthorLastName, AuthorFirstName");
                lineSet.add("from book_authors where AuthorFirstName = ");
                lineSet.add("and AuthorLastName = ");
                lineSet.add("drop temporary table authorbook;");
                lineSet.add("");
                lineSet.add("select b.Title, ba.AuthorLastName, ba.AuthorFirstName");
                lineSet.add("from authorbook ba, book b");
                lineSet.add("where ba.BookID = b.BookId;");
                break;

            case 4:
                lineSet.add("create temporary table BorrowerLoans as");
                lineSet.add("select bl.CardNo, br.BorrowerFName, br.BorrowerLName, count(bl.BookID) as \'BookCount\'");
                lineSet.add("from borrower br, book_loans bl");
                lineSet.add("where bl.CardNo = br.CardNo");
                lineSet.add("group by br.CardNo;");
                lineSet.add("drop temporary table BorrowerLoans;");
                lineSet.add("");
                lineSet.add("select BorrowerFName, BorrowerLName, BookCount");
                lineSet.add("from BorrowerLoans");
                lineSet.add("where BorrowerFName = ");
                lineSet.add("and BorrowerLName = ");
                break;

            case 5:
                lineSet.add("create temporary table branch_books as select distinct(book.BookID), book.Title,");
                lineSet.add("library_branch.BranchName, book_loans.BranchID");
                lineSet.add("from book, book_loans inner join library_branch");
                lineSet.add("on book_loans.BranchID = library_branch.BranchID");
                lineSet.add("where book.BookID = book_loans.BookID;");
                lineSet.add("drop temporary table branch_books;");
                lineSet.add("");
                lineSet.add("select *");
                lineSet.add("from branch_books");
                lineSet.add("where BranchName = ");
                break;

            case 6:
                lineSet.add("create temporary table most_books as select br.BorrowerLName, br.BorrowerFName,");
                lineSet.add("count(bl.BookID) as \'TotalBorrowed\', lb.BranchName");
                lineSet.add("from library_branch lb, book_loans bl, borrower br");
                lineSet.add("where bl.CardNo = br.CardNo and lb.BranchID = bl.BranchID");
                lineSet.add("group by lb.BranchName, br.BorrowerLName, br.BorrowerFName;");
                lineSet.add("drop temporary table most_books;");
                lineSet.add("");
                lineSet.add("select *");
                lineSet.add("from most_books");
                lineSet.add("where TotalBorrowed >= 10 and BranchName = ");
                break;

            case 7:
                lineSet.add("create temporary table overduecounttable as select lb.BranchName, lb.BranchID,");
                lineSet.add("count(bl.DateReturned-bl.DueDate) as \'OverDueCount\', b.Title,");
                lineSet.add("br.BorrowerLName, br.BorrowerFName");
                lineSet.add("from book b, book_loans bl, library_branch lb, borrower br");
                lineSet.add("where b.BookID = bl.BookID and bl.CardNo = br.CardNo");
                lineSet.add("and bl.BranchID = lb.BranchID and (bl.DateReturned - bl.DueDate) > 0");
                lineSet.add("group by lb.BranchName, lb.BranchID, b.Title,br.BorrowerLName, br.BorrowerFName;");
                lineSet.add("drop temporary table overduecounttable;");
                lineSet.add("");
                lineSet.add("select *");
                lineSet.add("from overduecounttable");
                lineSet.add("where BorrowerLName = ");
                lineSet.add("and BorrowerFName = ");
                break;

            case 8:
                lineSet.add("create temporary table ontimebooks as select lb.BranchName, lb.BranchID,");
                lineSet.add("count(bl.OnTime) as 'OnTimeCount', b.Title, br.BorrowerLName, br.BorrowerFName");
                lineSet.add("from booknames b, ontimeview bl, library_branch lb, borrower br");
                lineSet.add("where b.BookID = bl.BookID and bl.CardNo = br.CardNo");
                lineSet.add("and bl.BranchID = lb.BranchID");
                lineSet.add("group by lb.BranchName, lb.BranchID,b.Title, br.BorrowerLName, br.BorrowerFName;");
                lineSet.add("drop temporary table ontimebooks;");
                lineSet.add("");
                lineSet.add("select *");
                lineSet.add("from ontimebooks");
                lineSet.add("where Title = ");
                break;
        }

        return lineSet;
    }

    /*
    * TODO
    * 1. get Normal queries
    * 2. get using 1 index
    * 3. get using 2 indexes
    * 4. get using 1 view
    * 5. get using 2 views
    * 6. get using temporary table
    *
    * */
}
