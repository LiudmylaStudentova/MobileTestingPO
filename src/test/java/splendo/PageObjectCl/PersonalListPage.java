package splendo.PageObjectCl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalListPage {
    WebDriver driver;
    public By PersonalMenuItem = By.xpath(BaseTest.TextView + "[@text='Personal']");
    public By taskInputPersonal = By.id(BaseTest.app_package_name + "edtTaskName");

    public PersonalListPage(WebDriver driver) {
        this.driver = driver;
    }
    public void  personalMenuItemClick(){driver.findElement(PersonalMenuItem).click();}
    public void taskInputPersonalSK(){driver.findElement(taskInputPersonal).sendKeys("Do massage");}
}
