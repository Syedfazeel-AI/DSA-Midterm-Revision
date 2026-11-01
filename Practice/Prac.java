package Practice;

class Student {
    String rollNo;
    String name;
    String dept_name;
    String contact_no;

    Student(String rollNo , String name , String dept_name , String contact_no){
        this.rollNo = rollNo;
        this.name = name;
        this.dept_name = dept_name;
        this.contact_no = contact_no;
    }

}

public class Prac {
    public static void main(String[] args) {

        
    Student[] arr = new Student[5];

    arr[0] = new Student("25BSAI005" , "Fazeel" , "SW" , "03183442882");
    arr[1] = new Student("25BSAI007","Latif","SW","2356897410");
    arr[2] = new Student("25BSAI013","Mir M","SW","0326598741");
    arr[3] = new Student("25BSAI053","Mubbi","SW","03216549870");
    arr[4] = new Student("25BSAI052","Izzi small","SW","3265987446");
    

    String x = "25BSAI051";
    String result = "Not Found";
    for (int i = 0; i<arr.length ; i++){
        if (arr[i].rollNo.equals(x)) {
            result ="Found " + arr[i].rollNo;
            break;
        }
    }
    System.out.println(result);
    
    }
}



