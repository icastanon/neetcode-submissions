class MedianFinder {
    int size = 0;

    Queue<Integer> secondHalf;
    Queue<Integer> firstHalf;
    List<Integer> nums;

    public MedianFinder() {
        firstHalf = new PriorityQueue<>(Comparator.reverseOrder());
        secondHalf = new PriorityQueue<>();
        nums = new ArrayList<>();
    }
    
    public void addNum(int num) {
        if(firstHalf.isEmpty() || secondHalf.isEmpty()){
            firstHalf.offer(num);
            if(firstHalf.size() > secondHalf.size() && firstHalf.size() - secondHalf.size() > 1){
                secondHalf.offer(firstHalf.poll());
            }
        }else if(num > secondHalf.peek()){
            //push into second half
            secondHalf.offer(num);
            if(secondHalf.size() > firstHalf.size()){
                firstHalf.offer(secondHalf.poll());
            }
        }else{
            //push into first half
            firstHalf.offer(num);
            if(firstHalf.size() > secondHalf.size() && firstHalf.size() - secondHalf.size() > 1){
                secondHalf.offer(firstHalf.poll());
            }
        }

        size++;
        
    }
    
    public double findMedian() {
        if(size%2 == 0){
            return (double) (firstHalf.peek()+secondHalf.peek())/2;
        }else{
            return firstHalf.peek();
        }
        
        
        
    }
}
