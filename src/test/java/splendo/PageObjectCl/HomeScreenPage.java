package splendo.PageObjectCl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeScreenPage {
    WebDriver driver;
    public By addFirstTaskButton = By.id(BaseTest.app_package_name + "imgFirstTask");
    public By addNewTaskButton = By.id(BaseTest.app_package_name + "ivFAB_AddTask");
    public By taskInput = By.id(BaseTest.app_package_name + "edtTaskName");
    public By dueDate = By.id(BaseTest.app_package_name + "edtDueD");
    public By dueTime = By.id(BaseTest.app_package_name + "edtDueT");
    public By saveTask = By.id(BaseTest.app_package_name + "action_save_task");
    public By doneButton = By.id("android:id/button1");
    public By repeatButton = By.id(BaseTest.app_package_name + "spinnerRepeat");
    public By repeatButtonOnceAWeek = By.xpath(BaseTest.TextView + "[@text='Once a Week']");
    public By addToListButton = By.id(BaseTest.app_package_name + "spinnerLists");
    public By addToListButtonPersonal = By.xpath(BaseTest.TextView + "[@text='Personal']");
    public By popUpReapeatTaskNo = By.id("android:id/button2");

    public HomeScreenPage(WebDriver driver) {
        this.driver = driver;
    }
    public void addFirstTaskButtonclick(){
        driver.findElement(addFirstTaskButton).click();
    }
    public void taskInputSendKey(){
        driver.findElement(taskInput).sendKeys("test task");
    }
    public void dueDateClick(){
        driver.findElement(dueDate).click();
    }
    public void doneButtonClick(){
        driver.findElement(doneButton).click();
    }
    public void dueTimeClick(){
        driver.findElement(dueTime).click();
    }
    public void repeatButtonClick(){
        driver.findElement(repeatButton).click();
    }
    public void  repeatButtonOnceAWeekClick(){
        driver.findElement(repeatButtonOnceAWeek).click();
    }
    public void  addToListButtonClick(){
        driver.findElement(addToListButton).click();
    }
    public void  addToListButtonPersonalClick(){
        driver.findElement(addToListButtonPersonal).click();
    }
    public void saveTaskclick(){
        driver.findElement(saveTask).click();
    }
    public void popUpReapeatTaskNoClick(){
        driver.findElement(popUpReapeatTaskNo).click();
    }
}


