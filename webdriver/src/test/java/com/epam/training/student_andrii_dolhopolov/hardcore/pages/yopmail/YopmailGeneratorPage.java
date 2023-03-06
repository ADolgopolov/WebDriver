package com.epam.training.student_andrii_dolhopolov.hardcore.pages.yopmail;

import com.epam.training.student_andrii_dolhopolov.hardcore.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YopmailGeneratorPage extends AbstractPage {
    public YopmailGeneratorPage(WebDriver driver) {
        super(driver);
    }
    private final By emailField = By.xpath("//div[@id='geny']");
    private final By checkEmailButton = By.xpath("//button[@onclick='egengo();']");

    public String getEmailAddress(){
        return waitVisibilityOfElementLocated(emailField).getText();
    }
    public YopmailEmailBoxPage pressCheckEmailButton() {
        waitVisibilityOfElementLocated(checkEmailButton).click();
        return new YopmailEmailBoxPage(driver);
    }
}
