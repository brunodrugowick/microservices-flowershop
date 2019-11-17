package dev.drugowick.microservice.flowersupplier.service;

import dev.drugowick.microservice.flowersupplier.model.SupplierInfo;
import dev.drugowick.microservice.flowersupplier.repository.InfoRepository;
import org.springframework.stereotype.Service;

@Service
public class SupplierInfoService {

    private InfoRepository infoRepository;

    public SupplierInfoService(InfoRepository infoRepository) {
        this.infoRepository = infoRepository;
    }

    public SupplierInfo getInfoByProvince(String province) {
        return infoRepository.findByProvince(province);
    }
}
