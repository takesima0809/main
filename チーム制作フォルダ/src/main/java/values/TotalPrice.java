package values;

public class TotalPrice {
	private final int totalPrice;

	public TotalPrice(int totalPrice) {
		this.totalPrice=totalPrice;
	}
	
	public int toInt() {
		return this.totalPrice;
	}
}
