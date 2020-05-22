package app.RowObjects;

import java.util.List;

/**
 * @author Liam Ryan - 2020
 * owid-covid-data.csv
 */
public class OWIDtimeData{
    String country;
    String date;
    int totalCases;
    int newCases;
    int totalDeaths;
    int newDeaths;
    int totalTests;
    int newTests;
    double casesTestedRatio;

    public OWIDtimeData(String[] data) {
        country = data[1];
        date = data[2];
        totalCases = Integer.parseInt(data[3]);
        newCases = Integer.parseInt(data[4]);
        totalDeaths = Integer.parseInt(data[5]);
        newDeaths = Integer.parseInt(data[6]);
        try{
            totalTests = Integer.parseInt(data[11]);
        } catch(final Exception e){
            totalTests = 0;
        }
        try{
            newTests = Integer.parseInt(data[12]);
        } catch(final Exception e){
            newTests = 0;
        }
        if(totalTests == 0){
            casesTestedRatio = 0;
        }
        else{
            casesTestedRatio = ((double)totalCases)/((double)totalTests);
        }
    }

    /* 
    ---------------------------
    ---- ACCESSOR METHODS  ----
    ---------------------------
    */

    public String getCountry(){
        return country;
    }

     public String getDate(){
        return date;
    }

    public int getTotalCases(){
        return totalCases;
    }

    public int getNewCases(){
        return newCases;
    }

    public int getTotalDeaths(){
        return totalDeaths;
    }

    public int getNewDeaths(){
        return newDeaths;
    }

    public int getTotalTests(){
        return totalTests;
    }

    public int getNewTests(){
        return newTests;
    }

    public double getCasesTestedRatio(){
        return casesTestedRatio;
    }

    //Two methods that determine the average cases per day of a country, either using two OWID objects or an array
    public static double getAverageDiseaseSpreadOverInterval(OWIDtimeData owidOne, OWIDtimeData owidTwo) {
        double totalCases = owidTwo.getTotalCases();
        double days1 = dateToNumber(owidOne.getDate());
        double days2 = dateToNumber(owidTwo.getDate());
        double diseaseSpread = totalCases/(days2-days1);
        return diseaseSpread;
}

    
     public static double getAverageDiseaseSpreadOverInterval(OWIDtimeData[] data, String country, String startDate, String endDate) {
        double diseaseSpread = 0;
        double totalCases = 0;
        double days1 = 0;
        double days2 = 0;

        for(int i = 0; i < data.length; i++){
            if(data[i].getCountry().equals(country) && data[i].getDate().equals(startDate)){
                days1 = OWIDtimeData.dateToNumber(data[i].getDate());
            }
            else if(data[i].getCountry().equals(country) && data[i].getDate().equals(endDate)){
                days2 = OWIDtimeData.dateToNumber(data[i].getDate());
                totalCases = data[i].getTotalCases();
            }
        }
        diseaseSpread = totalCases/(days2-days1);
        return diseaseSpread;
    }

    //Useful helper methods for determining most/least recent, and necessary for the disease spread over time methods
    public static int dateToNumber(final String date){
        int year = Integer.parseInt(date.substring(0, date.indexOf("-"))) * 365;
        int month = monthTranslator(Integer.parseInt(date.substring(date.indexOf("-") + 1, date.indexOf("-") + 3)));
        int day = Integer.parseInt(date.substring(date.indexOf("-") + 4));
        return year + month + day;
    }

    public static int monthTranslator(int month){
        //Calibrated for leap year
        int numDays = 0;
        for(int i = 1; i <= month; i++){
            if(i == 2){
                numDays += 29;
            }
            else if(i == 4 || i== 6 || i == 9 || i == 11){
                numDays += 30;
            }
            else{
                numDays += 31;
            }
        }
        return numDays;
    }

