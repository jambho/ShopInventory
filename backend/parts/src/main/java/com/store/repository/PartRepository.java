package com.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.store.model.PartModel;

@Repository
public interface PartRepository extends JpaRepository<PartModel, Long> {
    List<PartModel> findByPartName(String partName);
    List<PartModel> findByPartNumber(String partNumber);
    List<PartModel> findByPartDescription(String partDescription);
    List<PartModel> findByPartPrice(double partPrice);
    
}
