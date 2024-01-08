import java.util.*;

public class SchoolInformationSystem {
    private Map<String, Student> students = new TreeMap<>();
    private Map<String, Teacher> teachers = new TreeMap<>();
    private Map<String, Course> courses = new TreeMap<>();
    private Scanner scanner;

     public SchoolInformationSystem() {
        this.scanner = new Scanner(System.in);
    }

     public static void main(String[] args) {
        SchoolInformationSystem system = new SchoolInformationSystem();
        system.run();
    }
  private void printBanner() {
        System.out.println("          _____                    _____                    _____          \n" +
                          "         /\\    \\                  /\\    \\                  /\\    \\         \n" +
                          "        /::\\    \\                /::\\    \\                /::\\    \\        \n" +
                          "       /::::\\    \\               \\:::\\    \\              /::::\\    \\       \n" +
                          "      /::::::\\    \\               \\:::\\    \\            /::::::\\    \\      \n" +
                          "     /:::/\\:::\\    \\               \\:::\\    \\          /:::/\\:::\\    \\     \n" +
                          "    /:::/__\\:::\\    \\               \\:::\\    \\        /:::/__\\:::\\    \\    \n" +
                          "    \\:::\\   \\:::\\    \\              /::::\\    \\       \\:::\\   \\:::\\    \\   \n" +
                          "  ___\\:::\\   \\:::\\    \\    ____    /::::::\\    \\    ___\\:::\\   \\:::\\    \\  \n" +
                          " /\\   \\:::\\   \\:::\\    \\  /\\   \\  /:::/\\:::\\    \\  /\\   \\:::\\   \\:::\\    \\ \n" +
                          "/::\\   \\:::\\   \\:::\\____\\/::\\   \\/:::/  \\:::\\____\\/::\\   \\:::\\   \\:::\\____\\\n" +
                          "\\:::\\   \\:::\\   \\::/    /\\:::\\  /:::/    \\::/    /\\:::\\   \\:::\\   \\::/    /\n" +
                          " \\:::\\   \\:::\\   \\/____/  \\:::\\/:::/    / \\/____/  \\:::\\   \\:::\\   \\/____/ \n" +
                          "  \\:::\\   \\:::\\    \\       \\::::::/    /            \\:::\\   \\:::\\    \\     \n" +
                          "   \\:::\\   \\:::\\____\\       \\::::/____/              \\:::\\   \\:::\\____\\    \n" +
                          "    \\:::\\  /:::/    /        \\:::\\    \\               \\:::\\  /:::/    /    \n" +
                          "     \\:::\\/:::/    /          \\:::\\    \\               \\:::\\/:::/    /     \n" +
                          "      \\::::::/    /            \\:::\\    \\               \\::::::/    /      \n" +
                          "       \\::::/    /              \\:::\\____\\               \\::::/    /       \n" +
                          "        \\::/    /                \\::/    /                \\::/    /        \n" +
                          "         \\/____/                  \\/____/                  \\/____/         \n" +
                          "                                                                           ");
    }
    
