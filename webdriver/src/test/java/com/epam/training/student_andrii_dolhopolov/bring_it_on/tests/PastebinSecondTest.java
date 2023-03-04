package com.epam.training.student_andrii_dolhopolov.bring_it_on.tests;

import com.epam.training.student_andrii_dolhopolov.bring_it_on.pages.CreatedPastePage;
import com.epam.training.student_andrii_dolhopolov.bring_it_on.pages.PastebinPage;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PastebinSecondTest {
    private static WebDriver driver;
    private static final String code = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force\n";
    private static final String pasteName = "how to gain dominance among developers";
    private static CreatedPastePage createdPastePage;

    @BeforeClass
    public static void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Start");
        createdPastePage = new PastebinPage(driver)
                .openPage()
                .inputCode(code)
                .setSyntaxHighlighting("Bash")
                .setPasteExpirationListBox("10 Minutes")
                .inputPasteName(pasteName)
                .createNewPaste();
    }

    @Test
    public void browserTitleEqualsPasteNameTest() {
        Assert.assertTrue(createdPastePage.getPageTitle().contains(pasteName));
    }
    @Test
    public void syntaxHighlightingEqualsBashTest() {
        Assert.assertEquals("Bash", createdPastePage.getSyntaxHighlighting());
    }
    @Test
    public void createdPasteCodeEqualsEnteredCodeTest() {
        Assert.assertEquals(code.strip(), createdPastePage.getCreatedPasteCode().strip());
    }

    @AfterClass
    public static void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
