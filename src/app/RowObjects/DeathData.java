package app.RowObjects;

public class DeathData {
    int id;
    String state;
    String country;
    String lastUpdate;
    int confirmed;
    int recovered;
    int deaths;

    public DeathData(String[] data){
        id = Integer.parseInt(data[2]);
        state = data[3];
        country = data[4];
        lastUpdate = data[5];
        confirmed = Integer.parseInt(data[8]);
        recovered = Integer.parseInt(data[9]);
        deaths = Integer.parseInt(data[10]);
    }

    public static DeathData[] sortByConfirmed(DeathData[] deathData, boolean lowToHigh){
        if(lowToHigh){
            for(int x = 1; x < deathData.length; x++){
                DeathData key = deathData[x];
                int y = x-1;
                while((y > -1) && (deathData[y].confirmed() > key.confirmed())){
                    deathData[y+1] = deathData[y];
                    y--;
                }
                deathData[y+1] = key;
            }
        }
        else{
            for(int x = 1; x < deathData.length; x++){
                DeathData key = deathData[x];
                int y = x-1;
                while((y > -1) && (deathData[y].confirmed() < key.confirmed())){
                    deathData[y+1] = deathData[y];
                    y--;
                }
                deathData[y+1] = key;
            }
        }
        return deathData;
    }

    public static DeathData[] sortByRecovered(DeathData[] deathData, boolean lowToHigh){
        if(lowToHigh){
            for(int x = 1; x < deathData.length; x++){
                DeathData key = deathData[x];
                int y = x-1;
                while((y > -1) && (deathData[y].recovered() > key.recovered())){
                    deathData[y+1] = deathData[y];
                    y--;
                }
                deathData[y+1] = key;
            }
        }
        else{
            for(int x = 1; x < deathData.length; x++){
                DeathData key = deathData[x];
                int y = x-1;
                while((y > -1) && (deathData[y].recovered() < key.recovered())){
                    deathData[y+1] = deathData[y];
                    y--;
                }
                deathData[y+1] = key;
            }
        }
        return deathData;
    }

    // -----------------------
    // --- ACCESOR METHODS ---
    // -----------------------
    public int id(){
        return id();
    }
    public String state(){
        return state;
    }
    public String country(){
        return country;
    }
    public String lastUpdate(){
        return lastUpdate;
    }
    public int confirmed(){
        return confirmed;
    }
    public int recovered(){
        return recovered;
    }
    public int deaths(){
        return deaths;
    }
}