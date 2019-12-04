package dev.drugowick.microservice.carrier.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Delivery {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long orderId;
	
	private LocalDate pickupEstimatedDate;
	
	private LocalDate deliveryEstimatedDate;
	
	private String fromAddress;
	
	private String toAddress;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public LocalDate getPickupEstimatedDate() {
		return pickupEstimatedDate;
	}

	public void setPickupEstimatedDate(LocalDate pickupEstimatedDate) {
		this.pickupEstimatedDate = pickupEstimatedDate;
	}

	public LocalDate getDeliveryEstimatedDate() {
		return deliveryEstimatedDate;
	}

	public void setDeliveryEstimatedDate(LocalDate deliveryEstimatedDate) {
		this.deliveryEstimatedDate = deliveryEstimatedDate;
	}

	public String getFromAddress() {
		return fromAddress;
	}

	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	public String getToAddress() {
		return toAddress;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}
	
}
