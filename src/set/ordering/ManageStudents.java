package set.ordering;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ManageStudents {

    private Set<Student> studentsSet;

    public ManageStudents() {
        this.studentsSet = new HashSet<>();
    }


    public void addStudent(String name, long registration, double avegare) {
        studentsSet.add(new Student(name, registration, avegare));
    }

    public void removeStudent(long registration) {
        Student studentForRemove = null;
        if (!studentsSet.isEmpty()) {
            for (Student s : studentsSet) {
                if (s.getRegistration() == registration) {
                    studentForRemove = s;
                    break;
                }
            }
            studentsSet.remove(studentForRemove);
        } else {
            throw new RuntimeException("The set is empty");
        }

        if (studentForRemove == null) {
            System.out.println("Registration not found");
        }
    }

    public void displayStudentsByName() {
        Set<Student> studentsForName = new TreeSet<>(studentsSet);
        if (!studentsForName.isEmpty()) {
            System.out.println(studentsForName);
        } else {
            System.out.println("the set is empty");
        }
    }


    public void displayStudentsByGrade() {
        Set<Student> studentsForGrade = new TreeSet<>(new ComparatorGrade());
        if (!studentsSet.isEmpty()) {
            studentsForGrade.addAll(studentsSet);
            System.out.println(studentsForGrade);
        } else {
            System.out.println("the set is empty");
        }
    }

    public static void main(String[] args) {
        ManageStudents manageStudents = new ManageStudents();

        manageStudents.addStudent("Lucas", 1234L,7.5);
        manageStudents.addStudent("Rodrigo", 1235L,9.0);
        manageStudents.addStudent("Vitor", 1236L,8.9);
        manageStudents.addStudent("Carlos", 1237L,6.5);


        System.out.println("Students in Manage: ");
        System.out.println(manageStudents.studentsSet);
        System.out.println("------------------------");

        System.out.println("Removing Students by Registration: ");
        manageStudents.removeStudent(000L);
        manageStudents.removeStudent(1235L);
        System.out.println("-----------------------------------");

        System.out.println("Showing Students by name: ");
        manageStudents.displayStudentsByName();
        System.out.println("-----------------------------");

        System.out.println("Showing Students by Grade: ");
        manageStudents.displayStudentsByGrade();
    }
}
