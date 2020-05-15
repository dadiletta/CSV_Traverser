package app;

// https://stackoverflow.com/questions/37552736/how-do-you-loop-through-a-column-of-a-csv-file-to-find-a-certain-string-in-java
// https://stackabuse.com/reading-and-writing-csvs-in-java/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

<<<<<<< Updated upstream
import app.RowObjects.UNStatsDeathData;
=======
import app.RowObjects.DeathData;
import app.RowObjects.OWIDData;
>>>>>>> Stashed changes

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
<<<<<<< Updated upstream
        ArrayList<String[]> fatalities = buildListfromCSV("COVID_stats_Deaths.csv");
        // then we convert each String[] into a data object, starting with a container for them all
        UNStatsDeathData[] dd = new UNStatsDeathData[fatalities.size() - 1];
        // loop through all our string[] and instantiate a data object for each
        for (int i = 1; i < fatalities.size(); i++){
            // pass the String[] to the UNStatsDeathData constructor
            dd[i - 1] = new UNStatsDeathData(fatalities.get(i));
            // access and print the deaths property from each object so we see it working
            //System.out.println(UNStatsDeathData[i].deaths());
        }
        UNStatsDeathData.sortByConfirmed(dd, true);
        System.out.println("Least reported cases: " + dd[0].country() + " " + dd[0].state() + " - " + dd[0].confirmed());
        System.out.println("Most reported cases: " + dd[dd.length  - 1].country() + " " + dd[dd.length - 1].state() + " - " + dd[dd.length - 1].confirmed());

        UNStatsDeathData.sortByRecovered(dd, true);
        System.out.println("Least recovered cases: " + dd[0].country() + " " + dd[0].state() + " - " + dd[0].recovered());
        System.out.println("Most recovered cases: " + dd[dd.length  - 1].country() + " " + dd[dd.length - 1].state() + " - " + dd[dd.length - 1].recovered());
        }
=======
        String date = "2020-05-06";
        ArrayList<String[]> owid = buildListfromCSV("owid-covid-data.csv");
        ArrayList<OWIDData> complete = new ArrayList<OWIDData>();
        for(int i = 1; i < owid.size(); i++){
            complete.add(new OWIDData(owid.get(i)));
        }
        OWIDData.filterDate(date, complete);
        OWIDData.sortByDeaths(complete);
        
        //TODO: RESULTS
        System.out.println("The country with the highest fatality rate per infected as of May 6th, 2020 is " + complete.get(complete.size()-1).location() + " with a rate of " + complete.get(complete.size()-1).percentDeaths() + "%.");
        System.out.println("The country with the second highest fatality rate per infected as of May 6th, 2020 is " + complete.get(complete.size()-2).location() + " with a rate of " + complete.get(complete.size()-2).percentDeaths() + "%.");
        System.out.println("The country with the third highest fatality rate per infected as of May 6th, 2020 is " + complete.get(complete.size()-3).location() + " with a rate of " + complete.get(complete.size()-3).percentDeaths() + "%.");
        System.out.println("The country with the lowest fatality rate per infected as of May 6th, 2020 is " + complete.get(0).location() + " with a rate of " + complete.get(0).percentDeaths() + "%.");
        System.out.println("The country with the second lowest fatality rate per infected as of May 6th, 2020 is " + complete.get(1).location() + " with a rate of " + complete.get(1).percentDeaths() + "%.");
        System.out.println("The country with the third lowest fatality rate per infected as of May 6th, 2020 is " + complete.get(2).location() + " with a rate of " + complete.get(2).percentDeaths() + "%.");
        


        // DeathData.sortByConfirmed(deathData, true);
        // for(DeathData dd : deathData){
        //     System.out.println(dd.state() + " - " + dd.country() + " - " + dd.confirmed());
        // }
        // DeathData highConfirm = deathData[0];
        // DeathData lowConfirm = deathData[0];
        // DeathData highRecover = deathData[0];
        // DeathData lowRecover = deathData[0];
        // for(DeathData dd : deathData){
        //     if(highConfirm.confirmed() < dd.confirmed()) highConfirm = dd;
        //     if(lowConfirm.confirmed() > dd.confirmed()) lowConfirm = dd;
        //     if(highRecover.recovered() < dd.recovered()) highRecover = dd;
        //     if(lowRecover.recovered() > dd.recovered()) lowRecover = dd;
        // }
        // System.out.println("The area with the most cases is " + highConfirm.state() + " - " + highConfirm.country());
        // System.out.println("The area with the least cases is " + lowConfirm.state() + " - " + lowConfirm.country());
        // System.out.println("The area with the most recoveries is " + highRecover.state() + " - " + highRecover.country());
        // System.out.println("The area with the least recoveries is " + lowRecover.state() + " - " + lowRecover.country());
    }
>>>>>>> Stashed changes


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