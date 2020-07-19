
import java.io.*;
import java.util.Scanner;
import java.util.regex.*;
public class project04
{
    String name;
    int temp;
    int speed;
    String direction;
    boolean flag;
    //flag to ensure data is input before it is desired to be printed

    String mystr;
    Scanner scan = new Scanner(System.in);
    public project04(){
        flag = false;
        setName();
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
            }
            else{
                System.out.println("\nInvalid Input, try again");
            }
            a = getUserOption();
        }        
    }

    public int getUserOption(){
        int a;
        System.out.println("\nPress 1 to input the weather data");
        System.out.println("Press 2 to print the data");
        System.out.println("Press 0 to exit");
        mystr = scan.nextLine();
        String userRegex = "[0-2]";
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
        mystr = (String) scan.nextLine();
        String tempRegex = "[-]?[0-9]{1,6}";
        if(regExCheck(tempRegex, mystr) && checkValidMystr(mystr)){
            temp = Integer.parseInt(mystr);
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

    public boolean checkValidMystr(String a){
        int num = a.length();
        if(num == 0){
            return false;
        }
        return true;
    }

    public static void main(String Args[]){
        project04 prj = new project04();        
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
}
