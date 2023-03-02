package com.epam.training.student_andrii_dolhopolov.bring_it_on.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatedPastePage {
    private final WebDriver driver;
    @FindBy(xpath = "//*[@class='bash']")
    protected WebElement pastedCode;
    @FindBy(xpath = "//div[@class='left']/a[@class='btn -small h_800']")
    protected WebElement codeSyntaxHighlighting;
    public CreatedPastePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String getPageTitle() {
        return driver.getTitle();
    }
    public String getSyntaxHighlighting() {
        return codeSyntaxHighlighting.getText();
    }

    public String getCreatedPasteCode() {
        return pastedCode.getText();
    }
}
