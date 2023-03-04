package com.epam.training.student_andrii_dolhopolov.hurt_me_plenty.models;

public class CalculatorFormTestData {
    private String productName;
    private String numberOfInstances;
    private String operationSystem;
    private String VMClass;
    private String instanceSeries;
    private String instanceType;
    private String numberOfGPUs;
    private String GPUType;
    private String localSSD;
    private String regionDatacenterLocation;
    private String committedUsage;
    private String estimatedComponentCostPerMonth;

    public CalculatorFormTestData() {
    }

    public CalculatorFormTestData fastSetTestData() {
        productName = "Compute Engine";
        numberOfInstances = "4";
        operationSystem = "Free"; //Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS
        VMClass = "Regular";
        instanceSeries = "N1";
        instanceType = "n1-standard-8";
        numberOfGPUs = "1";
        GPUType = "NVIDIA Tesla P100"; //not available "NVIDIA Tesla V100" on Location Frankfurt;
        localSSD = "2x375";
        regionDatacenterLocation = "Frankfurt";
        committedUsage = "1 Year";
        estimatedComponentCostPerMonth = "4,024.56";
        return this;
    }

    public String getProductName() {
        return productName;
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public String getOperationSystem() {
        return operationSystem;
    }

    public String getVMClass() {
        return VMClass;
    }

    public void setVMClass(String VMClass) {
        this.VMClass = VMClass;
    }

    public String getInstanceSeries() {
        return instanceSeries;
    }

    public String getInstanceType() {
        return instanceType;
    }

    public void setInstanceType(String instanceType) {
        this.instanceType = instanceType;
    }

    public String getNumberOfGPUs() {
        return numberOfGPUs;
    }

    public String getGPUType() {
        return GPUType;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public void setLocalSSD(String localSSD) {
        this.localSSD = localSSD;
    }

    public String getRegionDatacenterLocation() {
        return regionDatacenterLocation;
    }

    public void setRegionDatacenterLocation(String regionDatacenterLocation) {
        this.regionDatacenterLocation = regionDatacenterLocation;
    }

    public String getCommittedUsage() {
        return committedUsage;
    }

    public void setCommittedUsage(String committedUsage) {
        this.committedUsage = committedUsage;
    }

    public String getEstimatedComponentCostPerMonth() {
        return estimatedComponentCostPerMonth;
    }

    public void setEstimatedComponentCostPerMonth(String estimatedComponentCostPerMonth) {
        this.estimatedComponentCostPerMonth = estimatedComponentCostPerMonth;
    }
}