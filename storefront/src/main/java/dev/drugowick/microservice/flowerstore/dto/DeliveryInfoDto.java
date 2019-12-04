package dev.drugowick.microservice.flowerstore.dto;

import java.time.LocalDate;

public class DeliveryInfoDto {
	
	private Long orderId;
	
	private LocalDate deliveryEstimatedDate;
	
	private String fromAddress;
	
	private String toAddress;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
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

	@Override
	public String toString() {
		return "DeliveryInfoDto [orderId=" + orderId + ", deliveryEstimatedDate=" + deliveryEstimatedDate
				+ ", fromAddress=" + fromAddress + ", toAddress=" + toAddress + "]";
	}
	
	

}
