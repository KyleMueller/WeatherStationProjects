import java.io.*;
import java.util.Scanner;
import java.util.regex.*;
public class project09
{
    /**
     * For Paper Writing
     * Please Note: if the wrong type of data is entered, this will
     * still crash. It is not till project 4 that regex is added to catch
     * this user error. This one only checks for length of mystr
     */

    String name;
    int temp;
    int speed;
    String direction;
    boolean flag;
    //flag to ensure data is input before it is desired to be printed
    
    
    weatherMeasurement_t history [];
    weatherMeasurement_t temporary = new weatherMeasurement_t();
    int historyCount = 0;
    int historyIndex = 0;
    int arraySize;

    String mystr;
    Scanner scan = new Scanner(System.in);
    public project09(){
        lang inst = lang.getInstance();
        inst.start();
        flag = false;
        name = extra.setName();
        arraySize = extra.getArraySize();
        int a = extra.getUserOption(arraySize);
        history = new weatherMeasurement_t[arraySize];
        while(a != 0){ // while condition for the user has not yet exited the program
            if(a == 2){
                if(flag == true){
                    extra.quickStats(temporary, name);
                }
                else{
                    System.out.println("\n" + inst.get(1)); //1
                }
            }
            else if (a == 1){
                flag = true;
                temporary.setData();
                history[historyIndex] = new weatherMeasurement_t(temporary.getTemp().getTemp(),
                temporary.getWind().getSpeed(), 
                temporary.getWind().getDirection());
                historyCount++;
                historyIndex++;
                historyIndex = historyIndex % arraySize;
            }
            else if (a == 3){
                if(flag){
                    extra.printHistory(history, historyIndex, historyCount, arraySize, name);
                }
                else{
                    System.out.println(inst.get(2)); //2
                    System.out.println(inst.get(3)); //3
                }
            }
            else{
                System.out.println("\n" + inst.get(4));//4
            }
            a = extra.getUserOption(arraySize);
        }        
    }
        
    public static void main(String Args[]){
        project09 prj = new project09();        
    }    
}
