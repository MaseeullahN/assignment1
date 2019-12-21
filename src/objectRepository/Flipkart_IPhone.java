package objectRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class Flipkart_IPhone {
WebDriver driver ;
	public Flipkart_IPhone(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css = "input[name='q']")
	WebElement Search;
	@FindBy (css = "button[type='submit']")
	WebElement Submit;
	@FindBy (xpath = "//div[@class='_3wU53n']")
	WebElement iPhone_Flp;
	@FindBy (xpath = "//div[@class='_1vC4OE _3qQ9m1']")
	WebElement iPhone_Flp_Price;
	public WebElement FlipKartSearch()
    {
    	return Search;
    }
    public WebElement FlipKartSubmit()
    {
    	return Submit; }
    public WebElement iPhone_FlipKart()
    {return iPhone_Flp;
    }
    
    public WebElement iPhone_FlipKart_Price()
    {return iPhone_Flp_Price;}
    }
	
	
	
	


