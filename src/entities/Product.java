package entities;

public class Product {
	
	private Double quantity;
	private Integer erpNumber;
	
	public Product() {

	}
	
	public Product(Double quantity, Integer erpNumber) {
		this.quantity = quantity;
		this.erpNumber = erpNumber;
	}
	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	public Integer getErpNumber() {
		return erpNumber;
	}
	public void setErpNumber(Integer erpNumber) {
		this.erpNumber = erpNumber;
	}
	
	@Override
	public String toString() {
		return "Product [quantity=" + quantity + ", erpNumber=" + erpNumber + "]";
	}
	
	
	

}
