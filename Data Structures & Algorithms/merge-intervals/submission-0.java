class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]) );

        int l = intervals[0][0], r = intervals[0][1];

        List<int[]> result = new ArrayList<>();

        for(int[] i : intervals){
            if(i[0] <= r){
                //merge
                r = Math.max(r, i[1]);
            }else{
                result.add(new int[]{l, r});
                l = i[0];
                r = i[1];
            }
        }

        result.add(new int[]{l, r});

        int[][] res = new int[result.size()][2];

        for(int i = 0; i < result.size(); i++){
            res[i] = result.get(i);
        }

        return res;
        
    }
}
