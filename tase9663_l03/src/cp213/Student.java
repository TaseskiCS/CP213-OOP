package cp213;

import java.time.LocalDate;

/**
 * Student class definition.
 *
 * @author your name here
 * @version 2022-01-17
 */
public class Student implements Comparable<Student> {

    // Attributes
    private LocalDate birthDate = null;
    private String forename = "";
    private int id = 0;
    private String surname = "";

    /**
     * Instantiates a Student object.
     *
     * @param id        student ID number
     * @param surname   student surname
     * @param forename  name of forename
     * @param birthDate birthDate in 'YYYY-MM-DD' format
     */
    public Student(int id, String surname, String forename, LocalDate birthDate) {

	// assign attributes here
	this.id = id;
	this.forename = forename;
	this.surname = surname;
	this.birthDate = birthDate;

	return;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString() Creates a formatted string of student data.
     */
    @Override
    public String toString() {
	String string = "";

	string = String.format("Name: %s, %s\nID: %d\nBirthdate: %s\n", surname, forename, id, birthDate);
	return string;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(final Student target) {
	int result = 0;

	result = this.surname.compareTo(target.surname);

	if (result == 0) {
	    result = this.forename.compareTo(target.forename);

	    if (result == 0) {
		result = Integer.compare(this.id, target.id);
	    }
	}

	return result;
    }

    // getters and setters defined here

    // getters

    /**
     *
     * @return id
     */
    public int getId() {
	return this.id;
    }

    /**
     *
     * @return surname
     */
    public String getSurname() {
	return this.surname;
    }

    /**
     *
     * @return forename
     */
    public String getForename() {
	return this.forename;
    }

    /**
     *
     * @return birthDate
     */
    public LocalDate getBirthDate() {
	return this.birthDate;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
	this.id = id;

    }

    /**
     *
     * @param surname
     */
    public void setSurname(String surname) {
	this.surname = surname;

    }

    /**
     *
     * @param forename
     */
    public void setForename(String forename) {
	this.forename = forename;

    }

    /**
     *
     * @param birthDate
     */
    public void setBirthDate(LocalDate birthDate) {
	this.birthDate = birthDate;

    }

}
