import java.io.*;
import java.util.*;

public class BookEngine {

    // Task 1 Data Structures
    static ArrayList<String> allWords = new ArrayList<>();
    static HashMap<String, Integer> frequency = new HashMap<>();

    // Task 2 Data Structure (Adjacency List for Graph)
    // Outer Map: Key = Target Word, Value = Inner Map
    // Inner Map: Key = Neighbor Word, Value = Frequency of that neighbor
    static HashMap<String, HashMap<String, Integer>> graph = new HashMap<>();

    // TASK 1: Book Loading & Word Count
    public static void loadBook(String fileName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = br.readLine()) != null) {
                // Remove punctuation and convert to lowercase
                line = line.toLowerCase().replaceAll("[^a-z0-9\\s]", " ");

                // Split line into individual words
                String[] words = line.split("\\s+");

                for (String w : words) {
                    if (!w.trim().isEmpty()) {
                        // Add to dynamic array for total word count
                        allWords.add(w);

                        // Add to HashMap for exact frequency
                        frequency.put(w, frequency.getOrDefault(w, 0) + 1);
                    }
                }
            }
            br.close();

            // Build the graph for Task 2 after loading the book
            buildGraph();

        } catch (Exception e) {
            System.out.println("Error: File not found!");
        }
    }


    // Task 1 results display
    public static void showWordStatistics() {
        System.out.println("Total words (with duplicates): " + allWords.size());
        System.out.println("Total unique words (vocabulary): " + frequency.size());

        // Sort unique words by frequency in descending order
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(frequency.entrySet());
        sortedList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        System.out.println("Top 5 Most Frequent Words:");
        for (int i = 0; i < 5 && i < sortedList.size(); i++) {
            System.out.println(sortedList.get(i).getKey() + " = " + sortedList.get(i).getValue());
        }
    }

    // TASK 2: Neighboring Words (Bi-gram)

    public static void buildGraph() {
        // Loop through the ArrayList up to the second-to-last word
        for (int i = 0; i < allWords.size() - 1; i++) {
            String currentWord = allWords.get(i);
            String nextWord = allWords.get(i + 1); // The immediate neighbor

            // If the current word is not in the graph, create a new HashMap for it
            graph.putIfAbsent(currentWord, new HashMap<>());

            // Get the neighbor map for the current word and update the next word's frequency
            HashMap<String, Integer> neighbors = graph.get(currentWord);
            neighbors.put(nextWord, neighbors.getOrDefault(nextWord, 0) + 1);
        }
    }

    // Function to get and print neighbors of a specific target word
    public static void getNeighbors(String targetWord) {
        System.out.println("Neighbors of the word: '" + targetWord + "'");

        targetWord = targetWord.toLowerCase();

        // Check if the target word exists in our graph
        if (graph.containsKey(targetWord)) {
            HashMap<String, Integer> neighbors = graph.get(targetWord);

            // Print all neighbors and their frequencies
            for (Map.Entry<String, Integer> neighbor : neighbors.entrySet()) {
                System.out.println(" -> " + neighbor.getKey() + " (Frequency: " + neighbor.getValue() + ")");
            }
        } else {
            System.out.println("This word was not found in the book.");
        }
    }

    // ================================================================
    // TASK 3: SIMILAR WORDS SEARCH
    // ================================================================

    // Stores 26 alphabet characters
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    // Trie for prefix searching
    static class WordTrie {
        private TrieNode root = new TrieNode();
        private int wordCount = 0;

        // Insert a word into Trie
        public void insert(String word) {
            TrieNode curr = root;

            for (char ch : word.toCharArray()) { // for-each loop
                if (ch < 'a' || ch > 'z')
                    return; // skip words with non-letter characters

                int index = ch - 'a';

                if (curr.children[index] == null)
                    curr.children[index] = new TrieNode();

                curr = curr.children[index];
            }

            if (!curr.isEnd) {
                curr.isEnd = true;
                wordCount++;
            }
        }

        // Collect matching words
        private int collect(TrieNode node, String word, String[] result, int count) {
            if (node == null)
                return count; // Base case: if node is null, return the current count

            if (node.isEnd)
                result[count++] = word;

            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null) {
                    count = collect(node.children[i],
                        word + (char) ('a' + i), result, count); // Recursively collect words
                }
            }

            return count;
        }

        // Search words starting with a prefix
        public String[] getWordsWithPrefix(String prefix) {
            prefix = prefix.toLowerCase();
            TrieNode curr = root;

            for (char ch : prefix.toCharArray()) {
                if (ch < 'a' || ch > 'z')
                    return new String[0];

                curr = curr.children[ch - 'a'];

                if (curr == null)
                    return new String[0]; // prefix not found
            }

            String[] result = new String[wordCount]; // wordCount is total words in whole Trie
            int count = collect(curr, prefix, result, 0);

            return Arrays.copyOf(result, count);
        }
    }

    // Calculate Edit Distance (Dynamic Programming)
    public static int editDistance(String a, String b) { // first and second words
        int[][] dp = new int[a.length() + 1][b.length() + 1];

        for (int i = 0; i <= a.length(); i++)
            dp[i][0] = i;

        for (int j = 0; j <= b.length(); j++)
            dp[0][j] = j;

        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                int cost = a.charAt(i - 1) == b.charAt(j - 1) ? 0 : 1;

                dp[i][j] = Math.min(dp[i - 1][j - 1] + cost,
                    Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
            }
        }

        return dp[a.length()][b.length()];
    }

    // Find similar words from the book using our own frequency HashMap (Task 1)
    public static void getSimilarWords(String target, int maxDist) {
        for (String word : frequency.keySet()) {
            if (editDistance(target, word) <= maxDist)
                System.out.println("  " + word);
        }
    }

    // Builds the Trie from the words already counted in Task 1,
    // then runs a prefix search and a similar-word (edit distance) search.
    public static void runSimilarWordsDemo() {
        WordTrie wordTrie = new WordTrie();

        // Insert unique words from Task 1
        for (String word : frequency.keySet())
            wordTrie.insert(word);

        // Prefix Search
        String prefix = "ka";
        String[] matches = wordTrie.getWordsWithPrefix(prefix);

        System.out.println("\nWords starting with: " + prefix);
        for (String word : matches)
            System.out.println("  " + word);

        // Edit Distance Search
        String target = "kadm";

        System.out.println("\nSimilar words for: " + target);
        getSimilarWords(target, 1);
    }

    public static void main(String[] args) {
        // Load the book and process Task 1
        loadBook("PBL/book.txt");

        // Display Task 1
        showWordStatistics();

        // Test Task 2
        getNeighbors("project");

        // Test Task 3
        runSimilarWordsDemo();
    }
}