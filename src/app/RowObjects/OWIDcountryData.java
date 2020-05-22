package app.RowObjects;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liam Ryan - 2020
 * owid-covid-data.csv
 */
public class OWIDcountryData {
    String name;
    double averageDiseaseSpread;
    List<OWIDtimeData> data = new ArrayList<OWIDtimeData>();
    int totalCases;

    public OWIDcountryData(String theName, double theAverageDiseaseSpread, int theTotalCases){
        name = theName;
        averageDiseaseSpread = theAverageDiseaseSpread;
        totalCases = theTotalCases;
    }
    
    /* 
    ---------------------------
    ---- ACCESSOR METHODS  ----
    ---------------------------
    */
    public String getName(){
        return name;
    }

    public double getAverageDiseaseSpread(){
        return averageDiseaseSpread;
    }

    public List<OWIDtimeData> getData(){
        return data;
    }

    public int getTotalCases(){
        return totalCases;
    }

    public void addData(OWIDtimeData newData){
        data.add(newData);
    }

    //Sorts by average new cases per day, just now realizing I could have used the new cases variable but this math also works
    public static List<OWIDcountryData> sortByDiseaseSpread(List<OWIDcountryData> countries, boolean lowToHigh){
        OWIDcountryData temp;
        if (lowToHigh) {
            // INNEFICIENT SELECTION SORT ALG
            for (int i = 0; i < countries.size() - 1; i++) {	
                //initialize the smallest_index    
                int smallest_index = i;		
                //inner loop locate smallest 
                for(int j = i + 1; j < countries.size(); j++) {
                    if((countries.get(j).getAverageDiseaseSpread()) < (countries.get(smallest_index).getAverageDiseaseSpread())) smallest_index = j;
                }	
                // 3 part swap between loops   
                temp = countries.get(smallest_index);
                countries.set(smallest_index, countries.get(i));		
                countries.set(i, temp);
            }// close the otter loop
        } else {
            for (int i = 0; i < countries.size() - 1; i++) {	
                //initialize the largest_index    
                int largest_index = i;		
                //inner loop locate largest 
                for(int j = i + 1; j < countries.size(); j++) {
                    if((double)(countries.get(j).getAverageDiseaseSpread()) > (double)(countries.get(largest_index).getAverageDiseaseSpread())) largest_index = j;
                }	
                // 3 part swap between loops   
                temp = countries.get(largest_index);
                countries.set(largest_index, countries.get(i));		
                countries.set(i, temp);
            }// close the otter loop
        }
        return countries;
    }

    //Converts an array of OWID data objects to a list of Country objects
    public static ArrayList<OWIDcountryData> owidToCountryConverter(OWIDtimeData[] owidData){
        OWIDtimeData firstOwid = null;
        OWIDtimeData secondOwid = null;
        ArrayList<OWIDcountryData> countries = new ArrayList<OWIDcountryData>();
        for(int i = 0; i < owidData.length; i++){
            if(i == 0 || !owidData[i - 1].getCountry().equals(owidData[i].getCountry())){
                firstOwid = owidData[i];
                secondOwid = OWIDtimeData.findMostRecent(firstOwid.getCountry(), owidData);
                OWIDcountryData temp = new OWIDcountryData(firstOwid.getCountry(), ((double)(secondOwid.getTotalCases())/(double)(OWIDtimeData.dateToNumber(secondOwid.getDate()) - OWIDtimeData.dateToNumber(firstOwid.getDate()))), secondOwid.getTotalCases());
                countries.add(temp);
            }
        }
        return countries;
    }

    //Uses the average cases per day to make a rough estimate of the total cases of a country in a specified number of days
    public static int casePrediction(String country, ArrayList<OWIDcountryData> countries, int numDays){
        int answer = 0;
        for(OWIDcountryData i : countries){
            if(i.getName().equals(country)){
                System.out.println(i.getAverageDiseaseSpread());
                answer =  (int)(i.getTotalCases() + (numDays * i.getAverageDiseaseSpread()));
            }
        }
        return answer;
    }
}