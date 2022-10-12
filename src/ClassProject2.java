import java.util.Scanner;

class Student {
    public float points;
    private String school;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}

public class ClassProject2 {
    static Scanner kb = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter number of students:");
        int NumOfStudents = kb.nextInt();
        Student[] students = new Student[NumOfStudents];
        float[][] matrix = new float[NumOfStudents][5];
        float currMax = -400;
        Student currWinner = new Student();

        for (int i = 0; i < students.length; i++) {
            kb.nextLine();
            students[i] = new Student();
            System.out.println("Enter student #" + i + " name:");
            students[i].setName(kb.nextLine());
            System.out.println("Enter " + students[i].getName() + "'s school:");
            students[i].setSchool(kb.nextLine());

            for (int j = 0; j < matrix[0].length; j++) {
                System.out.println("Enter " + students[i].getName()
                        + "'s points for task #" + j + ":");
                matrix[i][j] = 400;
                while (matrix[i][j] > 10 || matrix[i][j] < 0) {
                    matrix[i][j] = kb.nextFloat();
                }
                students[i].points += matrix[i][j];
            }

            if (students[i].points > currMax) {
                currWinner = students[i];
                currMax = students[i].points;
            }
        }
        System.out.println("The winner is " + currWinner.getName() +
                " from " + currWinner.getSchool() + " with " + currWinner.points + " points");
    }

}