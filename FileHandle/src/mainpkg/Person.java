package mainpkg;

import java.io.Serializable;

/**
 *
 * @author RayhaN
 */
public class Person implements Serializable {
    String firstName , lastName ;
    Float cgpa ;

    public Person() {
        this.firstName = "TBA" ;
        this.lastName = "TBA" ;
        this.cgpa = 0.00f ;
    }

    public Person(String firstName, String lastName, Float cgpa) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cgpa = cgpa;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Float getCgpa() {
        return cgpa;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCgpa(Float cgpa) {
        this.cgpa = cgpa;
    }

    @Override
    public String toString() {
        return "FirstName=" + firstName + "\nLastName=" + lastName + "\nCGPA=" + cgpa ;
    }
    
    
}