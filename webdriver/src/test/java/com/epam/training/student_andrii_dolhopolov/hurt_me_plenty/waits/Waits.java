package com.epam.training.student_andrii_dolhopolov.hurt_me_plenty.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {
    private final WebDriver driver;
    private static final long WAIT_TIMEOUT_SECONDS = 10;

    public Waits(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement presenceOfElementLocated(By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void invisibilityOf(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).until(ExpectedConditions.invisibilityOf(element));
    }
}
