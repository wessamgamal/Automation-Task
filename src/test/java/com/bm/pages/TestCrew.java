package com.bm.pages;

import com.cc.utils.JsonReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class TestCrew extends BasePage{

    @FindBy(id = "name-classic")
    WebElement ClassicplanName;

    @FindBy(xpath = "//*[@id=\"currency-classic\"]/b")
    WebElement ClassicplanPrice;

    @FindBy(id = "currency-classic")
    WebElement ClassicplanCurrency;


    @FindBy(id = "name-lite")
    WebElement LiteplanName;

    @FindBy(xpath = "//*[@id=\"currency-lite\"]/b")
    WebElement LiteplanPrice;

    @FindBy(xpath = "//*[@id=\"currency-lite\"]/i/text()[1]")
    WebElement LiteplanCurrency;

    @FindBy(id = "name-premium")
    WebElement PremiunplanName;

    @FindBy(xpath = "//*[@id=\"currency-premium\"]/b")
    WebElement PremiumplanPrice;

    @FindBy(xpath = "//*[@id=\"currency-premium\"]/i/text()[1]")
    WebElement PremiumplanCurrency;



    public void Validate_SA_classic_Plan_Details(){
        String Actual_Plan_Name=ClassicplanName.getText();
        System.out.println("Actual paln name is : " + Actual_Plan_Name);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"currency-classic\"]/b")));
        String Actual_Plan_Price=ClassicplanPrice.getText();
        System.out.println("Actual paln price is : " + Actual_Plan_Price);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("currency-classic")));

        boolean Actual_Plan_Currency=ClassicplanCurrency.getText().replace("/month","").trim().contains("SAR");
        System.out.println("Actual paln currency is SAR : " + Actual_Plan_Currency);


        Assert.assertEquals(Actual_Plan_Name,new JsonReader().getValue("subscriptionPlans","SAclassicPlanDetailsname"));
        Assert.assertEquals(Actual_Plan_Price,new JsonReader().getValue("subscriptionPlans","SAclassicPlanDetailsprice"));
        Assert.assertEquals(Actual_Plan_Currency,true);



    }

    public void Validate_Lite_SA_Lite_Plan_Details(){
      String   Actual_Plan_Name=LiteplanName.getText();
        System.out.println("Actual paln name is : " + Actual_Plan_Name);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"currency-lite\"]/b")));
        String Actual_Plan_Price=LiteplanPrice.getText();
        System.out.println("Actual paln price is : " + Actual_Plan_Price);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("currency-classic")));

        boolean Actual_Plan_Currency=ClassicplanCurrency.getText().replace("/month","").trim().contains("SAR");
        System.out.println("Actual paln currency is SAR : " + Actual_Plan_Currency);


        Assert.assertEquals(Actual_Plan_Name,new JsonReader().getValue("subscriptionPlans","SALitePlanDetailsname"));
        Assert.assertEquals(Actual_Plan_Price,new JsonReader().getValue("subscriptionPlans","SALitePlanDetailsprice"));
        Assert.assertEquals(Actual_Plan_Currency,true);




    }

    public void Validate_SA_Premium_Plan_Details(){
      String  Actual_Plan_Name=PremiunplanName.getText();
        System.out.println("Actual paln name is : " + Actual_Plan_Name);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"currency-lite\"]/b")));
        String Actual_Plan_Price=PremiumplanPrice.getText();
        System.out.println("Actual paln price is : " + Actual_Plan_Price);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("currency-classic")));

        boolean Actual_Plan_Currency=ClassicplanCurrency.getText().replace("/month","").trim().contains("SAR");
        System.out.println("Actual paln currency is SAR : " + Actual_Plan_Currency);



        Assert.assertEquals(Actual_Plan_Name,new JsonReader().getValue("subscriptionPlans","SAPremiumLitePlanDetailsname"));
        Assert.assertEquals(Actual_Plan_Price,new JsonReader().getValue("subscriptionPlans","SAPremiumLitePlanDetailsprice"));
        Assert.assertEquals(Actual_Plan_Currency,true);




    }

    public void Validate_kw_classic_Plan_Details(){
       String Actual_Plan_Name=ClassicplanName.getText();
        System.out.println("Actual paln name is : " + Actual_Plan_Name);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"currency-classic\"]/b")));
        String Actual_Plan_Price=ClassicplanPrice.getText();
        System.out.println("Actual paln price is : " + Actual_Plan_Price);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("currency-classic")));

        boolean Actual_Plan_Currency=ClassicplanCurrency.getText().replace("/month","").trim().contains("KWD");
        System.out.println("Actual paln currency is SAR : " + Actual_Plan_Currency);


        Assert.assertEquals(Actual_Plan_Name,new JsonReader().getValue("subscriptionPlans","kwclassicPlanDetailsname"));
        Assert.assertEquals(Actual_Plan_Price,new JsonReader().getValue("subscriptionPlans","kwclassicPlanDetailsprice"));
        Assert.assertEquals(Actual_Plan_Currency,true);



    }

    public void Validate_kw_Lite_Plan_Details(){
        String   Actual_Plan_Name=LiteplanName.getText();
        System.out.println("Actual paln name is : " + Actual_Plan_Name);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"currency-lite\"]/b")));
        String Actual_Plan_Price=LiteplanPrice.getText();
        System.out.println("Actual paln price is : " + Actual_Plan_Price);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("currency-classic")));

        boolean Actual_Plan_Currency=ClassicplanCurrency.getText().replace("/month","").trim().contains("KWD");
        System.out.println("Actual paln currency is SAR : " + Actual_Plan_Currency);


        Assert.assertEquals(Actual_Plan_Name,new JsonReader().getValue("subscriptionPlans","kwLitePlanDetailsname"));
        Assert.assertEquals(Actual_Plan_Price,new JsonReader().getValue("subscriptionPlans","kwLitePlanDetailsprice"));
        Assert.assertEquals(Actual_Plan_Currency,true);



    }

    public void Validate_kw_Premium_Plan_Details(){
        String  Actual_Plan_Name=PremiunplanName.getText();
        System.out.println("Actual paln name is : " + Actual_Plan_Name);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"currency-lite\"]/b")));
        String Actual_Plan_Price=PremiumplanPrice.getText();
        System.out.println("Actual paln price is : " + Actual_Plan_Price);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("currency-classic")));

        boolean Actual_Plan_Currency=ClassicplanCurrency.getText().replace("/month","").trim().contains("KWD");
        System.out.println("Actual paln currency is SAR : " + Actual_Plan_Currency);


        Assert.assertEquals(Actual_Plan_Name,new JsonReader().getValue("subscriptionPlans","kwPremiunPlanDetailsname"));
        Assert.assertEquals(Actual_Plan_Price,new JsonReader().getValue("subscriptionPlans","kwPremiumPlanDetailsprice"));
        Assert.assertEquals(Actual_Plan_Currency,true);



    }




    public void Validate_BH_classic_Plan_Details(){
        String Actual_Plan_Name=ClassicplanName.getText();
        System.out.println("Actual paln name is : " + Actual_Plan_Name);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"currency-classic\"]/b")));
        String Actual_Plan_Price=ClassicplanPrice.getText();
        System.out.println("Actual paln price is : " + Actual_Plan_Price);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("currency-classic")));

        boolean Actual_Plan_Currency=ClassicplanCurrency.getText().replace("/month","").trim().contains("BHD");
        System.out.println("Actual paln currency is SAR : " + Actual_Plan_Currency);



        Assert.assertEquals(Actual_Plan_Name,new JsonReader().getValue("subscriptionPlans","BHclassicPlanDetailsname"));
        Assert.assertEquals(Actual_Plan_Price,new JsonReader().getValue("subscriptionPlans","BHclassicPlanDetailsprice"));
        Assert.assertEquals(Actual_Plan_Currency,true);



    }

    public void Validate_BH_Lite_Plan_Details(){
        String   Actual_Plan_Name=LiteplanName.getText();
        System.out.println("Actual paln name is : " + Actual_Plan_Name);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"currency-lite\"]/b")));
        String Actual_Plan_Price=LiteplanPrice.getText();
        System.out.println("Actual paln price is : " + Actual_Plan_Price);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("currency-classic")));

        boolean Actual_Plan_Currency=ClassicplanCurrency.getText().replace("/month","").trim().contains("BHD");
        System.out.println("Actual paln currency is SAR : " + Actual_Plan_Currency);


        Assert.assertEquals(Actual_Plan_Name,new JsonReader().getValue("subscriptionPlans","BHLitePlanDetailsname"));
        Assert.assertEquals(Actual_Plan_Price,new JsonReader().getValue("subscriptionPlans","BHLitePlanDetailsprice"));
        Assert.assertEquals(Actual_Plan_Currency,true);



    }

    public void Validate_BH_Premium_Plan_Details(){
        String  Actual_Plan_Name=PremiunplanName.getText();
        System.out.println("Actual paln name is : " + Actual_Plan_Name);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"currency-lite\"]/b")));
        String Actual_Plan_Price=PremiumplanPrice.getText();
        System.out.println("Actual paln price is : " + Actual_Plan_Price);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("currency-classic")));

        boolean Actual_Plan_Currency=ClassicplanCurrency.getText().replace("/month","").trim().contains("BHD");
        System.out.println("Actual paln currency is SAR : " + Actual_Plan_Currency);


        Assert.assertEquals(Actual_Plan_Name,new JsonReader().getValue("subscriptionPlans","BHPremiunPlanDetailsname"));
        Assert.assertEquals(Actual_Plan_Price,new JsonReader().getValue("subscriptionPlans","BHPremiumPlanDetailsprice"));
        Assert.assertEquals(Actual_Plan_Currency,true);



    }



    public void close_website(){
        driver.close();
    }


}
