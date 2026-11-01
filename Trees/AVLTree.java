package Trees;


public class AVLTree {
    private int key;
    private int height;
    private AVLTree left;
    private AVLTree right;

    private AVLTree(){
        left = right = this;
        height = -1;
    }

    private AVLTree(int key, AVLTree left, AVLTree right) {
        this.key = key;
        this.left = left;
        this.right = right;
        height = 1 + Math.max(left.height, right.height);
    }

    public AVLTree(int key) {
        this.key = key;
        left = right = NIL;
    }

    public static final AVLTree NIL = new AVLTree();

    public boolean add(int key){
        int oldSize = size();
        grow(key);
        return size() > oldSize;
    }

    public int size() {
        if (this == NIL) {
            return 0;
        }
        return 1 + left.size() + right.size();
    }

    public int getHeight() {
        return height;
    }

    public AVLTree grow(int key) {
        if (this == NIL)
            return new AVLTree(key);
        if (key == this.key)
            return this; // Duplicate key, do nothing
        if (key < this.key) {
            left = left.grow(key);
        } else {
            right = right.grow(key);
        }
        rebalance();
        height = 1 + Math.max(left.height, right.height);
        return this;
    }

    // Balance Factor check karta hai aur zaroorat pe rotation karwata hai
    private void rebalance() {
        int balance = left.height - right.height;

        if (balance > 1) {
            // Left-heavy: ya to LL case hai ya LR case
            if (left.left.height < left.right.height) {
                left.rotateLeft(); // LR ko pehle LL mein convert karo
            }
            rotateRight(); // ab seedha LL case hai, fix karo
        } else if (balance < -1) {
            // Right-heavy: ya to RR case hai ya RL case
            if (right.right.height < right.left.height) {
                right.rotateRight(); // RL ko pehle RR mein convert karo
            }
            rotateLeft(); // ab seedha RR case hai, fix karo
        }
    }

    // 'this' ka left child naya "virtual root" ban jata hai, lekin object identity same rehti hai
    private void rotateRight() {
        AVLTree pivot = left;                                  // pivot = jo upar aana chahiye
        left = pivot.left;                                     // apna naya left = pivot ka left
        right = new AVLTree(key, pivot.right, right);          // purana content neeche chala gaya
        key = pivot.key;                                       // apna key ab pivot ka key ban gaya
    }

    // rotateRight ka mirror-image
    private void rotateLeft() {
        AVLTree pivot = right;
        right = pivot.right;
        left = new AVLTree(key, left, pivot.left);
        key = pivot.key;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();

        // Preorder traversal (Root, Left, Right)
        sb.append(key);
        if (left != NIL) {
            sb.append(" "+left.toString());
        }
        if (right != NIL) {
            sb.append(" "+right.toString());
        }
        // ------------------------------------------------------

        // for Inorder traversal (Left, Root, Right)
        // if (left != NIL) {
        //     sb.append(left.toString());
        // }
        // sb.append(key + " ");
        // if (right != NIL) {
        //     sb.append(right.toString());
        // }
        // ------------------------------------------------------

        // for Postorder traversal (Left, Right, Root)
        // if (left != NIL) {
        //      sb.append(left.toString());
        // }
        // if (right != NIL) {
        //      sb.append(right.toString());
        // }
        // sb.append(key + " ");

        return sb + "";
    }

    public static void main(String[] args) {
    // Root node banaya
    AVLTree tree = new AVLTree(50);

    // Random values add ki
    tree.add(30);
    tree.add(70);
    tree.add(20);
    tree.add(40);
    tree.add(60);
    tree.add(80);

    System.out.println("Size of tree: " + tree.size());
    System.out.println("Tree elements (Preorder): " + tree.toString());
    System.out.println("Height after random inserts: " + tree.getHeight());

    // ---- Real test: AVL ka asal fayda tab dikhta hai jab SORTED order mein insert karo ----
    // Normal BST mein ye ek seedhi line (linked list) ban jata, height = 14
    // AVL mein height hamesha O(log n) rehni chahiye
    AVLTree sortedTest = new AVLTree(1);
    for (int i = 2; i <= 15; i++) {
        sortedTest.add(i);
    }
    System.out.println("\nSorted insert test (1 to 15, worst case for normal BST):");
    System.out.println("Size: " + sortedTest.size());
    System.out.println("Height: " + sortedTest.getHeight() + " (agar ye ~3-4 hai, to AVL kaam kar raha hai; agar 14 hota, to fail)");
    }
}