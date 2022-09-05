import ticket.Ticket;
import product.Product;
import product.ExemptProduct;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated constructor stub
		Ticket t = new Ticket();
		Product p1 = new ExemptProduct(12.49, 1, "libro");
		Product p2 = new Product(14.99, 1, "CD de música");
		Product p3 = new ExemptProduct(0.85, 1, "barrita de chocolate");
		
		t.addProduct(p1);
		t.addProduct(p2);
		t.addProduct(p3);
		
		System.out.println(t);
	}

}
