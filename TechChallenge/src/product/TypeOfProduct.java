package product;

/**
 * Identifies the type of product (exempt from taxes or general) and its tax applicable.
 * @author Andrea Olcina
 *
 */
public enum TypeOfProduct {
	EXEMPT(0.0), GENERAL(10.0);
	
	// Private
	private double tax;

	/**
	 * Constructor.
	 * @param tax
	 */
	private TypeOfProduct(double tax) {
		this.tax = tax;
	}
	
	/**
	 * Returns the tax applicable to a product.
	 * @return tax
	 */
	public double getApplicableTax() {
		return this.tax;
	}
}
