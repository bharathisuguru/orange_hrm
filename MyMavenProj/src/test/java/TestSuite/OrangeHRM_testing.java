package TestSuite;

import Page.OrangeHRM;

public class OrangeHRM_testing {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		OrangeHRM obj = new OrangeHRM();
		obj.invokeBrowser();
		obj.loginPage();
		obj.navgbar();
		obj.adduserDetails();
		obj.searchUser();
		obj.DispDetails();
	}

}
