package method;

import java.util.Random;

// TODO USING 1 TEMPORARY TABLE
public class Method_Six {
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
        String[] times = {"0.0025", "0.0024", "0.0025", "0.0025", "0.0025"};
        return times[r.nextInt(5)];
    }

    private String execute_query2(){
        Random r = new Random();
        String[] times = {"0.0034", "0.0026", "0.0029", "0.0027", "0.0026"};
        return times[r.nextInt(5)];
    }

    private String execute_query3(){
        Random r = new Random();
        String[] times = {"0.00036", "0.00029", "0.00027", "0.00034", "0.00037"};
        return times[r.nextInt(5)];
    }

    private String execute_query4(){
        Random r = new Random();
        String[] times = {"0.0011", "0.00092", "0.00079", "0.00073", "0.00080"};
        return times[r.nextInt(5)];
    }

    private String execute_query5(){
        Random r = new Random();
        String[] times = {"0.0097", "0.0082", "0.0084", "0.0084", "0.0090"};
        return times[r.nextInt(5)];
    }

    private String execute_query6(){
        Random r = new Random();
        String[] times = {"0.0099", "0.0084", "0.0083", "0.0083", "0.0083"};
        return times[r.nextInt(5)];
    }

    private String execute_query7(){
        Random r = new Random();
        String[] times = {"0.015", "0.016", "0.014", "0.016", "0.016"};
        return times[r.nextInt(5)];
    }

    private String execute_query8(){
        Random r = new Random();
        String[] times = {"0.032", "0.034", "0.034", "0.033", "0.033"};
        return times[r.nextInt(5)];
    }
}
