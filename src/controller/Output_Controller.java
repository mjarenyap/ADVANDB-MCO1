package controller;

import method.*;
import model.Execution_Time;
import model.Result;
import model.Table;

import java.util.ArrayList;

public class Output_Controller{

    private Method_One method_one;
    private Method_Two method_two;
    private Method_Three method_three;
    private Method_Four method_four;
    private Method_Five method_five;
    private Method_Six method_six;

    public Output_Controller(){
        method_one = new Method_One();
        method_two = new Method_Two();
        method_three = new Method_Three();
        method_four = new Method_Four();
        method_five = new Method_Five();
        method_six = new Method_Six();
    }

    public Result generate_output(int query, String input){

        switch(query){
            case 1: return execute_query1(input);
            case 2: return execute_query2(input);
            case 3: return execute_query3(input);
            case 4: return execute_query4(input);
            case 5: return execute_query5(input);
            case 6: return execute_query6(input);
            case 7: return execute_query7(input);
            default: return null;
        }
    }

    private Result execute_query1(String input){
        Table_Controller table_controller = new Table_Controller();
        Table the_table = table_controller.execute(1, input);

        Execution_Time times = new Execution_Time();
        times.setNormal_query(method_one.record_execution(1));
        times.setOne_index(method_two.record_execution(1));
        times.setTwo_indexes(method_three.record_execution(1));
        times.setOne_view(method_four.record_execution(1));
        times.setTwo_views(method_five.record_execution(1));
        times.setOne_temp_table(method_six.record_execution(1));

        Result result = new Result();
        result.setTable_results(the_table);
        result.setTimes(times);
        return result;
    }

    private Result execute_query2(String input){
        Table_Controller table_controller = new Table_Controller();
        Table the_table = table_controller.execute(2, input);

        Execution_Time times = new Execution_Time();
        times.setNormal_query(method_one.record_execution(2));
        times.setOne_index(method_two.record_execution(2));
        times.setTwo_indexes(method_three.record_execution(2));
        times.setOne_view(method_four.record_execution(2));
        times.setTwo_views(method_five.record_execution(2));
        times.setOne_temp_table(method_six.record_execution(2));

        Result result = new Result();
        result.setTable_results(the_table);
        result.setTimes(times);
        return result;
    }

    private Result execute_query3(String input){
        Table_Controller table_controller = new Table_Controller();
        Table the_table = table_controller.execute(3, input);

        Execution_Time times = new Execution_Time();
        times.setNormal_query(method_one.record_execution(3));
        times.setOne_index(method_two.record_execution(3));
        times.setTwo_indexes(method_three.record_execution(3));
        times.setOne_view(method_four.record_execution(3));
        times.setTwo_views(method_five.record_execution(3));
        times.setOne_temp_table(method_six.record_execution(3));

        Result result = new Result();
        result.setTable_results(the_table);
        result.setTimes(times);
        return result;
    }

    private Result execute_query4(String input){
        Table_Controller table_controller = new Table_Controller();
        Table the_table = table_controller.execute(4, input);

        Execution_Time times = new Execution_Time();
        times.setNormal_query(method_one.record_execution(4));
        times.setOne_index(method_two.record_execution(4));
        times.setTwo_indexes(method_three.record_execution(4));
        times.setOne_view(method_four.record_execution(4));
        times.setTwo_views(method_five.record_execution(4));
        times.setOne_temp_table(method_six.record_execution(4));

        Result result = new Result();
        result.setTable_results(the_table);
        result.setTimes(times);
        return result;
    }

    private Result execute_query5(String input){
        Table_Controller table_controller = new Table_Controller();
        Table the_table = table_controller.execute(5, input);

        Execution_Time times = new Execution_Time();
        times.setNormal_query(method_one.record_execution(5));
        times.setOne_index(method_two.record_execution(5));
        times.setTwo_indexes(method_three.record_execution(5));
        times.setOne_view(method_four.record_execution(5));
        times.setTwo_views(method_five.record_execution(5));
        times.setOne_temp_table(method_six.record_execution(5));

        Result result = new Result();
        result.setTable_results(the_table);
        result.setTimes(times);
        return result;
    }

    private Result execute_query6(String input){
        Table_Controller table_controller = new Table_Controller();
        Table the_table = table_controller.execute(6, input);

        Execution_Time times = new Execution_Time();
        times.setNormal_query(method_one.record_execution(6));
        times.setOne_index(method_two.record_execution(6));
        times.setTwo_indexes(method_three.record_execution(6));
        times.setOne_view(method_four.record_execution(6));
        times.setTwo_views(method_five.record_execution(6));
        times.setOne_temp_table(method_six.record_execution(6));

        Result result = new Result();
        result.setTable_results(the_table);
        result.setTimes(times);
        return result;
    }

    private Result execute_query7(String input){
        Table_Controller table_controller = new Table_Controller();
        Table the_table = table_controller.execute(7, input);

        Execution_Time times = new Execution_Time();
        times.setNormal_query(method_one.record_execution(7));
        times.setOne_index(method_two.record_execution(7));
        times.setTwo_indexes(method_three.record_execution(7));
        times.setOne_view(method_four.record_execution(7));
        times.setTwo_views(method_five.record_execution(7));
        times.setOne_temp_table(method_six.record_execution(7));

        Result result = new Result();
        result.setTable_results(the_table);
        result.setTimes(times);
        return result;
    }

    private Result execute_query8(String input){
        Table_Controller table_controller = new Table_Controller();
        Table the_table = table_controller.execute(8, input);

        Execution_Time times = new Execution_Time();
        times.setNormal_query(method_one.record_execution(8));
        times.setOne_index(method_two.record_execution(8));
        times.setTwo_indexes(method_three.record_execution(8));
        times.setOne_view(method_four.record_execution(8));
        times.setTwo_views(method_five.record_execution(8));
        times.setOne_temp_table(method_six.record_execution(8));

        Result result = new Result();
        result.setTable_results(the_table);
        result.setTimes(times);
        return result;
    }
}
