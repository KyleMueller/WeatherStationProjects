import java.util.Scanner;
public class weatherMeasurement_t
{
    wind_t myWind;
    temperature_t myTemp;

    public weatherMeasurement_t()
    {
        myWind = new wind_t(0,"null");
        myTemp = new temperature_t(0);
    }
    public weatherMeasurement_t(int tem, int spe, String dir){
        myWind =  new wind_t(spe, dir);
        myTemp = new temperature_t(tem);
    }
    public void setData(){
        myTemp.setTemp();
        myWind.setWind();
    }
    public wind_t getWind(){
        return myWind;
    }
    public temperature_t getTemp(){
        return myTemp;
    }
}
