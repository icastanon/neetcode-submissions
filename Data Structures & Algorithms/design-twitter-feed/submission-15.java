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
        
        Queue<int[]> minHeap = new PriorityQueue<>((a,b) -> 
            {
                int userIdA = a[0];
                int lastTweetIndexA = a[1];
                List<int[]> tweetsForA = tweets.get(userIdA);
                int[] lastTweetForA = tweetsForA.get(lastTweetIndexA);

                int userIdB = b[0];
                int lastTweetIndexB = b[1];
                List<int[]> tweetsForB = tweets.get(userIdB);
                int[] lastTweetForB = tweetsForB.get(lastTweetIndexB);

                return lastTweetForB[1] - lastTweetForA[1];
            });


        for(int userIdd : followed){
            List<int[]> tweetsForUser = tweets.getOrDefault(userIdd, new ArrayList<>());

            if(!tweetsForUser.isEmpty()){
                int lastIndex = tweetsForUser.size()-1;

                int[] userAndLastIndex = {userIdd, lastIndex};
                minHeap.offer(userAndLastIndex);
            }
            
        }

        List<Integer> result = new ArrayList<>();

        while(!minHeap.isEmpty() && result.size() < 10){
            int[] userAndLastIndex = minHeap.poll();
            result.add(tweets.get(userAndLastIndex[0]).get(userAndLastIndex[1])[0]);
            if(userAndLastIndex[1] > 0){
                int[] newUserAndLastIndex = {userAndLastIndex[0], userAndLastIndex[1]-1};
                minHeap.offer(newUserAndLastIndex);
            }
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
