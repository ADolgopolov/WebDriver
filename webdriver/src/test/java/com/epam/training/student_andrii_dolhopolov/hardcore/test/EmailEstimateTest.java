package com.epam.training.student_andrii_dolhopolov.hardcore.test;

import com.epam.training.student_andrii_dolhopolov.hardcore.models.CalculatorFormTestData;
import com.epam.training.student_andrii_dolhopolov.hardcore.pages.*;
import com.epam.training.student_andrii_dolhopolov.hardcore.pages.yopmail.YopmailGeneratorPage;
import com.epam.training.student_andrii_dolhopolov.hardcore.pages.yopmail.YopmailHomePage;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class EmailEstimateTest {
    private static WebDriver driver;

    @BeforeClass
    public static void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void emailEstimatedCostTest() {
        String searchTerms = "Google Cloud Platform Pricing Calculator";

        CalculatorFormTestData testCalculatorFormData = new CalculatorFormTestData().fastSetTestData();
        CloudGooglePricingCalculatorPage calculatorPage = new CloudGoogleHomePage(driver)
                .openPage()
                .inputSearchTerm(searchTerms)
                .clickLinkWithText(searchTerms);
        CalculatorFormTestData actualCalculatedData = calculatorPage.makeCalculationOnPage(testCalculatorFormData);
        SendEmailEstimateForm sendEmailEstimateForm = calculatorPage.emailEstimate();
        String googleCalculatorWindow = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);
        YopmailGeneratorPage yopmailPage = new YopmailHomePage(driver)
                .openPage()
                .generateEmailAddress();
        String generatedEmailAddress = yopmailPage.getEmailAddress();
        String yopmailWindow = driver.getWindowHandle();

        driver.switchTo().window(googleCalculatorWindow);
        calculatorPage.switchToInnerFrame();
        sendEmailEstimateForm.sendEmailTo(generatedEmailAddress);

        driver.switchTo().window(yopmailWindow);
        String emailEstimatedComponentCostPerMonth = yopmailPage.pressCheckEmailButton().getPrice();

        Assert.assertTrue("\nActual estimated component cost per month in E-mail:\n'" + emailEstimatedComponentCostPerMonth + "'"
                        + "\n not equal expected value calculated on website: '" + actualCalculatedData.getEstimatedComponentCostPerMonth() + "'",
                actualCalculatedData.getEstimatedComponentCostPerMonth().contains(emailEstimatedComponentCostPerMonth));
    }

    @AfterClass
    public static void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
