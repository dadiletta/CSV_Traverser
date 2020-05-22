package app.RowObjects;

import java.util.ArrayList;

/**
 * @author Brian and Cole - 2020
 * owid-covid-data.csv
 */
public class OWIDperData{
    String location;
    double newTests;
    int newCases;
    String date;
    int totalDeaths;
    int totalCases;


    public OWIDperData(String[] data){
        location = data[1];
        try{
            newCases = Integer.parseInt(data[4]);
        } catch(Exception e){
            newCases = -1;
        }
        try{
            newTests = Integer.parseInt(data[12]);
        } catch(Exception e){
            newTests = -1;
        }
        date = data[2];
        try{
            totalDeaths = Integer.parseInt(data[5]);
        } catch(Exception e){
            totalDeaths = -1;
        }
        try{
            totalCases = Integer.parseInt(data[3]);
        } catch(Exception e){
            totalCases = -1;
        }
    }

    public double percentPos(){
        if(newTests != -1 && newCases != -1){
            double nt = (double)newTests;
            double nc = (double)newCases;
            return nc/nt;
        }
        return -1;
    }

    public double percentDeaths(){
        if(totalCases != -1 && totalDeaths != -1){
            double tc = (double)totalCases;
            double td = (double)totalDeaths;
            return td/tc;
        }
        return -1;
    }

    public static OWIDperData[] sortByNewTests(OWIDperData[] owidData, boolean lowToHigh){
        OWIDperData temp;
        if(lowToHigh){
            for (int i = 0; i < owidData.length - 1; i++ ){
                //initialize the smallest_index    
                int smallest_index = i;
                //inner loop locate smallest 
                for(int j = i + 1; j < owidData.length; j++) {
                        if(owidData[ j ].newTests() < owidData[ smallest_index ].newTests())
                                smallest_index = j;
                }
                // 3 part swap between loops   
                temp = owidData[ smallest_index ];
                owidData[ smallest_index ] = owidData[ i ];
                owidData[ i ] = temp;
            }// close the otter loop
        }
        return owidData;
    }

    public static OWIDperData[] sortByNewCases(OWIDperData[] owidData, boolean lowToHigh){
        OWIDperData temp;
        if(lowToHigh){
            for (int i = 0; i < owidData.length - 1; i++ ){
                //initialize the smallest_index    
                int smallest_index = i;
                //inner loop locate smallest 
                for(int j = i + 1; j < owidData.length; j++) {
                        if(owidData[ j ].newCases() < owidData[ smallest_index ].newCases())
                                smallest_index = j;
                }
                // 3 part swap between loops   
                temp = owidData[ smallest_index ];
                owidData[ smallest_index ] = owidData[ i ];
                owidData[ i ] = temp;
            }// close the otter loop
        }
        return owidData;
    }

    // public static OWIDperData[] sortByDeaths(ArrayList<OWIDperData> owidDatas, boolean lowToHigh){
    //     OWIDperData temp;
    //     if(lowToHigh){
    //         for (int j = 1; j < owidDatas.size(); j++) {
    //             OWIDperData current = owidDatas.get(j);
    //             int i = j-1;
    //             while ((i > -1) && ((owidDatas.get(i).compareTo(current)) == 1)) {
    //                 list.set(i+1, list.get(i));
    //                 i--;
    //             }
    //             list.set(i+1, current);
    //         }
    //     }
 
    //     else{
    //         for (int i = 0; i < owidDatas.length - 1; i++ ){
    //                 int largest_index = i;     
    //                 //inner loop locate largest
    //                 for(int j = i + 1; j < owidDatas.length; j++) {
    //                         if( owidDatas[ j ].percentPos() > owidDatas[ largest_index ].percentPos())
    //                                 largest_index = j;
    //                 }  
    //                 // 3 part swap between loops   
    //                 temp = owidDatas[ largest_index ];
    //                 owidDatas[ largest_index ] = owidDatas[ i ];
    //                 owidDatas[ i ] = temp;
    //         }
    //     }
 
 
    //     return owidDatas;
    // }

    public static void sortByDeaths(ArrayList<OWIDperData> sort){
        OWIDperData temp;
        for(int j = 1; j < sort.size(); j++){
            for(int i = j-1; i > -1; i--){
                if(sort.get(i+1).percentDeaths()<sort.get(i).percentDeaths()) sort.add(i+1,sort.remove(i));
                //TODO: FINISH SORT
            }
        }
    }

    public static void filterDate(String date, ArrayList<OWIDperData> sorted){
        int i = 0;
        while(i < sorted.size()){
            if(!sorted.get(i).date().equals(date)) sorted.remove(i);
            else i++;
        }
    }



    // -----------------
    // ACCESSOR METHODS
    // -----------------

    public String location(){
        return location;
    }

    public double newTests(){
        return newTests;
    }

    public double newCases(){
        return newCases;
    }

    public String date(){
        return date;
    }
}