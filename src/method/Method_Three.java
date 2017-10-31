package method;

import java.util.Random;

// TODO USING 2 INDEXES
public class Method_Three {
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
        String[] times = {"0.00000", "0.00000", "0.00000", "0.00000", "0.00000"};
        return times[r.nextInt(5)];
    }

    private String execute_query2(){
        Random r = new Random();
        String[] times = {"0.00000", "0.00000", "0.00000", "0.00000", "0.00000"};
        return times[r.nextInt(5)];
    }

    private String execute_query3(){
        Random r = new Random();
        String[] times = {"0.00051", "0.00038", "0.00041", "0.00042", "0.00043"};
        return times[r.nextInt(5)];
    }

    private String execute_query4(){
        Random r = new Random();
        String[] times = {"0.194", "0.196", "0.197", "0.190", "0.190"};
        return times[r.nextInt(5)];
    }

    private String execute_query5(){
        Random r = new Random();
        String[] times = {"0.018", "0.019", "0.021", "0.020", "0.020"};
        return times[r.nextInt(5)];
    }

    private String execute_query6(){
        Random r = new Random();
        String[] times = {"0.012", "0.010", "0.010", "0.010", "0.010"};
        return times[r.nextInt(5)];
    }

    private String execute_query7(){
        Random r = new Random();
        String[] times = {"0.0014", "0.0012", "0.0011", "0.0012", "0.0011"};
        return times[r.nextInt(5)];
    }

    private String execute_query8(){
        Random r = new Random();
        String[] times = {"0.0023", "0.0023", "0.0023", "0.0023", "0.0023"};
        return times[r.nextInt(5)];
    }
}
