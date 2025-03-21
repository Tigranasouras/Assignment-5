// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String[] input = {"google", "gojo", "amazingly", "jogo", "luna", "pup", "solas",
                "solo", "pupperino", "amaterasu", "amazon", "puppy",
                "hydra", "amazonia", "vueltiao"};

        LexicoRadixSort.radixSort(input);

        // Print sorted array
        for (String s : input) {
            System.out.print(s + ", ");
        }

        System.out.println(WordPattern.followsPattern("abba", '?', "dog?cat?cat?dog")); // true
        System.out.println(WordPattern.followsPattern("abba", '|', "apple|banana|grape|apple")); // false
        System.out.println(WordPattern.followsPattern("aaaa", ',', "dog,cat,cat,dog")); // false
        System.out.println(WordPattern.followsPattern("aaaa", ' ', "ice cream taco day")); // false
        System.out.println(WordPattern.followsPattern("adxp", ' ', "ice cream taco day")); // true
    }
}

