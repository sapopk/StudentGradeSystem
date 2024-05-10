// Programmer: Johny Ramos Assuncao
// Studend ID: B00139596
// Date Completed: 16/03/2023
// Function: Assignment 01 - Software Development 02
// Note: System for teacher to input student's grade
// Code: quickSort and display Lowest & highest methods

import java.util.ArrayList;

public class assignment01_SearchSort {

    //Method to identify Lowest Grade
    public void getLowestGrade(ArrayList<studentProfile> students) {
        double lowestGrade = Double.MAX_VALUE; //instance for lowest double grade
        studentProfile lowestGStudent = null; //instance for student's name of lowest value
        
        //loop through Array List
        for(studentProfile student : students){
            //loop through ArrayList grade in studentProfile java file
            for(double grade : student.getGrade()){
                if(grade < lowestGrade){
                    lowestGrade = grade;
                    lowestGStudent = student;
                }
            }
        }

        //header of table
        System.out.println("\n" +"-".repeat(67)); //print 67 dashes
        System.out.printf("%40s %n","Lowest Grade");
        System.out.println("-".repeat(67)); //print 67 dashes
        System.out.printf("| %-30s | %-30s |%n", "Student Name", "Grade");
        System.out.println("-".repeat(67)); //print 67 dashes

        if(lowestGStudent != null){
            System.out.printf(
            "| %-30s | %30.2f |%n", 
            lowestGStudent.getNameFirst() +" " 
            +lowestGStudent.getNameLast(),
            lowestGrade);
        } else if(students.isEmpty()){
            System.out.printf("%n %48s %n","No grades have been recorded yet");
        }

        System.out.println("-".repeat(67)); //print 67 dashes
        System.out.println("\n\n");//double blank line
    }
    
    //Method to identify Highest Grade
    public void getHighestGrade(ArrayList<studentProfile> students) {
        double highestGrade = Double.MIN_VALUE; //instance for lowest double grade
        studentProfile heghestGStudent = null; //instance for student's name of lowest value

        //loop through Array List
        for(studentProfile student : students){
            //loop through ArrayList grade in studentProfile java file
            for(double grade : student.getGrade()){
                if(grade > highestGrade){
                    highestGrade = grade;
                    heghestGStudent = student;
                }
            }
        }

        //header of table
        System.out.println("\n" +"-".repeat(67)); //print 67 dashes
        System.out.printf("%40s %n","Highest Grade");
        System.out.println("-".repeat(67)); //print 67 dashes
        System.out.printf("| %-30s | %-30s |%n", "Student Name", "Grade");
        System.out.println("-".repeat(67)); //print 67 dashes

        if(heghestGStudent != null){
            System.out.printf(
            "| %-30s | %30.2f |%n", 
            heghestGStudent.getNameFirst() +" " 
            +heghestGStudent.getNameLast(),
            highestGrade);
        } else if(students.isEmpty()){
            System.out.printf("%n %48s %n","No grades have been recorded yet");
        } else {
            System.out.println("\t\tNo student grade entered yet!");
        }

        System.out.println("-".repeat(67)); //print 67 dashes
        System.out.println("\n\n");//double blank line
    }

    //Quicksort Algorithmmethod to sort all students name by A-Z
    public void quickSort(ArrayList<studentProfile> students, int low, int high) {
        if(low < high) {
            int pivot = partition(students, low, high);
            quickSort(students, low, pivot -1);
            quickSort(students, pivot +1, high);
        }
    }
    //partition method to identify smaller and higher values
    public int partition(ArrayList<studentProfile> students, int low, int high) {
        studentProfile pivot = students.get(high);
        int i = low -1;

        //swap process
        for(int j=low; j<high; j++){
            if(students.get(j).getNameFirst().compareTo(pivot.getNameFirst()) < 0){
                i++;
                studentProfile temp = students.get(i);
                students.set(i, students.get(j));
                students.set(j, temp);
            }
        }
        studentProfile temp = students.get(i+1);
        students.set(i +1, students.get(high));
        students.set(high, temp);
        return i+1;
    }
}
