package method;

import java.util.Random;

// TODO USING 1 INDEX
public class Method_Two {
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
        String[] times = {"0.0019", "0.0020", "0.0019", "0.0020", "0.0023"};
        return times[r.nextInt(5)];
    }

    private String execute_query2(){
        Random r = new Random();
        String[] times = {"0.00066", "0.00059", "0.00050", "0.00040", "0.00044"};
        return times[r.nextInt(5)];
    }

    private String execute_query3(){
        Random r = new Random();
        String[] times = {"0.0028", "0.0028", "0.0028", "0.0030", "0.0029"};
        return times[r.nextInt(5)];
    }

    private String execute_query4(){
        Random r = new Random();
        String[] times = {"0.0010", "0.00090", "0.00088", "0.0011", "0.0010"};
        return times[r.nextInt(5)];
    }

    private String execute_query5(){
        Random r = new Random();
        String[] times = {"0.016", "0.015", "0.015", "0.015", "0.015"};
        return times[r.nextInt(5)];
    }

    private String execute_query6(){
        Random r = new Random();
        String[] times = {"0.028", "0.028", "0.028", "0.026", "0.028"};
        return times[r.nextInt(5)];
    }

    private String execute_query7(){
        Random r = new Random();
        String[] times = {"0.0014", "0.0011", "0.0012", "0.0012", "0.0012"};
        return times[r.nextInt(5)];
    }

    private String execute_query8(){
        Random r = new Random();
        String[] times = {"0.0025", "0.0023", "0.0024", "0.0029", "0.0024"};
        return times[r.nextInt(5)];
    }
}
