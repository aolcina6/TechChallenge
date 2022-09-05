package product;

public class ExemptProduct extends Product {

	public ExemptProduct(double price, int qty, String desc) {
		super(price, qty, desc);
		this.tax = 0;
	}
}
