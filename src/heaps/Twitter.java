package heaps;

import java.util.*;

public class Twitter {

    class Tweet implements Comparable<Tweet>{
        int tweetId;
        int timestamp;
        Tweet(int tweetId,int timestamp){
            this.tweetId=tweetId;
            this.timestamp=timestamp;
        }

        @Override
        public int compareTo(Tweet comparewith){
          return comparewith.timestamp-this.timestamp;
        }
    }

    Map<Integer,List<Tweet>> usertweetmap;
    Map<Integer,List<Integer>> userfollowermap;
    int timestamp=0;

    /** Initialize your data structure here. */
    public Twitter() {
        this.usertweetmap=new HashMap<>();
        this.userfollowermap=new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Tweet tweet=new Tweet(tweetId,timestamp++);
        if(usertweetmap.containsKey(userId)){
            usertweetmap.get(userId).add(tweet);
        }else{
            List<Tweet> tweetlist=new ArrayList<>();
            tweetlist.add(tweet);
            usertweetmap.put(userId,tweetlist);
        }
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq=new PriorityQueue<>();
        if(usertweetmap.containsKey(userId)){
            for(Tweet usertweets : usertweetmap.get(userId)){
                pq.offer(usertweets);
            }
        }


        if(userfollowermap.containsKey(userId)){
            for(Integer followee : userfollowermap.get(userId)){
                if(usertweetmap.containsKey(followee)){
                    for(Tweet usertweets : usertweetmap.get(followee)){
                        pq.offer(usertweets);
                    }
                }
            }
        }

        List<Integer> newsfeed=new LinkedList<>();
        int count=0;
        while(!pq.isEmpty() && count<10){
            newsfeed.add(pq.poll().tweetId);
            count++;
        }
        return newsfeed;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        List<Integer> followeelist=new ArrayList<>();
        followeelist.add(followeeId);

        if(userfollowermap.containsKey(followerId)){
            userfollowermap.get(followerId).addAll(followeelist);
        }else{
            userfollowermap.put(followerId,followeelist);
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        userfollowermap.get(followerId).remove((Object)followeeId);
    }
}
