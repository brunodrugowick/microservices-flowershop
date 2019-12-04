package dev.drugowick.microservice.flowerstore.dto;

import java.time.LocalDate;

public class VoucherDto {
	
	private Long number;
	
	private LocalDate deliveryEstimatedDate;

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public LocalDate getDeliveryEstimatedDate() {
		return deliveryEstimatedDate;
	}

	public void setDeliveryEstimatedDate(LocalDate deliveryEstimatedDate) {
		this.deliveryEstimatedDate = deliveryEstimatedDate;
	}

	@Override
	public String toString() {
		return "VoucherDto [number=" + number + ", deliveryEstimatedDate=" + deliveryEstimatedDate + "]";
	}

}
