package dev.drugowick.microservice.flowersupplier.controller;

import dev.drugowick.microservice.flowersupplier.model.SupplierInfo;
import dev.drugowick.microservice.flowersupplier.service.InfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("info")
public class InfoController {

    private InfoService infoService;

    public InfoController(InfoService infoService) {
        this.infoService = infoService;
    }

    @RequestMapping("/estado")
    public SupplierInfo getInfoByProvince(String province) {
        return infoService.getInfoByProvince(province);
    }
}
