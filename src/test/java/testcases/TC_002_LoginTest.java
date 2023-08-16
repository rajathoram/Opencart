package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import testbase.BaseClass;

public class TC_002_LoginTest extends BaseClass
{
	@Test
	public void test_Login()
	{
		logger.info("Starting TC_002_LoginTest");
		
		try
		{				
			HomePage hp=new HomePage(driver);
			
			hp.clickMyAccount();
						
			hp.clickLogin();
			
			LoginPage lp=new LoginPage(driver);
			
			lp.setEmail(bundle.getString("email")); // valid email, get it from properties file
			
			lp.setPassword(bundle.getString("password")); // valid password, get it from properties file
			
			lp.clickLogin();
			
			MyAccountPage macc=new MyAccountPage(driver);
			
			boolean targetpage=macc.isMyAccountPageExists();
						
			Assert.assertEquals(targetpage, true);
			
		}	
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info(" Finished TC_002_LoginTest");
		
	}
	
	
}


