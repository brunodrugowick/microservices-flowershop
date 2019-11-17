package dev.drugowick.microservice.flowersupplier.dto;

public class ReservationDTO {
	
	public Integer reservationId;
	
	public Integer fulfillmentTime;

	public Integer getReservationId() {
		return reservationId;
	}

	public void setReservationId(Integer reservationId) {
		this.reservationId = reservationId;
	}

	public Integer getFulfillmentTime() {
		return fulfillmentTime;
	}

	public void setFulfillmentTime(Integer fulfillmentTime) {
		this.fulfillmentTime = fulfillmentTime;
	}

}
