package com.bm.pages;

import com.cc.utils.*;
import io.appium.java_client.*;
//import io.github.bonigarcia.wdm.WebDriverManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.appmanagement.BaseOptions;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.SupportsContextSwitching;
import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import com.cc.utils.DriverManager;
import com.cc.utils.GlobalParams;
import com.cc.utils.LoggerManager;

import static io.appium.java_client.touch.offset.PointOption.point;

public class BasePage {
    public WebDriver driver;
    LoggerManager utils = new LoggerManager();


    //initializing constructor

    public BasePage(){
        this.driver = new DriverManager().getDriver();
      //  PageFactory.initElements(driver, this);

        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);  //back


    }

    public void takeScreenshotAllure() {
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

    public void sendKeys(WebElement e, String txt, String msg) {
//        waitForVisibility(WebElement e);
        utils.log().info(msg);
        e.sendKeys(txt);
    }


//    public void switchContext() throws InterruptedException {
//      AppiumDriver appiumDriver = (AppiumDriver) driver;
//        Thread.sleep(2000);
  //      appiumDriver.context("WEBVIEW_chrome");
//        utils.log().info("Switched to Webview");
//    }

    protected boolean switchToWebContext() throws MalformedURLException, InterruptedException {
        Thread.sleep(5000);
        AppiumDriver appiumDriver = (AppiumDriver) driver;
       // UiAutomator2Options options = new UiAutomator2Options().setAutoGrantPermissions(true);
//        AppiumDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), (Capabilities) options);
        ((SupportsContextSwitching) driver).getContextHandles();
        ArrayList<String> contexts = new ArrayList(((SupportsContextSwitching) driver).getContextHandles());

        for (String context : contexts) {
            System.out.println(context);
        }

        for (String context : contexts) {
            System.out.println(context);
            if (context.contains("WEBVIEW_com.banquemisr.bmbusinessonline.cash.collection.debug")) {
                System.out.println("found context  : " +context);
                ((SupportsContextSwitching) driver).context(context);
                System.out.println("context switched to : " +context);
                return true;
            }
        }
        return false;
    }

    public static void clickPerformAction(WebDriver driver, String mobileId, String otherMobileId, String desktopId, String desktopAction1, String desktopAction2, String desktopAction3) {
 Dimension viewportSize = driver.manage().window().getSize();
 if (viewportSize.getWidth() < 758) {
 driver.findElement(By.id(mobileId)).click();
 if (otherMobileId != null) {
  driver.findElement(By.id(otherMobileId)).click();
   }
  } else {
     if (desktopId != null) {
    driver.findElement(By.id(desktopId)).click();
     if (desktopAction1 != null) {
     driver.findElement(By.id(desktopAction1)).click();
       }
       if (desktopAction2 != null) {
         driver.findElement(By.id(desktopAction2)).click();
       }
       if (desktopAction3 != null) {
         driver.findElement(By.id(desktopAction3)).click();
       }
     }
   }
    }


    public void SwitchTonewWindow(WebElement w) {
        Actions newwin = new Actions(driver);
        String originalWindow = driver.getWindowHandle();
        System.out.println(driver.getCurrentUrl());
        //Check we don't have other windows open already
        assert driver.getWindowHandles().size() == 1;
        //Click the link which opens in a new window
//        click(w,"clicked");

        newwin.keyDown(Keys.COMMAND).click(w).keyUp(Keys.COMMAND).build().perform();
        //Wait for the new window or tab
//        WebDriverWait wait = new WebDriverWait(driver, 20);
//        wait.until(numberOfWindowsToBe(2));

        //Loop through until we find a new window handle
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public void openURL(URL url) throws InterruptedException {
        Thread.sleep(3000);
        driver.navigate().to(url);


    }
    public void waitForVisibilityWeb(WebElement w) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(w));

    }




    public void waitForClickability(WebElement W) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(W));
    }
    public void clear(WebElement w) {
        waitForVisibilityWeb(w);
        w.clear();
    }


    public void click(WebElement e) {
        //waitForVisibility(e);
        e.click();
    }

    public void click(WebElement W, String msg) {
        waitForVisibilityWeb(W);
        waitForClickability(W);
        utils.log().info(msg);
        W.click();
    }

    public void waitforinterception(WebElement W){
        waitForVisibilityWeb(W);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", W);
    }

    public void ScrollDown(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,350)", "");
    }

    public void waitforPage(){

        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
    }







