import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentService service = new StudentService();
        FileHandler file = new FileHandler();

        service.setStudents(file.loadStudents());

        int choice = 0;

        do {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Please enter a valid number!");
                sc.nextLine();
                continue;
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Student Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Department: ");
                    String department = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    if (id <= 0 || age <= 0 ||
                            name.isBlank() ||
                            department.isBlank() ||
                            email.isBlank() ||
                            name.contains(",") ||
                            department.contains(",") ||
                            email.contains(",")) {

                        System.out.println("Invalid student details!");
                        break;
                    }

                    Student student = new Student(
                            id, name, age, department, email
                    );

                    service.addStudent(student);

                    file.saveStudents(service.getStudents());

                    break;

                case 2:

                    service.viewStudents();
                    break;

                case 3:

                    System.out.print("Enter Student ID: ");
                    int searchId = sc.nextInt();
                    sc.nextLine();

                    service.searchStudent(searchId);

                    break;

                case 4:

                    System.out.print("Enter Student ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter New Age: ");
                    int newAge = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Department: ");
                    String newDepartment = sc.nextLine();

                    System.out.print("Enter New Email: ");
                    String newEmail = sc.nextLine();

                    if (newAge <= 0 ||
                            newName.isBlank() ||
                            newDepartment.isBlank() ||
                            newEmail.isBlank() ||
                            newName.contains(",") ||
                            newDepartment.contains(",") ||
                            newEmail.contains(",")) {

                        System.out.println("Invalid student details!");
                        break;
                    }

                    service.updateStudent(
                            updateId,
                            newName,
                            newAge,
                            newDepartment,
                            newEmail
                    );

                    file.saveStudents(service.getStudents());

                    break;

                case 5:

                    System.out.print("Enter Student ID to delete: ");
                    int deleteId = sc.nextInt();
                    sc.nextLine();

                    service.deleteStudent(deleteId);

                    file.saveStudents(service.getStudents());

                    break;

                case 6:

                    System.out.println("Thank you!");
                    break;

                default:

                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}