package app;

public class StateData {
    
    String state;
    
 
    int fips;
    double cases;
    double deaths;

    public StateData(String[] data){
        
        
        state = data[1];
        cases = Double.parseDouble(data[3]);
        deaths = Double.parseDouble(data[4]);
    }


    public static StateData[] sortByDeathChance(StateData[] stateData, boolean lowToHigh) {
    
           
            if(lowToHigh){
            for ( int i = 0; i < stateData.length - 1; i++ ){
                    //initialize the smallest_index    
                    int smallest_index = i;		
                    //inner loop locate smallest 
                    for(int j = i + 1; j < stateData.length; j++) {
                            if( (stateData[ j ].deaths() / stateData[j].cases() )< (stateData[ smallest_index ].deaths() / stateData[smallest_index].cases() ))
                                    smallest_index = j;
                    }	
                    // 3 part swap between loops   
                    StateData temp = stateData[ smallest_index ];
                    stateData[ smallest_index ] = stateData[ i ];		
                    stateData[ i ] = temp;
            }
        }
        else{
            for ( int i = 0; i < stateData.length - 1; i++ ){
                //initialize the smallest_index    
                int smallest_index = i;		
                //inner loop locate smallest 
                for(int j = i + 1; j < stateData.length; j++) {
                        if( (stateData[ j ].deaths() / stateData[j].cases() )> (stateData[ smallest_index ].deaths() / stateData[smallest_index].cases() ))
                                smallest_index = j;
                }	
                // 3 part swap between loops   
                StateData temp = stateData[ smallest_index ];
                stateData[ smallest_index ] = stateData[ i ];		
                stateData[ i ] = temp;
        }
        }
    
        return stateData;
    }

    


    

    public double deaths(){
        return deaths;
    }

    public String state(){
        return state;
    }


    public double cases(){
        return cases;
    }
  


}