package com.bikesparehub.bikesparehub.repository;

import com.bikesparehub.bikesparehub.model.BikePart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BikePartRepository extends JpaRepository<BikePart, Long> {

    List<BikePart> findByCityOrderByPriceAsc(String city);

    List<BikePart> findByCompatibleOldModel(String compatibleOldModel);

    List<BikePart> findByCategory(String category);

    List<BikePart> findByStockLessThan(int stock);
}