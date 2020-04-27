package app;

// https://stackoverflow.com/questions/37552736/how-do-you-loop-through-a-column-of-a-csv-file-to-find-a-certain-string-in-java
// https://stackabuse.com/reading-and-writing-csvs-in-java/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
//import java.io.IOException;
import java.util.ArrayList;

import app.RowObjects.DeathData;

public class App {

    /**
     * App launcher
     * @param args 
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        System.out.println("------------------------------------");
        System.out.println("------WELCOME TO CSV_TRAVERSER------");
        System.out.println("------------------------------------");

        // ---------
        // USING UNStats COVID-19 response: https://covid-19-data.unstatshub.org/datasets/1cb306b5331945548745a5ccd290188e_0
        // ---------
        // first we build string arrays of the converted data
        ArrayList<String[]> fatalities = buildListfromCSV("COVID_stats_Deaths.csv");
        // then we convert each String[] into a data object, starting with a container for them all

        

        DeathData[] deathData = new DeathData[fatalities.size()-1]; 
        // loop through all our string[] and instantiate a data object for each
        for (int i = 1; i < fatalities.size(); i++){
            // pass the String[] to the DeathData constructor
            deathData[i-1] = new DeathData(fatalities.get(i));
            // access and print the deaths property from each object so we see it working
            //System.out.println(deathData[i].deaths());
        }
        //print least and most confirmed
        DeathData.sortByConfirmed(deathData, true);
        System.out.println("Least Confirmed: " + deathData[0].country() + " - " + deathData[0].state() + " - " + deathData[0].confirmed());
        System.out.println("Most Confirmed: " + deathData[deathData.length-1].country() + " - " + deathData[deathData.length-1].state() + " - " + deathData[deathData.length-1].confirmed());
        
        //print least and most recovered
        DeathData.sortByRecovered(deathData, true);
        System.out.println("Least Recovered: " + deathData[0].country() + " - " + deathData[0].state() + " - " + deathData[0].recovered());
        System.out.println("Most Recovered: " + deathData[deathData.length-1].country() + " - " + deathData[deathData.length-1].state() + " - " + deathData[deathData.length-1].recovered());
        /*for(DeathData dd : deathData){
            System.out.println(dd.country() + " - " + dd.state() + " - " + dd.confirmed());
        }*/
    }


    /**
     * Finds a given CSV inside the root project folder, traverses each line, and adds a String array
     * into an ArrayList that gets return 
     * @param pathToCsv Name of CSV file inside the root folder
     * @return ArrayList of Strings representing each row of CSV file
     */
    public static ArrayList<String[]> buildListfromCSV(String name){
        // build the full path to the file
        String pathToCsv = System.getProperty("user.dir") + "/" + name;
        // check if file exists
        File csvFile = new File(pathToCsv);
        if (!csvFile.isFile()){
            System.out.println("No file found");
            return null;
        }
        // build result object
        ArrayList<String[]> result = new ArrayList<>();
        // saftey first!
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader(pathToCsv));     
            String  row = "";
            // split each row into an array and add to result object
            while ((row = csvReader.readLine()) != null) {
                //break each line of the csv file to its elements
                result.add(row.split(","));
            }
            csvReader.close();
        // catch and report errors
        } catch (Exception e) {
            System.out.println("Error traversing CSV: " + e);
            return null;
        }       
        // ta-da!
        return result;
    }

    
}