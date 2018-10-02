package pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;



@SuppressWarnings("unused")
public class HomePage {
	static WebDriver driver;


	public static void main() {

		//To Launch browser, clear cookies and maximise browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nivedita\\Desktop\\Programs\\softwares\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.close();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		//Hit URL
		driver.get("https://www.expertvoice.com/");

		//to wait till page loads
		//implicit wait
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Explicit wait
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String strTitle = driver.getTitle();		
		System.out.println(strTitle);

		HomePage objHomePage = new HomePage();
		objHomePage.clickSignin();
		System.out.println("SigIn page opened");
		objHomePage.closeSignIn();
		System.out.println("SigIn page closed");
		objHomePage.navigateToHomePage();
		//driver.quit();

	}


	//Method to click SignIn button in HomePage

	public void clickSignin() {
		WebElement btnSignin = driver.findElement(By.xpath("//*[@id=\"masthead\"]//a[contains(text(),'Sign In')]"));
		btnSignin.click();
		//ExplicitWait
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//Method to close SignIn page

	public void closeSignIn() {
		WebDriverWait wait = new WebDriverWait(driver,60);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"exp-onboarding-modal\"]//*[contains(@class,'exp-ux-small exp-ux-close')]")));   
	    WebElement btnClose = driver.findElement(By.xpath("//*[@id=\"exp-onboarding-modal\"]//*[contains(@class,'exp-ux-small exp-ux-close')]"));
		btnClose.click();
		try {
			WebDriverWait wait1 = new WebDriverWait(driver, 60);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//Method to Navigate to HomePage from HomePage


	public void navigateToHomePage() {
		try {
			WebDriverWait wait = new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"masthead\"]//*[contains(@class,'site-logo')]")));   
			
			WebElement btnLogo = driver.findElement(By.xpath("//*[@id=\"masthead\"]//*[contains(@class,'site-logo')]"));
			btnLogo.click();
			//ExplicitWait
			WebDriverWait wait1 = new WebDriverWait(driver, 60);
		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
			WebElement btnLogo = driver.findElement(By.xpath("//*[@id=\"masthead\"]//*[contains(@class,'site-logo')]"));
			btnLogo.click();
			//ExplicitWait
			WebDriverWait wait1 = new WebDriverWait(driver, 60);
		}
		System.out.println("Navigated to Home Page");
		System.out.println(driver.getTitle());


	}

}
