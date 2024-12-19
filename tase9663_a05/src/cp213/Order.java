package cp213;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Stores a HashMap of MenuItem objects and the quantity of each MenuItem
 * ordered. Each MenuItem may appear only once in the HashMap.
 *
 * @author Antonio Taseski
 * @author Abdul-Rahman Mawlood-Yunis
 * @author David Brown
 * @version 2024-10-15
 */
public class Order implements Printable {

    private static final String lineFormat = "%-14s%2d @ $%5.2f = $%6.2f\n";
    private static final String totalFormat = "%-9s                   $%6.2f\n";
    /**
     * The current tax rate on menu items.
     */
    public static final BigDecimal TAX_RATE = new BigDecimal(0.13);

    // define a Map of MenuItem objects
    // Note that this must be a *Map* of some flavour
    // @See
    // https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Map.html

    // your code here
    private HashMap<MenuItem, Integer> orderMap = new HashMap<MenuItem, Integer>();

    /**
     * Increments the quantity of a particular MenuItem in an Order with a new
     * quantity. If the MenuItem is not in the order, it is added.
     *
     * @param item     The MenuItem to purchase - the HashMap key.
     * @param quantity The number of the MenuItem to purchase - the HashMap value.
     */
    public void add(final MenuItem item, final int quantity) {

	// your code here
	orderMap.put(item, quantity);

    }

    /**
     * Calculates the total value of all MenuItems and their quantities in the
     * HashMap.
     *
     * @return the total cost for the MenuItems ordered.
     */
    public BigDecimal getSubTotal() {

	// your code here
	BigDecimal price = BigDecimal.ZERO;
	BigDecimal quantity = BigDecimal.ZERO;
	BigDecimal total = BigDecimal.ZERO;

	for (Map.Entry<MenuItem, Integer> pair : orderMap.entrySet()) {
	    quantity = new BigDecimal(pair.getValue());
	    price = pair.getKey().getPrice();
	    total = total.add(price.multiply(quantity));
	}

	return total;
    }

    /**
     * Calculates and returns the total taxes to apply to the subtotal of all
     * MenuItems in the order. Tax rate is TAX_RATE.
     *
     * @return total taxes on all MenuItems
     */
    public BigDecimal getTaxes() {

	// your code here
	BigDecimal total = this.getSubTotal();
	return total.multiply(TAX_RATE);
    }

    /**
     * Calculates and returns the total cost of all MenuItems order, including tax.
     *
     * @return total cost
     */
    public BigDecimal getTotal() {

	// your code here
	BigDecimal total = this.getSubTotal();
	return total.multiply(TAX_RATE.add(new BigDecimal(1)));
    }

    /*
     * Implements the Printable interface print method. Prints lines to a Graphics2D
     * object using the drawString method. Prints the current contents of the Order.
     */
    @Override
    public int print(final Graphics graphics, final PageFormat pageFormat, final int pageIndex)
	    throws PrinterException {
	int result = PAGE_EXISTS;

	if (pageIndex == 0) {
	    final Graphics2D g2d = (Graphics2D) graphics;
	    g2d.setFont(new Font("MONOSPACED", Font.PLAIN, 12));
	    g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
	    // Now we perform our rendering
	    final String[] lines = this.toString().split("\n");
	    int y = 100;
	    final int inc = 12;

	    for (final String line : lines) {
		g2d.drawString(line, 100, y);
		y += inc;
	    }
	} else {
	    result = NO_SUCH_PAGE;
	}
	return result;
    }

    /**
     * Returns a String version of a receipt for all the MenuItems in the order.
     */
    @Override
    public String toString() {

	// your code here
	String prnt = "Receipt\n";
	for (Map.Entry<MenuItem, Integer> pair : orderMap.entrySet()) {
	    prnt += String.format("%-14s %d @ $ %5.2f = $ %5.2f\n", pair.getKey().getListing(), pair.getValue(),
		    pair.getKey().getPrice(), pair.getKey().getPrice().multiply(new BigDecimal(pair.getValue())));

	}

	prnt += "\n";
	prnt += String.format("%-27s $ %5.2f\n", "Subtotal:", this.getSubTotal());
	prnt += String.format("%-27s $ %5.2f\n", "Taxes:", this.getTaxes());
	prnt += String.format("%-27s $ %5.2f\n", "Total:", this.getTotal());

	return prnt;
    }

    /**
     * Replaces the quantity of a particular MenuItem in an Order with a new
     * quantity. If the MenuItem is not in the order, it is added. If quantity is 0
     * or negative, the MenuItem is removed from the Order.
     *
     * @param item     The MenuItem to update
     * @param quantity The quantity to apply to item
     */
    public void update(final MenuItem item, final int quantity) {

	// your code here
	if (quantity <= 0) {
	    orderMap.remove(item);
	} else {
	    orderMap.put(item, quantity);
	}

    }
}