package com.epam.training.student_andrii_dolhopolov.hardcore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SendEmailEstimateForm extends AbstractPage {
    protected SendEmailEstimateForm(WebDriver driver) {
        super(driver);
    }

    private final By emailField = By.xpath("//input[@type='email']");
    private final By sendMailButton = By.xpath("//button[normalize-space()='Send Email']");

    public void sendEmailTo(String emailAddress) {
        scrollToElement(waitVisibilityOfElementLocated(emailField)).sendKeys(emailAddress);
        waitElementToBeClickable(sendMailButton).click();
    }
}
