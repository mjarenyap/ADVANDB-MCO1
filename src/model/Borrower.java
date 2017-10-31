package model;

public class Borrower {
    private int cardNo;
    private String borrower_fname;
    private String borrower_lname;
    private String address;
    private String phone;


    public Borrower(int cardNo, String borrower_fname, String borrower_lname, String address, String phone) {
        this.cardNo = cardNo;
        this.borrower_fname = borrower_fname;
        this.borrower_lname = borrower_lname;
        this.address = address;
        this.phone = phone;
    }


    public int getCardNo() {
        return cardNo;
    }

    public void setCardNo(int cardNo) {
        this.cardNo = cardNo;
    }

    public String getBorrower_fname() {
        return borrower_fname;
    }

    public void setBorrower_fname(String borrower_fname) {
        this.borrower_fname = borrower_fname;
    }

    public String getBorrower_lname() {
        return borrower_lname;
    }

    public void setBorrower_lname(String borrower_lname) {
        this.borrower_lname = borrower_lname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
