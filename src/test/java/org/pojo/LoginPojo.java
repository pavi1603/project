package org.pojo;

import java.io.IOException;

import org.datadriven.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPojo extends BaseClass{
	public LoginPojo() {
		PageFactory.initElements(driver, this);
	}	
	@FindBy(id="EmailAddress")
	private WebElement txtUser;
	
	@FindBy(id="Password")
	private WebElement txtPass;
	
	@FindBy(xpath="//button[@class='btn btn-danger span12 disableableContinueButton continuebtn btn--large']")
	private WebElement btnLogin;
	
	@FindBy(xpath="//span[@class='myAccount_guest']")
	private WebElement signbtn;
	
	public WebElement getTxtUser() {
		return txtUser;
	}
	public WebElement getTxtPass() {
		return txtPass;
	}
	public WebElement getBtnLogin() {
		return btnLogin;
	}
	public WebElement getSignBtn() {
		return signbtn;
	}

@SuppressWarnings("unused")
public static void main(String[] args) throws IOException, InterruptedException {
	
	launchChrome();
	WinMax();
	loadUrl("https://www.mandmdirect.com/");
	printTitle();
	printCurrentUrl();
	Thread.sleep(3000);

	LoginPojo l = new LoginPojo();
	WebElement signbtn = l.getSignBtn();
	btnClick(signbtn);
	Thread.sleep(2000);
	
	WebElement txtUser = l.getTxtUser();
	fill(l.getTxtUser(), getData(3,4));

	WebElement txtPass = l.getTxtPass();
	fill(txtPass, getData(5,4));

	WebElement btnLogin= l.getBtnLogin();
	btnClick(btnLogin);
	
}

}
