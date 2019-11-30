package dev.drugowick.microservice.flowerstore.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "order_table")
public class Order {

	@Id
	private Long supplierOrderId;
	
	private Integer fulfillmentTime;
	
	private String destinationAddress;
	
	public Long getSupplierOrderId() {
		return supplierOrderId;
	}

	public void setSupplierOrderId(Long supplierOrderId) {
		this.supplierOrderId = supplierOrderId;
	}

	public String getDestinationAddress() {
		return destinationAddress;
	}

	public void setDestinationAddress(String destinationAddress) {
		this.destinationAddress = destinationAddress;
	}

	public Integer getFulfillmentTime() {
		return fulfillmentTime;
	}

	public void setFulfillmentTime(Integer fulfillmentTime) {
		this.fulfillmentTime = fulfillmentTime;
	}
	
	
}