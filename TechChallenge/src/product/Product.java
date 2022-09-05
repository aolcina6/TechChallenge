package product;

import java.text.DecimalFormat;

public class Product {
	private double price;
	private int qty;
	private boolean isImported = false;
	private double additionalTaxes;
	private String desc;
	private TypeOfProduct type;
	
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
	
	public double getPrice() {
		return price;
	}
	
	public double getQty() {
		return qty;
	}
	
	public String getDescription() {
		return desc;
	}
	
	public double getTotalTaxes() {
		double taxes = Math.ceil(((this.type.getApplicableTax()/100)*this.price)*20.0)/20.0;
		if (this.isImported) {
			taxes += Math.ceil(((this.additionalTaxes/100)*this.price)*20.0)/20.0;
		}
		return taxes;
	}	

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#0.00");
		return this.qty + " " + this.desc + ": " + df.format((this.price + this.getTotalTaxes())) + "€";
	}
}
