package splendo.test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import splendo.PageObjectCl.*;

import java.util.concurrent.TimeUnit;


public class AppiumTest extends AndroidSetup {
    //String app_package_name = "com.splendapps.splendo:id/";
    //String TextView = "//android.widget.TextView";
    // Home Screen
    // Task List Screen
    //Add in Batch Mode

    //PersonalList

    HomeScreenPage HomeScreen;
    TaskListScreenPage TaskListScreen;
    AddInBatchMode AddInBatchMode;
    PersonalListPage PersonalList;

    @Test(priority = 1)
    public void showTest() {

        HomeScreen = new HomeScreenPage(driver);
        TaskListScreen = new TaskListScreenPage(driver);
        AddInBatchMode = new AddInBatchMode(driver);
        PersonalList = new PersonalListPage(driver);

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
        TaskListScreen.taskCheckBoxCkick();
        HomeScreen.popUpReapeatTaskNoClick();
        wait.until(ExpectedConditions.presenceOfElementLocated(TaskListScreen.toolBar));
        TaskListScreen.toolBarClick();
        TaskListScreen.finishedMenuItemClick();
        assert driver.findElement(TaskListScreen.taskName).isDisplayed();
    }

    @Test(priority = 3)
    public void addQuickTask() throws InterruptedException {
        TaskListScreen.toolBarClick();
        TaskListScreen.allListsMenuItemClick();
        TaskListScreen.quickTaskClick();
        TaskListScreen.quickTaskClickSK();
        TaskListScreen.doneButtonForQuickTaskClick();
        assert driver.findElement(TaskListScreen.taskName).isDisplayed();
    }

    @Test(priority = 4)
    public void addInBatchMode() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        AddInBatchMode.moreOptionsClick();
        AddInBatchMode.addInBatchModeClick();
        AddInBatchMode.whatIsToBeDoneSK();
        HomeScreen.dueDateClick();
        HomeScreen.doneButtonClick();
        wait.until(ExpectedConditions.presenceOfElementLocated(HomeScreen.saveTask));
        HomeScreen.saveTaskclick();
        assert driver.findElement(TaskListScreen.taskName).isDisplayed();
        TaskListScreen.taskCheckBoxCkick();
        assert driver.findElement(TaskListScreen.listMain).isDisplayed();
    }

    @Test(priority = 5)
    public void addTaskToPersonalListTest() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        TaskListScreen.allListsMenuItemClick();
        PersonalList.personalMenuItemClick();
        HomeScreen.addNewTaskButtonClick();
        PersonalList.taskInputPersonalSK();
        HomeScreen.dueDateClick();
        HomeScreen.doneButtonClick();
        wait.until(ExpectedConditions.presenceOfElementLocated(HomeScreen.saveTask));
        HomeScreen.saveTaskclick();
        assert driver.findElement(TaskListScreen.taskName).isDisplayed();
        TaskListScreen.taskCheckBoxCkick();
        wait.until(ExpectedConditions.presenceOfElementLocated(TaskListScreen.toolBar));
        TaskListScreen.toolBarClick();
        TaskListScreen.finishedMenuItemClick();
        assert driver.findElement(TaskListScreen.taskName).isDisplayed();
    }
}