import java.util.*;

public class LexicoRadixSort {

    public static void radixSort(String[] arr) {
        //array is null or empty; sorting is for losers
        if (arr == null || arr.length == 0) return;

        //length of the longest string in the array
        int maxLength = 0;
        for (String word : arr) {
            if (word.length() > maxLength) {
                maxLength = word.length();
            }
        }

        //character position from right to left
        for (int position = maxLength - 1; position >= 0; position--) {
            sortByCharacterAtPosition(arr, position);
        }
    }

    //sorts the array based on the character at the given position
    private static void sortByCharacterAtPosition(String[] arr, int position) {
        //TreeMap to keep keys (characters) sorted - I hate tree maps
        Map<Character, Queue<String>> buckets = new TreeMap<>();

        for (String word : arr) {
            // If the word is too short; use a placeholder character
            char currentChar;
            if (position < word.length()) {
                currentChar = word.charAt(position);
            } else {
                currentChar = 0; // Special character to sort shorter words first
            }

            //Add the word to the correct bucket
            buckets.putIfAbsent(currentChar, new LinkedList<>());
            buckets.get(currentChar).add(word);
        }

        //remake the array using the sorted buckets
        int index = 0;
        for (Queue<String> group : buckets.values()) {
            while (!group.isEmpty()) {
                arr[index] = group.poll();
                index++;
            }
        }
    }

    // Main method to test the radix sort
    public static void main(String[] args) {
        // Sample input list
        String[] words = {
                "google", "gojo", "amazingly", "jogo", "luna", "pup", "solas",
                "solo", "pupperino", "amaterasu", "amazon", "puppy",
                "hydra", "amazonia", "vueltiao"
        };

        // Call radix sort
        radixSort(words);

        // Print sorted result
        System.out.println("Sorted words:");
        for (String word : words) {
            System.out.print(word + ", ");
        }
    }
}