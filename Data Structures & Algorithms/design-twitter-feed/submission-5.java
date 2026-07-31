class Twitter {

    Integer time;

    Map<Integer, Deque<Tweet>> userAndTweets;
    Map<Integer, Set<Integer>> userAndFollows;

    public Twitter() {
        userAndTweets = new HashMap<>();
        userAndFollows = new HashMap<>();
        time = 1;
        
    }

    class Tweet{
        public Integer id;
        public Integer time;

        public Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }
    
    public void postTweet(int userId, int tweetId) {
        Deque<Tweet> tweets = userAndTweets.get(userId);
        if(tweets == null){
            tweets = new ArrayDeque<>();
            tweets.push(new Tweet(tweetId, time++));
            userAndTweets.put(userId, tweets);

            //every time a first post is made. make the user follow themselves
            Set<Integer> followees = new HashSet<>();
            followees.add(userId);
            userAndFollows.put(userId, followees);
        }else{
            tweets.push(new Tweet(tweetId, time++));
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> followees = userAndFollows.get(userId);
        if(followees != null && !followees.isEmpty()){
            // System.out.println("FOLLOWEES FOR " + userId + ": ");
            // for(Integer f : followees){
            //     System.out.println(f);
            // }

            Map<Integer, Deque<Tweet>> removedTweets = new HashMap<>();

            List<Integer> feed = new ArrayList<>();

            for(int i = 0; i < 10; i++){
                Integer mostRecentUser = null;
                Tweet mostRecentTweet = null;

                //find the most recent tweet of all followees
                for(Integer f : followees){
                    Deque<Tweet> tweetsForF = userAndTweets.get(f);
                    Tweet t = tweetsForF.peek();

                    if(t != null && (mostRecentTweet == null || t.time > mostRecentTweet.time)){
                        mostRecentTweet = t;
                        mostRecentUser = f;
                    }
                }

                //if no followers have any tweets break
                if(mostRecentTweet == null){
                    break;
                }

                //remove the most recent one and add it to a stack of removed tweets for 'mostRecentUser'
                Deque<Tweet> removed = removedTweets.get(mostRecentUser);
                if(removed == null){
                    removed = new ArrayDeque<>();
                    removed.push(userAndTweets.get(mostRecentUser).pop());
                    removedTweets.put(mostRecentUser, removed);
                }else{
                    removed.push(userAndTweets.get(mostRecentUser).pop());
                }

                //add it to the feed list
                feed.add(mostRecentTweet.id);
            }

            //add back the tweets and return each stack to its original form (number of removed tweets should always be 10)
            for(Integer user : removedTweets.keySet()){
                Deque<Tweet> tweetsToPutBack = removedTweets.get(user);
                while(!tweetsToPutBack.isEmpty()){
                    userAndTweets.get(user).push(tweetsToPutBack.pop());
                }
            }

            return feed;
        }else{
            // System.out.println("NO FOLLOWEES FOR " + userId);

            //return only the users tweets;
            List<Integer> feed = new ArrayList<>();

            //pop elements from the stack
            Deque<Tweet> tweets = userAndTweets.get(userId);
            if(tweets == null){
                return feed;
            }
            Deque<Tweet> removedTweets = new ArrayDeque<>();

            int tweetCount = 0;
            while(tweets.size() > 0 && tweetCount < 10){
                Tweet tweet = tweets.pop();
                feed.add(tweet.id);
                removedTweets.push(tweet);
            }

            //put removed tweets back into the stack
            while(!removedTweets.isEmpty()){
                tweets.push(removedTweets.pop());
            }

            return feed;
        }
        
    }
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> followees = userAndFollows.get(followerId);

        if(followees == null){
            followees = new HashSet<>();
            followees.add(followeeId);

            userAndFollows.put(followerId, followees);
        }else{
            followees.add(followeeId);
        }
        
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followees = userAndFollows.get(followerId);

        if(followees != null){
            followees.remove(followeeId);
        }
        
    }
}
