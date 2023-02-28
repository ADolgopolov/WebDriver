package com.epam.training.student_andrii_dolhopolov.i_can_win.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PastebinPage {
    public static final String PAGE_URL = "https://pastebin.com";
    private final WebDriver driver;
    @FindBy(id = "postform-text")
    protected  WebElement codeTexArea;
    @FindBy(id = "select2-postform-expiration-container")
    protected  WebElement pasteExpirationListBox;
    @FindBy(id = "postform-name")
    protected  WebElement pasteNameInput;
    @FindBy(xpath = "//button[@class='btn -big']")
    protected  WebElement createNewPasteButton;

    public PastebinPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PastebinPage openPage() {
        driver.get(PAGE_URL);
        return this;
    }

    public PastebinPage inputCode(String text) {
        this.codeTexArea.sendKeys(text);
        return this;
    }

    public PastebinPage setPasteExpirationListBox(String pasteExpirationListBox) {
        new Actions(driver)
                .scrollByAmount(0, 500)
                .build()
                .perform();
        this.pasteExpirationListBox.click();
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='" + pasteExpirationListBox + "']")))
                .click();
        return this;
    }

    public PastebinPage inputPasteName(String pasteName) {
        this.pasteNameInput.sendKeys(pasteName);
        return this;
    }

    public String createNewPaste() {
        this.createNewPasteButton.click();
        return driver.getCurrentUrl();
    }
}
