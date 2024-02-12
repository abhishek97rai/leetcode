class TimeMap {

    // use a map of key, treemap 
    // treemap itself will hold the timestamp as key and actual value as its value
    Map<String, TreeMap<Integer, String>> hm;

    public TimeMap() {
        hm = new HashMap<>();    
    }
    
    // create/update treemap as per actual key
    public void set(String key, String value, int timestamp) {
        if (!hm.containsKey(key)) {
            hm.put(key, new TreeMap<>());
        }
        hm.get(key).put(timestamp, value);
    }
    
    // get the nearest key using TreeMap.floorKey method that returns an Integer
    public String get(String key, int timestamp) {
        if (!hm.containsKey(key)) {
            return "";
        } else {
            TreeMap<Integer, String> tm = hm.get(key);
            Integer newKey = tm.floorKey(timestamp);
            if (newKey == null) {
                return "";
            } else {
                return tm.get(newKey);
            }
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
