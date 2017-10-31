package model;

import java.util.ArrayList;

public class Table {
    private ArrayList<String> column1;
    private ArrayList<String> column2;
    private ArrayList<String> column3;
    private ArrayList<String> column4;
    private ArrayList<String> column5;
    private ArrayList<String> column6;
    private ArrayList<String> column7;
    private String[] headers;

    public Table(String[] headers){
        column1 = new ArrayList<>();
        column2 = new ArrayList<>();
        column3 = new ArrayList<>();
        column4 = new ArrayList<>();
        column5 = new ArrayList<>();
        column6 = new ArrayList<>();
        column7 = new ArrayList<>();

        this.headers = headers;
    }

    public void addData(int colNum, String data){
        switch(colNum){
            case 1: column1.add(data);
                break;

            case 2: column2.add(data);
                break;

            case 3: column3.add(data);
                break;

            case 4: column4.add(data);
                break;

            case 5: column5.add(data);
                break;

            case 6: column6.add(data);
                break;

            case 7: column7.add(data);
                break;
        }
    }

    public String[][] getTable(){
        String[][] theTable = new String[column1.size()][7];

        for(int i = 0; i < 7; i++){
            for(int j = 0; j < column1.size(); i++){
                switch(i + 1){
                    case 1: theTable[j][i] = column1.get(j);
                    break;

                    case 2: theTable[j][i] = column2.get(j);
                    break;

                    case 3: theTable[j][i] = column3.get(j);
                    break;

                    case 4: theTable[j][i] = column4.get(j);
                    break;

                    case 5: theTable[j][i] = column5.get(j);
                    break;

                    case 6: theTable[j][i] = column6.get(j);
                    break;

                    case 7: theTable[j][i] = column7.get(j);
                    break;
                }
            }
        }

        return theTable;
    }
}
