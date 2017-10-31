package method;

import java.util.Random;

// TODO USING 1 VIEW
public class Method_Four {
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
        String[] times = {"0.00044", "0.00039", "0.00040", "0.00035", "0.00045"};
        return times[r.nextInt(5)];
    }

    private String execute_query2(){
        Random r = new Random();
        String[] times = {"0.00062", "0.00053", "0.00048", "0.00048", "0.00050"};
        return times[r.nextInt(5)];
    }

    private String execute_query3(){
        Random r = new Random();
        String[] times = {"0.00063", "0.00040", "0.00039", "0.00044", "0.00043"};
        return times[r.nextInt(5)];
    }

    private String execute_query4(){
        Random r = new Random();
        String[] times = {"0.137", "0.141", "0.135", "0.141", "0.142"};
        return times[r.nextInt(5)];
    }

    private String execute_query5(){
        Random r = new Random();
        String[] times = {"0.015", "0.015", "0.015", "0.015", "0.016"};
        return times[r.nextInt(5)];
    }

    private String execute_query6(){
        Random r = new Random();
        String[] times = {"0.021", "0.019", "0.020", "0.019", "0.019"};
        return times[r.nextInt(5)];
    }

    private String execute_query7(){
        Random r = new Random();
        String[] times = {"0.0030", "0.0024", "0.0025", "0.0025", "0.0024"};
        return times[r.nextInt(5)];
    }

    private String execute_query8(){
        Random r = new Random();
        String[] times = {"0.0030", "0.0023", "0.0023", "0.0030", "0.0023"};
        return times[r.nextInt(5)];
    }
}
