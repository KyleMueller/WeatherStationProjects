
import java.io.*;
import java.util.Scanner;
import java.util.regex.*;
public class project08
{
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
    public project08(){
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
                    System.out.println("\nNo data to print.");
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
                    System.out.println("This is not the history you are looking for.");
                    System.out.println("No history to print");
                }
            }
            else{
                System.out.println("\nInvalid Input, try again");
            }
            a = extra.getUserOption(arraySize);
        }        
    }
        
    public static void main(String Args[]){
        project08 prj = new project08();        
    }    
}
