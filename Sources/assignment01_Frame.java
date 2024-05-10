// Programmer: Johny Ramos Assuncao
// Studend ID: B00139596
// Date Completed: 16/03/2023
// Function: Assignment 01 - Software Development 02
// Note: System for teacher to input student's grade
// Code: Main code to display content

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class assignment01_Frame {   

    static int optionS = 0;

    public static void errorMessage(){ //method to display error message
        System.err.println();
        System.err.print("-".repeat(67)); //print 67 dashes
        System.err.printf("%n%50s %n","Invalid option, please try again.");
        System.err.print("-".repeat(67) +"\n"); //print 67 dashes
    }
    public static void main(String[] args) {
        Scanner scannerInput = new Scanner(System.in);

        //OOP for methods class SearchSort
        assignment01_SearchSort searchSort = new assignment01_SearchSort();

        //Array Object to store students' data
        ArrayList<studentProfile> studentList = new ArrayList<studentProfile>();

        do {
            try{
                System.out.println("+".repeat(67)); //print 67 dashes
                System.out.printf(
                "%n %28s %n %23s %n",
                "Module Grade Dashboard", 
                "Choose option!");
                System.out.print(
                  "\n1) - Setup Students Grade."
                + "\n2) - Search Students Grades."
                + "\n3) - End program!"
                + "\n\n Type here: ");

                optionS = scannerInput.nextInt();
            }catch(InputMismatchException ipt) {} //empty error

            scannerInput.nextLine(); //clean scanner
            nave: //label to return
            switch (optionS) {
                case 1:
                    System.out.println("+".repeat(67)); //print 67 dashes
                    System.out.printf(
                    "%n %25s %n%n %27s %n",
                    "Setup Grade Section", 
                    "Type 'quit' to finish!");

                    System.out.printf("%n %26s %n","Do not type/add space or invalid value no requested from this section onward!!");
                    
                    System.out.print("\nEnter number of students in class: ");
                    String numbInput = scannerInput.nextLine();
                    int numStudent = 0;

                    while (!numbInput.equalsIgnoreCase("quit")) {
                        try {
                            numStudent = Integer.parseInt(numbInput);
                            break;
                        } catch (NumberFormatException numFor) {
                            errorMessage(); // error message
                            System.out.print("Enter number of students in class: ");
                            numbInput = scannerInput.nextLine();
                        }
                    }

                    System.out.println("");

                    int counter = 1; //counter for number of grades entered.
                    int countStudent = 0; //counter to identify student input

                    for (int i = 0; i < numStudent; i++) {

                        System.out.print("\nEnter student's first name [" +(countStudent+=1) +"]: ");
                        String firstName = scannerInput.nextLine();

                        if (firstName.equalsIgnoreCase("quit")) {
                            break; 
                        }

                        //while() to accept only letters
                        while(!firstName.matches("[a-zA-Z]+")) {
                            errorMessage(); // error message
                            System.out.print(
                            "\nEnter student's first name [" +countStudent +"]: ");
                            firstName = scannerInput.nextLine();

                            if (firstName.equalsIgnoreCase("quit")) {
                                break; 
                            }
                        }

                        //capitalize first letter
                        firstName = firstName.substring(0,1).toUpperCase() + firstName.substring(1).toLowerCase();
                        
                        System.out.print("Enter student's surname [" +countStudent +"]: ");
                        String LastName = scannerInput.nextLine();

                        if (LastName.equalsIgnoreCase("quit")) {
                            break; 
                        }

                        //while() to accept only letters
                        while(!LastName.matches("[a-zA-Z]+")) {
                            errorMessage(); // error message
                            System.out.print(
                            "\nEnter student's surname name [" +countStudent +"]: ");
                            LastName = scannerInput.nextLine();
                                
                            if (LastName.equalsIgnoreCase("quit")) {
                            break; 
                            }
                        }

                        //capitalize first letter 
                        LastName = LastName.substring(0,1).toUpperCase() + LastName.substring(1).toLowerCase();

                        //OOP stores names,surnmas and grade and to manipulate display&Calc methods
                        //trim() method to remove white spaces
                        studentProfile student = new studentProfile(firstName.trim(), LastName.trim());
                        
                        //block to store student's grades
                        while (true) {
                            try {
                                System.out.print("Enter " +firstName +"'s grade [" +(counter++) +"]: ");
                                String gradeInput = scannerInput.nextLine();

                                if (gradeInput.equalsIgnoreCase("quit")) {
                                    break; 
                                }

                                double studentGrades = Double.parseDouble(gradeInput);
                                student.addGrade(studentGrades);
                            } catch (NumberFormatException misMat) {
                                errorMessage(); // error message
                            }
                        }
                        
                        studentList.add(student); //add input to Student profile 
                        counter = 1; // reset grade's counter to move to the next student
                    }
                break;
                case 2: 
                    //instance and declaration for display options
                    char optionChar = 0;

                    //output message for display dashboard
                    do{  
                        System.out.println("+".repeat(67)); //print 67 dashes
                        System.out.printf(
                        "%n %27s %n%n %s %n",
                        "Display Grade Section", 
                        "Choose one option by the displayed letter!");

                        System.out.print(
                        "\nA) - Search by student's surname."
                        + "\nB) - Display all class grades."
                        + "\nC) - Display lowest class grade."
                        + "\nD) - Display highest class grade."
                        + "\nE) - Display average class grade."
                        + "\nF) - Quit!"
                        + "\n\n Type option here (letter + enter): ");
              
                        String optionStr = scannerInput.next().toUpperCase();
                        if(optionStr.length() != 1){
                            errorMessage();
                            continue;
                        }
                        optionChar = optionStr.charAt(0);
                        scannerInput.nextLine(); //clean scanner
                        switch(optionChar){
                            case 'A': //Output grade by student surname

                                System.out.print("\nEnter student's surname to search: ");
                                String searchName = scannerInput.nextLine().toLowerCase();
                                System.out.println(); //blank line

                                //while() to accept only letters
                                while(!searchName.matches("[a-zA-Z]+")) {
                                    System.out.print(
                                    "Invalid option, please try again"
                                    +"\nEnter student's surname to search: ");
                                    searchName = scannerInput.nextLine().toLowerCase();
                                    System.out.println(); //blank line
                                }

                                //header of table
                                System.out.println("\n" +"-".repeat(67)); //print 67 dashes
                                System.out.printf("%38s %n","Grade Table");
                                System.out.println("-".repeat(67)); //print 67 dashes
                                System.out.printf("| %-30s | %-30s |%n", "Student Name", "Grade");
                                System.out.println("-".repeat(67)); //print 67 dashes

                                if(studentList.isEmpty()) {
                                    System.out.printf("%n %48s %n","No grades have been recorded yet");
                                } else {
                                    for(studentProfile s : studentList){
                                        s.printStudent(searchName.trim());
                                    }
                                }

                                System.out.println("-".repeat(67)); //print 67 dashes
                                System.out.println("\n\n");//double blank line

                            break;
                            case 'B': //Output all class grade sorted

                                //call sorting method 
                                searchSort.quickSort(studentList, 0 ,studentList.size() - 1);

                                //header of table
                                System.out.println("\n" +"-".repeat(67)); //print 67 dashes
                                System.out.printf("%40s %n","All Grade Table");
                                System.out.println("-".repeat(67)); //print 67 dashes
                                System.out.printf("| %-30s | %-30s |%n", "Student Name", "Grade");
                                System.out.println("-".repeat(67)); //print 67 dashes

                                if(studentList.isEmpty()) {
                                    System.out.printf("%n %48s %n","No grades have been recorded yet");
                                } else {
                                    for(studentProfile s : studentList){
                                        s.printAll();
                                    }
                                }
                                System.out.println("\n\n");//double blank line
                            break;
                            case 'C': //Output lowest grade of the class

                                searchSort.getLowestGrade(studentList); 

                            break;
                            case 'D': //Output highest grade of the class

                                searchSort.getHighestGrade(studentList);

                            break;
                            case 'E': //Output all class students name sorted by A-Z

                                searchSort.quickSort(studentList, 0 ,studentList.size() - 1);

                                //header of table
                                System.out.println("\n" +"-".repeat(67)); //print 67 dashes
                                System.out.printf("%46s %n","All Average Grade Table");
                                System.out.println("-".repeat(67)); //print 67 dashes
                                System.out.printf("| %-30s | %-30s |%n", "Student Name", "Grade");
                                System.out.println("-".repeat(67)); //print 67 dashes

                                if(studentList.isEmpty()) {
                                    System.out.printf("%n %48s %n","No grades have been recorded yet");
                                    System.out.println("-".repeat(67)); //print 67 dashes
                                } else {
                                    for(studentProfile s : studentList){
                                        s.printAverage();
                                    }
                                }

                                System.out.println("\n\n");//double blank line
                            break;
                            case 'F':
                            break nave; // label to return to first switch(optionS) 
                            default: 
                                errorMessage(); // error message
                                System.err.printf("%n%55s %n","Please enter the option letter from A to F!");
                            break;
                        }
                        
                    }while(optionChar != 'F');
                break;
                case 3:
                System.exit(1); //close process
                break;
                default:
                    errorMessage(); // error message
                    System.err.printf("%n%55s %n","Please enter the option number from 1 to 3!");
                break;
            }
        } while (optionS != 3);
        scannerInput.close(); //close input
    }
}