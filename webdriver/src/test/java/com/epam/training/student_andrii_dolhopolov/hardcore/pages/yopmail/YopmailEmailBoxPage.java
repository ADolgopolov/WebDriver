package com.epam.training.student_andrii_dolhopolov.hardcore.pages.yopmail;

import com.epam.training.student_andrii_dolhopolov.hardcore.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YopmailEmailBoxPage extends AbstractPage {
    @FindBy(id = "ifmail")
    protected WebElement eMailFrame;
    @FindBy(xpath = "(//h3)[2]")
    protected WebElement priceString;
    @FindBy(id = "nbmail")
    protected WebElement mailsAmountLabel;

    public YopmailEmailBoxPage(WebDriver driver) {
        super(driver);
    }

    public String getPrice() {
        for (int i = 0; i < 10; i++) {
            if (waitVisibilityOf(mailsAmountLabel).getText().contains("0 mail")) {
                driver.navigate().refresh();
            } else {
                break;
            }
        }
        driver.switchTo().frame(waitVisibilityOf(eMailFrame));
        return waitVisibilityOf(priceString).getText();
    }
}
