// AVL Tree where each node stores one word (key) and its list of page numbers.
// Self-balancing: tree height stays O(log n) no matter how many words are inserted.
public class WordIndexTree {

    private String key;       // the word stored in this node
    private PageList pages;   // pages where this word appears
    private int height;
    private WordIndexTree left;
    private WordIndexTree right;

    // Private constructor — used only for the NIL sentinel node.
    private WordIndexTree() {
        left = right = this;
        height = -1;
    }

    // Private constructor — used internally during rotations.
    private WordIndexTree(String key, PageList pages, WordIndexTree left, WordIndexTree right) {
        this.key = key;
        this.pages = pages;
        this.left = left;
        this.right = right;
        height = 1 + Math.max(left.height, right.height);
    }

    // Public constructor — creates a new node for a word.
    public WordIndexTree(String key) {
        this.key = key;
        this.pages = new PageList();
        left = right = NIL;
    }

    // NIL is a shared empty-node sentinel. All leaf nodes point to NIL instead of null.
    public static final WordIndexTree NIL = new WordIndexTree();

    public int getHeight() {
        return height;
    }

    // Inserts a word + its page number into the tree.
    // If the word already exists, just adds the page to its existing list (no duplicate node).
    public WordIndexTree insert(String word, int page) {
        if (this == NIL) {
            WordIndexTree node = new WordIndexTree(word);
            node.pages.addPage(page);
            return node;
        }

        int cmp = word.compareTo(this.key);

        if (cmp == 0) {
            pages.addPage(page);   // word already exists — just add the new page
        } else if (cmp < 0) {
            left = left.insert(word, page);
        } else {
            right = right.insert(word, page);
        }

        rebalance();
        height = 1 + Math.max(left.height, right.height);
        return this;
    }

    // Searches for a word and returns its PageList. Returns null if not found.
    public PageList find(String word) {
        WordIndexTree node = this;

        while (node != NIL) {
            int cmp = word.compareTo(node.key);
            if (cmp == 0) {
                return node.pages;
            }
            node = (cmp < 0) ? node.left : node.right;
        }

        return null; // word not in tree
    }

    // Checks balance and triggers the correct rotation if the tree is leaning too far.
    private void rebalance() {
        int balance = left.height - right.height;

        if (balance > 1) {
            // Left-heavy. Check if it's LR case (needs double rotation).
            if (left.left.height < left.right.height) {
                left.rotateLeft(); // convert LR → LL first
            }
            rotateRight(); // fix LL
        } else if (balance < -1) {
            // Right-heavy. Check if it's RL case (needs double rotation).
            if (right.right.height < right.left.height) {
                right.rotateRight(); // convert RL → RR first
            }
            rotateLeft(); // fix RR
        }
    }

    // Rotates the tree right. The left child moves up to take this node's place.
    // Instead of changing which object is root, we swap field values in-place.
    private void rotateRight() {
        WordIndexTree pivot = left;
        left = pivot.left;
        right = new WordIndexTree(key, pages, pivot.right, right); // old content moves down-right
        key = pivot.key;
        pages = pivot.pages;
    }

    // Mirror of rotateRight.
    private void rotateLeft() {
        WordIndexTree pivot = right;
        right = pivot.right;
        left = new WordIndexTree(key, pages, left, pivot.left); // old content moves down-left
        key = pivot.key;
        pages = pivot.pages;
    }

    // Prints all words in alphabetical order (inorder traversal).
    // If the output is alphabetical, the BST structure is correct.
    public String toString() {
        StringBuilder sb = new StringBuilder();
        inorder(this, sb);
        return sb.toString();
    }

    private void inorder(WordIndexTree node, StringBuilder sb) {
        if (node == NIL) return;
        inorder(node.left, sb);
        sb.append(node.key).append(node.pages).append("\n");
        inorder(node.right, sb);
    }

    // Self-test
    public static void main(String[] args) {
        // Inserting in non-sorted order on purpose — forces rotations to happen.
        WordIndexTree tree = new WordIndexTree("the");
        tree.insert("the", 1);
        tree.insert("sheriff", 1);
        tree.insert("kadem", 1);
        tree.insert("ludden", 2);
        tree.insert("pilarn", 2);
        tree.insert("kadem", 3);   // "kadem" appears on page 3 too
        tree.insert("bijou", 4);
        tree.insert("amusement", 4);

        System.out.println("Inorder (must be alphabetical):");
        System.out.println(tree);

        System.out.println("Height: " + tree.getHeight());

        System.out.println("find('kadem')  -> " + tree.find("kadem"));   
        System.out.println("find('ludden') -> " + tree.find("ludden"));  
        System.out.println("find('dud')    -> " + tree.find("dud"));     

        // Stress test: insert 21 words in sorted order.
        // A normal BST would become a straight line (height = 20).
        // AVL should stay around height 4-5.
        WordIndexTree sortedTest = new WordIndexTree("a");
        sortedTest.insert("a", 1);
        String[] letters = {"b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u"};
        for (int i = 0; i < letters.length; i++) {
            sortedTest.insert(letters[i], i + 2);
        }
        System.out.println("\nSorted-insert stress test (21 words, a to u):");
        System.out.println("Height: " + sortedTest.getHeight() );   // should be ~4-5, not 20
    }
}