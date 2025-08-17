import java.util.*;

public class GroupAnagramsOptimal {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] input = { "eat", "tea", "tan", "ate", "nat", "bat" };
        List<List<String>> output = groupAnagrams(input);
        System.out.println(output);
    }
}

// Algorithm (Step by Step)
// Initialize a HashMap:
// Key: frequency signature (String).
// Value: list of anagrams.
// For each word:
// Create an int[26] array (for letters 'a'–'z').
// Count frequency of each character.
// Convert that frequency array into a string key (like "1#0#2#...").
// Put the word into the HashMap under that key.
// Return all the HashMap values (lists of anagrams).

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            // frequency array
            int[] freq = new int[26];
            for (char c : str.toCharArray())
                freq[c - 'a']++;

            // creating a unique key from freq
            StringBuilder sb = new StringBuilder();
            for (int count : freq)
                sb.append(count).append("#"); // eg 0#2#7# it can be wtv , we just want a unique key
            String key = sb.toString();

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}