package BB;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BBClass {
	public static String url= "https://www.demoblaze.com/index.html";
	WebDriver driver;
	
	@BeforeTest(enabled = true )
	public void BT() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
	}
	@Test(enabled = true)
	public void tt() throws InterruptedException {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,100) ");
		//driver.findElement(By.linkText("https://www.demoblaze.com/prod.html?idp_=1")).click();
		driver.findElement(By.xpath("(//img[@class='card-img-top img-fluid'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@onclick='addToCart(1)']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().refresh();
		driver.navigate().back();
		driver.navigate().back();
	}
	    @Test(enabled = true)
		public void tt1() throws InterruptedException {
	    JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,100) ");
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//img[@class='card-img-top img-fluid'])[2]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@onclick='addToCart(2)']")).click();
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().back();
		driver.navigate().back();
		}
	    @Test(enabled = true)
		public void tt3() throws InterruptedException {
		driver.findElement(By.xpath("(//img[@class='card-img-top img-fluid'])[3]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@onclick='addToCart(3)']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//*[@class='nav-link'])[4]")).click();
		//driver.findElement(By.linkText("https://www.demoblaze.com/cart.html")).click();
		String product1= driver.findElement(By.xpath("//tr[@class]/td[3]")).getText();
		System.out.println(product1);
		String product2 =driver.findElement(By.xpath("//*[@id='tbodyid']/tr[2]/td[3]")).getText();
		System.out.println(product2);
		String product3 =driver.findElement(By.xpath("//*[@id='tbodyid']/tr[3]/td[3]")).getText();
		System.out.println(product3);
		String total =driver.findElement(By.xpath("//*[@id='totalp']")).getText();
		System.out.println(total);
		product1=product1.substring(1);
		product2=product2.substring(1);
		product3=product3.substring(1);
		//total=total.substring(1);
//		Double firstproduct=Double.parseDouble(product1);
//		System.out.println(firstproduct);
//		Double secondproduct=Double.parseDouble(product2);
//		System.out.println(secondproduct);
//		Double thirdproduct=Double.parseDouble(product3);
//		System.out.println(thirdproduct);
		//Double totalprice=Double.parseDouble(product3);
		String totalprice=product1+product2+product3;
		
		if(total.equals(totalprice)) {
			System.out.println("prices matched");
		}else {
			System.out.println("prices not matched");
		}
		driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr[1]/td[4]/a")).click();
		}
	    
	}

