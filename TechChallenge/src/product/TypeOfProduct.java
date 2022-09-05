package product;

public enum TypeOfProduct {
	EXEMPT(0.0), GENERAL(10.0);
	
	private double tax;

	private TypeOfProduct(double tax) {
		this.tax = tax;
	}
		
	public double getApplicableTax() {
		return this.tax;
	}
}
