import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    String fileName = "students.txt";

    public void saveStudents(ArrayList<Student> students) {

        try {

            BufferedWriter writer =
                    new BufferedWriter(new FileWriter(fileName));

            for (Student student : students) {

                writer.write(
                        student.getId() + "," +
                                student.getName() + "," +
                                student.getAge() + "," +
                                student.getDepartment() + "," +
                                student.getEmail()
                );

                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            System.out.println("Error saving student records!");
        }
    }

    public ArrayList<Student> loadStudents() {

        ArrayList<Student> students = new ArrayList<>();

        try {

            File file = new File(fileName);

            if (!file.exists()) {
                return students;
            }

            BufferedReader reader =
                    new BufferedReader(new FileReader(file));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",", -1);

                if (data.length != 5) {
                    System.out.println("Invalid student record: " + line);
                    continue;
                }

                try {

                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    int age = Integer.parseInt(data[2]);
                    String department = data[3];
                    String email = data[4];

                    Student student = new Student(
                            id, name, age, department, email
                    );

                    students.add(student);

                } catch (NumberFormatException e) {
                    System.out.println("Invalid student record: " + line);
                }
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("Error loading student records!");
        }

        return students;
    }
}