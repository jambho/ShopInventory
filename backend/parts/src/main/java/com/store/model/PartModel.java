package com.store.model;

import jakarta.persistence.*;

@Entity
@Table(name = "parts")
public class PartModel {
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String partName;

    private String partNumber;

    private String partDescription;

    private double partPrice;

    public PartModel() {
    }

    public PartModel(String partName, String partNumber, String partDescription, double partPrice) {
        this.partName = partName;
        this.partNumber = partNumber;
        this.partDescription = partDescription;
        this.partPrice = partPrice;
    }

    public Long getId() {
        return id;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getPartDescription() {
        return partDescription;
    }

    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }

    public double getPartPrice() {
        return partPrice;
    }

    public void setPartPrice(double partPrice) {
        this.partPrice = partPrice;
    }

    @Override
    public String toString() {
        return "PartModel [id=" + id + ", partDescription=" + partDescription + ", partName=" + partName + ", partNumber="
                + partNumber + ", partPrice=" + partPrice + "]";
    }
}
