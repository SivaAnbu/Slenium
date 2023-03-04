package org.pojo;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Fbloginpojo extends BaseClass {
	
	public Fbloginpojo() {
		PageFactory.initElements(driver, this);
		
	}
@FindBy(xpath="//a[text()='Create new account']")
private  WebElement createnewacc ;


@FindBy(xpath ="(//input[@type='text'])[2]")
private  WebElement  firstname;

	@FindBy(name ="lastname")
	private WebElement secounname;

	@FindBy(name = "reg_email__")
	private WebElement mobileemailtextbox;
	
	@FindBy(name = "reg_passwd__")
	private WebElement newpaasword;

	public WebElement getCreatenewacc() {
		return createnewacc;
	}

	public WebElement getFirstname() {
		return firstname;
	}

	public WebElement getSecounname() {
		return secounname;
	}

	public WebElement getMobileemailtextbox() {
		return mobileemailtextbox;
	}

	public WebElement getNewpaasword() {
		return newpaasword;
	}

}
