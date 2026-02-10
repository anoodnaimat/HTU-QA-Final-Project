package SauceDemo;



import java.util.List; 
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases {
	String myWebsite = "https://www.saucedemo.com/";
    WebDriver driver= new EdgeDriver();

    String userName = "standard_user";
    String password = "secret_sauce";
    
    Random rand=new Random();

@BeforeTest
public void mySetUp()  {
	
	driver.get(myWebsite);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	
}




@Test(priority = 1)
public void login()  {
	
	
	WebElement UserName = driver.findElement(By.id("user-name"));
	WebElement Password= driver.findElement(By.id("password"));
	WebElement Button =driver.findElement(By.id("login-button"));
	
	UserName.sendKeys(userName);
	Password.sendKeys(password);
	Button.click();
	
	Assert.assertEquals(driver.findElement(By.className("title")).getText(),"Products" );
	
}

@Test
public void negativeLoginTest() {
    WebDriver driver = new EdgeDriver();
    driver.get("https://www.saucedemo.com/");

    WebElement userName = driver.findElement(By.id("user-name"));
    WebElement password = driver.findElement(By.id("password"));
    WebElement loginBtn = driver.findElement(By.id("login-button"));

    userName.sendKeys("wrong_user");
    password.sendKeys("wrong_pass");
    loginBtn.click();

    WebElement errorMsg = driver.findElement(By.cssSelector("h3[data-test='error']"));
    Assert.assertTrue(errorMsg.isDisplayed());

    driver.close();
}



@Test(priority = 2)
public void sortProductsTest() {

List<WebElement> beforeSort = driver.findElements(By.className("inventory_item_name"));
String firstBefore = beforeSort.get(0).getText();

WebElement sortDropdown = driver.findElement(By.className("product_sort_container"));
sortDropdown.click();

WebElement zToA = driver.findElement(By.xpath("//option[@value='za']"));
zToA.click();

List<WebElement> afterSort = driver.findElements(By.className("inventory_item_name"));
String firstAfter = afterSort.get(0).getText();

Assert.assertNotEquals(firstBefore, firstAfter);

}


@Test(priority = 3)
public void addProductsToCart() throws InterruptedException {
	

	
	
	List<WebElement> addToCartButtons = driver.findElements(By.cssSelector(".btn_inventory"));


	int firstIndex = rand.nextInt(addToCartButtons.size());

	int secondIndex;
	do {
	    secondIndex = rand.nextInt(addToCartButtons.size());
	} while (secondIndex == firstIndex);

	addToCartButtons.get(firstIndex).click();
	addToCartButtons.get(secondIndex).click();

	driver.findElement(By.className("shopping_cart_link")).click();

	Assert.assertEquals(
	    driver.findElements(By.className("inventory_item_name")).size(),
	    2);

	Thread.sleep(1000);

}

@Test(priority = 4)
public void viewCartTest() {
	
	Assert.assertEquals(
			driver.findElement(By.className("title")).getText(),
			"Your Cart"
			);
	
	
}

@Test(priority = 5)
public void removeProductTest() throws InterruptedException {
	
	
	driver.findElement(By.className("shopping_cart_link")).click();

	List<WebElement> removeButtons = driver.findElements(By.cssSelector("button[id^='remove-']"));

	WebElement removeButton = removeButtons.get(0);
	removeButton.click();

	List<WebElement> itemsAfterRemove = driver.findElements(By.className("inventory_item_name"));
	
	Assert.assertEquals(itemsAfterRemove.size(), 1);

	Thread.sleep(1000);
	
}

@Test(priority = 6)
public void checkoutTest() {
	
	WebElement checkoutButton=driver.findElement(By.id("checkout"));
	checkoutButton.click();
	
	Assert.assertEquals(
			driver.findElement(By.className("title")).getText(),
			"Checkout: Your Information"
			);
	
}

@Test(priority = 7)
public void fillCheckoutInfo() throws InterruptedException {
	WebElement firstName = driver.findElement(By.id("first-name"));
    WebElement lastName = driver.findElement(By.id("last-name"));
    WebElement postalCode = driver.findElement(By.id("postal-code"));
	
    firstName.sendKeys("Anoop");
    lastName.sendKeys("Test");
    postalCode.sendKeys("11111");
    
    
    WebElement contineuButton= driver.findElement(By.id("continue"));
    contineuButton.click();
    
    Assert.assertEquals(
    	    driver.findElement(By.className("title")).getText(),
    	    "Checkout: Overview"
    	    );
    Thread.sleep(1000);
	
}
@Test(priority = 8)
public void finishOrdero() throws InterruptedException {
	
	WebElement finishBtn = driver.findElement(By.id("finish"));
    finishBtn.click();

    WebElement successMsg = driver.findElement(By.className("complete-header"));

    Assert.assertEquals(
        successMsg.getText(),
        "Thank you for your order!"
    );
	
    Thread.sleep(1000);
}


@Test(priority = 9)
public void logout()  {
	 
	WebElement menuBtn = driver.findElement(By.id("react-burger-menu-btn"));
    menuBtn.click();

    WebElement logoutBtn = driver.findElement(By.id("logout_sidebar_link"));
    logoutBtn.click();

    Assert.assertEquals(
        driver.getCurrentUrl(),
        "https://www.saucedemo.com/"
    );
   
	
}


@AfterTest
public void AfterMyTest() {
	driver.close();
}

}
