class Solution {
    class Coordinate implements Comparable<Coordinate>{
        public int[] xy;
        public int distanceFromOrigin;

        public Coordinate(int[] xy){
            this.xy = xy;
            int x = xy[0], y = xy[1];
            distanceFromOrigin = (x*x) + (y*y);
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

    public int[][] kClosest(int[][] points, int k) {
        Queue<Coordinate> heap = new PriorityQueue<>(Comparator.reverseOrder());

        for(int[] point : points){
            Coordinate c = new Coordinate(point);

            heap.offer(c);

            if(heap.size() > k){
                heap.poll();
            }
        }

        int[][] result = new int[k][2];

        for(int i = 0; i < k; i++){
            result[i] = heap.poll().xy;
        }

        return result;

    }
}
