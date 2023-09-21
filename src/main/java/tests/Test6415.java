package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class Test6415 implements HtmlTest {

    @Override
    public boolean execute(WebDriver driver) {

        try {
            Thread.sleep(1000);
            driver.findElement(By.tagName("h1"));
            return false;  // h1 태그가 존재하면 true 반환
        } catch (Exception e) {
            return true;  // h1 태그가 존재하지 않으면 false 반환
        }
    }
}
