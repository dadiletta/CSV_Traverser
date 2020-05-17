package app.RowObjects;

/**
 * https://ourworldindata.org/coronavirus-source-data
 * total_deaths.csv
 * @author Charlie M. - 2020
 */
public class OxfordData {

    String date;
    int china;
    public int chinaNewDeaths;
    int usa;
    public int usaNewDeaths;
    int canada;
    public int canadaNewDeaths;
    int russia;
    public int russiaNewDeaths;
    int india;
    public int indiaNewDeaths;
    int germany;
    public int germanyNewDeaths;
    int southKorea;
    public int southKoreaNewDeaths;
    int mexico;
    public int mexicoNewDeaths;

    public OxfordData(String[] data){
        date = data[0];
        try{
            china = Integer.parseInt(data[43]);
        }
        catch(Exception e){
            china = 0;
        }

        try{
            usa = Integer.parseInt(data[200]);
        }
        catch(Exception e){
            usa = 0;
        }
        
        try{
            canada = Integer.parseInt(data[37]);
        }
        catch(Exception e){
            canada = 0;
        }

        try{
            russia = Integer.parseInt(data[158]);
        }
        catch(Exception e){
            russia = 0;
        }
        
        try{
            india = Integer.parseInt(data[91]);
        }
        catch(Exception e){
            india = 0;
        }

        try{
            germany = Integer.parseInt(data[75]);
        }
        catch(Exception e){
            germany = 0;
        }

        try{
            southKorea = Integer.parseInt(data[176]);
        }
        catch(Exception e){
            southKorea = 0;
        }

        try{
            mexico = Integer.parseInt(data[126]);
        }
        catch(Exception e){
            mexico = 0;
        }
    }

    public static void populateNewDeathData(OxfordData[] oxfordData){
        int chinaGreatestDeaths = 0;
        for(int i = 1; i < oxfordData.length - 1; i++){
            oxfordData[i].chinaNewDeaths = oxfordData[i].china() - oxfordData[i - 1].china();
            if(oxfordData[i].chinaNewDeaths > chinaGreatestDeaths) chinaGreatestDeaths = oxfordData[i].chinaNewDeaths;
        }

        int usaGreatestDeaths = 0;
        for(int i = 1; i < oxfordData.length - 1; i++){
            oxfordData[i].usaNewDeaths = oxfordData[i].usa() - oxfordData[i - 1].usa();
            if(oxfordData[i].usaNewDeaths > usaGreatestDeaths) usaGreatestDeaths = oxfordData[i].usaNewDeaths;
        }

        int canadaGreatestDeaths = 0;
        for(int i = 1; i < oxfordData.length - 1; i++){
            oxfordData[i].canadaNewDeaths = oxfordData[i].canada() - oxfordData[i - 1].canada();
            if(oxfordData[i].canadaNewDeaths > canadaGreatestDeaths) canadaGreatestDeaths = oxfordData[i].canadaNewDeaths;
        }

        int russiaGreatestDeaths = 0;
        for(int i = 1; i < oxfordData.length - 1; i++){
            oxfordData[i].russiaNewDeaths = oxfordData[i].russia() - oxfordData[i - 1].russia();
            if(oxfordData[i].russiaNewDeaths > russiaGreatestDeaths) russiaGreatestDeaths = oxfordData[i].russiaNewDeaths;
        }

        int indiaGreatestDeaths = 0;
        for(int i = 1; i < oxfordData.length - 1; i++){
            oxfordData[i].indiaNewDeaths = oxfordData[i].india() - oxfordData[i - 1].india();
            if(oxfordData[i].indiaNewDeaths > indiaGreatestDeaths) indiaGreatestDeaths = oxfordData[i].indiaNewDeaths;
        }

        int germanyGreatestDeaths = 0;
        for(int i = 1; i < oxfordData.length - 1; i++){
            oxfordData[i].germanyNewDeaths = oxfordData[i].germany() - oxfordData[i - 1].germany();
            if(oxfordData[i].germanyNewDeaths > germanyGreatestDeaths) germanyGreatestDeaths = oxfordData[i].germanyNewDeaths;
        }

        int southKoreaGreatestDeaths = 0;
        for(int i = 1; i < oxfordData.length - 1; i++){
            oxfordData[i].southKoreaNewDeaths = oxfordData[i].southKorea() - oxfordData[i - 1].southKorea();
            if(oxfordData[i].southKoreaNewDeaths > southKoreaGreatestDeaths) southKoreaGreatestDeaths = oxfordData[i].southKoreaNewDeaths;
        }

        int mexicoGreatestDeaths = 0;
        for(int i = 1; i < oxfordData.length - 1; i++){
            oxfordData[i].mexicoNewDeaths = oxfordData[i].mexico() - oxfordData[i - 1].mexico();
            if(oxfordData[i].mexicoNewDeaths > mexicoGreatestDeaths) mexicoGreatestDeaths = oxfordData[i].mexicoNewDeaths;
        }

        System.out.println("The greatest amount of deaths in a single day for China is " + chinaGreatestDeaths);
        System.out.println("The greatest amount of deaths in a single day for the USA is " + usaGreatestDeaths);
        System.out.println("The greatest amount of deaths in a single day for Canada is " + canadaGreatestDeaths);
        System.out.println("The greatest amount of deaths in a single day for Russia is " + russiaGreatestDeaths);
        System.out.println("The greatest amount of deaths in a single day for India is " + indiaGreatestDeaths);
        System.out.println("The greatest amount of deaths in a single day for Germany is " + germanyGreatestDeaths);
        System.out.println("The greatest amount of deaths in a single day for South Korea is " + southKoreaGreatestDeaths);
        System.out.println("The greatest amount of deaths in a single day for Mexico is " + mexicoGreatestDeaths);
    }

    // -----------------
    // ACCESSOR METHODS
    // -----------------

    public String date(){
        return date;
    }

    public int china(){
        return china;
    }

    public int usa(){
        return usa;
    }

    public int canada(){
        return canada;
    }

    public int russia(){
        return russia;
    }

    public int india(){
        return india;
    }

    public int germany(){
        return germany;
    }

    public int southKorea(){
        return southKorea;
    }

    public int mexico(){
        return mexico;
    }

}