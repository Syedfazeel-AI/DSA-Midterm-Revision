class Employee{
    String emp_id;
    String name;
    String dept;
    String salary;

    Employee(String emp_id, String name, String dept, String salary){
        this.emp_id = emp_id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }
}


public class Prac3 {
    public static void main(String[] args) {
        Employee[] emp = new Employee[5];
        emp[0] = new Employee("e1005", "Fazeel", "Sales", "1000000");
        emp[1] = new Employee("e1007", "Latif", "Finance", "250000");
        emp[2] = new Employee("e1012", "Aman", "Devp", "350000");
        emp[3] = new Employee("e1013", "Mir", "Sales", "190000");
        emp[4] = new Employee("e1014", "Saad", "Devp", "1500000");

        String x = "e1014";
        String result = "Not Found";
        for(int i = 0; i < emp.length ; i++){
            if (emp[i].emp_id.equals(x)){
                result = "Found " + emp[i].emp_id;
                System.out.println(emp[i]);
            }
        
        }
        System.out.println(result);

    }
}
