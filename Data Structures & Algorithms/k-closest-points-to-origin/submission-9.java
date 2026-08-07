class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<Coordinate> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for(int[] c : points){
            Coordinate coor = new Coordinate(c[0], c[1]);
            maxHeap.offer(coor);
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }

        int[][] result = new int[k][2];

        for(int[] c : result){
            c[0] = maxHeap.peek().x;
            c[1] = maxHeap.poll().y;
        }

        return result;
        

    }

    class Coordinate implements Comparable<Coordinate>{
        int x, y;

        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int compareTo(Coordinate c){
            double thisDistance = (Math.sqrt(Math.pow(0 - this.x, 2) + Math.pow(0 - this.y, 2)));
            double otherDistance = (Math.sqrt(Math.pow(0 - c.x, 2) + Math.pow(0 - c.y, 2)));

            if(thisDistance > otherDistance){
                return 1;
            }else if(thisDistance < otherDistance){
                return -1;
            }

            return 0;
        }
    }
}
