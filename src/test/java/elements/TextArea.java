package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextArea {
    public void write(WebDriver driver, String id, String text) {
            driver.findElement(By.id(id)).clear();
            driver.findElement(By.id(id)).sendKeys(text);
    }
}
