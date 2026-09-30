class ImageNode{
    String data;
    ImageNode next;

    ImageNode(String data){
        this.data = data;
        this.next = null;
    }
}



public class Prac2 {
    public static void main(String[] args) {
        

    ImageNode names = new ImageNode("Book 1");
    ImageNode p = names;
    p.next = new ImageNode("snapchat.png");
    p = p.next;
    p.next = new ImageNode("instagram.jpg");
    p = p.next;
    p.next = new ImageNode("whatsapp.png");
    p=p.next;
    p.next = new ImageNode("img4.jpg");
    p = p.next;
    p.next = new ImageNode("img7.png");

    ImageNode sizes = new ImageNode("Author 1");
    ImageNode q = sizes;
    q.next = new ImageNode("7gb");
    q = q.next;
    q.next = new ImageNode("8kb");
    q = q.next;
    q.next = new ImageNode("3mb");
    q =q.next;
    q.next = new ImageNode("9gb");
    q=q.next;
    q.next = new ImageNode("6gb");


    p = names; 
    q = sizes;

    while (p != null &&  q != null) {
        System.out.println(p.data + " by " + q.data);

        p=p.next;
        q=q.next;
    }
    
}
}