     public void run() {
        int choice;

        do {
            printBanner();
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("                       School Information System"                         );
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("1. Add Student");
            System.out.println("2. Add Teacher");
            System.out.println("3. Add Course");
            System.out.println("4. Edit Information");
            System.out.println("5. Display All Information");
            System.out.println("6. Exit");
            System.out.println("Enter your choice: ");
            System.out.println("-------------------------------------------------------------------------");

            try {
                choice = scanner.nextInt();

                switch (choice) {
                case 1:
                        addStudent();
                        break;
                    case 2:
                        addTeacher();
                        break;
                    case 3:
                        addCourse();
                        break;
                    case 4:
                        editInformation();
                        break;
                    case 5:
                        displayAllInformation();
                        break;
                    case 6:
                        System.out.println("Exiting the system...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); 
                choice = 0; 
            }
        } while (choice != 6);

        scanner.close();
    }

    private void addStudent() {
        try {
            System.out.println("-------------------------------------------------------------------------");
            System.out.print("Enter Student Name: ");
            String name = scanner.next();
            System.out.print("Enter Student Roll No: ");
            String rollNo = scanner.next();
            System.out.print("Enter Student Class Name: ");
            String className = scanner.next();
            System.out.println("-------------------------------------------------------------------------");
            if (students.containsKey(rollNo)) {
                System.out.println("Student with the same roll number already exists. Please use a unique roll number.");
            } else {
                Student student = new Student(name, rollNo, className);
                students.put(rollNo, student);
                System.out.println("Student added successfully.");
               
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid information.");
            scanner.next();
        }
    }

    private void addTeacher() {
        try {
            System.out.println("-------------------------------------------------------------------------");
            System.out.print("Enter Teacher Name: ");
            String name = scanner.next()+scanner.next();
            System.out.print("Enter Teacher Subject: ");
            String subject = scanner.next();
            System.out.println("-------------------------------------------------------------------------");
            if (teachers.containsKey(name)) {
                System.out.println("Teacher with the same name already exists. Please use a unique name.");
            } else {
                Teacher teacher = new Teacher(name, subject);
                teachers.put(name, teacher);
                System.out.println("Teacher added successfully.");
                
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid information.");
            scanner.next();
        }
    }

    private void addCourse() {
        try {
            System.out.println("-------------------------------------------------------------------------");
            System.out.print("Enter Course Name: ");
            String name = scanner.next();
            System.out.print("Enter Course Code: ");
            String courseCode = scanner.next();
             System.out.println("-------------------------------------------------------------------------");
            if (courses.containsKey(courseCode)) {
                System.out.println("Course with the same code already exists. Please use a unique code.");
            } else {
                Course course = new Course(name, courseCode);
                courses.put(courseCode, course);
                System.out.println("Course added successfully.");
                
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid information.");
            scanner.next(); 
        }
    }

  private void editInformation() {
    System.out.println("-------------------------------------------------------------------------");
    System.out.println("Select an option to edit:");
    System.out.println("1. Edit Student");
    System.out.println("2. Edit Teacher");
    System.out.println("3. Edit Course");
    System.out.println("4. Edit Student Roll No");
    System.out.print("Enter your choice: ");
    System.out.println("-------------------------------------------------------------------------");

    try {
        int editChoice = scanner.nextInt();

        switch (editChoice) {
            case 1:
                editStudent();
                break;
            case 2:
                editTeacher();
                break;
            case 3:
                editCourse();
                break;
            case 4:
                editStudentRollNo();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    } catch (InputMismatchException e) {
        System.out.println("Invalid input. Please enter a valid number.");
        scanner.next();
    }
}


    private void editStudent() {
        System.out.println("-------------------------------------------------------------------------");
        System.out.print("Enter Student Roll No to edit: ");
        String rollNo = scanner.next();
        System.out.println("-------------------------------------------------------------------------");
        if (students.containsKey(rollNo)) {
            System.out.println("Select an option to edit:");
            System.out.println("1. Edit Name");
            System.out.println("2. Edit Class Name");
            System.out.print("Enter your choice: ");

            try {
                int editChoice = scanner.nextInt();

                switch (editChoice) {
                    case 1:
                        System.out.print("Enter new name: ");
                        String newName = scanner.next();
                        students.get(rollNo).setName(newName);
                        System.out.println("Student name updated successfully.");
                        System.out.println("-------------------------------------------------------------------------");
                        break;
                    case 2:
                        System.out.print("Enter new class name: ");
                        String newClassName = scanner.next();
                        students.get(rollNo).setClassName(newClassName);
                        System.out.println("Student class name updated successfully.");
                        System.out.println("-------------------------------------------------------------------------");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();  // Consume the invalid input to avoid an infinite loop
            }
        } else {
            System.out.println("Student with the provided roll number not found.");
            System.out.println("-------------------------------------------------------------------------");
        }
    }

    private void editTeacher() {
        System.out.println("-------------------------------------------------------------------------");
        System.out.print("Enter Teacher Name to edit: ");
        String name = scanner.next();
        System.out.println("-------------------------------------------------------------------------");
        if (teachers.containsKey(name)) {
            System.out.println("Select an option to edit:");
            System.out.println("1. Edit Subject");
            System.out.print("Enter your choice: ");
           

            try {
                int editChoice = scanner.nextInt();

                switch (editChoice) {
                    case 1:
                        System.out.print("Enter new subject: ");
                        String newSubject = scanner.next();
                        teachers.get(name).setSubject(newSubject);
                        System.out.println("-------------------------------------------------------------------------");
                        System.out.println("Teacher subject updated successfully.");
                       
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); 
            }
        } else {
            System.out.println("Teacher with the provided name not found.");
        }
    }

    private void editCourse() {
        System.out.println("-------------------------------------------------------------------------");
        System.out.print("Enter Course Code to edit: ");
        String courseCode = scanner.next();
        System.out.println("-------------------------------------------------------------------------");
        if (courses.containsKey(courseCode)) {
            System.out.println("Select an option to edit:");
            System.out.println("1. Edit Name");
            System.out.print("Enter your choice: ");

            try {
                int editChoice = scanner.nextInt();

                switch (editChoice) {
                    case 1:
                        System.out.print("Enter new name: ");
                        String newName = scanner.next();
                        courses.get(courseCode).setName(newName);
                        System.out.println("-------------------------------------------------------------------------");
                        System.out.println("Course name updated successfully.");
                        
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();  // Consume the invalid input to avoid an infinite loop
            }
        } else {
            System.out.println("Course with the provided code not found.");
        }
    }
 private void editStudentRollNo() {
    System.out.println("-------------------------------------------------------------------------");
    System.out.print("Enter current Student Roll No to edit: ");
    String currentRollNo = scanner.next();
    System.out.println("-------------------------------------------------------------------------");

    if (students.containsKey(currentRollNo)) {
        System.out.print("Enter new Roll No: ");
        String newRollNo = scanner.next();

        if (students.containsKey(newRollNo)) {
            System.out.println("Student with the new roll number already exists. Please use a unique roll number.");
        } else {
            Student student = students.get(currentRollNo);
            student.setRollNo(newRollNo);
            students.remove(currentRollNo);
            students.put(newRollNo, student);
            System.out.println("Student roll number updated successfully.");
        }
    } else {
        System.out.println("Student with the provided roll number not found.");
    }

    System.out.println("-------------------------------------------------------------------------");
}

    private void displayAllInformation() {
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("|                      Student Information Table                       |");
        System.out.println("-------------------------------------------------------------------------");
        System.out.printf("| %-15s | %-20s | %-15s |\n", "Roll No", "Name", "Class");
        System.out.println("|-----------------|----------------------|-----------------|");

        for (Map.Entry<String, Student> entry : students.entrySet()) {
            Student student = entry.getValue();
            System.out.printf("| %-15s | %-20s | %-15s |\n", student.getRollNo(), student.getName(), student.getClassName());
        }

        System.out.println("-------------------------------------------------------------------------");
        System.out.println("|                      Teacher Information Table                       |");
        System.out.println("-------------------------------------------------------------------------");
        System.out.printf("| %-20s | %-15s |\n", "Name", "Subject");
        System.out.println("|--------------------|-----------------|");

        for (Map.Entry<String, Teacher> entry : teachers.entrySet()) {
            Teacher teacher = entry.getValue();
            System.out.printf("| %-20s | %-15s |\n", teacher.getName(), teacher.getSubject());
        }

        System.out.println("-------------------------------------------------------------------------");
        System.out.println("|                      Course Information Table                        |");
        System.out.println("-------------------------------------------------------------------------");
        System.out.printf("| %-15s | %-20s |\n", "Code", "Name");
        System.out.println("|-----------------|----------------------|");

        for (Map.Entry<String, Course> entry : courses.entrySet()) {
            Course course = entry.getValue();
            System.out.printf("| %-15s | %-20s |\n", course.getCourseCode(), course.getName());
        }

        System.out.println("-------------------------------------------------------------------------");
    }
}