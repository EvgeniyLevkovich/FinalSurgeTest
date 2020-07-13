package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class TextArea {
    public void write(WebDriver driver, String id, String text) {
            log.info("Filling in field with id = " + id + " with text: " + text);
            driver.findElement(By.id(id)).clear();
            driver.findElement(By.id(id)).sendKeys(text);
    }
}
