package dev.drugowick.microservice.flowerstore.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CartDTO {

	@JsonIgnore
	private Long orderId;
    private List<CartItemDTO> items;
    private AddressDTO address;

    public List<CartItemDTO> getItems() {
        return items;
    }

    public void setItems(List<CartItemDTO> items) {
        this.items = items;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "CartDTO [orderId=" + orderId + ", items=" + items + ", address=" + address + "]";
	}
	
	
}
