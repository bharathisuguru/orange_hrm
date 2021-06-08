package Page;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrangeHRM {
	String url = "https://opensource-demo.orangehrmlive.com/"; 
	static ChromeDriver driver;
	
	@FindBy(id="txtUsername") WebElement username ;
	@FindBy(id="txtPassword") WebElement password;
	@FindBy(id="btnLogin") WebElement clickLogin;
	
	@FindBy(id="menu_admin_viewAdminModule") WebElement clickAdmin;
//	@FindBy(id="menu_admin_UserManagement") WebElement clickUserManagement;
	@FindBy(id="btnAdd") WebElement clickAdd;
	@FindBy(id="systemUser_userType") WebElement clickUserRole;
	
	@FindBy(id="systemUser_employeeName_empName") WebElement EmpName;
	@FindBy(id="systemUser_userName") WebElement Name;
	@FindBy(id="systemUser_status") WebElement status;
	@FindBy(id="systemUser_password") WebElement userPass;
	@FindBy(id="systemUser_confirmPassword") WebElement userPassCofir;
	@FindBy(id="btnSave") WebElement saveBtn;
	
	@FindBy(name="searchSystemUser[userName]") WebElement SearchUser;
	@FindBy(id="searchBtn") WebElement SearchBtn;
	
	public void invokeBrowser() throws Exception{
		driver = new ChromeDriver();
		PageFactory.initElements(driver, this);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		Thread.sleep(3000);
	}
	public void loginPage() throws Exception{
		username.sendKeys("Admin");
		password.sendKeys("admin123");
		clickLogin.click();
		Thread.sleep(3000);
	}
	public void navgbar() throws Exception {
		clickAdmin.click();
		clickAdd.click();
		Thread.sleep(3000);
	}
	public void adduserDetails() throws Exception{
		Select s = new Select(clickUserRole);
		s.selectByVisibleText("Admin");
		EmpName.sendKeys("Orange Test");
		Name.sendKeys("Alicerose1234");
		
		Select s1 = new Select(status);
		s1.selectByVisibleText("Disabled");
		
		userPass.sendKeys("ALICEJOHN#123");
		userPassCofir.sendKeys("ALICEJOHN#123");
		Thread.sleep(2000);
		saveBtn.click();
		Thread.sleep(2000);
	}
	public void searchUser() throws Exception{
		SearchUser.sendKeys("Alicerose1234");
		SearchBtn.click();
		Thread.sleep(3000);
	}
	public void DispDetails()
	{
		List <WebElement> tabledata=(driver.findElementsByTagName("tr"));
	   for(int i=0;i<tabledata.size();i++)
	   {
		   System.out.println(tabledata.get(i).getText());
	   }
	}

}
