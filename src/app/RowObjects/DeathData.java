package app.RowObjects;

public class DeathData {
    int id;
    String state;
    String country;
    String lastUpdate;
    int confirmed;
    int recovered;
    int deaths;
    double recoveryRate;

    public DeathData(String[] data){
        id = Integer.parseInt(data[2]);
        state = data[3];
        country = data[4];
        lastUpdate = data[5];
        confirmed = Integer.parseInt(data[8]);
        recovered = Integer.parseInt(data[9]);
        deaths = Integer.parseInt(data[10]);
        recoveryRate = ((double)(recovered)/(double)(confirmed))*100;
    }
    
    public static DeathData[] sortByConfirmed(DeathData[] deathData, boolean lowToHigh){
        DeathData temp;
        if(lowToHigh){
            for (int i = 0; i < deathData.length - 1; i++ ){
                    int smallest_index = i;		
                    //inner loop locate smallest 
                    for(int j = i + 1; j < deathData.length; j++) {
                            if( deathData[ j ].confirmed() < deathData[ smallest_index ].confirmed())
                                    smallest_index = j;
                    }	
                    // 3 part swap between loops   
                    temp = deathData[ smallest_index ];
                    deathData[ smallest_index ] = deathData[ i ];
                    deathData[ i ] = temp;
            }
        }

        else{
            for (int i = 0; i < deathData.length - 1; i++ ){
                    int largest_index = i;		
                    //inner loop locate largest 
                    for(int j = i + 1; j < deathData.length; j++) {
                            if( deathData[ j ].confirmed() > deathData[ largest_index ].confirmed())
                                    largest_index = j;
                    }	
                    // 3 part swap between loops   
                    temp = deathData[ largest_index ];
                    deathData[ largest_index ] = deathData[ i ];
                    deathData[ i ] = temp;
            }
        }


        return deathData;
    }

    public static DeathData[] sortByRecovered(DeathData[] deathData, boolean lowToHigh){
        DeathData temp;
        if(lowToHigh){
            for (int i = 0; i < deathData.length - 1; i++ ){
                    int smallest_index = i;		
                    //inner loop locate smallest 
                    for(int j = i + 1; j < deathData.length; j++) {
                            if( deathData[ j ].recoveryRate() < deathData[ smallest_index ].recoveryRate())
                                    smallest_index = j;
                    }	
                    // 3 part swap between loops   
                    temp = deathData[ smallest_index ];
                    deathData[ smallest_index ] = deathData[ i ];
                    deathData[ i ] = temp;
            }
        }

        else{
            for (int i = 0; i < deathData.length - 1; i++ ){
                    int largest_index = i;		
                    //inner loop locate largest 
                    for(int j = i + 1; j < deathData.length; j++) {
                            if( deathData[ j ].recoveryRate() > deathData[ largest_index ].recoveryRate())
                                    largest_index = j;
                    }	
                    // 3 part swap between loops   
                    temp = deathData[ largest_index ];
                    deathData[ largest_index ] = deathData[ i ];
                    deathData[ i ] = temp;
            }
        }


        return deathData;
    }

    public String state(){
        return state;
    }

    public String country(){
        return country;
    }

    public String lastUpdate(){
        return lastUpdate();
    }

    public int deaths(){
        return deaths;
    }

    public int recovered(){
        return recovered;
    } 

    public int confirmed(){
        return confirmed;
    }

    public double recoveryRate(){
        return recoveryRate;
    }
}