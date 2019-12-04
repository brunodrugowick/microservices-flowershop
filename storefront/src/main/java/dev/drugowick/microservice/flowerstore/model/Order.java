package dev.drugowick.microservice.flowerstore.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "order_table")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long supplierOrderId;
	
	private Integer fulfillmentTime;
	
	private String destinationAddress;
	
	private LocalDate deliveryDate;
	
	private Long voucher;
	
	@Enumerated(EnumType.STRING)
	private OrderState state;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
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
	
	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Long getVoucher() {
		return voucher;
	}

	public void setVoucher(Long voucher) {
		this.voucher = voucher;
	}

	public OrderState getState() {
		return state;
	}

	public void setState(OrderState state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", supplierOrderId=" + supplierOrderId + ", fulfillmentTime=" + fulfillmentTime
				+ ", destinationAddress=" + destinationAddress + ", deliveryDate=" + deliveryDate + ", voucher="
				+ voucher + ", state=" + state + "]";
	}
	
	
	
}
