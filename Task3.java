// import java.util.Arrays;

// // ================================================================
// // TASK 3: SIMILAR WORDS SEARCH
// // ================================================================

// // Stores 26 alphabet characters
// static class TrieNode {
//     TrieNode[] children = new TrieNode[26];
//     boolean isEnd = false;
// }

// // Trie for prefix searching
// static class WordTrie {
//     private TrieNode root = new TrieNode();
//     private int wordCount = 0;

//     // Insert a word into Trie
//     public void insert(String word) {
//         TrieNode curr = root;

//         for (char ch : word.toCharArray()) { //for-each loop
//             if (ch < 'a' || ch > 'z')
//                 return;

//             int index = ch - 'a';

//             if (curr.children[index] == null)
//                 curr.children[index] = new TrieNode();

//             curr = curr.children[index];
//         }

//         if (!curr.isEnd) {
//             curr.isEnd = true;
//             wordCount++;
//         }
//     }

//     // Collect matching words
//     private int collect(TrieNode node, String word,
//                         String[] result, int count) {
//         if (node == null)
//             return count; // Base case: if node is null, return the current count

//         if (node.isEnd) 
//             result[count++] = word;

//         for (int i = 0; i < 26; i++) {
//             if (node.children[i] != null) {
//                 count = collect(node.children[i],
//                     word + (char)('a' + i), result, count); // Recursively collect words
//             }
//         }

//         return count;
//     }

//     // Search words starting with a prefix
//     public String[] getWordsWithPrefix(String prefix) {
//         prefix = prefix.toLowerCase();
//         TrieNode curr = root;

//         for (char ch : prefix.toCharArray()) {
//             if (ch < 'a' || ch > 'z')
//                 return new String[0];

//             curr = curr.children[ch - 'a'];

//             if (curr == null)
//                 return new String[0];
//         }

//         String[] result = new String[wordCount]; //wordCount is the total number of words in the Trie
//         int count = collect(curr, prefix, result, 0);

//         return Arrays.copyOf(result, count);
//     }
// }

// // Calculate Edit Distance
// public static int editDistance(String a, String b) { //first and second words
//     int[][] dp = new int[a.length() + 1][b.length() + 1];
    

//     for (int i = 0; i <= a.length(); i++)
//         dp[i][0] = i; 

//     for (int j = 0; j <= b.length(); j++)
//         dp[0][j] = j;

//     for (int i = 1; i <= a.length(); i++) {
//         for (int j = 1; j <= b.length(); j++) {
//             int cost = a.charAt(i - 1) == b.charAt(j - 1) ? 0 : 1;

//             dp[i][j] = Math.min(dp[i-1][j-1] + cost,
//                 Math.min(dp[i-1][j] + 1, dp[i][j-1] + 1));
//         }
//     }

//     return dp[a.length()][b.length()];
// }

// // Find similar words from the book
// public static void getSimilarWords(WordHashTable wordTable,
//                                    String target, int maxDist) {
//     for (WordFrequency item : wordTable.getAllWords()) {
//         if (editDistance(target, item.word) <= maxDist)
//             System.out.println("  " + item.word);
//     }
// }

// // ================================================================
// // TASK 3: MAIN SECTION
// // ================================================================

// WordTrie wordTrie = new WordTrie();

// // Insert unique words from Task 1
// for (WordFrequency item : wordTable.getAllWords())
//     wordTrie.insert(item.word);

// // Prefix Search
// String prefix = "al";
// String[] matches = wordTrie.getWordsWithPrefix(prefix);

// System.out.println("Words starting with: " + prefix);
// for (String word : matches)
//     System.out.println("  " + word);

// // Edit Distance Search
// String target = "alce";

// System.out.println("\nSimilar words for: " + target);
// getSimilarWords(wordTable, target, 2);