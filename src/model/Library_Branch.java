package model;

public class Library_Branch {
    private int branchID;
    private String branch_name;
    private String branch_address;

    public Library_Branch(int branchID, String branch_name, String branch_address) {
        this.branchID = branchID;
        this.branch_name = branch_name;
        this.branch_address = branch_address;
    }

    public int getBranchID() {
        return branchID;
    }

    public void setBranchID(int branchID) {
        this.branchID = branchID;
    }

    public String getBranch_name() {
        return branch_name;
    }

    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }

    public String getBranch_address() {
        return branch_address;
    }

    public void setBranch_address(String branch_address) {
        this.branch_address = branch_address;
    }
}
