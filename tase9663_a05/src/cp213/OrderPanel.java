package cp213;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * The GUI for the Order class.
 *
 * @author Antonio Taseski
 * @author Abdul-Rahman Mawlood-Yunis
 * @author David Brown
 * @version 2024-10-15
 */
@SuppressWarnings("serial")
public class OrderPanel extends JPanel {

    /**
     * Implements an ActionListener for the 'Print' button. Prints the current
     * contents of the Order to a system printer or PDF.
     */
    private class PrintListener implements ActionListener {

	@Override
	public void actionPerformed(final ActionEvent e) {

	    // your code here
	    PrinterJob job = PrinterJob.getPrinterJob();
	    job.setPrintable(order);

	    if (job.printDialog()) {
		try {
		    job.print();
		} catch (PrinterException err) {
		    System.out.println(err.getMessage());
		}
	    }

	}
    }

    /**
     * Implements a FocusListener on a JTextField. Accepts only positive integers,
     * all other values are reset to 0. Adds a new MenuItem to the Order with the
     * new quantity, updates an existing MenuItem in the Order with the new
     * quantity, or removes the MenuItem from the Order if the resulting quantity is
     * 0.
     */
    private class QuantityListener implements FocusListener {
	private MenuItem item = null;

	QuantityListener(final MenuItem item) {
	    this.item = item;
	}

	// your code here
	@Override
	public void focusGained(final FocusEvent e) {
	}

	@Override
	public void focusLost(final FocusEvent e) {
	    JTextField quantityText = (JTextField) e.getSource();
	    String quantityStr = quantityText.getText();
	    int quanity = 0;
	    try {
		quanity = Integer.parseInt(quantityStr);
		if (quanity < 0) {
		    quanity = 0;
		}
	    } catch (NumberFormatException error) {
		quanity = 0;
	    }

	    order.update(item, quanity);

	    subtotalLabel.setText(String.format("%.2f", order.getSubTotal().floatValue()));
	    taxLabel.setText(String.format("%.2f", order.getTaxes().floatValue()));
	    totalLabel.setText(String.format("%.2f", order.getTotal().floatValue()));

	    String qToString = String.valueOf(quanity);
	    quantityText.setText(qToString);
	}

    }

    // Attributes
    private Menu menu = null;
    private final Order order = new Order();
    private final DecimalFormat priceFormat = new DecimalFormat("$##0.00");
    private final JButton printButton = new JButton("Print");
    private final JLabel subtotalLabel = new JLabel("0");
    private final JLabel taxLabel = new JLabel("0");
    private final JLabel totalLabel = new JLabel("0");

    private JLabel nameLabels[] = null;
    private JLabel priceLabels[] = null;
    // TextFields for menu item quantities.
    private JTextField quantityFields[] = null;

    /**
     * Displays the menu in a GUI.
     *
     * @param menu The menu to display.
     */
    public OrderPanel(final Menu menu) {
	this.menu = menu;
	this.nameLabels = new JLabel[this.menu.size()];
	this.priceLabels = new JLabel[this.menu.size()];
	this.quantityFields = new JTextField[this.menu.size()];
	this.layoutView();
	this.registerListeners();
    }

    /**
     * Uses the GridLayout to place the labels and buttons.
     */
    private void layoutView() {

	// your code here
	GridLayout gLayout = new GridLayout(menu.size() + 5, 3);
	setLayout(gLayout);

	JLabel itemHeading = new JLabel("Item");
	JLabel priceHeading = new JLabel("Price");
	JLabel quantityHeading = new JLabel("Quantity");

	this.add(itemHeading);
	this.add(priceHeading);
	this.add(quantityHeading);

	for (int i = 0; i < menu.size(); i++) {
	    MenuItem item = menu.getItem(i);
	    nameLabels[i] = new JLabel(item.getListing());
	    priceLabels[i] = new JLabel(item.getPrice().toString());
	    quantityFields[i] = new JTextField("0", 5);

	    this.add(nameLabels[i]);
	    this.add(priceLabels[i]);
	    this.add(quantityFields[i]);

	}

	JLabel subtotalHeading = new JLabel("Subtotal:");
	JLabel taxHeading = new JLabel("Tax:");
	JLabel totalHeading = new JLabel("Total:");

	this.add(subtotalHeading);
	this.add(new JLabel(""));
	this.add(subtotalLabel);
	this.add(taxHeading);
	this.add(new JLabel(""));
	this.add(taxLabel);
	this.add(totalHeading);
	this.add(new JLabel(""));
	this.add(totalLabel);
	this.add(new JLabel(""));
	this.add(printButton);

	this.setVisible(true);

    }

    /**
     * Register the widget listeners with the widgets.
     */
    private void registerListeners() {
	// Register the PrinterListener with the print button.
	this.printButton.addActionListener(new PrintListener());

	// your code here
	for (int i = 0; i < menu.size(); i++) {
	    MenuItem item = menu.getItem(i);
	    quantityFields[i].addFocusListener(new QuantityListener(item));
	}

    }
}