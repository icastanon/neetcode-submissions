class TimeMap {
    Map<String, List<MapObject>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        MapObject valueAndTimestamp = new MapObject(value, timestamp);
        List<MapObject> values = map.get(key);
        if(Objects.nonNull(values)){
            values.add(valueAndTimestamp);
        }else{
            List<MapObject> l = new ArrayList<>();
            l.add(valueAndTimestamp);
            map.put(key, l);
        }
    }
    
    public String get(String key, int timestamp) {
        List<MapObject> values = map.get(key);
        
        if(Objects.isNull(values) || timestamp < values.get(0).getTimeStamp()){
            return "";
        }else if (timestamp > values.get(values.size()-1).getTimeStamp()){
            return values.get(values.size()-1).getValue();
        }else{
            int start = 0, end = values.size()-1;
            MapObject result = null;

            while(start <= end){
                int mid = (end+start)/2;
                MapObject value = values.get(mid);
            
                if(value.getTimeStamp().equals(timestamp)){
                    return value.getValue();
                }else if(value.getTimeStamp() < timestamp){
                    result = value;
                    start = mid + 1;
                }else{
                    result = values.get(start);
                    end = mid - 1;
                }
            }
            return values.get(start-1).getValue();
        }     
    }

    class MapObject{
        String value;
        Integer timeStamp;

        public MapObject(){}

        public MapObject(String value, Integer timeStamp){
            this.value = value;
            this.timeStamp = timeStamp;
        }

        public Integer getTimeStamp(){
            return timeStamp;
        }

        public String getValue(){
            return value;
        }
    }
}

// 10, 20, 30

// 25
