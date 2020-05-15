package app;

// https://stackoverflow.com/questions/37552736/how-do-you-loop-through-a-column-of-a-csv-file-to-find-a-certain-string-in-java
// https://stackabuse.com/reading-and-writing-csvs-in-java/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import app.RowObjects.DeathData;
import app.RowObjects.OWIDData;

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
        // creates data in array for OWIDData
        ArrayList<String[]> data = buildListfromCSV("owid-covid-data.csv");
        //for(String[] s: data) System.out.println(s[0]);
        // then we convert each String into a data object, starting with a container for them all
        OWIDData[] owidData = new OWIDData[data.size()-1]; 
        // loop through all our string[] and instantiate a data object for each
        for (int i = 1; i < data.size(); i++){
            // pass the String[] to the DeathData constructor
            owidData[i-1] = new OWIDData(data.get(i));
            System.out.println(owidData[i-1].tests() + " " + i);
        }

        ArrayList<OWIDData> oData = OWIDData.sortByNegResults(owidData, true);
        for(OWIDData d: oData){
            System.out.println(d.country() + " negative test results is: " + d.negativeTestResults());
        }

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