import java.io.*;
import java.util.Scanner;
public class project02
{
    public static void main(String Args[]){
        String name;
        int temp;
        int speed;
        String direction;

        String mystr;
        Scanner scan = new Scanner(System.in);
        name = setName();
        temp = setTemp();
        speed = setSpeed();
        direction = setDirection();
        stats(name, temp, speed, direction);
    }
    public static String setName(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please set the name of the weather station.");
        return scan.nextLine();
    }
    public static int setTemp(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please set the temperature at the location. (an integer in F)");
        String mystr = scan.nextLine();
        return Integer.parseInt(mystr);
    }
    public static int setSpeed(){  
        Scanner scan = new Scanner(System.in);
        System.out.println("Please set the wind speed at the location. (an integer)");
        String mystr = scan.nextLine();
        return Integer.parseInt(mystr);
    }
    public static String setDirection(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please set the wind direction at the location. (i.e N,S,E,W,NE,SE etc.)");
        return scan.nextLine();
    }
    public static void stats(String name, int temp, int speed, String direction){
        System.out.print("Location: " + name + "\n");
        System.out.print("Temperature: " + temp + " F\n");
        System.out.print("Wind speed and Direction: " + speed + " " + direction + "\n");
    }
}
