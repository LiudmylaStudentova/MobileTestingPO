package splendo.PageObjectCl;

import org.openqa.selenium.By;

public class PersonalListPage {
    public By PersonalMenuItem = By.xpath(BaseTest.TextView + "[@text='Personal']");
    public By taskInputPersonal = By.id(BaseTest.app_package_name + "edtTaskName");
}
