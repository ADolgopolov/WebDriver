package com.epam.training.student_andrii_dolhopolov.i_can_win.test;

import com.epam.training.student_andrii_dolhopolov.i_can_win.pages.PastebinPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PastebinFirstTest {
    private WebDriver driver;

    @Before
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void pastebinTest() {
        String createdLink = new PastebinPage(driver)
                .openPage()
                .inputCode("Hello from WebDriver")
                .setPasteExpirationListBox("10 Minutes")
                .inputPasteName("helloweb")
                .createNewPaste();
        System.out.println(createdLink);
        System.out.println(PastebinPage.PAGE_URL);
        Assert.assertNotEquals(createdLink, PastebinPage.PAGE_URL);
    }

    @After
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
