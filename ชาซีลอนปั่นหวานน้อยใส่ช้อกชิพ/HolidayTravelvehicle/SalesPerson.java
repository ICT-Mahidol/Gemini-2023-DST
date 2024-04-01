public class SalesPerson {
    private String emp_id;
    private String emp_name;
    private int emp_age;
    private String emp_phone_number;
    

    public SalesPerson(String emp_id, String emp_name, int emp_age, String emp_phone_number) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_age = emp_age;
        this.emp_phone_number = emp_phone_number;
    }

    // Getters and setters
    public String getId() {
        return emp_id;
    }
    public void setId(String id) {
        this.emp_id = id;
    }

    public String getName() {
        return emp_name;
    }
    public void setName(String name) {
        this.emp_name = name;
    }

    public int getAge() {
        return emp_age;
    }
    public void setAge(int age) {
        this.emp_age = age;
    }

    public String getPhonenumber() {
        return emp_phone_number;
    }
    public void setAge(String phone_number ) {
        this.emp_phone_number = phone_number ;
    }

    // Additional methods

    // คำนวณอายุเฉลี่ยของ sale person  ทั้งหมด
    public double calculateAverageAge(SalesPerson[] employees) {
        int totalAge = 0;
        for (SalesPerson employee : employees) {
            totalAge += employee.getAge();
        }
        return (double) totalAge / employees.length;
    }
    // แสดงข้้อมูล sale person 
    public void printSalePersonDetails() {
        System.out.println("Employee ID: " + emp_id);
        System.out.println("Employee Name: " + emp_name);
        System.out.println("Employee Age: " + emp_age);
        System.out.println("Employee Phone number: " + emp_phone_number);
    }
       
}
