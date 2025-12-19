import java.util.Scanner;
import java.util.ArrayList;;

public class Result {
    static int numOfStudent;

    public static char gradecal(float percentage) {

        if (percentage > 80 && percentage <= 100) {
            return 'A';
        } else if (percentage > 70 && percentage <= 80) {
            return 'B';

        } else if (percentage > 60 && percentage <= 70) {
            return 'C';
        } else if (percentage > 50 && percentage <= 60) {
            return 'D';
        } else if (percentage > 40 && percentage <= 50) {
            return 'E';
        } else {
            return 'F';
        }

    }

    public static float sgpacal(float percentage) {
        return percentage / 10;
    }

    public static void printMenu() {

        System.out.println(
                ".......................... Welcome to student Management portal ...............................");
        System.out.println(" 1. Add student");
        System.out.println(" 2. Delete student");
        System.out.println(" 3. Update student");
        System.out.println(" 4. Dispaly all student");
        System.out.println(" 5. Search student detail");
        System.out.println(" 6. Check Exam Result");
        System.out.println(" 7. Clear database");
        System.out.println(" 8. Exit");
    }

    public static void addStudent(ArrayList<String> studentName, ArrayList<String> fatherName,
            ArrayList<String> dob,
            ArrayList<Integer> admissionYear, ArrayList<String> branch, ArrayList<Integer> semester,
            ArrayList<Float> gainedMarks, ArrayList<Float> percentage, ArrayList<Float> sgpa,
            ArrayList<Character> grade) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        studentName.add(name);
        System.out.print("Enter Father name: ");
        name = sc.nextLine();
        fatherName.add(name);
        System.out.print("Enter d/o/b: ");
        String d = sc.nextLine();
        dob.add(d);
        System.out.print("Enter branch: ");
        String b = sc.nextLine();
        branch.add(b);
        System.out.print("Enter Admission year: ");
        admissionYear.add(sc.nextInt());

        System.out.print("Enter semester: ");
        semester.add(sc.nextInt());

