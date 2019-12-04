package dev.drugowick.microservice.carrier.dto;

import java.time.LocalDate;

public class VoucherDTO {

	private Long number;
	
	private LocalDate deliveryEstimatedDate;

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long numero) {
		this.number = numero;
	}

	public LocalDate getDeliveryEstimatedDate() {
		return deliveryEstimatedDate;
	}

	public void setDeliveryEstimatedDate(LocalDate previsaoParaEntrega) {
		this.deliveryEstimatedDate = previsaoParaEntrega;
	}
}
