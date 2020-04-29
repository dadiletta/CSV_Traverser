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
        recoveryRate = ((double)((double)(recovered)/(double)(confirmed)))*100;
    }

    // sorts out data by amount of confirmed
    public static DeathData[] sortByConfirmed(DeathData[] deathData, Boolean lowToHigh){
        int n = deathData.length;
        if(lowToHigh){
            for(int j = 1; j < n; j++){
                DeathData key = deathData[j];
                int i = j-1;
                while((i>-1) && deathData[i].confirmed() > key.confirmed()){
                    deathData[i+1] = deathData[i];
                    i--;
                }
                deathData[i+1] = key;
            }
        } else {
            for(int j = 1; j < n; j++){
                DeathData key = deathData[j];
                int i = j-1;
                while((i>-1) && deathData[i].confirmed() < key.confirmed()){
                    deathData[i+1] = deathData[i];
                    i--;
                }
                deathData[i+1] = key;
            }
        }
        return deathData;
    }

    // sorts out data by amount of recovered
    public static DeathData[] sortByRecovered(DeathData[] deathData, Boolean lowToHigh){
        int n = deathData.length;
        if(lowToHigh){
            for(int j = 1; j < n; j++){
                DeathData key = deathData[j];
                int i = j-1;
                while((i>-1) && deathData[i].recovered() > key.recovered()){
                    deathData[i+1] = deathData[i];
                    i--;
                }
                deathData[i+1] = key;
            }
        } else {
            for(int j = 1; j < n; j++){
                DeathData key = deathData[j];
                int i = j-1;
                while((i>-1) && deathData[i].recovered() < key.recovered()){
                    deathData[i+1] = deathData[i];
                    i--;
                }
                deathData[i+1] = key;
            }
        }
        return deathData;
    }

    // sorts out data by amount of percentage recovered
    public static DeathData[] sortByPercentageRecovered(DeathData[] deathData, Boolean lowToHigh){
        int n = deathData.length;
        if(lowToHigh){
            for(int j = 1; j < n; j++){
                DeathData key = deathData[j];
                int i = j-1;
                while((i>-1) && (deathData[i].recoveryRate()) > (key.recoveryRate())){
                    deathData[i+1] = deathData[i];
                    i--;
                }
                deathData[i+1] = key;
            }
        } else {
            for(int j = 1; j < n; j++){
                DeathData key = deathData[j];
                int i = j-1;
                while((i>-1) && (deathData[i].recoveryRate()) < (key.recoveryRate())){
                    deathData[i+1] = deathData[i];
                    i--;
                }
                deathData[i+1] = key;
            }
        }
        return deathData;
    }
    // -----------------
    // Accessor methods
    // -----------------
    // returns number of deaths
    public int deaths(){
        return deaths;
    }
    // returns the state the data is in
    public String state(){
        return state;
    }
    // returns number of confirmed cases
    public int confirmed(){
        return confirmed;
    }
    // returns number of people recovered
    public int recovered(){
        return recovered;
    }
    // returns the name of the country
    public String country(){
        return country;
    }
    // returns the last time it was updated
    public String lastUpdate(){
        return lastUpdate;
    }
    // returns percentage recvered
    public double recoveryRate(){
        return recoveryRate;
    }
}