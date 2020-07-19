import java.util.*;
import java.io.*;
public class stationManager
{
    public static void main(String Args[]){
        lang inst = lang.getInstance();
        inst.start();
        Map<Integer,station> myStations = new HashMap<Integer,station>();
        int a = getUserChoice();
        int numStations = 0;
        Scanner scan = new Scanner(System.in);
        while(true){
            if(a == 0){ //exit
                break;
            }
            else if(a == 1){//create new station
                numStations++;
                station temp = new station();
                //temp.originalProcess();
                myStations.put(numStations,temp);
            }
            else if(a == 2){//manage existing station
                if(numStations == 0){
                    System.out.println(inst.get(33)); //33
                }
                else{
                    String stationRegex = "[1-9]|[0-9]{2,6}";
                    do{
                        System.out.println(inst.get(41)); //41
                        for(int i = 1; i <= numStations; i++){
                            System.out.println(i + ":" + myStations.get(i).getName());
                        }
                        System.out.print(inst.get(40)); //40
                        String statNum = scan.nextLine();
                        if(extra.regExCheck(stationRegex, statNum)){
                            int b = Integer.parseInt(statNum);
                            myStations.get(b).originalProcess();
                            break;
                        }
                        else{
                            System.out.println(inst.get(34)); //34
                        }
                    }while(true);
                }
            }
            else{// print all histories
                if(numStations == 0){
                    System.out.println(inst.get(33)); //33
                }
                else{
                    for(int i = 1; i <= numStations; i++){
                        myStations.get(i).printStationHistory();
                    }
                }
            }
            a = getUserChoice();
        }
    }
    public static int getUserChoice(){
        lang inst = lang.getInstance();
        System.out.println(inst.get(35)); //35
        System.out.println(inst.get(36)); //36
        System.out.println(inst.get(37)); //37
        System.out.println(inst.get(38)); //38
        System.out.println(inst.get(39)); //39
        System.out.print(inst.get(40)); //40
        Scanner scan = new Scanner(System.in);
        String inputRegex = "[0-3]";
        String mystr = scan.nextLine();
        if(extra.regExCheck(inputRegex, mystr)){
            return Integer.parseInt(mystr);
        }
        else{
            System.out.println(inst.get(34));//34
            return getUserChoice();
        }
    }
}
