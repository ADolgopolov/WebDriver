package com.epam.training.student_andrii_dolhopolov.hurt_me_plenty.test;

import com.epam.training.student_andrii_dolhopolov.hurt_me_plenty.models.CalculatorFormTestData;
import com.epam.training.student_andrii_dolhopolov.hurt_me_plenty.pages.*;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloudGoogleComTest {
    private static WebDriver driver;
    private static CalculatorFormTestData testCalculatorFormData;
    private static CalculatorFormTestData actualCalculatedData;

    @BeforeClass
    public static void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        String searchTerms = "Google Cloud Platform Pricing Calculator";
        testCalculatorFormData = new CalculatorFormTestData().fastSetTestData();

        actualCalculatedData = new CloudGoogleHomePage(driver)
                .openPage()
                .inputSearchTerm(searchTerms)
                .clickLinkWithText(searchTerms)
                .makeCalculationOnPage(testCalculatorFormData);
    }

    @Test
    public void modelVMClassDataMatchesTest() {
        Assert.assertTrue("Actual string:\n'" + actualCalculatedData.getVMClass() + "'"
                        + "\n not contains expected test value: '" + testCalculatorFormData.getVMClass() + "'",
                actualCalculatedData.getVMClass().contains(testCalculatorFormData.getVMClass()));
    }

    @Test
    public void instanceTypeDataMatchesTest() {
        Assert.assertTrue("Actual string:\n'" + actualCalculatedData.getInstanceType() + "'"
                        + "\n not contains expected test value: '" + testCalculatorFormData.getInstanceType() + "'",
                actualCalculatedData.getInstanceType().contains(testCalculatorFormData.getInstanceType()));
    }

    @Test
    public void regionDatacenterLocationDataMatchesTest() {
        Assert.assertTrue("Actual string:\n'" + actualCalculatedData.getRegionDatacenterLocation() + "'"
                        + "\n not contains expected test value: '" + testCalculatorFormData.getRegionDatacenterLocation() + "'",
                actualCalculatedData.getRegionDatacenterLocation().contains(testCalculatorFormData.getRegionDatacenterLocation()));
    }
    @Test
    public void localSSDDataMatchesTest() {
        Assert.assertTrue("Actual string:\n'" + actualCalculatedData.getLocalSSD() + "'"
                        + "\n not contains expected test value: '" + testCalculatorFormData.getLocalSSD() + "'",
                actualCalculatedData.getLocalSSD().contains(testCalculatorFormData.getLocalSSD()));
    }
    @Test
    public void committedUsageDataMatchesTest() {
        Assert.assertTrue("Actual string:\n'" + actualCalculatedData.getCommittedUsage() + "'"
                        + "\n not contains expected test value: '" + testCalculatorFormData.getCommittedUsage() + "'",
                actualCalculatedData.getCommittedUsage().contains(testCalculatorFormData.getCommittedUsage()));
    }
    @Test
    public void estimatedComponentCostPerMonthMatchesTest() {
        Assert.assertTrue("Actual string:\n'" + actualCalculatedData.getEstimatedComponentCostPerMonth() + "'"
                        + "\n not contains expected test value: '" + testCalculatorFormData.getEstimatedComponentCostPerMonth() + "'",
                actualCalculatedData.getEstimatedComponentCostPerMonth().contains(testCalculatorFormData.getEstimatedComponentCostPerMonth()));
    }

    @AfterClass
    public static void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
