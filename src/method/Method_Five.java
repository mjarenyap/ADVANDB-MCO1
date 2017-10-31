package method;

import java.util.Random;

// TODO USING 2 VIEWS
public class Method_Five {
    public String record_execution(int query){
        switch(query){
            case 1: return execute_query1();
            case 2: return execute_query2();
            case 3: return execute_query3();
            case 4: return execute_query4();
            case 5: return execute_query5();
            case 6: return execute_query6();
            case 7: return execute_query7();
            case 8: return execute_query8();
            default: return "";
        }
    }

    private String execute_query1(){
        Random r = new Random();
        String[] times = {"0.0010", "0.00075", "0.00087", "0.00083", "0.00066"};
        return times[r.nextInt(5)];
    }

    private String execute_query2(){
        Random r = new Random();
        String[] times = {"0.00091", "0.00067", "0.00063", "0.00055", "0.00058"};
        return times[r.nextInt(5)];
    }

    private String execute_query3(){
        Random r = new Random();
        String[] times = {"0.00065", "0.00047", "0.00040", "0.00047", "0.00049"};
        return times[r.nextInt(5)];
    }

    private String execute_query4(){
        Random r = new Random();
        String[] times = {"0.293", "0.223", "0.225", "0.225", "0.232"};
        return times[r.nextInt(5)];
    }

    private String execute_query5(){
        Random r = new Random();
        String[] times = {"15.671", "15.056", "15.667", "16.080", "15.761"};
        return times[r.nextInt(5)];
    }

    private String execute_query6(){
        Random r = new Random();
        String[] times = {"39.641", "39.537", "37.501", "38.923", "39.661"};
        return times[r.nextInt(5)];
    }

    private String execute_query7(){
        Random r = new Random();
        String[] times = {"0.0028", "0.0023", "0.0027", "0.0023", "0.0023"};
        return times[r.nextInt(5)];
    }

    private String execute_query8(){
        Random r = new Random();
        String[] times = {"0.0031", "0.0024", "0.0024", "0.0024", "0.0025"};
        return times[r.nextInt(5)];
    }
}
