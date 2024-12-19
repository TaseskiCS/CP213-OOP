package cp213;

/**
 * Inherited class in simple example of inheritance / polymorphism.
 *
 * @author David Brown
 * @version 2022-02-25
 */
public class IA extends Student {

    // your code here
    protected String id = null;
    private String course;

    /**
     * IA constructor
     *
     * @param lastName  IA last name (surname): defined in Person
     * @param firstName IA first name (given name): defined in Person
     * @param id        Student id number
     * @param course    IA course number
     */

    public IA(String lastName, String firstName, String id, String course) {
	super(lastName, firstName, id);
	this.course = course;

    }

    /**
     * Getter for course.
     *
     * @return this.course
     */
    public String getCourse() {
	return this.course;
    }

    /**
     * Creates formatted string version of IA.
     */

    @Override
    public String toString() {
	return (super.toString() + '\n' + "Course: " + this.course);
    }

}
