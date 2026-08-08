class MedianFinder {
    Queue<Integer> left, right;

    public MedianFinder() {
        left = new PriorityQueue<>(Comparator.reverseOrder());
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(!right.isEmpty() && num > right.peek()){
            right.offer(num);
        }else{
            left.offer(num);
        }

        while(right.size() > left.size()){
            left.offer(right.poll());
        }
        
        if(left.size() - right.size() > 1){
            right.offer(left.poll());
        }
    }
    
    public double findMedian() {
        if(left.size() == right.size()){
            return (left.peek() + right.peek()) / 2.0;
        }

        return left.peek();
    }
}