//    public void sendKeys(MobileElement e, String txt) {
//        waitforPage();
//        waitForVisibility(e);
//        e.sendKeys(txt);
//    }

//    public void sendKeys(MobileElement e, String txt, String msg) {
//        waitForVisibility(e);
//        utils.log().info(msg);
//        e.sendKeys(txt);
//    }

//    sendkeys for webelement
    public void sendKeys(WebElement w , String value){
        waitForVisibilityWeb(w);
        w.sendKeys(value);
    }


//    public String getAttribute(MobileElement e, String attribute) {
//        waitForVisibility(e);
//        return e.getAttribute(attribute);
//    }

    //getAttribute for Webelement

    public String getAttribute(WebElement W, String attribute) {
        waitForVisibilityWeb(W);
        return W.getAttribute(attribute);
    }
//
//    public String getAttribute(By e, String attribute) {
//        waitForVisibility(e);
//        return driver.findElement(e).getAttribute(attribute);
//    }

    //getText for Webelement
    public String getText(WebElement W) {
        String txt;
        txt = getAttribute(W, "text");
        return txt;
    }


//    public String getText(MobileElement e, String msg) {
//        String txt;
//        switch(new GlobalParams().getPlatformName()){
//            case "Android":
//                txt = getAttribute(e, "text");
//                break;
//            case "iOS":
//                txt = getAttribute(e, "label");
//                break;
//            default:
//                throw new IllegalStateException("Unexpected value: " + new GlobalParams().getPlatformName());
//        }
//        utils.log().info(msg + txt);
//        return txt;
//    }

//    public String getText(By e, String msg) {
//        String txt;
//        switch(new GlobalParams().getPlatformName()){
//            case "Android":
//                txt = getAttribute(e, "text");
//                break;
//            case "iOS":
//                txt = getAttribute(e, "label");
//                break;
//            default:
//                throw new IllegalStateException("Unexpected value: " + new GlobalParams().getPlatformName());
//        }
//        utils.log().info(msg + txt);
//        return txt;
//    }

    public void ClickOnInterceptedElement(WebElement W){

        // Create a reference
        JavascriptExecutor js = (JavascriptExecutor)driver;

        // Call the JavascriptExecutor methods
        js.executeScript("arguments[0].click();", W);
    }



//    public void closeApp() {
//        ((InteractsWithApps) driver).closeApp();
//    }
//
//
//    public void launchApp() {
//        ((InteractsWithApps) driver).launchApp();
//    }

