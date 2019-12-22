package splendo.test;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import splendo.PageObjectCl.AddInBatchMode;
import splendo.PageObjectCl.HomeScreenPage;
import splendo.PageObjectCl.PersonalListPage;
import splendo.PageObjectCl.TaskListScreenPage;

import java.util.concurrent.TimeUnit;


public class AppiumTest extends AndroidSetup {
    //String app_package_name = "com.splendapps.splendo:id/";
    //String TextView = "//android.widget.TextView";
    // Home Screen
    // Task List Screen
    //Add in Batch Mode
    //PersonalList

    HomeScreenPage HomeScreen = new HomeScreenPage(driver);
    TaskListScreenPage TaskListScreen = new TaskListScreenPage();
    AddInBatchMode AddInBatchMode = new AddInBatchMode();
    PersonalListPage PersonalList = new PersonalListPage();

    @Test(priority = 1)
    public void showTest()  {

        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        HomeScreen.addFirstTaskButtonclick();
        HomeScreen.taskInputSendKey();
        HomeScreen.dueDateClick();
        HomeScreen.doneButtonClick();
        HomeScreen.dueTimeClick();
        HomeScreen.doneButtonClick();
        HomeScreen.repeatButtonClick();
        HomeScreen.repeatButtonOnceAWeekClick();
        HomeScreen.addToListButtonClick();
        HomeScreen.addToListButtonPersonalClick();
        HomeScreen.saveTaskclick();

        wait.until(ExpectedConditions.presenceOfElementLocated(TaskListScreen.taskName));

        assert driver.findElement(TaskListScreen.taskName).isDisplayed();
    }

    // Complete task
    @Test(priority = 2)
    public void completeTask() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(TaskListScreen.taskCheckBox).click();

        driver.findElement(HomeScreen.popUpReapeatTaskNo).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(TaskListScreen.toolBar));

        driver.findElement(TaskListScreen.toolBar).click();

        driver.findElement(TaskListScreen.finishedMenuItem).click();

        assert driver.findElement(TaskListScreen.taskName).isDisplayed();
    }

    @Test(priority = 3)
    public void addQuickTask() throws InterruptedException {
        driver.findElement(TaskListScreen.toolBar).click();

        driver.findElement(TaskListScreen.allListsMenuItem).click();

        driver.findElement(TaskListScreen.quickTask).click();

        driver.findElement(TaskListScreen.quickTask).sendKeys("test task");

        driver.findElement(TaskListScreen.doneButtonForQuickTask).click();

        assert driver.findElement(TaskListScreen.taskName).isDisplayed();
    }

    @Test(priority = 4)
    public void addInBatchMode() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(AddInBatchMode.moreOptions).click();

        driver.findElement(AddInBatchMode.addInBatchMode).click();

        driver.findElement(AddInBatchMode.whatIsToBeDone).sendKeys("test task done");

        driver.findElement(HomeScreen.dueDate).click();

        driver.findElement(HomeScreen.doneButton).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(HomeScreen.saveTask));

        driver.findElement(HomeScreen.saveTask).click();

        assert driver.findElement(TaskListScreen.taskName).isDisplayed();


        driver.findElement(TaskListScreen.taskCheckBox).click();

        assert driver.findElement(TaskListScreen.listMain).isDisplayed();
    }

    @Test(priority = 5)
    public void addTaskToPersonalListTest() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(TaskListScreen.allListsMenuItem).click();

        driver.findElement(PersonalList.PersonalMenuItem).click();

        driver.findElement(HomeScreen.addNewTaskButton).click();

        driver.findElement(PersonalList.taskInputPersonal).sendKeys("Do massage");

        driver.findElement(HomeScreen.dueDate).click();

        driver.findElement(HomeScreen.doneButton).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(HomeScreen.saveTask));

        driver.findElement(HomeScreen.saveTask).click();

        assert driver.findElement(TaskListScreen.taskName).isDisplayed();

        driver.findElement(TaskListScreen.taskCheckBox).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(TaskListScreen.toolBar));


        driver.findElement(TaskListScreen.toolBar).click();

        driver.findElement(TaskListScreen.finishedMenuItem).click();

        assert driver.findElement(TaskListScreen.taskName).isDisplayed();
    }
}