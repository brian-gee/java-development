package com.brian;

public class StudentScores {
    private Console c = new Console();

    public void calc() {
        System.out.println("The Student Scores application\n");
        int numOfStudents= c.getInt("Number of students: ", 1, 500);
        getScores(numOfStudents);
    }

    private void getScores(int n){
        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            students[i] = new Student();
            System.out.println("\nSTUDENT " + (i+1));
            students[i].setLastName(c.getString("Last name: "));
            students[i].setFirstName(c.getString("First name: "));
            students[i].setScore(c.getInt("Score: ", 0, 100));
        }

        System.out.println("\nSUMMARY");
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i].getLastName() +
                    ", " + students[i].getFirstName() +
                    ": " + students[i].getScore());
        }
    }
}