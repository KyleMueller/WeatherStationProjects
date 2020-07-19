import java.io.*;
import java.util.Scanner;
import java.util.regex.*;
public class project06
{
    String name;
    int temp;
    int speed;
    String direction;
    boolean flag;
    //flag to ensure data is input before it is desired to be printed
    
    
    int [] tempHistory;
    int [] speedHistory;
    String [] directionHistory;
    int historyCount = 0;
    int historyIndex = 0;
    int arraySize;

    String mystr;
    Scanner scan = new Scanner(System.in);
    public project06(){
        flag = false;
        setName();
        getArraySize();
        int a = getUserOption();
        while(a != 0){ // while condition for the user has not yet exited the program
            if(a == 2){
                if(flag == true){
                    stats();
                }
                else{
                    System.out.println("\nNo data to print.");
                }
            }
            else if (a == 1){
                setTemp();
                setSpeed();
                setDirection();
                historyCount++;
                historyIndex++;
                historyIndex = historyIndex % arraySize;
            }
            else if (a == 3){
                if(flag){
                    printHistory();
                }
                else{
                    System.out.println("This is not the history you are looking for.");
                    System.out.println("No history to print");
                }
            }
            else{
                System.out.println("\nInvalid Input, try again");
            }
            a = getUserOption();
        }        
    }
    
    public void getArraySize(){
        String arraySizeRegex = "[1-9]|[0-9]{2,3}";
        System.out.print("Enter the size of the array(From 1-999):");
        mystr = scan.nextLine();
        if(regExCheck(arraySizeRegex, mystr) && checkValidMystr(mystr)){
            arraySize = Integer.parseInt(mystr);
            tempHistory = new int[arraySize];
            speedHistory = new int[arraySize];
            directionHistory = new String[arraySize];
        }
        else{
            System.out.println("\nInvalid Input, please try again");
            getArraySize();
        }
    }

    public int getUserOption(){
        int a;
        System.out.println("\nPress 1 to input the weather data");
        System.out.println("Press 2 to print the data");
        System.out.println("Press 3 to print up to last " + arraySize + " measurements");
        System.out.println("Press 0 to exit");
        mystr = scan.nextLine();
        String userRegex = "[0-3]";
        if(regExCheck(userRegex, mystr) && checkValidMystr(mystr)){
            a = Integer.parseInt(mystr);
            return a;
        }
        else{
            System.out.println("\nInvalid Input, please try again");
            return getUserOption();
        }  
    }

    public void setName(){
        System.out.print("Please set the name of the weather station: ");
        mystr = scan.nextLine();
        if(checkValidMystr(mystr)){
            name = mystr;
        }
        else{
            System.out.println("\nUser input an empty line. Please try again");
            setName();
        }
    }

    public void setTemp(){
        System.out.print("\nPlease set the temperature at the location. (an integer in F): ");
        mystr = scan.nextLine();
        String tempRegex = "[-]?[0-9]{1,6}";
        if(regExCheck(tempRegex, mystr) && checkValidMystr(mystr)){
            temp = Integer.parseInt(mystr);
            tempHistory[historyIndex] = temp;
        }
        else{
            System.out.println("\nUser input invalid. Please try again");
            setTemp();
        }  
        flag = true;
    }

    public void setSpeed(){  
        System.out.print("Please set the wind speed at the location. (an integer): ");
        mystr = scan.nextLine();
        String speedRegex = "[0-9]{1,6}";
        if(regExCheck(speedRegex, mystr) && checkValidMystr(mystr)){
            speed = Integer.parseInt(mystr);
            speedHistory[historyIndex] = speed;
        }
        else{
            System.out.println("\nUser input invalid. Please try again");
            setSpeed();
        }    
    }

    public void setDirection(){
        System.out.print("Please set the wind direction at the location. (i.e N,S,E,W,NE,SE etc.): ");
        mystr = scan.nextLine();
        String directionRegex = "[N]|[S]|[E]|[W]|[NE]|[SE]|[SW]|[NW]|[n]|[e]|[s]|[w]|[ne]|[se]|[sw]|[nw]";
        if(regExCheck(directionRegex, mystr) && checkValidMystr(mystr)){
            direction = mystr;
            directionHistory[historyIndex] = direction;
        }
        else{
            System.out.println("\nUser input invalid. Please try again");
            setDirection();
        } 
    }

    public void stats(){
        System.out.print("\nLocation: " + name + "\n");
        System.out.print("Temperature: " + temp + " F\n");
        System.out.print("Wind speed and Direction: " + speed + " " + direction + "\n");
    }
    
    public void statsGiven(String n, int t, int s, String d){
        System.out.print("Location: " + n + "\n");
        System.out.print("Temperature: " + t + " F\n");
        System.out.print("Wind speed and Direction: " + s + " " + d + "\n\n");
    }

    public boolean checkValidMystr(String a){
        int num = a.length();
        if(num == 0){
            return false;
        }
        return true;
    }

    public static void main(String Args[]){
        project06 prj = new project06();        
    }
    
    //check for Regexs,
    public static boolean regExCheck(String regex, String input){
        Pattern check = Pattern.compile(regex);
        Matcher matcher = check.matcher(input);
        if(matcher.matches()){
            return true;
        }
        return false;
    }
    
    public void printHistory(){
        System.out.println("Displaying up to last four readings: #1 as the most recent.");
        int m;
        m = historyIndex; // used to not change value of historyIndex
        if(historyCount > arraySize){ //history arrays overflowed
            int k = 1;         
            for(int r = 0; r < arraySize; r++){
                m--;
                if(m == -1){
                    m = arraySize - 1;
                }
                System.out.println("Reading #" + k);
                k++;
                statsGiven(name, tempHistory[m], speedHistory[m], directionHistory[m]);
            }
        }
        else{ //history arrays did not overflow
            int j = 1;
            if(m == 0){ m = arraySize;}
            for(int i = m - 1; i > -1; i--){
                System.out.println("Reading #" + j);
                j++;
                statsGiven(name, tempHistory[i], speedHistory[i], directionHistory[i]);
            }
        }
    }
}
