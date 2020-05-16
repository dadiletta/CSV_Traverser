package app.RowObjects;

/**
 * UNStats COVID-19 response 
 * https://covid-19-data.unstatshub.org/datasets/bbb2e4f589ba40d692fab712ae37b9ac_0?geometry=64.592%2C-38.069%2C-47.205%2C63.033
 * COVID_stats_Deaths.csv
 * 
 * Want to know the difference between static and non-static?
 * https://www.youtube.com/watch?v=WhDd9JQ7UtI&feature=youtu.be&hd=1
 */
public class UNStatsDeathData {
    int id;
    String state;
    String country;
    String lastUpdate;
    int confirmed;
    int recovered;
    int deaths;

    /**
     * Constructor method. This takes the raw String[] from the CSV and creates
     * a data object.
     * @param data the String[] built from the App's importer
     */
    public UNStatsDeathData(String[] data){
        id = Integer.parseInt(data[2]);
        state = data[3];
        country = data[4];
        lastUpdate = data[5];
        confirmed = Integer.parseInt(data[8]);
        recovered = Integer.parseInt(data[9]);
        deaths = Integer.parseInt(data[10]);
    }

    /* 
    ---------------------------
    ---- ACCESSOR METHODS  ----
    ---------------------------
    */

    public int deaths(){
        return deaths;
    }

     public String lastUpdate(){
        return lastUpdate;
    }

    public String state(){
        return state;
    }

    public int recovered(){
        return recovered;
    }

    public int confirmed(){
        return confirmed;
    }

    public String country(){
        return country;
    }

    /**
     * Static helper method. It takes rows from a CSV that have been converted into 
     * instantiated copies of this file. Arrays of data objects can be passed
     * into this static helper so we sort according to a particular property. 
     * @param UNStatsDeathData array of objects holding each row's data
     * @param lowToHigh toggle sort order
     * @return sorted array
     */
    public static UNStatsDeathData[] sortByConfirmed(UNStatsDeathData[] UNStatsDeathData, boolean lowToHigh) {
        UNStatsDeathData temp;
        if (lowToHigh) {
            // INNEFICIENt SELECTION SORT ALG
            for (int i = 0; i < UNStatsDeathData.length - 1; i++) {	
                //initialize the smallest_index    
                int smallest_index = i;		
                //inner loop locate smallest 
                for(int j = i + 1; j < UNStatsDeathData.length; j++) {
                    if(UNStatsDeathData[j].confirmed() < UNStatsDeathData[smallest_index].confirmed()) smallest_index = j;
                }	
                // 3 part swap between loops   
                temp = UNStatsDeathData[ smallest_index ];
                UNStatsDeathData[ smallest_index ] = UNStatsDeathData[i];		
                UNStatsDeathData[ i ] = temp;
            }// close the otter loop
        } else {
            for (int i = 0; i < UNStatsDeathData.length - 1; i++) {	
                //initialize the smallest_index    
                int largest_index = i;		
                //inner loop locate smallest 
                for(int j = i + 1; j < UNStatsDeathData.length; j++) {
                    if(UNStatsDeathData[j].confirmed() > UNStatsDeathData[largest_index].confirmed()) largest_index = j;
                }	
                // 3 part swap between loops   
                temp = UNStatsDeathData[largest_index];
                UNStatsDeathData[largest_index] = UNStatsDeathData[i];		
                UNStatsDeathData[i] = temp;
            } 
        }
        return UNStatsDeathData;
    }

    /**
     * Static helper method. It takes rows from a CSV that have been converted into 
     * instantiated copies of this file. Arrays of data objects can be passed
     * into this static helper so we sort according to a particular property. 
     * @param UNStatsDeathData array of objects holding each row's data
     * @param lowToHigh toggle sort order
     * @return sorted array
     */
    public static UNStatsDeathData[] sortByRecovered(UNStatsDeathData[] UNStatsDeathData, boolean lowToHigh) {
        UNStatsDeathData temp;
        if (lowToHigh) {
            // INNEFICIENt SELECTION SORT ALG
            for (int i = 0; i < UNStatsDeathData.length - 1; i++) {	
                //initialize the smallest_index    
                int smallest_index = i;		
                //inner loop locate smallest 
                for(int j = i + 1; j < UNStatsDeathData.length; j++) {
                    if(UNStatsDeathData[j].recovered() < UNStatsDeathData[smallest_index].recovered()) smallest_index = j;
                }	
                // 3 part swap between loops   
                temp = UNStatsDeathData[ smallest_index ];
                UNStatsDeathData[ smallest_index ] = UNStatsDeathData[i];		
                UNStatsDeathData[ i ] = temp;
            }// close the otter loop
        } else {
            for (int i = 0; i < UNStatsDeathData.length - 1; i++) {	
                //initialize the smallest_index    
                int largest_index = i;		
                //inner loop locate smallest 
                for(int j = i + 1; j < UNStatsDeathData.length; j++) {
                    if(UNStatsDeathData[j].recovered() > UNStatsDeathData[largest_index].recovered()) largest_index = j;
                }	
                // 3 part swap between loops   
                temp = UNStatsDeathData[largest_index];
                UNStatsDeathData[largest_index] = UNStatsDeathData[i];		
                UNStatsDeathData[i] = temp;
            } 
        }
        return UNStatsDeathData;
    }
    
    /**
     * Static helper method. It takes rows from a CSV that have been converted into 
     * instantiated copies of this file. Arrays of data objects can be passed
     * into this static helper so we sort according to a particular property. 
     * @param UNStatsDeathData array of objects holding each row's data
     * @param lowToHigh toggle sort order
     * @return sorted array
     */
    public static UNStatsDeathData[] sortByRecoveryPercentage(UNStatsDeathData[] UNStatsDeathData, boolean lowToHigh) {
        UNStatsDeathData temp;
        if (lowToHigh) {
            // INNEFICIENt SELECTION SORT ALG
            for (int i = 0; i < UNStatsDeathData.length - 1; i++) {	
                //initialize the smallest_index    
                int smallest_index = i;		
                //inner loop locate smallest 
                for(int j = i + 1; j < UNStatsDeathData.length; j++) {
                    if((double)(UNStatsDeathData[j].recovered() / UNStatsDeathData[j].confirmed()) < (double)(UNStatsDeathData[smallest_index].recovered() / UNStatsDeathData[smallest_index].confirmed())) smallest_index = j;
                }	
                // 3 part swap between loops   
                temp = UNStatsDeathData[ smallest_index ];
                UNStatsDeathData[ smallest_index ] = UNStatsDeathData[i];		
                UNStatsDeathData[ i ] = temp;
            }// close the otter loop
        } else {
            for (int i = 0; i < UNStatsDeathData.length - 1; i++) {	
                //initialize the smallest_index    
                int largest_index = i;		
                //inner loop locate smallest 
                for(int j = i + 1; j < UNStatsDeathData.length; j++) {
                    if((double)(UNStatsDeathData[j].recovered() / UNStatsDeathData[j].confirmed()) < (double)(UNStatsDeathData[largest_index].recovered() / UNStatsDeathData[largest_index].confirmed())) largest_index = j;
                }	
                // 3 part swap between loops   
                temp = UNStatsDeathData[largest_index];
                UNStatsDeathData[largest_index] = UNStatsDeathData[i];		
                UNStatsDeathData[i] = temp;
            } 
        }
        return UNStatsDeathData;
    }

}