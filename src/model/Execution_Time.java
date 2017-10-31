package model;

public class Execution_Time {
    private String normal_query;
    private String one_index;
    private String two_indexes;
    private String one_view;
    private String two_views;
    private String one_temp_table;

    public Execution_Time(){
        normal_query = "";
        one_index = "";
        two_indexes = "";
        one_view = "";
        two_views = "";
        one_temp_table = "";
    }

    public String getNormal_query() {
        return normal_query;
    }

    public void setNormal_query(String normal_query) {
        this.normal_query = normal_query;
    }

    public String getOne_index() {
        return one_index;
    }

    public void setOne_index(String one_index) {
        this.one_index = one_index;
    }

    public String getTwo_indexes() {
        return two_indexes;
    }

    public void setTwo_indexes(String two_indexes) {
        this.two_indexes = two_indexes;
    }

    public String getOne_view() {
        return one_view;
    }

    public void setOne_view(String one_view) {
        this.one_view = one_view;
    }

    public String getTwo_views() {
        return two_views;
    }

    public void setTwo_views(String two_views) {
        this.two_views = two_views;
    }

    public String getOne_temp_table() {
        return one_temp_table;
    }

    public void setOne_temp_table(String one_temp_table) {
        this.one_temp_table = one_temp_table;
    }
}
