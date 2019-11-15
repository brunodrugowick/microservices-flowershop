package dev.drugowick.microservice.flowersupplier.service;

import dev.drugowick.microservice.flowersupplier.model.SupplierInfo;
import dev.drugowick.microservice.flowersupplier.repository.InfoRepository;
import org.springframework.stereotype.Service;

@Service
public class InfoService {

    private InfoRepository infoRepository;

    public InfoService(InfoRepository infoRepository) {
        this.infoRepository = infoRepository;
    }

    public SupplierInfo getInfoByProvince(String province) {
        return infoRepository.findByProvince(province);
    }
}
