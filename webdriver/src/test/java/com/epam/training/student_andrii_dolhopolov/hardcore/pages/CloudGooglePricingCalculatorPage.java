package com.epam.training.student_andrii_dolhopolov.hardcore.pages;

import com.epam.training.student_andrii_dolhopolov.hardcore.models.CalculatorFormTestData;
import com.epam.training.student_andrii_dolhopolov.hardcore.waits.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CloudGooglePricingCalculatorPage extends AbstractPage {

    private final By mainFrame = By.xpath("//*[@id='cloud-site']/devsite-iframe/iframe");
    private final By innerFrame = By.id("myFrame");
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
    private final Waits wait;

    public CloudGooglePricingCalculatorPage(WebDriver driver) {
        super(driver);
        wait = new Waits(driver);
    }

    public void switchToInnerFrame() {
        driver.switchTo().frame(wait.presenceOfElementLocated(mainFrame));
        driver.switchTo().frame(wait.presenceOfElementLocated(innerFrame));
    }
    public CalculatorFormTestData makeCalculationOnPage(CalculatorFormTestData calculatorFormData) {
        switchToInnerFrame();
        selectProductName(calculatorFormData.getProductName());
        inputNumberOfInstances.sendKeys(calculatorFormData.getNumberOfInstances());
        selectOperatingSystem(calculatorFormData.getOperationSystem());
        selectVMClass(calculatorFormData.getVMClass());
        selectInstanceSeries(calculatorFormData.getInstanceSeries());
        selectInstanceType(calculatorFormData.getInstanceType());
        scrollToElement(addGPUsCheckBox).click();
        selectGPUType(calculatorFormData.getGPUType());
        selectNumberOfGPUs(calculatorFormData.getNumberOfGPUs());
        selectLocalSSD(calculatorFormData.getLocalSSD());
        selectDatacenterLocation(calculatorFormData.getRegionDatacenterLocation());
        selectCommittedUsageTime(calculatorFormData.getCommittedUsage());
        scrollToElement(addToEstimateButton).click();
        return returnActualCalculatedData();
    }

    protected void selectDropdownOption(String option) {
        WebElement dropdownOption =
                wait.presenceOfElementLocated(By.xpath(String.format("//div[contains(@class, 'md-active')]//md-option/div[contains(text(), '%s')]", option)));
        dropdownOption.click();
        wait.invisibilityOf(dropdownOption);
    }

    protected void selectProductName(String productName) {
        wait.presenceOfElementLocated(By.xpath(String.format("//md-tab-item[normalize-space()='%s']", productName)))
                .click();
    }

    protected void selectOperatingSystem(String operatingSystem) {
        scrollToElement(operatingSystemDropdown).click();
        selectDropdownOption(operatingSystem);
    }

    protected void selectVMClass(String VMClass) {
        scrollToElement(VMClassDropdown).click();
        selectDropdownOption(VMClass);
    }

    protected void selectInstanceSeries(String series) {
        scrollToElement(instanceSeriesDropdown).click();
        selectDropdownOption(series);
    }

    protected void selectInstanceType(String instanceType) {
        scrollToElement(instanceTypeDropdown).click();
        selectDropdownOption(instanceType);
    }

    protected void selectGPUType(String GPUType) {
        scrollToElement(wait.presenceOfElementLocated(By.xpath("//md-select[contains(@aria-label, 'GPU type')]"))).click();
        selectDropdownOption(GPUType);
    }

    protected void selectNumberOfGPUs(String numberOfGPUs) {
        scrollToElement(numberOfGPUsDropdown).click();
        selectDropdownOption(numberOfGPUs);
    }

    protected void selectLocalSSD(String localSSD) {
        scrollToElement(localSSDDropdown).click();
        selectDropdownOption(localSSD);
    }

    protected void selectDatacenterLocation(String datacenterLocation) {
        scrollToElement(datacenterLocationDropdown).click();
        selectDropdownOption(datacenterLocation);
    }

    protected void selectCommittedUsageTime(String committedUsage) {
        scrollToElement(committedUsageDropdown).click();
        selectDropdownOption(committedUsage);
    }

    private CalculatorFormTestData returnActualCalculatedData() {
        CalculatorFormTestData actualCalculatedData = new CalculatorFormTestData();
        actualCalculatedData.setVMClass(wait.presenceOfElementLocated(By.xpath("//md-list-item[4]")).getText());
        actualCalculatedData.setInstanceType(wait.presenceOfElementLocated(By.xpath("//md-list-item[5]")).getText());
        actualCalculatedData.setRegionDatacenterLocation(wait.presenceOfElementLocated(By.xpath("//md-list-item[1]")).getText());
        actualCalculatedData.setLocalSSD(wait.presenceOfElementLocated(By.xpath("//md-list-item[8]")).getText());
        actualCalculatedData.setCommittedUsage(wait.presenceOfElementLocated(By.xpath("//md-list-item[3]")).getText());
        actualCalculatedData.setEstimatedComponentCostPerMonth(wait.presenceOfElementLocated(By.xpath("//md-list-item[9]")).getText());
        return actualCalculatedData;
    }

    public SendEmailEstimateForm emailEstimate() {
        scrollToElement(waitVisibilityOf(emailEstimateButton)).click();
        return new SendEmailEstimateForm(driver);
    }
}
