package cp213;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

//---------------------------------------------------------------
/**
 * The right triangle model. Allows users to update the base and height
 * separately.
 *
 * @author David Brown from Byron Weber-Becker
 * @version 2017-06-19
 */
public class RTModel {
    // Constants.
    /**
     * Used to signal a change in the base value property of the model.
     */
    public static final String BASE_CHANGE = "Base Changed";
    /**
     * Used to signal a change in the height value property of the model.
     */
    public static final String HEIGHT_CHANGE = "Height Changed";
    /**
     * The maximum size of each of the two non-hypotenuse sides of the triangle.
     */
    public static final double MAX_SIDE = 100.0;
    /**
     * The initial size of the base.
     */
    private double base = 30.0;
    /**
     * The initial size of the height.
     */
    private double height = 40.0;
    /**
     * The initial size of the hypotenuse based upon base and height.
     */
    private double hypotenuse = Math
	    .sqrt(Math.pow(this.base, 2.0) + Math.pow(this.height, 2.0));;
    /**
     * Allows views to listen to generic changes in the model.
     */
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    // ---------------------------------------------------------------
    /**
     * Attaches listeners to the model.
     * 
     * @param listener
     *            The listener to attach to the model.
     */
    public void addPropertyChangeListener(
	    final PropertyChangeListener listener) {
	this.pcs.addPropertyChangeListener(listener);
    }

    // ---------------------------------------------------------------
    /**
     * Attaches listeners to the model for a particular property.
     * 
     * @param propertyName
     *            The name of the property to listen for.
     * @param listener
     *            The listener to attach to the model.
     */
    public void addPropertyChangeListener(final String propertyName,
	    final PropertyChangeListener listener) {
	this.pcs.addPropertyChangeListener(propertyName, listener);
    }

    // ---------------------------------------------------------------
    /**
     * Returns the value of the model's base.
     * 
     * @return the value of the model's base.
     */
    public double getBase() {
	return this.base;
    }

    // ---------------------------------------------------------------
    /**
     * Returns the value of the model's height.
     * 
     * @return the value of the model's height.
     */
    public double getHeight() {
	return this.height;
    }

    // ---------------------------------------------------------------
    /**
     * Returns the hypotenuse.
     * 
     * @return the hypotenuse.
     */
    public double getHypotenuse() {
	return this.hypotenuse;
    }

    // ---------------------------------------------------------------
    /**
     * Assigns a value to the model's base and updates all views accordingly.
     * 
     * @param newBase
     *            The base value to set.
     */
    public void setBase(final double newBase) {
	this.base = Math.min(Math.max(0, newBase), RTModel.MAX_SIDE);
	this.setHypotenuse();
	// Inform listeners the model is updated.
	this.pcs.firePropertyChange(RTModel.BASE_CHANGE, null, this.base);
    }

    // ---------------------------------------------------------------
    /**
     * Assigns a value to the model's height and updates all views accordingly.
     * 
     * @param newHeight
     *            The height value to set.
     */
    public void setHeight(final double newHeight) {
	this.height = Math.min(Math.max(0, newHeight), RTModel.MAX_SIDE);
	this.setHypotenuse();
	// Inform listeners the model is updated.
	this.pcs.firePropertyChange(RTModel.HEIGHT_CHANGE, null, this.height);
    }

    // ---------------------------------------------------------------
    /**
     * Sets the value of the hypotenuse. (Not public since the hypotenuse cannot
     * be changed independently of the base or height.)
     */
    private void setHypotenuse() {
	this.hypotenuse = Math
		.sqrt(Math.pow(this.base, 2.0) + Math.pow(this.height, 2.0));
    }

    // ---------------------------------------------------------------
}