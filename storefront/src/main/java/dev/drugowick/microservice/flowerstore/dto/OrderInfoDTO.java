package dev.drugowick.microservice.flowerstore.dto;

public class OrderInfoDTO {
	
	private Long id;
	
	private Integer fulfillmentTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getFulfillmentTime() {
		return fulfillmentTime;
	}

	public void setFulfillmentTime(Integer fulfillmentTime) {
		this.fulfillmentTime = fulfillmentTime;
	}

	@Override
	public String toString() {
		return "OrderInfoDTO [id=" + id + ", fulfillmentTime=" + fulfillmentTime + "]";
	}

}
