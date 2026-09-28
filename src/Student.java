public class Student {

    private int id;
    private String name;
    private int age;
    private String department;
    private String email;

    public Student(int id, String name, int age,
                   String department, String email) {

        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void displayStudent() {

        System.out.println("Student ID : " + id);
        System.out.println("Name       : " + name);
        System.out.println("Age        : " + age);
        System.out.println("Department : " + department);
        System.out.println("Email      : " + email);
        System.out.println("---------------------------");
    }
}