package dev.drugowick.microservice.flowerstore.dto;

import java.util.List;

public class CartDTO {

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
}
