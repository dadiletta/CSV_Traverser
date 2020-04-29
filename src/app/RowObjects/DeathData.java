package app.RowObjects;

public class DeathData {
    //INSTANCE VARIABLES
    int id;
    String state;
    String country;
    String lastUpdate;
    int confirmed;
    int recovered;
    int deaths;
    double deathRatio;
    double recoveryRatio;

    public DeathData(String[] data){
        id = Integer.parseInt(data[2]);
        state = data[3];
        country = data[4];
        lastUpdate = data[5];
        confirmed = Integer.parseInt(data[8]);
        recovered = Integer.parseInt(data[9]);
        deaths = Integer.parseInt(data[10]);
        deathRatio = (double)deaths/(double)confirmed;
        recoveryRatio = ((double)recovered/(double)confirmed) * 100;
    }

    //STATIC HELPER METHODS
    public static DeathData[] sortByCases(DeathData[] deathData, boolean lowToHigh){
        //CONVERT TO INSERTION SORT LATER
            /*for(int i = 1; i < deathData.length; i++){
                DeathData key = deathData[i];
                int j = i - 1;
                while((j > -1) && (deathData[j].cases() > key.cases())){
                    deathData[j+1] = deathData[j];
                    j--;
                }
                deathData[i+1] = key;
            }
        }
        else{
            for(int i = 1; i < deathData.length; i++){
                DeathData key = deathData[i];
                int j = i - 1;
                while((j > -1) && (deathData[j].cases() < key.cases())){
                    deathData[j+1] = deathData[j];
                    j--;
                }
                deathData[i+1] = key;
            }
        }*/
        DeathData temp;
        if(lowToHigh){
		    for (int i = 1; i < deathData.length - 1; i++ ){
				//initialize the smallest_index    
				int smallest_index = i;		
				//inner loop locate smallest 
				for(int j = i + 1; j < deathData.length; j++) {
						if( deathData[ j ].cases() < deathData[ smallest_index ].cases()){
                            smallest_index = j;
                        }
				}
				// 3 part swap between loops   
				temp = deathData[ smallest_index ];
				deathData[ smallest_index ] = deathData[ i ];
				deathData[ i ] = temp;
            }// close the otter loop
        }
        else{
            for (int i = 1; i < deathData.length - 1; i++ ){
				//initialize the smallest_index    
				int smallest_index = i;		
				//inner loop locate smallest 
				for(int j = i + 1; j < deathData.length; j++) {
					if( deathData[ j ].cases() > deathData[ smallest_index ].cases()){
                        smallest_index = j;
                    }
				}
				// 3 part swap between loops   
				temp = deathData[ smallest_index ];
				deathData[ smallest_index ] = deathData[ i ];
				deathData[ i ] = temp;
            }// close the otter loop
        }
        return deathData;
    }

    public static DeathData[] sortByRecoveryRate(DeathData[] deathData, boolean lowToHigh){
        //CONVERT TO INSERTION SORT LATER
        DeathData temp;
        if(lowToHigh){
		    for (int i = 1; i < deathData.length - 1; i++ ){
				//initialize the smallest_index    
				int smallest_index = i;		
				//inner loop locate smallest 
				for(int j = i + 1; j < deathData.length; j++) {
						if( deathData[ j ].recoveryRatio() < deathData[ smallest_index ].recoveryRatio()){
                            smallest_index = j;
                        }
				}
				// 3 part swap between loops   
				temp = deathData[ smallest_index ];
				deathData[ smallest_index ] = deathData[ i ];
				deathData[ i ] = temp;
            }// close the otter loop
        }
        else{
            for (int i = 1; i < deathData.length - 1; i++ ){
				//initialize the smallest_index    
				int smallest_index = i;		
				//inner loop locate smallest 
				for(int j = i + 1; j < deathData.length; j++) {
					if( deathData[ j ].recoveryRatio() > deathData[ smallest_index ].recoveryRatio()){
                        smallest_index = j;
                    }
				}
				// 3 part swap between loops   
				temp = deathData[ smallest_index ];
				deathData[ smallest_index ] = deathData[ i ];
				deathData[ i ] = temp;
            }// close the otter loop
        }
        return deathData;
    }

    public static DeathData findMaxCases(DeathData[] deathData){
        DeathData max = deathData[0];
        for(int i = 0; i < deathData.length; i++){
            if(deathData[i].cases() > max.cases()){
                max = deathData[i];
            }
        }
        return max;
    }

    public static DeathData findMinCases(DeathData[] deathData){
        DeathData min = deathData[0];
        for(int i = 0; i < deathData.length; i++){
            if(deathData[i].cases() < min.cases()){
                min = deathData[i];
            }
        }
        return min;
    }

    public static DeathData findHighestRecoveryRate(DeathData[] deathData){
        DeathData max = deathData[0];
        for(int i = 0; i < deathData.length; i++){
            if(deathData[i].recoveryRatio > max.recoveryRatio()){
                max = deathData[i];
            }
        }
        return max;
    }

    public static DeathData findLowestRecoveryRate(DeathData[] deathData){
        DeathData min = deathData[0];
        for(int i = 0; i < deathData.length; i++){
            if(deathData[i].recoveryRatio < min.recoveryRatio()){
                min = deathData[i];
            }
        }
        return min;
    }

//ACCESSOR METHODS
    public int deaths(){
        return deaths;
    }

    public String state(){
        return state;
    }

    public String country(){
        return country;
    }

    public int cases(){
        return confirmed;
    }

    public int recoveries(){
        return recovered;
    }

    public double deathRatio(){
        return deathRatio;
    }

    public double recoveryRatio(){
        return recoveryRatio;
    }

    public String lastUpdate(){
        return lastUpdate;
    }
}