        float[] submarks = new float[5];
        float totalMarks = 0;
        System.out.println("Add subject marks...");
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter subject[" + i + "] marks: ");
            submarks[i] = sc.nextFloat();
            totalMarks += submarks[i];
        }
        gainedMarks.add(totalMarks);
        float p = (totalMarks * 100) / 500;
        percentage.add(p);
        grade.add(gradecal(p));
        sgpa.add(sgpacal(p));
        numOfStudent = numOfStudent + 1;
        System.out.println("Student Registered successfully.");
        System.out.println("Total student registered: " + numOfStudent);

    }

    public static void deleteStudent(ArrayList<String> studentName, ArrayList<String> fatherName,
            ArrayList<String> dob,
            ArrayList<Integer> admissionYear, ArrayList<String> branch, ArrayList<Integer> semester,
            ArrayList<Float> gainedMarks, ArrayList<Float> percentage, ArrayList<Float> sgpa,
            ArrayList<Character> grade, int roll) {

        studentName.remove(roll - 1);
        String name = studentName.get(roll - 1);
        fatherName.remove(roll - 1);
        dob.remove(roll - 1);
        admissionYear.remove(roll - 1);
        branch.remove(roll - 1);
        semester.remove(roll - 1);
        grade.remove(roll - 1);
        sgpa.remove(roll - 1);
        numOfStudent = numOfStudent - 1;

        System.out.println("Roll number " + roll + "Name: " + name + "deleted successfully.");
        System.out.println("Total remaining registered student: " + numOfStudent);

    }

    public static void main() {
        ArrayList<String> studentName = new ArrayList<String>();
        ArrayList<String> fatherName = new ArrayList<String>();
        ArrayList<String> dob = new ArrayList<String>();
        ArrayList<Integer> admissionYear = new ArrayList<Integer>();
        ArrayList<String> branch = new ArrayList<String>();
        ArrayList<Integer> semester = new ArrayList<Integer>();
        ArrayList<Float> gainedMarks = new ArrayList<Float>();
        ArrayList<Float> percentage = new ArrayList<Float>();
        ArrayList<Float> sgpa = new ArrayList<Float>();
        ArrayList<Character> grade = new ArrayList<Character>();
        numOfStudent = 0;

        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            printMenu();
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent(studentName, fatherName, dob, admissionYear, branch, semester, gainedMarks,
                            percentage, sgpa, grade);
                    break;
                case 2:
                    System.out.print("Enter student roll no: ");
                    int roll = sc.nextInt();
                    if (roll <= numOfStudent && roll > 0) {
                        deleteStudent(studentName, fatherName, dob, admissionYear, branch, semester, gainedMarks,
                                percentage, sgpa, grade, roll);
                    }
                    break;
                case 3:

                    System.out.print("Enter student roll no: ");
                    int rollnum = sc.nextInt();
                    if (rollnum <= numOfStudent && rollnum > 0) {
                        System.out.println("What you want to update...");
                        System.out.println(" 1. Name");
                        System.out.println(" 2. Father name");
                        System.out.println(" 3. DOB");
                        System.out.println(" 4. Admission year");
                        System.out.println(" 5. Branch");
                        System.out.println(" 6. Semester");
                        System.out.println(" 7. Exit");
                        System.out.print("Enter choice: ");
                        int ch = sc.nextInt();

                        switch (ch) {
                            case 1:
                                System.out.print("Enter new name: ");
                                sc.nextLine();
                                String t1 = sc.nextLine();
                                studentName.set(rollnum - 1, t1);
                                System.out.println("Details updated Successfully.");
                                break;
                            case 2:
                                System.out.print("Enter new father name: ");
                                sc.nextLine();
                                String t2 = sc.nextLine();
                                fatherName.set(rollnum - 1, t2);
                                System.out.println("Details updated Successfully.");

                                break;
                            case 3:
                                System.out.print("Enter new dob: ");
                                sc.nextLine();
                                String t3 = sc.nextLine();
                                dob.set(rollnum - 1, t3);
                                System.out.println("Details updated Successfully.");

                                break;
                            case 4:
                                System.out.print("Enter new admission year: ");
                                sc.nextLine();
                                int year = sc.nextInt();
                                admissionYear.set(rollnum - 1, year);
                                System.out.println("Details updated Successfully.");

                                break;
                            case 5:
                                System.out.print("Enter new branch: ");
                                sc.nextLine();

                                String b = sc.nextLine();
                                branch.set(rollnum - 1, b);
                                System.out.println("Details updated Successfully.");

                                break;
                            case 6:
                                System.out.print("Enter new semester: ");
                                sc.nextLine();

                                int sem = sc.nextInt();
                                semester.set(rollnum - 1, sem);
                                System.out.println("Details updated Successfully.");

                                break;
                            case 7:
                                System.out.println("exit");
                                break;
                            default:
                                System.out.println("Invalid choice ! Kindly try again.");
                                System.out.println();
                                break;
                        }

                    } else {
                        System.out.println("Invalid roll number ! try again.");
                        System.out.println();

                    }

                    break;
                case 4:
                    for (int i = 0; i < numOfStudent; i++) {

                        System.out.println("===========================================================");
                        System.out.println();
                        System.out.println(" Name: " + studentName.get(i));
                        System.out.println(" Father name: " + fatherName.get(i));
                        System.out.println(" D/O/B: " + dob.get(i));

                        System.out.println(" Admission year: " + admissionYear.get(i));
                        System.out.println(" Branch: " + branch.get(i));
                        System.out.println(" Semester: " + semester.get(i));

                        System.out.println();
                        System.out.println("===========================================================");

                    }

                    break;
                case 5:
                    System.out.println("This feature is on progress...");

                    break;
                case 6:
                    System.out.println("------------------------Exam Result------------------------------");
                    System.out.print("Enter roll number: ");
                    int rnum = sc.nextInt();
                    if (rnum <= numOfStudent && rnum > 0) {
                        System.out.println();
                        System.out.println("==========================  Year: " + admissionYear.get(rnum - 1)
                                + "  =================================");
                        System.out.println();
                        System.out.println(" Name: " + studentName.get(rnum - 1));
                        System.out.println(" Father name: " + fatherName.get(rnum - 1));
                        System.out.println(" D/O/B: " + dob.get(rnum - 1));

                        System.out.println(" Branch: " + branch.get(rnum - 1));
                        System.out.println(" Semester: " + semester.get(rnum - 1));
                        System.out.println(" Total marks: " + gainedMarks.get(rnum - 1));
                        System.out.println(" Percentage marks: " + percentage.get(rnum - 1));
                        System.out.println(" Grade: " + grade.get(rnum - 1));

                        System.out.println(" SGPA: " + sgpa.get(rnum - 1));
                        System.out.println();
                        System.out.println("===========================================================");
                    }

                    break;
                case 7:
                    System.out.println("All data deleted.");
                    studentName.clear();
                    fatherName.clear();
                    dob.clear();
                    admissionYear.clear();
                    branch.clear();
                    gainedMarks.clear();
                    percentage.clear();
                    grade.clear();
                    sgpa.clear();

                    break;
                case 8:
                    System.out.println("exit");

                    break;
                default:
                    System.out.println("Invalid choice ! Kindly try again.");
                    System.out.println();
                    break;
            }
        } while (choice != 7);

    }
}