//    public MobileElement andScrollToElementUsingUiScrollable(String childLocAttr, String childLocValue) {
//        return (MobileElement) ((FindsByAndroidUIAutomator) driver).findElementByAndroidUIAutomator(
//                "new UiScrollable(new UiSelector()" + ".scrollable(true)).scrollIntoView("
//                        + "new UiSelector()."+ childLocAttr +"(\"" + childLocValue + "\"));");
//    }

    public void Takescreenshot(){
//        WebDriverWait wait = new WebDriverWait(driver,30000);

        Screenshot screen = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        try {
//            ImageIO.write(screen.getImage(), "PNG", new File("C:\\Users\\Admin\\merchant automation\\view.png"));
            ImageIO.write(screen.getImage(), "PNG", new File("C:\\Users\\Admin\\merchant automation\\registerationpdf.png"));
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }




    }




  /*  public MobileElement iOSScrollToElementUsingMobileScroll(MobileElement e) {
        RemoteWebElement element = ((RemoteWebElement) e);
        String elementID = element.getId();
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("element", elementID);
//	  scrollObject.put("direction", "down");
//	  scrollObject.put("predicateString", "label == 'ADD TO CART'");
//	  scrollObject.put("name", "test-ADD TO CART");
        scrollObject.put("toVisible", "sdfnjksdnfkld");
        driver.executeScript("mobile:scroll", scrollObject);
        return e;
    }

    public By iOSScrollToElementUsingMobileScrollParent(MobileElement parentE, String predicateString) {
        RemoteWebElement parent = (RemoteWebElement)parentE;
        String parentID = parent.getId();
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("element", parentID);
        scrollObject.put("predicateString", predicateString);
        driver.executeScript("mobile:scroll", scrollObject);
        By m = MobileBy.iOSNsPredicateString(predicateString);
        System.out.println("Mobilelement is " + m);
        return m;
    }

    public MobileElement scrollToElement(MobileElement element, String direction) throws Exception {
        Dimension size = driver.manage().window().getSize();
        int startX = (int) (size.width * 0.5);
        int endX = (int) (size.width * 0.5);
        int startY = 0;
        int endY = 0;
        boolean isFound = false;

        switch (direction) {
            case "up":
                endY = (int) (size.height * 0.4);
                startY = (int) (size.height * 0.6);
                break;

            case "down":
                endY = (int) (size.height * 0.6);
                startY = (int) (size.height * 0.4);
                break;
        }

        for (int i = 0; i < 3; i++) {
            if (find(element, 1)) {
                isFound = true;
                break;
            } else {
                swipe(startX, startY, endX, endY, 1000);
            }
        }
        if(!isFound){
            throw new Exception("Element not found");
        }
        return element;
    }

    public By scrollToElement(By element, String direction) throws Exception {
        Dimension size = driver.manage().window().getSize();
        int startX = (int) (size.width * 0.5);
        int endX = (int) (size.width * 0.5);
        int startY = 0;
        int endY = 0;
        boolean isFound = false;

        switch (direction) {
            case "up":
                endY = (int) (size.height * 0.4);
                startY = (int) (size.height * 0.6);
                break;

            case "down":
                endY = (int) (size.height * 0.6);
                startY = (int) (size.height * 0.4);
                break;
        }

        for (int i = 0; i < 3; i++) {
            if (find(element, 1)) {
                isFound = true;
                break;
            } else {
                swipe(startX, startY, endX, endY, 1000);
            }
        }
        if(!isFound){
            throw new Exception("Element not found");
        }
        return element;
    }
*/
//    public boolean find(final MobileElement element, int timeout) {
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, timeout);
//            return wait.until(new ExpectedCondition<Boolean>() {
//                @Override
//                public Boolean apply(WebDriver driver) {
//                    if (element.isDisplayed()) {
//                        return true;
//                    }
//                    return false;
//                }
//            });
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    public boolean find(final By element, int timeout) {
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, timeout);
//            return wait.until(new ExpectedCondition<Boolean>() {
//                @Override
//                public Boolean apply(WebDriver driver) {
//                    if (driver.findElement(element).isDisplayed()) {
//                        return true;
//                    }
//                    return false;
//                }
//            });
//        } catch (Exception e) {
//            return false;
//        }
//    }

  /*  public void swipe(int startX, int startY, int endX, int endY, int millis)
            throws InterruptedException {
        TouchAction t = new TouchAction(driver);
        t.press(point(startX, startY)).waitAction(waitOptions(ofMillis(millis))).moveTo(point(endX, endY)).release()
                .perform();
    }

    //New Actions
    public void takeScreenshot() {
        Allure.addAttachment("Any text", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

    public void scrollFromRightToLeft() {
        Dimension dimension = driver.manage().window().getSize();
        int a = (int) (dimension.width * 0.8);
        int b = (int) (dimension.height * 0.5);
        int c = (int) (dimension.width *0.2);
        int d = (int) (dimension.height * 0.5);

        TouchAction touch = new TouchAction(driver);
        touch.press(PointOption.point(a,b)).
                waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).
                moveTo(PointOption.point(c,d)).release().perform();
    }



    public void scrollToTextAndclick(String text) {
        String uiSelector = "new UiSelector().textMatches(\"" + text
                + "\")";
        String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("
                + uiSelector + ");";
        driver.findElement(MobileBy.AndroidUIAutomator(command)).click();
    }*/

            }