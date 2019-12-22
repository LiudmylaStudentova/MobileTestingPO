package splendo.PageObjectCl;

import org.openqa.selenium.By;

public class TaskListScreenPage {
    // Task List Screen
    public static By taskName = By.id(BaseTest.app_package_name + "task_name");
    public By taskCheckBox = By.id(BaseTest.app_package_name + "checkDone");
    public By toolBar = By.id(BaseTest.app_package_name + "spinnerToolbar");
    public By finishedMenuItem = By.xpath(BaseTest.TextView + "[@text='Finished']");

    public By quickTask = By.id(BaseTest.app_package_name + "etQuickTask");
    public By doneButtonForQuickTask = By.id(BaseTest.app_package_name + "ivAddQuickTask");
    public By allListsMenuItem = By.xpath(BaseTest.TextView + "[@text='All Lists']");
    public By listMain = By.id(BaseTest.app_package_name + "listMain");
}
