package set.ordering;

import java.util.Comparator;
import java.util.Objects;

public class Student implements Comparable<Student> {

    private String name;

    private long registration;

    private double average;

    public Student(String name, long registration, double average) {
        this.name = name;
        this.registration = registration;
        this.average = average;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return Objects.equals(getRegistration(), student.getRegistration());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRegistration());
    }

    @Override
    public int compareTo(Student student) {
        return name.compareTo(student.getName());
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", registration=" + registration + ", average=" + average + "]";
    }

    public String getName() {
        return name;
    }

    public long getRegistration() {
        return registration;
    }

    public double getAverage() {
        return average;
    }

}
    class ComparatorGrade implements Comparator<Student> {
        @Override
        public int compare(Student g1, Student g2) {
            return Double.compare(g1.getAverage(), g2.getAverage());
        }
    }

