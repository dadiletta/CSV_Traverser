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

    public static String mostDeaths(DeathData[] deathDataCsv){
        int max = 0;
        String mostCountry = " ";
        for(int x = 0; x < deathDataCsv.length; x++){
            if(deathDataCsv[x].deaths() > max){
                max = deathDataCsv[x].deaths();
                mostCountry = deathDataCsv[x].country();

            }
        }
        return mostCountry;
    }

    public static String leastDeaths(DeathData[] deathDataCsv){
        int min = deathDataCsv[0].deaths();
        String leastCountry = " ";
        for(int x = 0; x < deathDataCsv.length; x++){
            if(deathDataCsv[x].deaths() < min){
                min = deathDataCsv[x].deaths();
                leastCountry = deathDataCsv[x].country();
            }
        }
        return leastCountry;
    }

    public static String mostRecovered(DeathData[] deathDataCsv){
        int max = 0;
        String mostCountry = " ";
        for(int x = 0; x < deathDataCsv.length; x++){
            if(deathDataCsv[x].recovered() > max){
                max = deathDataCsv[x].recovered();
                mostCountry = deathDataCsv[x].country();
            }
        }
        return mostCountry;
    }


    public static String leastRecovered(DeathData[] deathDataCsv){
        int min = 1000000000;
        String leastCountry = " ";
        for(int x = 0; x < deathDataCsv.length; x++){
            if(deathDataCsv[x].recovered() < min){
                min = deathDataCsv[x].recovered();
                leastCountry = deathDataCsv[x].country();
            }
        }
        return leastCountry;
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

    public String state(){
        return state;
    }

    public String country(){
        return country;
    }

    public String lastUpdate(){
        return lastUpdate;
    }
}