package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

@Log4j2
public class Dropdown {

    public static void selectOption(WebDriver driver, String id, String text) {
        log.info("Selecting  '" + text + "' option from dropdown with id = " + id);
        Select select = new Select(driver.findElement(By.id(id)));
        select.selectByVisibleText(text);
    }
}
