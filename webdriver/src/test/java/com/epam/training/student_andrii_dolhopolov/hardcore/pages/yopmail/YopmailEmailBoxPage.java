package com.epam.training.student_andrii_dolhopolov.hardcore.pages.yopmail;

import com.epam.training.student_andrii_dolhopolov.hardcore.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YopmailEmailBoxPage extends AbstractPage {
    private final By eMailFrame = By.id("ifmail");
    private final By priceString = By.xpath("(//h3)[2]");

    public YopmailEmailBoxPage(WebDriver driver) {
        super(driver);
    }

    public String getPrice() {

        driver.navigate().refresh();
        driver.switchTo().frame(waitDocumentLocated(eMailFrame));
        return waitVisibilityOfElementLocated(priceString).getText();
    }
}
