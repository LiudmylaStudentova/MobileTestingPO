package splendo.PageObjectCl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddInBatchMode {
    WebDriver driver;

    public By moreOptions = By.xpath("//android.widget.ImageView[@content-desc=\"More options\"]");
    public By addInBatchMode = By.xpath(BaseTest.TextView + "[@text='Add in Batch Mode']");
    public By whatIsToBeDone = By.id(BaseTest.app_package_name + "edtTaskName");

    public AddInBatchMode(WebDriver driver){this.driver = driver;}
    public void moreOptionsClick () {driver.findElement(moreOptions).click();}
    public void addInBatchModeClick(){driver.findElement(addInBatchMode).click();}
    public void whatIsToBeDoneSK(){driver.findElement(whatIsToBeDone).sendKeys("test task done");}
    }

