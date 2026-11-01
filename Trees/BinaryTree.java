package Trees;

public class BinaryTree {
    Object Root;
    BinaryTree left;
    BinaryTree right;

    BinaryTree(Object Root) {
        this.Root = Root;
    }
    BinaryTree(Object Root, BinaryTree left, BinaryTree right) {
        this.Root = Root;
        this.left = left;
        this.right = right;
    }

    Object getRoot() {
        return Root;
    }
    BinaryTree getLeft() {
        return left;
    }
    BinaryTree getRight() {
        return right;
    }

    Object setRoot(Object Root) {
        this.Root = Root;
        return Root;
    }
    Object setLeft(BinaryTree left) {
        this.left = left;
        return left;
    }
    Object setRight(BinaryTree right) {
        this.right = right;
        return right;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        
        // Preorder traversal (Root, Left, Right)
        // sb.append(Root);
        // if (left != null) {
        //     sb.append(" "+left.toString());
        // }
        // if (right != null) {
        //     sb.append(" "+right.toString());
        // }
        
        // for Inorder traversal (Left, Root, Right)
        // if (left != null) {
        //     sb.append(left.toString()); 
        // }
        // sb.append(Root + " ");          
        // if (right != null) {
        //     sb.append(right.toString()); 
        // }
        
        // for Postorder traversal (Left, Right, Root)
        if (left != null) {
            sb.append(left.toString()); 
        }
        if (right != null) {
            sb.append(right.toString());
        }
        sb.append(Root + " ");

        return sb + "";  
    }

    int size() {
        if(left == null && right == null){
            return 1;
        }
        if (left == null) {
            return 1 + right.size();
        }
        if (right == null) {
            return 1 + left.size();
        }
        return 1 + left.size() + right.size();
    }

    int height() {
        if(Root == null){
            return -1;
        }
        int leftst = 0;
        int rightst = 0;
        if (left != null) {
            leftst = 1 + left.height();
        }
        if (right != null) {
            rightst = 1 + right.height();
        }
        return leftst > rightst ? leftst : rightst;
    }

    public boolean search(Object val){
        if (Root == val){
            return true;
        }
        if (left != null){
            if (left.search(val)){
                return true;
            }
        }
        if (right != null){
            if (right.search(val)){
                return true;
            }
        }
        return false;
    }

    public boolean equals(BinaryTree other) {
        if (other == null) {
            return false;
        }
        if (this.size() != other.size()) {
            return false;
        }
        if (this.height() != other.height()) {
            return false;
        }
        if (this.Root != other.Root) {
            return false;
        }
        if (this.left != null && other.left != null){
            if (this.left.equals(other.left) == false){
                return false;
            }
        }
        if (this.right != null && other.right != null){
            if (this.right.equals(other.right) == false){
                return false;
            }
        }
        return true;
    }

    int countLeaves() {
        if (left == null && right == null) {
            return 1;
        }
        int leftLeaves = 0;
        int rightLeaves = 0;
        if (left != null) {
            leftLeaves = left.countLeaves();
        }
        if (right != null) {
            rightLeaves = right.countLeaves();
        }
        return leftLeaves + rightLeaves;
    }

    void printlevel(int targetLevel){
        if (targetLevel == 0) {
            System.out.print(Root + " ");
        } else {
            if (left != null) {
                left.printlevel(targetLevel - 1);
            }
            if (right != null) {
                right.printlevel(targetLevel - 1);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree A = new BinaryTree("A" , new BinaryTree("B", new BinaryTree("D"), new BinaryTree("E")), new BinaryTree("C", new BinaryTree("F"), new BinaryTree("G")));
        // BinaryTree A = new BinaryTree("A" , B , C);
        // BinaryTree B = new BinaryTree("B" , D , E);
        // BinaryTree C = new BinaryTree("C" , F , G);
        // BinaryTree D = new BinaryTree("D");
        // BinaryTree E = new BinaryTree("E");
        // BinaryTree F = new BinaryTree("F");
        // BinaryTree G = new BinaryTree("G");
        // System.out.println(A.toString());
        // System.out.println("Size of the tree: " + A.size());
        // System.out.println("Height of the tree: " + A.height());
        // System.out.println("Search for 'D': " + A.search("D"));
        // System.out.println("Search for 'H': " + A.search("H"));

        BinaryTree B = new BinaryTree("A" , new BinaryTree("B", new BinaryTree("D"), new BinaryTree("E")), new BinaryTree("C"));
        BinaryTree C = new BinaryTree("A" , new BinaryTree("B", new BinaryTree("X"), new BinaryTree("E")), new BinaryTree("C", new BinaryTree("F"), new BinaryTree("G")));

        System.out.println("\n--- EQUALS TEST ---");
        System.out.println("A equals B? " + A.equals(B)); 
        System.out.println("A equals C? " + A.equals(C));

        // ----------------------------------------
        System.out.println("Leaves in A: " + A.countLeaves());
        System.out.println("Leaves in B: " + B.countLeaves());
        System.out.println("Leaves in C: " + C.countLeaves());
        System.out.print("Nodes at level 2 in A: ");
        A.printlevel(2);
        System.out.println();

        // ----------------------------------------

        // int h = A.height();
        // System.out.print("Level Order Traversal: ");
        // for (int i = 0; i <= h; i++) {
        //     A.printlevel(i);
        // }
    }
        
}
