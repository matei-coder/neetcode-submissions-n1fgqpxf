class TimeMap {

    Map<String , Map<Integer , String>> harta;
    Map<String , TreeSet<Integer>> hartasortat;
    public TimeMap() {
        harta = new HashMap<>();
        hartasortat = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {


        if(!harta.containsKey(key)){
            Map<Integer , String> timemap = new HashMap<>();
            TreeSet<Integer> setcopac = new TreeSet<>((a, b) -> a - b);
            setcopac.add(timestamp);
            //setcopac.add(0);
            hartasortat.put(key , setcopac);
            timemap.put(timestamp ,value);
            harta.put( key , timemap);
        }
        else{
            harta.get(key).put(timestamp ,value);
            hartasortat.get(key).add(timestamp);
        }
    }
    
    public String get(String key, int timestamp) {
        String raspunspartial="";
        if(harta.containsKey(key)){
        
        Integer t = hartasortat.get(key).floor(timestamp);
        if(t!=null){
            return harta.get(key).get(t);

        }
        else
            return raspunspartial;

        }
        else {
            return raspunspartial;
        }
        
    }
}
