import java.util.Scanner;
public class temperature_t
{
    private int temp;
    private Scanner scan = new Scanner(System.in);
    String mystr;
    /**
     * Constructor for objects of class temperature_t
     */
    public temperature_t()
    {
        // initialise temp as zero as null value
        temp = 0;
    }
    public temperature_t(int a){
        temp = a;
    }
    public void setTemp(){
        System.out.print("\nPlease set the temperature at the location. (an integer in F): ");
        mystr = scan.nextLine();
        String tempRegex = "[-]?[0-9]{1,6}";
        if(extra.regExCheck(tempRegex, mystr)){
            temp = Integer.parseInt(mystr);
        }
        else{
            System.out.println("\nUser input invalid. Please try again");
            setTemp();
        }  
    }
    public int getTemp(){
        return temp;
    }

}
