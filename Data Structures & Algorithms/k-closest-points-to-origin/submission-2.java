class Solution {
    class Coordinate implements Comparable<Coordinate>{
        public int[] xy;
        public Double distanceFromOrigin;

        public Coordinate(int[] xy){
            this.xy = xy;
            distanceFromOrigin = Math.sqrt(Math.pow(0-xy[0], 2) + Math.pow(0-xy[1], 2));
        }

        public int compareTo(Coordinate other){
            if(distanceFromOrigin > other.distanceFromOrigin){
                return 1;
            }else if(distanceFromOrigin < other.distanceFromOrigin){
                return -1;
            }else{
                return 0;
            }
        }
    }

    //NOT OPTIMAL SOLUTION NEED TO WORK WITH A MAX HEAP OF SIZE K TO ONLY KEEP THE K SMALLES ELEMENTS. 
    //ALWAYS REMOVE THE LARGEST WHEN INSERTING INTO THE MAX HEAP THAT IS OF SIZE K

    public int[][] kClosest(int[][] points, int k) {
        Queue<Coordinate> heap = new PriorityQueue<>();

        for(int[] point : points){
            Coordinate c = new Coordinate(point);

            heap.offer(c);
        }

        int[][] result = new int[k][2];

        for(int i = 0; i < k; i++){
            result[i] = heap.poll().xy;
        }

        return result;

    }
}
