// Programmer: Johny Ramos Assuncao
// Studend ID: B00139596
// Date Completed: 16/03/2023
// Function: Assignment 01 - Software Development 02
// Note: System for teacher to input student's grade
// Code: Constructor, Total & Average methods and Display methods

import java.util.ArrayList;

public class studentProfile {
    private String studentFirst;
    private String studentLast;
    private ArrayList<Double> grade;

    public studentProfile(String first, String last) {
        this.studentFirst = first;
        this.studentLast = last;
        this.grade = new ArrayList<>();
    }
    public void addGrade(double grade) {
        this.grade.add(grade);
    }
    public ArrayList<Double> getGrade() {
        return grade;
    }
    public String getName() {
        return studentFirst +" " +studentLast;
    }
    public String getNameFirst() {
        return studentFirst;
    }
    public String getNameLast() {
        return studentLast;
    }

    //method to calc total grade value
    public double totalCalc() {
        double total= 0; 
        for(double g : grade) {
            total += g;
        }
        return total;
    }

    //method to calc average value
    public double average() {
        double average= 0; 
        for(double g : grade) {
            average += g;
        }
        return average/ grade.size();
    }

    //method to display the grade contents
    public void printAll() {

        for (int i = 0; i < grade.size(); i++) {
            System.out.printf("| %-30s | %30.2f |%n", getName(), getGrade().get(i));

        }
        System.out.println("-".repeat(67)); //print 67 dashes

    }
    
    //method to display the average grade
    public void printAverage() {

        for (int i = 0; i < grade.size(); i++) {
            System.out.printf("| %-30s | %30.2f |%n", getName(), getGrade().get(i));
        }
        System.out.println("-".repeat(67)); //print 67 dashes
        System.out.printf("| %-30s | %30s |%n", getName(),"FINAL VALUES");
        System.out.printf("| %-30s | %30.2f |%n", "Total",totalCalc());
        System.out.printf("| %-30s | %30.2f |%n", "Average",average());
        System.out.println("-".repeat(67)); //print 67 dashes
    }

    //method to display the student's grade
    public void printStudent(String searchName) { 

        //remove white spaces and add Uppercase for first letter
        searchName = searchName.substring(0,1).toUpperCase() + searchName.substring(1).toLowerCase();

        if(getNameLast().equalsIgnoreCase(searchName)){
            for(int i=0; i<grade.size(); i++) {
                System.out.printf("| %-30s | %30.2f |%n", getName(), getGrade().get(i));
            }
        }
        
        if(getNameLast().equalsIgnoreCase(searchName)){
            System.out.println("-".repeat(67)); //print 67 dashes
            System.out.printf("| %-30s | %30.2f |%n", "Total",totalCalc());
            System.out.println("-".repeat(67)); //print 67 dashes
            System.out.printf("| %-30s | %30.2f |%n", "Average",average());
        }
    }
}

