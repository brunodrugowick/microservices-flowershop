package dev.drugowick.microservice.flowersupplier.dto;

public class OrderItemDTO {
	
	private long id;
	
	private int amount;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}	

}
