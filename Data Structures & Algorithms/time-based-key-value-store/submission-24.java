class TimeMap {
    Map<String, List<ValueAndTimestamp>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        ValueAndTimestamp vt = new ValueAndTimestamp(value, timestamp);
        List<ValueAndTimestamp> list = map.getOrDefault(key, new ArrayList<>());
        list.add(vt);
        map.put(key, list);
    }
    
    public String get(String key, int timestamp) {
        List<ValueAndTimestamp> values = map.get(key);
        if(values == null){
            return "";
        }
        //perform binary search

        int l = 0 ,r = values.size() - 1;
        String value = "";

        while(l <= r){
            int mid = (l+r)/2;
            ValueAndTimestamp val = values.get(mid);
            if(val.timestamp == timestamp){
                return val.value;
            }else if(timestamp > val.timestamp){
                value = val.value;
                l = mid+1;
            }else{
                r = mid-1;
            }
        }

        return value;
        
    }

    class ValueAndTimestamp{
        public String value;
        public int timestamp;

        public ValueAndTimestamp(String value, int timestamp){
            this.value = value;
            this.timestamp = timestamp;
        }
    }
}
