package com.epam.training.student_andrii_dolhopolov.bring_it_on.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
    @FindBy(id = "select2-postform-format-container")
    protected  WebElement syntaxHighlightingListBox;
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

    public PastebinPage setPasteExpirationListBox(String pasteExpirationOption) {
        new Actions(driver)
                .scrollByAmount(0, 500)
                .build()
                .perform();
        this.pasteExpirationListBox.click();
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='" + pasteExpirationOption + "']")))
                .click();
        return this;
    }

    public PastebinPage inputPasteName(String pasteName) {
        this.pasteNameInput.sendKeys(pasteName);
        return this;
    }

    public CreatedPastePage createNewPaste() {
        this.createNewPasteButton.click();
        return new CreatedPastePage(driver);
    }

    public PastebinPage setSyntaxHighlighting(String syntaxHighlightingOption) {
        new Actions(driver)
                .scrollByAmount(0, 500)
                .build()
                .perform();
        this.syntaxHighlightingListBox.click();
        WebElement  searchOptionsEditBox = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='select2-search__field']")));
        searchOptionsEditBox.sendKeys(syntaxHighlightingOption);
        searchOptionsEditBox.sendKeys(Keys.ENTER);
        return this;
    }

}
