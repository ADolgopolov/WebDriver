package com.epam.training.student_andrii_dolhopolov.hardcore.pages;

import com.epam.training.student_andrii_dolhopolov.hardcore.models.CalculatorFormTestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CloudGooglePricingCalculatorPage extends AbstractPage {

    private final By mainFrame = By.xpath("//*[@id='cloud-site']/devsite-iframe/iframe");
    private final By innerFrame = By.id("myFrame");
    private final By GPUTypeDropdown = By.xpath("//md-select[contains(@aria-label, 'GPU type')]");
    @FindBy(name = "quantity")
    protected WebElement inputNumberOfInstances;
    @FindBy(xpath = "//md-select[contains(@aria-label, 'Operating System')]")
    protected WebElement operatingSystemDropdown;
    @FindBy(xpath = "//md-select[contains(@aria-label, 'VM Class')]")
    protected WebElement VMClassDropdown;
    @FindBy(xpath = "//md-select[contains(@aria-label, 'Series')]")
    protected WebElement instanceSeriesDropdown;
    @FindBy(xpath = "//md-select[contains(@aria-label, 'Instance type')]")
    protected WebElement instanceTypeDropdown;
    @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']/div[contains(@class, 'md-container')]")
    protected WebElement addGPUsCheckBox;
    @FindBy(xpath = "//md-select[contains(@aria-label, 'Number of GPUs')]")
    protected WebElement numberOfGPUsDropdown;
    @FindBy(xpath = "//form[@name='ComputeEngineForm']//md-select[contains(@aria-label, 'Local SSD')]")
    protected WebElement localSSDDropdown;
    @FindBy(xpath = "//form[@name='ComputeEngineForm']//md-select[contains(@aria-label, 'Datacenter location')]")
    protected WebElement datacenterLocationDropdown;
    @FindBy(xpath = "//form[@name='ComputeEngineForm']//md-select[contains(@aria-label, 'Committed usage')]")
    protected WebElement committedUsageDropdown;
    @FindBy(xpath = "//form[@name='ComputeEngineForm']/div/button")
    protected WebElement addToEstimateButton;
    @FindBy(xpath = "//button[@id='Email Estimate']")
    protected WebElement emailEstimateButton;

    public CloudGooglePricingCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public CloudGooglePricingCalculatorPage switchToInnerFrame() {
        driver.switchTo().frame(waitPresenceOfElementLocated(mainFrame));
        driver.switchTo().frame(waitPresenceOfElementLocated(innerFrame));
        return this;
    }

    public CalculatorFormTestData makeCalculationOnPage(CalculatorFormTestData calculatorFormData) {
        return switchToInnerFrame()
                .selectProductName(calculatorFormData.getProductName())
                .setNumberOfInstances(calculatorFormData.getNumberOfInstances())
                .selectOperatingSystem(calculatorFormData.getOperationSystem())
                .selectVMClass(calculatorFormData.getVMClass())
                .selectInstanceSeries(calculatorFormData.getInstanceSeries())
                .selectInstanceType(calculatorFormData.getInstanceType())
                .selectAddGPUsCheckBox()
                .selectGPUType(calculatorFormData.getGPUType())
                .selectNumberOfGPUs(calculatorFormData.getNumberOfGPUs())
                .selectLocalSSD(calculatorFormData.getLocalSSD())
                .selectDatacenterLocation(calculatorFormData.getRegionDatacenterLocation())
                .selectCommittedUsageTime(calculatorFormData.getCommittedUsage())
                .clickAddToEstimateButton()
                .returnActualCalculatedData();
    }

    public CloudGooglePricingCalculatorPage selectProductName(String productName) {
        waitPresenceOfElementLocated(By.xpath(String.format("//md-tab-item[normalize-space()='%s']", productName)))
                .click();
        return this;
    }

    public CloudGooglePricingCalculatorPage setNumberOfInstances(String numberOfInstances) {
        inputNumberOfInstances.sendKeys(numberOfInstances);
        return this;
    }

    public CloudGooglePricingCalculatorPage selectOperatingSystem(String operatingSystem) {
        operatingSystemDropdown.click();
        selectDropdownOption(operatingSystem);
        return this;
    }

    public CloudGooglePricingCalculatorPage selectVMClass(String VMClass) {
        VMClassDropdown.click();
        selectDropdownOption(VMClass);
        return this;
    }

    public CloudGooglePricingCalculatorPage selectInstanceSeries(String series) {
        instanceSeriesDropdown.click();
        selectDropdownOption(series);
        return this;
    }

    public CloudGooglePricingCalculatorPage selectInstanceType(String instanceType) {
        instanceTypeDropdown.click();
        selectDropdownOption(instanceType);
        return this;
    }

    public CloudGooglePricingCalculatorPage selectAddGPUsCheckBox() {
        addGPUsCheckBox.click();
        return this;
    }

    public CloudGooglePricingCalculatorPage selectGPUType(String GPUType) {
        waitPresenceOfElementLocated(GPUTypeDropdown).click();
        selectDropdownOption(GPUType);
        return this;
    }

    public CloudGooglePricingCalculatorPage selectNumberOfGPUs(String numberOfGPUs) {
        numberOfGPUsDropdown.click();
        selectDropdownOption(numberOfGPUs);
        return this;
    }

    public CloudGooglePricingCalculatorPage selectLocalSSD(String localSSD) {
        localSSDDropdown.click();
        selectDropdownOption(localSSD);
        return this;
    }

    public CloudGooglePricingCalculatorPage selectDatacenterLocation(String datacenterLocation) {
        datacenterLocationDropdown.click();
        selectDropdownOption(datacenterLocation);
        return this;
    }

    public CloudGooglePricingCalculatorPage selectCommittedUsageTime(String committedUsage) {
        committedUsageDropdown.click();
        selectDropdownOption(committedUsage);
        return this;
    }

    public CloudGooglePricingCalculatorPage clickAddToEstimateButton() {
        addToEstimateButton.click();
        return this;
    }

    public CalculatorFormTestData returnActualCalculatedData() {
        CalculatorFormTestData actualCalculatedData = new CalculatorFormTestData();
        actualCalculatedData.setVMClass(waitPresenceOfElementLocated(By.xpath("//md-list-item[4]")).getText());
        actualCalculatedData.setInstanceType(waitPresenceOfElementLocated(By.xpath("//md-list-item[5]")).getText());
        actualCalculatedData.setRegionDatacenterLocation(waitPresenceOfElementLocated(By.xpath("//md-list-item[1]")).getText());
        actualCalculatedData.setLocalSSD(waitPresenceOfElementLocated(By.xpath("//md-list-item[8]")).getText());
        actualCalculatedData.setCommittedUsage(waitPresenceOfElementLocated(By.xpath("//md-list-item[3]")).getText());
        actualCalculatedData.setEstimatedComponentCostPerMonth(waitPresenceOfElementLocated(By.xpath("//md-list-item[9]")).getText());
        return actualCalculatedData;
    }

    public SendEmailEstimateForm emailEstimate() {
        scrollToElement(waitVisibilityOf(emailEstimateButton)).click();
        return new SendEmailEstimateForm(driver);
    }
}
