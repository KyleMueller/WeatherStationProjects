import java.util.Scanner;
public class temperature_t
{
    private int temp;
    private Scanner scan = new Scanner(System.in);
    String mystr;
    lang inst = lang.getInstance();
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
        System.out.print("\n" + inst.get(9)); //9
        mystr = scan.nextLine();
        String tempRegex = "[-]?[0-9]{1,6}";
        if(extra.regExCheck(tempRegex, mystr)){
            temp = Integer.parseInt(mystr);
        }
        else{
            System.out.println("\n" + inst.get(10));//10
            setTemp();
        }  
    }
    public int getTemp(){
        return temp;
    }

}
