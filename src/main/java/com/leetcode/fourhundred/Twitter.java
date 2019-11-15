package com.leetcode.fourhundred;

import java.util.*;

/**
 * https://leetcode.com/problems/design-twitter/
 * <p>
 * Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:
 * <p>
 * postTweet(userId, tweetId): Compose a new tweet.
 * getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
 * follow(followerId, followeeId): Follower follows a followee.
 * unfollow(followerId, followeeId): Follower unfollows a followee.
 * Example:
 * <p>
 * Twitter twitter = new Twitter();
 * <p>
 * // User 1 posts a new tweet (id = 5).
 * twitter.postTweet(1, 5);
 * <p>
 * // User 1's news feed should return a list with 1 tweet id -> [5].
 * twitter.getNewsFeed(1);
 * <p>
 * // User 1 follows user 2.
 * twitter.follow(1, 2);
 * <p>
 * // User 2 posts a new tweet (id = 6).
 * twitter.postTweet(2, 6);
 * <p>
 * // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
 * // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
 * twitter.getNewsFeed(1);
 * <p>
 * // User 1 unfollows user 2.
 * twitter.unfollow(1, 2);
 * <p>
 * // User 1's news feed should return a list with 1 tweet id -> [5],
 * // since user 1 is no longer following user 2.
 * twitter.getNewsFeed(1);
 *
 * @auther carl
 */
public class Twitter {
    Map<Integer, List<Tweet>> userTweets = new HashMap<>();
    Map<Integer, Set<Integer>> userUser = new HashMap<>();
    int timestamp = 0;

    public Twitter() {
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        List<Tweet> tweets = userTweets.computeIfAbsent(userId, k -> new LinkedList<>());
        tweets.add(0, new Tweet(tweetId, timestamp++));
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> que = new PriorityQueue<>((a, b) -> (int) (b.timestamp - a.timestamp));
        que.addAll(userTweets.computeIfAbsent(userId, k -> new LinkedList<>()));
        for (Integer u : userUser.computeIfAbsent(userId, k -> new HashSet<>())) {
            que.addAll(userTweets.computeIfAbsent(u, k -> new LinkedList()));
        }
        List<Integer> tweets = new LinkedList<>();
        for (int i = 0; i < 10 && !que.isEmpty(); i++) {
            tweets.add(que.poll().id);
        }
        return tweets;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        userUser.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        userUser.computeIfAbsent(followerId, k -> new HashSet<>()).remove(followeeId);
    }

    class Tweet {
        int id;
        long timestamp;

        public Tweet(int id, long timestamp) {
            this.id = id;
            this.timestamp = timestamp;
        }
    }
}
