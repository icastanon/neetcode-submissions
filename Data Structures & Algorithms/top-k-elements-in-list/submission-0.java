class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numAndCount = new HashMap<>();
        for(int i : nums){
            if(Objects.nonNull(numAndCount.get(i))){
                numAndCount.put(i, numAndCount.get(i)+1);
            }else{
                numAndCount.put(i, 0);
            }
        }

        List<Set<Integer>> buckets = new ArrayList<>();

        for (int i = 0; i <= nums.length; i++) {
            buckets.add(new HashSet<>());
        }

        for(Integer i : numAndCount.keySet()){
            Integer count = numAndCount.get(i);
            Set<Integer> numbers = buckets.get(count); //return set of numbers that occur 'count' times
            numbers.add(i);
        }

        List<Integer> topKelements = new ArrayList<>();

        for(int i = buckets.size() -1 ; i >= 0; i--){
            for(Integer n : buckets.get(i)){
                topKelements.add(n);
                if(topKelements.size() == k){
                    return topKelements.stream().mapToInt(Integer::intValue).toArray();
                }
            }
        }

        return null;
    }

    public static void addToBucket(Integer num, Integer count){

    }
}
