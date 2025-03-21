import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    // Checks if the string follows the given pattern using the specified delimiter
    public static boolean followsPattern(String pattern, char delimiter, String s) {
        // Split the input string into words using the delimiter
        String[] words = s.split("//the splitter" + delimiter);

        // If number of pattern characters and words don't match, return false - l bozo
        if (words.length != pattern.length()) {
            return false;
        }

        //track of character-to-word and word-to-character mappings
        Map<Character, String> patternToWord = new HashMap<>();
        Map<String, Character> wordToPattern = new HashMap<>();

        //Loop char, pattern per word
        for (int i = 0; i < pattern.length(); i++) {
            char currentChar = pattern.charAt(i);
            String currentWord = words[i];

            //checker for double mapping
            if (patternToWord.containsKey(currentChar)) {
                // If the previously mapped word is different, return false
                if (!patternToWord.get(currentChar).equals(currentWord)) {
                    return false;
                }
            } else {
                //return false if mapped elsewhere
                if (wordToPattern.containsKey(currentWord)) {
                    return false;
                }

                //the mapping in both directions
                patternToWord.put(currentChar, currentWord);
                wordToPattern.put(currentWord, currentChar);
            }
        }

        return true;
    }
}