// Stores page numbers where a word appears.
// Uses a growable int[] array — no built-in ArrayList used.
public class PageList {

    private int[] pages;
    private int size;

    public PageList() {
        pages = new int[4]; // start small, grows when needed
        size = 0;
    }

    public int size() {
        return size;
    }

    // Adds a page number to the list.
    // Book is read top-to-bottom, so pages always arrive in increasing order.
    // We only check the LAST element for duplicates — no need to scan the whole array.
    public void addPage(int page) {
        if (size > 0 && pages[size - 1] == page) {
            return; // same page already added, skip
        }

        if (size == pages.length) {
            resize();
        }

        pages[size] = page;
        size++;
    }

    // Doubles the array size when it gets full.
    private void resize() {
        int[] bigger = new int[2 * pages.length];
        System.arraycopy(pages, 0, bigger, 0, size);
        pages = bigger;
    }

    // Returns true if any page in this list falls inside [startPage, endPage].
    // Uses binary search — O(log k) where k = number of pages stored.
    public boolean existsInRange(int startPage, int endPage) {
        int lo = 0, hi = size - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (pages[mid] < startPage) {
                lo = mid + 1;       // target range is to the right
            } else if (pages[mid] > endPage) {
                hi = mid - 1;       // target range is to the left
            } else {
                return true;        // pages[mid] is inside [startPage, endPage]
            }
        }

        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(pages[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    // Self-test
    public static void main(String[] args) {
        PageList pl = new PageList();

        pl.addPage(2);
        pl.addPage(2);   // duplicate — should be ignored
        pl.addPage(5);
        pl.addPage(9);
        pl.addPage(9);   // duplicate 
        pl.addPage(14);
        pl.addPage(20);

        System.out.println("Pages: " + pl);         
        System.out.println("Size:  " + pl.size());  

        System.out.println("\nRange tests:");
        System.out.println("In [1,3]?   " + pl.existsInRange(1, 3));    // (2 is inside)
        System.out.println("In [6,8]?   " + pl.existsInRange(6, 8));    // (no page here)
        System.out.println("In [10,13]? " + pl.existsInRange(10, 13));  // (gap between 9 and 14)
        System.out.println("In [14,14]? " + pl.existsInRange(14, 14));  // (exact match)
        System.out.println("In [21,30]? " + pl.existsInRange(21, 30));  // (out of range)
        System.out.println("In [0,100]? " + pl.existsInRange(0, 100));  // (covers everything)
    }
}