package splendo.PageObjectCl;

import org.openqa.selenium.By;

public class AddInBatchMode {
    public By moreOptions = By.xpath("//android.widget.ImageView[@content-desc=\"More options\"]");
    public By addInBatchMode = By.xpath(BaseTest.TextView + "[@text='Add in Batch Mode']");
    public By whatIsToBeDone = By.id(BaseTest.app_package_name + "edtTaskName");
}
