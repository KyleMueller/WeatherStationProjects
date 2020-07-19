
import java.util.Scanner;
public class wind_t
{
    private int mySpeed;
    private String myDirection;
    
    private Scanner scan = new Scanner(System.in);
    private String mystr;
    lang inst = lang.getInstance();
    /**
     * Constructor for objects of class wind_t
     */
    public wind_t()
    {
        mySpeed = 0;
        myDirection = "";
    }
    public wind_t(int a, String b){
        mySpeed = a;
        myDirection = b;
    }
    public void setWind(){
        setSpeed();
        setDirection();
    }
    public int getSpeed(){
        return mySpeed;
    }
    public String getDirection(){
        return myDirection;
    }
    private void setDirection(){
        System.out.print(inst.get(5)); //5
        mystr = scan.nextLine();
        String directionRegex = "[N]|[S]|[E]|[W]|[NE]|[SE]|[SW]|[NW]|[n]|[e]|[s]|[w]|[ne]|[se]|[sw]|[nw]";
        if(extra.regExCheck(directionRegex, mystr)){
            myDirection = mystr;
        }
        else{
            System.out.println("\n" + inst.get(6)); //6
            setDirection();
        } 
    }
    private void setSpeed(){  
        System.out.print(inst.get(7)); //7
        mystr = scan.nextLine();
        String speedRegex = "[0-9]{1,6}";
        if(extra.regExCheck(speedRegex, mystr)){
            mySpeed = Integer.parseInt(mystr);
        }
        else{
            System.out.println("\n" + inst.get(8)); //8
            setSpeed();
        }    
    }
    
}