    //Sorts an array of OWID data based on number of total cases
    public static OWIDtimeData[] sortByTotalCases(OWIDtimeData[] owidData, boolean lowToHigh) {
        OWIDtimeData temp;
        if (lowToHigh) {
            // INNEFICIENt SELECTION SORT ALG
            for (int i = 0; i < owidData.length - 1; i++) {	
                //initialize the smallest_index    
                int smallest_index = i;		
                //inner loop locate smallest 
                for(int j = i + 1; j < owidData.length; j++) {
                    if(owidData[j].getTotalCases() < owidData[smallest_index].getTotalCases()) smallest_index = j;
                }	
                // 3 part swap between loops   
                temp = owidData[ smallest_index ];
                owidData[ smallest_index ] = owidData[i];		
                owidData[ i ] = temp;
            }// close the otter loop
        } else {
            for (int i = 0; i < owidData.length - 1; i++) {	
                //initialize the largest_index    
                int largest_index = i;		
                //inner loop locate largest
                for(int j = i + 1; j < owidData.length; j++) {
                    if(owidData[j].getTotalCases() > owidData[largest_index].getTotalCases()) largest_index = j;
                }	
                // 3 part swap between loops   
                temp = owidData[largest_index];
                owidData[largest_index] = owidData[i];		
                owidData[i] = temp;
            } 
        }
        return owidData;
    }

    //Sorts data by most recently collected, could show what countries are falling behind in collecting data
    public static OWIDtimeData[] sortByMostRecent(OWIDtimeData[] owidData, boolean lowToHigh) {
        OWIDtimeData temp;
        if (lowToHigh) {
            // INNEFICIENt SELECTION SORT ALG
            for (int i = 0; i < owidData.length - 1; i++) {	
                //initialize the smallest_index    
                int smallest_index = i;		
                //inner loop locate smallest 
                for(int j = i + 1; j < owidData.length; j++) {
                    if(OWIDtimeData.dateToNumber(owidData[j].getDate()) < OWIDtimeData.dateToNumber(owidData[smallest_index].getDate())) smallest_index = j;
                }	
                // 3 part swap between loops   
                temp = owidData[ smallest_index ];
                owidData[ smallest_index ] = owidData[i];		
                owidData[ i ] = temp;
            }// close the otter loop
        } else {
            for (int i = 0; i < owidData.length - 1; i++) {	
                //initialize the largest_index    
                int largest_index = i;		
                //inner loop locate largest 
                for(int j = i + 1; j < owidData.length; j++) {
                    if(OWIDtimeData.dateToNumber(owidData[j].getDate()) > OWIDtimeData.dateToNumber(owidData[largest_index].getDate())) largest_index = j;
                }	
                // 3 part swap between loops   
                temp = owidData[largest_index];
                owidData[largest_index] = owidData[i];		
                owidData[i] = temp;
            } 
        }
        return owidData;
    }

    //Two helper methods, useful for the OWID data to Country converter
    public static OWIDtimeData findMostRecent(String country, OWIDtimeData[] owidData){
        OWIDtimeData answer = null;
        for(int i = 0; i < owidData.length; i++){
            if(owidData[i].getCountry().equals(country)){
                answer = owidData[i];
                break;
            }
        }
        for(int i = 0; i < owidData.length; i++){
            if(OWIDtimeData.dateToNumber(owidData[i].getDate()) > OWIDtimeData.dateToNumber(answer.getDate()) && owidData[i].getCountry().equals(country)){
                answer = owidData[i];
            }
        }
        return answer;
    }

    public static OWIDtimeData findLeastRecent(String country, OWIDtimeData[] owidData){
        OWIDtimeData answer = null;
        for(int i = 0; i < owidData.length; i++){
            if(owidData[i].getCountry().equals(country)){
                answer = owidData[i];
                break;
            }
        }
        for(int i = 0; i < owidData.length; i++){
            if(OWIDtimeData.dateToNumber(owidData[i].getDate()) < OWIDtimeData.dateToNumber(answer.getDate()) && owidData[i].getCountry().equals(country)){
                answer = owidData[i];
            }
        }
        return answer;
    }
}