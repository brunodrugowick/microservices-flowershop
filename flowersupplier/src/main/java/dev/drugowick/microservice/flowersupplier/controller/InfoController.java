package dev.drugowick.microservice.flowersupplier.controller;

import dev.drugowick.microservice.flowersupplier.model.SupplierInfo;
import dev.drugowick.microservice.flowersupplier.service.SupplierInfoService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class InfoController {
	
	private static final Logger LOG = LoggerFactory.getLogger(InfoController.class);

    private SupplierInfoService infoService;

    public InfoController(SupplierInfoService infoService) {
        this.infoService = infoService;
    }

    @RequestMapping("/{province}")
    public SupplierInfo getInfoByProvince(@PathVariable String province) {
        SupplierInfo supplierInfo = infoService.getInfoByProvince(province);
        LOG.info("Got info from the SupplierInfoService {}", supplierInfo);
        return supplierInfo;
    }
}
