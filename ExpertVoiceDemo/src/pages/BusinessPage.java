package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

@SuppressWarnings("unused")
public class BusinessPage extends HomePage {							/* Inheritance */


	static BusinessPage ObjBusinessPage = new BusinessPage();
	static HomePage ObjHomePage = new BusinessPage();           		/* Polymorphism */ 


	public static void main(String[] args) {
		HomePage.main();
		ObjBusinessPage.navigateToBusinessPage();
		ObjHomePage.navigateToHomePage();         						/* Method overloading*/	

	}

	//Method to Navigate to Business page from Home page

	public void navigateToBusinessPage() {
		try {
			WebElement btnBusiness = driver.findElement(By.xpath("//*[@id=\"home-menu\"]//a[contains(text(),'Busines')]"));
			btnBusiness.click();
		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
			WebElement btnBusiness = driver.findElement(By.xpath("//*[@id=\"home-menu\"]//a[contains(text(),'Busines')]"));
			btnBusiness.click();
		}
		//ExplicitWait
		try {															/* Exception Handling */
			WebDriverWait wait = new WebDriverWait(driver, 60);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Navigated to Business page");
		System.out.println(driver.getTitle());

	}


	//Method to navigate to home page from Business page	
	public void navigateToHomePage() {

		WebElement btnLogo = driver.findElement(By.xpath("//*[@id=\"masthead\"]//*[contains(@class,'site-logo')]"));
		btnLogo.click();
		//ExplicitWait
		WebDriverWait wait = new WebDriverWait(driver, 60);
		System.out.println("Navigated to Home Page");
		System.out.println(driver.getTitle());


	}

}
