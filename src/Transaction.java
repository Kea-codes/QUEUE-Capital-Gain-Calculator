public class Transaction{
	int quantity;
	int unitPrice;
	
	Transaction(int q, int p) {
		quantity = q;
		unitPrice = p;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
}