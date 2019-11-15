package dev.drugowick.microservice.flowerstore.dto;

public class SupplierInfoDTO {
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SupplierInfoDTO{" +
                "address='" + address + '\'' +
                '}';
    }
}
