class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        for(int n : nums){
            counts.put(n, counts.getOrDefault(n, 0) + 1);
        }

        List<Integer>[] a = new List[nums.length];
        for(int i = 0; i < a.length; i++){
            a[i] = new ArrayList<>();
        }

        for(int n : counts.keySet()){
            int count = counts.get(n);
            a[count-1].add(n);
        }

        int[] result = new int[k];
        int index = 0;

        for(int i = nums.length-1; i >= 0; i--){
            for(int n : a[i]){
                result[index++] = n;
                if(index == k){
                    return result;
                }
            }
        }

        // System.out.println(a[3].size());

        return null;
    }
}
