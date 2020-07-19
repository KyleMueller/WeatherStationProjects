
import java.util.Scanner;
import java.util.regex.*;
public class extra
{ 
    public static boolean regExCheck(String regex, String input){
        Pattern check = Pattern.compile(regex);
        Matcher matcher = check.matcher(input);
        if(matcher.matches()){
            return true;
        }
        return false;
    }
    public static int getArraySize(){
        Scanner scan = new Scanner(System.in);
        String mystr;
        String arraySizeRegex = "[1-9]||[0-9]{2,3}";
        while(true){
            System.out.print("Enter the size of the array(From 1-999):");
            mystr = scan.nextLine();
            if(extra.regExCheck(arraySizeRegex, mystr)){
                return Integer.parseInt(mystr);          
            }
            else{
                System.out.println("\nInvalid Input, please try again");
            }
        }
    }
    public static String setName(){
        String mystr;
        Scanner scan = new Scanner(System.in);
        System.out.print("Please set the name of the weather station: ");
        mystr = scan.nextLine();
        if(mystr.length() >= 1){
            return mystr;
        }
        else{
            System.out.println("\nUser input an empty line. Please try again");
            return setName();
        }
    }
    public static void quickStats(weatherMeasurement_t a, String name){
        statsGiven(name, a.getTemp().getTemp(), a.getWind().getSpeed(),
        a.getWind().getDirection());
    }
    public static void statsGiven(String n, int t, int s, String d){
        System.out.print("Location: " + n + "\n");
        System.out.print("Temperature: " + t + " F\n");
        System.out.print("Wind speed and Direction: " + s + " " + d + "\n\n");
    }
    public static void printHistory(weatherMeasurement_t [] weatherHistory, int historyIndex,
        int historyCount, int arraySize, String name){
        System.out.println("Displaying up to last " + arraySize + 
        " readings: #1 as the most recent.");
        int m;
        m = historyIndex; 
        if(historyCount > arraySize){ //history arrays overflowed
            int k = 1;         
            for(int r = 0; r < arraySize; r++){
                m--;
                if(m == -1){
                    m = arraySize - 1;
                }
                System.out.println("Reading #" + k);
                k++;
                statsGiven(name, weatherHistory[m].getTemp().getTemp(),
                weatherHistory[m].getWind().getSpeed(), 
                weatherHistory[m].getWind().getDirection());
            }
        }
        else{ //history arrays did not overflow
            int j = 1;
            if(m == 0){ m = arraySize;}
            for(int i = m - 1; i > -1; i--){
                System.out.println("Reading #" + j);
                j++;
                statsGiven(name, weatherHistory[i].getTemp().getTemp(),
                weatherHistory[i].getWind().getSpeed(), 
                weatherHistory[i].getWind().getDirection());
            }
        }
    }
    public static int getUserOption(int arraySize){
        Scanner scan = new Scanner(System.in);
        int a;
        String mystr;
        System.out.println("\nPress 1 to input the weather data");
        System.out.println("Press 2 to print the data");
        System.out.println("Press 3 to print up to last " + arraySize + " measurements");
        System.out.println("Press 0 to exit");
        mystr = scan.nextLine();
        String userRegex = "[0-3]";
        if(regExCheck(userRegex, mystr)){
            a = Integer.parseInt(mystr);
            return a;
        }
        else{
            System.out.println("\nInvalid Input, please try again");
            return getUserOption(arraySize);
        }  
    }
}
