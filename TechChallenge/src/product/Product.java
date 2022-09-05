package product;

public class Product {
	private double price;
	private int qty;
	private boolean isImported = false;
	protected double tax = 10;
	private double additionalTaxes;
	private String desc;
	
	public Product(double price, int qty, String desc) {
		this.price = price;
		this.qty = qty;
		this.desc = desc;
		if (this.desc.contains("importado") || this.desc.contains("importaci[ó|o]n")) {
			this.isImported = true;
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
		double taxes = Math.round(((this.tax/100)*this.price)*100)/100d;
		if (this.isImported) {
			taxes += roundTaxes((this.additionalTaxes/100)*this.price);
		}
		return taxes;
	}	
	
	public double roundTaxes(double num) {
		return Math.round((5*(Math.ceil(Math.abs(num/5))))*100.0)/100.0;
	}
	
	@Override
	public String toString() {
		return this.qty + " " + this.desc + ": " + this.price + "€";
	}
}
