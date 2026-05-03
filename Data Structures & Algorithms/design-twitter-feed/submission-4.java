class Twitter {



    class Tweet{
        int time;
        int tweetID;

        Tweet(int time , int tweetID){
            this.time = time;
            this.tweetID = tweetID;
        }
    }


    Map<Integer , PriorityQueue<Tweet>> posts = new HashMap<>();
    Map<Integer, Set<Integer>> followers = new HashMap<>();
    int timestamp = 0;
    public Twitter() {
        
    }
    
    public void postTweet(int userId, int tweetID) {
        if(!posts.containsKey(userId)){
            posts.put(userId , new PriorityQueue<>((a,b)->b.time - a.time));
           
        }
        posts.get(userId).add(new Tweet(timestamp++ , tweetID));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a,b)->b.time - a.time);

        if (posts.containsKey(userId)) {
        pq.addAll(posts.get(userId));
        }
        if(followers.containsKey(userId))
        for(int follower : followers.get(userId)){
            if(posts.containsKey(follower))
                pq.addAll(posts.get(follower));
        }

         while (!pq.isEmpty() && ans.size() < 10) {
        ans.add(pq.poll().tweetID);
        }

        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId==followeeId)return;
        if(!followers.containsKey(followerId)){
            followers.put(followerId , new HashSet<>());
        }
        followers.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerId==followeeId)return;
        followers.get(followerId).remove((Integer)followeeId);
    }
}
