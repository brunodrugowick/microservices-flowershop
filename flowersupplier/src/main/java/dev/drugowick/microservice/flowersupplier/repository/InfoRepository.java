package dev.drugowick.microservice.flowersupplier.repository;

import dev.drugowick.microservice.flowersupplier.model.SupplierInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoRepository extends CrudRepository<SupplierInfo, Long> {

    SupplierInfo findByProvince(String province);
}
