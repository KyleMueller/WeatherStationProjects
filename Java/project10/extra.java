import java.util.Scanner;
import java.util.regex.*;
public class extra
{ 
    lang inst = lang.getInstance();
    public static boolean regExCheck(String regex, String input){
        Pattern check = Pattern.compile(regex);
        Matcher matcher = check.matcher(input);
        if(matcher.matches()){
            return true;
        }
        return false;
    }
    public static int getArraySize(){
        lang inst = lang.getInstance();
        Scanner scan = new Scanner(System.in);
        String mystr;
        String arraySizeRegex = "[1-9]||[0-9]{2,3}";
        while(true){
            System.out.print(inst.get(11));//11
            mystr = scan.nextLine();
            if(extra.regExCheck(arraySizeRegex, mystr)){
                return Integer.parseInt(mystr);          
            }
            else{
                System.out.println("\n" + inst.get(12));//12
            }
        }
    }
    public static String setName(){
        lang inst = lang.getInstance();
        String mystr;
        Scanner scan = new Scanner(System.in);
        System.out.print(inst.get(13));//13 
        mystr = scan.nextLine();
        if(mystr.length() >= 1){
            return mystr;
        }
        else{
            System.out.println("\n" + inst.get(14));//14
            return setName();
        }
    }
    public static void quickStats(weatherMeasurement_t a, String name){
        statsGiven(name, a.getTemp().getTemp(), a.getWind().getSpeed(),
        a.getWind().getDirection());
    }
    public static void statsGiven(String n, int t, int s, String d){
        lang inst = lang.getInstance();
        System.out.print(inst.get(15) + n + "\n");//15 
        System.out.print(inst.get(17) + t + inst.get(18) + "\n");//17 and 18
        System.out.print(inst.get(19) + s + inst.get(20) + d + "\n\n");//19 and 20
    }
    public static void printHistory(weatherMeasurement_t [] weatherHistory, int historyIndex,
        int historyCount, int arraySize, String name){
        lang inst = lang.getInstance();
        System.out.println(inst.get(22) + arraySize + inst.get(23));//22 and 23
        int m;
        m = historyIndex; 
        if(historyCount > arraySize){ //history arrays overflowed
            int k = 1;         
            for(int r = 0; r < arraySize; r++){
                m--;
                if(m == -1){
                    m = arraySize - 1;
                }
                System.out.println(inst.get(24) + k);//24
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
                System.out.println(inst.get(24) + j);//24
                j++;
                statsGiven(name, weatherHistory[i].getTemp().getTemp(),
                weatherHistory[i].getWind().getSpeed(), 
                weatherHistory[i].getWind().getDirection());
            }
        }
    }
    public static int getUserOption(int arraySize){
        lang inst = lang.getInstance();
        Scanner scan = new Scanner(System.in);
        int a;
        String mystr;
        System.out.println("\n" + inst.get(25));//25
        System.out.println(inst.get(26));//26
        System.out.println(inst.get(27) + arraySize + inst.get(28));//27 and 28
        System.out.println(inst.get(29));//29
        mystr = scan.nextLine();
        String userRegex = "[0-3]";
        if(regExCheck(userRegex, mystr)){
            a = Integer.parseInt(mystr);
            return a;
        }
        else{
            System.out.println("\n" + inst.get(30));//30
            return getUserOption(arraySize);
        }  
    }
}
