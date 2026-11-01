import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Reads the book file, builds the inverted index (WordIndexTree),
// and provides the searchInPageRange() function for Task 4.
//
// NOTE: A plain .txt file has no real page numbers.
// We treat every 50 lines as one "page" — this is a documented design choice.
public class WordIndexer {

    private static final int PAGE_SIZE = 50; // 50 lines = 1 page

    private WordIndexTree index;

    // Reads the book line by line and builds the full index.
    public void loadBook(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            int lineNumber = 0;

            while ((line = br.readLine()) != null) {
                lineNumber++;
                int page = ((lineNumber - 1) / PAGE_SIZE) + 1; // e.g. lines 1-50 → page 1

                // Lowercase and remove punctuation, keep only letters/digits/spaces
                String cleaned = line.toLowerCase().replaceAll("[^a-z0-9\\s]", " ");
                String[] words = cleaned.split("\\s+");

                for (String w : words) {
                    if (!w.trim().isEmpty()) {
                        if (index == null) {
                            index = new WordIndexTree(w);
                            index.insert(w, page);
                        } else {
                            index.insert(w, page);
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading book: " + e.getMessage());
        }
    }

    // Task 4 — Requirement 2:
    // Returns true if the word appears on any page between startPage and endPage.
    // Does NOT re-read the book — uses the index directly.
    public boolean searchInPageRange(String word, int startPage, int endPage) {
        if (index == null) return false;

        PageList pages = index.find(word.toLowerCase());
        if (pages == null) {
            return false; // word not in book at all
        }
        return pages.existsInRange(startPage, endPage);
    }

    public int getIndexHeight() {
        return (index == null) ? -1 : index.getHeight();
    }

    public static void main(String[] args) {
        WordIndexer engine = new WordIndexer();

        long start = System.nanoTime();
        engine.loadBook("PBL/book.txt");
        long elapsedMs = (System.nanoTime() - start) / 1_000_000;

        System.out.println("Book loaded in " + elapsedMs + " ms");
        System.out.println("AVL tree height (unique words): " + engine.getIndexHeight());

        System.out.println("\n--- searchInPageRange tests ---");

        System.out.println("'kadem' in pages 1-3?    " + engine.searchInPageRange("kadem", 1, 3));
        System.out.println("'kadem' in pages 1-14?   " + engine.searchInPageRange("kadem", 1, 14));

        System.out.println("'pilarn' in pages 1-3?   " + engine.searchInPageRange("pilarn", 1, 3));
        System.out.println("'pilarn' in pages 4-14?  " + engine.searchInPageRange("pilarn", 4, 14));

        System.out.println("'xyz123' in pages 1-14?  " + engine.searchInPageRange("xyz123", 1, 14));  // not in book

        System.out.println("'gutenberg' in pages 1-1? " + engine.searchInPageRange("gutenberg", 1, 1));
    }
}