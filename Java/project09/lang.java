import java.util.*;
import java.io.*;
public class lang
{
    private static Map<String,String> knownLang = new HashMap<String,String>();
    private static Map<Integer,String> langMap = new HashMap<Integer,String>();
    private static lang instance;
    private lang(){
        try{
            instance = new lang();
        }
        catch(Exception e){
        }
        loadKnown();
    }

    public static lang getInstance(){
        return instance;
    }

    public static void start(){
        loadKnown();
    }

    private static void loadKnown(){
        try{
            InputStream stream = lang.class.getResourceAsStream("README.TXT");
            BufferedReader in = new BufferedReader(new InputStreamReader(stream));
            String line = "";

            while((line = in.readLine()) != null){
                if(line.substring(0,4).equals("know")){
                    String parts[] = line.split(" ");
                    knownLang.put(parts[0], parts[1]);
                }
                else{
                    break;
                }
            }
            in.close();
            System.out.println("Choose a language(by number):");
            Iterator it = knownLang.entrySet().iterator();
            int knownNum = 0;
            while(it.hasNext()){
                knownNum++;
                System.out.println(knownNum + ":" + knownLang.get("know" + knownNum));
                it.next();
            }
            System.out.print("Choice:");
            String regex = "[1-9]|[0-9]{2,3}";
            Scanner scan = new Scanner(System.in);
            String mystr;
            do{
                mystr = scan.nextLine();
                if(!extra.regExCheck(regex,mystr)){
                    System.out.println("Invalid Input.");
                    System.out.print("Choice:");
                    continue;
                }
                else if(Integer.parseInt(mystr) > knownNum){
                    System.out.println("I don't know that many languages.");
                    System.out.print("Choice:");
                    continue;
                }
                else{
                    break;
                }      
            }while(true);
            int langChoice = Math.abs(Integer.parseInt(mystr));
            loadChoice(langChoice);
        }
        catch(Exception e){
            System.out.println("Error reading known langs");
        }
    }
    private static void loadChoice(int a){
        langMap.clear();
        String line = "";
        BufferedReader in;
        InputStream stream;
        int numLine = 1;
        try{
            stream = lang.class.getResourceAsStream("README.TXT");
            in = new BufferedReader(new InputStreamReader(stream));
            line = "";
            numLine = 1;
            while((line = in.readLine()) != null){
                if(line.substring(0,2).equals("s" + a)){
                    String parts[] = line.split(" ");
                    langMap.put(numLine, parts[1]);
                    numLine++;
                }
            }
        }
        catch(Exception e){
            System.out.println("Error reading in chosen language.");
        }
    }
    public static String get(int a){
        String current = langMap.get(a);
        current = current.replaceAll("_"," ");
        return current;
    }
}
