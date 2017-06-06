package test.cjhaveri.corejava.tricks;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by chetanjhaveri on 10/5/16.
 * https://leetcode.com/problems/lru-cache/
 * 146. LRU Cache  QuestionEditorial Solution  My Submissions
 * Total Accepted: 90595
 * Total Submissions: 572344
 * Difficulty: Hard
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 */
public class LRUCache {


    Map<String, String> map = null;

    public LRUCache(int capacity) {

        //initialize some kind of a map of the appropriate capacity
        //how to store the access counts in some kind of a sorted fashion
        map = new ConcurrentHashMap<>(capacity);


    }

    public int get(int key) {

        //return if the item is available in the map
        //-1 if item is not available
        //increment access counts
        //sort the items such that higher items are on top?

        return -1;

    }

    public void set(int key, int value) {

        //if item is available in map, update it
        //if map is not full then set the item into the map
        //else remove the least used item and set this in there
        //with an access count of zero

    }
}
