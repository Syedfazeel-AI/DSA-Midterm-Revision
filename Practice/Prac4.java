package Practice;

class AiProject{
    String proj_id;
    String title;
    int score;

    AiProject(String proj_id, String title, int score ){
        this.proj_id = proj_id;
        this.title = title;
        this.score = score;
    }
}




public class Prac4 {
    public static void main(String[] args) {
        AiProject[] ap = new AiProject[5];
        ap[0] = new AiProject("bsai005", "ABC", 10);
        ap[1] = new AiProject("bsai007", "DEF", 07);
        ap[2] = new AiProject("bsai008", "GHI", 06);
        ap[3] = new AiProject("bsai009", "JKL", 10);
        ap[4] = new AiProject("bsai012", "MNO", 9);

        String x = "bsai008";
        for(int i = 0; i<ap.length; i++){
            if(ap[i].proj_id.equals(x)){
                System.out.println("Project ID : " + ap[i].proj_id);
                System.out.println("Project Title : " + ap[i].title);
                System.out.println("Project Score : " + ap[i].score);
                break;
            }
        }
    }
}
