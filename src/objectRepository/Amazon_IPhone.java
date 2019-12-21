package objectRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class Amazon_IPhone {
WebDriver driver ;
	public Amazon_IPhone(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy (id = "twotabsearchtextbox" )
	WebElement Search;
	@FindBy (css = "input[value='Go']")
	WebElement Submit;
	@FindBy (linkText = "Apple iPhone XR (64GB) - Yellow")
	WebElement iPhone_Amz;
	@FindBy (id = "priceblock_ourprice" )
	WebElement iPhone_Amz_Price;
	public WebElement AmazonSearch()
    {
    	return Search;
    }
    public WebElement AmazonSubmit()
    {
    	return Submit; }
    public WebElement iPhone_Amazon()
    {return iPhone_Amz;
    }
    
    public WebElement iPhone_Amazon_Price()
    {return iPhone_Amz_Price;}
    }
	
	
	


