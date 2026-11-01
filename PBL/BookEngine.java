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
    public static void main(String[] args) {
        // Load the book and process Task 1
        loadBook("PBL/book.txt"); 
        
        // Display Task 1 
        showWordStatistics();

        // Test Task 2 
        
        getNeighbors("project"); 
    }
}