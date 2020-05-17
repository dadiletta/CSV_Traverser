package app.RowObjects;

import java.util.ArrayList;

/**
 * @author Joe P. - 2020
 * owid-covid-data.csv
 */
public class OWIDData {
    String isoCode;
    String country;
    String update;
    int totalCases;
    int totalTests;
    int totalDeaths;

    /**
     * Constructor method. This takes the raw String[] from the CSV and creates
     * a data object.
     * @param data the String[] built from the App's importer
     */
    public OWIDData(String[] data){
        isoCode = data[0];
        country = data[1];
        update = data[2];
        try{
            totalCases = Integer.parseInt(data[3]);
        } catch (Exception e){
            totalCases = 0;
        }
        try{
            totalTests = Integer.parseInt(data[11]);
        } catch(Exception e){
            totalTests = 0;
        }
        try{
            totalDeaths = Integer.parseInt(data[5]);
        } catch(Exception e){
            totalDeaths = 0;
        }
        
    }

    /* 
    ---------------------------
    ---- ACCESSOR METHODS  ----
    ---------------------------
    */
    public String isoCode(){
        return isoCode;
    }
    public int deaths(){
        return totalDeaths;
    }

     public String lastUpdate(){
        return update;
    }


    public int tests(){
        return totalTests;
    }

    public int cases(){
        return totalCases;
    }

    public String country(){
        return country;
    }

    public double negativeTestResults(){
        double k = (double)totalCases;
        double s = (double)totalTests;
        if(s == 0.0) return -1;
        return (k / s)*100;
    }

    /**
     * This is the static helper methods from this point on.
     * @param owidData
     * @param isoCode
     * @return
     */
    public static ArrayList<OWIDData> filterByCountry(OWIDData[] owidData, String isoCode){
        ArrayList<OWIDData> k = new ArrayList<OWIDData>();
        for(int i = 0; i < owidData.length; i++){
            if(owidData[i].isoCode().equals(isoCode)){
                k.add(owidData[i]);
            }
        }
        return k;
    }

    public static ArrayList<OWIDData> filterByMostRecent(OWIDData[] owidData){
        ArrayList<OWIDData> k = new ArrayList<OWIDData>();
        for(int i = 1; i < owidData.length; i++){
            if(!owidData[i-1].isoCode().equals(owidData[i].isoCode())){
                for(int b = i-1; b >= 0 && owidData[i-1].isoCode().equals(owidData[b].isoCode()); b--){
                    if(owidData[b].tests() != 0 && owidData[b].tests() != -1){
                        k.add(owidData[b]);
                        break;
                    }
                }
            }
        }
        return k;
    }
    /**
     * Static helper method. It takes rows from a CSV that have been converted into 
     * instantiated copies of this file. Arrays of data objects can be passed
     * into this static helper so we sort according to a particular property. 
     * @param OWIDData array of objects holding each row's data
     * @param lowToHigh toggle sort order
     * @return sorted array
     */
    public static ArrayList<OWIDData> sortByNegResults(OWIDData[] owidData, boolean lowToHigh) {
        OWIDData temp;
        // sorts each country to find only newest date
        ArrayList<OWIDData> oData = filterByMostRecent(owidData);
        //sorts through the neg test results
        if (lowToHigh) {
            // INNEFICIENt SELECTION SORT ALG
            for (int i = 0; i < oData.size() - 1; i++) {	
                //initialize the smallest_index    
                int smallest_index = i;	
                //inner loop locate smallest 
                for(int j = i + 1; j < oData.size(); j++) {
                    if(oData.get(j).negativeTestResults() < oData.get(smallest_index).negativeTestResults()) smallest_index = j;
                }	
                // 3 part swap between loops 
                temp = oData.get(smallest_index);
                oData.set( smallest_index, oData.get(i));		
                oData.set( i, temp);
            }// close the otter loop
        } else {
            for (int i = 0; i < oData.size() - 1; i++) {	
                //initialize the smallest_index    
                int largest_index = i;		
                //inner loop locate smallest 
                for(int j = i + 1; j < oData.size(); j++) {
                    if(oData.get(j).negativeTestResults() > oData.get(largest_index).negativeTestResults()) largest_index = j;
                }	
                // 3 part swap between loops   
                temp = oData.get(largest_index);
                oData.set( largest_index, oData.get(i));		
                oData.set( i, temp);
            } 
        }
        return oData;
    }

}