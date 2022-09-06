package product;

import java.text.DecimalFormat;

/**
 * Class Product, identifies items.
 * @author: Andrea Olcina
 */

public class Product {
	// Private Vars
	private double price;
	private int qty;
	private boolean isImported = false;
	private double additionalTaxes;
	private String desc;
	private TypeOfProduct type;
	
    /**
     * Constructor
     * @param price Unitary price of the product. 
     * @param qty Quantity of the product. 
	 * @param desc Description of the product. 
	 * @param type TypeOfProduct object. 
	 * @param isImported True or false.
     */
	public Product(double price, int qty, String desc, TypeOfProduct type, boolean isImported) {
		
		this.price = price;
		this.qty = qty;
		this.desc = desc;
		this.type = type;
		this.isImported = isImported;
		if (this.isImported) {
			this.additionalTaxes = 5.0;
		}
	}
	
	/**
	 * Returns the unitary price of the product. 
	 * @return price
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * Returns the quantity of the product.
	 * @return qty
	 */
	public double getQty() {
		return qty;
	}
	
	/**
	 * Returns the total cost of the item.
	 * @return
	 */
	public double getCost() {
		return (this.price*this.qty);
	}
	/**
	 * Returns the description of the product.
	 * @return desc
	 */
	public String getDescription() {
		return desc;
	}
	
	/**
	 * Calculates the total cost of the taxes associated to the product.
	 * @return taxes
	 */
	public double getTotalTaxes() {
		double taxes = Math.ceil(((this.type.getApplicableTax()/100)*getCost())*20.0)/20.0;
		if (this.isImported) {
			taxes += Math.ceil(((this.additionalTaxes/100)*getCost())*20.0)/20.0;
		}
		return taxes;
	}	

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#0.00");
		return this.qty + " " + this.desc + ": " + df.format((getCost() + this.getTotalTaxes())) + "€";
	}
}
