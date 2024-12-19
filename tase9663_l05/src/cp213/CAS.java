package cp213;

/**
 * Inherited class in simple example of inheritance / polymorphism.
 *
 * @author
 * @version 2022-02-25
 */
public class CAS extends Professor {

    // your code here
    protected String id = null;
    private String term;

    /**
     * CAS constructor
     *
     * @param lastName   CAS last name (surname): defined in Person
     * @param firstName  CAS first name (given name): defined in Person
     * @param department CAS department
     * @param term       CAS term date
     */

    public CAS(String lastName, String firstName, String department, String term) {
	super(lastName, firstName, department);
	this.term = term;

    }

    /**
     * Getter for term.
     *
     * @return this.term
     */
    public String getTerm() {
	return this.term;
    }

    /**
     * Creates formatted string version of CAS.
     */

    @Override
    public String toString() {
	return (super.toString() + '\n' + "Term: " + this.term);
    }

}
