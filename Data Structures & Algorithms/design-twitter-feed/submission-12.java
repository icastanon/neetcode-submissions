class Twitter {
    Map<Integer, Set<Integer>> following;
    Map<Integer, List<int[]>> tweets;
    int time = 1;


    public Twitter() {
        following = new HashMap<>();
        tweets = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        int[] tweet = {tweetId, time++};
        List<int[]> userTweets = tweets.getOrDefault(userId, new ArrayList<>());
        userTweets.add(tweet);
        tweets.put(userId, userTweets);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> followed = following.getOrDefault(userId, new HashSet<>());
        followed.add(userId);
        Queue<int[]> minHeap = new PriorityQueue<int[]>((a,b) -> b[1] - a[1]);

        for(int f : followed){
            List<int[]> fTweets = tweets.getOrDefault(f, new ArrayList<>());
            for(int[] tweet : fTweets){
                minHeap.add(tweet);
            }
        }

        List<Integer> result = new ArrayList<>();

        while(!minHeap.isEmpty() && result.size() < 10){
            result.add(minHeap.poll()[0]);
        }

        return result;
        
    }
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> followed = following.getOrDefault(followerId, new HashSet<>());
        followed.add(followeeId);
        following.put(followerId, followed);
        
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followed = following.getOrDefault(followerId, new HashSet<>());
        followed.remove(followeeId);
        following.put(followerId, followed);
    }

}
