package adapter_design_pattern;

//Этот интерфейс определяет два метода: getElement() и selectElement().
// Эти методы представляют действия, связанные с веб-автоматизацией, такие как поиск элемента и выбор элемента.
interface WebDriver
{
	public void getElement();
	public void selectElement();
}

//	Этот класс представляет веб-драйвер для браузера Google Chrome
class ChromeDriver implements WebDriver 
{
	@Override
	public void getElement() 
	{
	    System.out.println("Get element from ChromeDriver");
	}

	@Override
	public void selectElement() 
	{
	    System.out.println("Select element from ChromeDriver");
	    
	}
	  
}

class IEDriver
{
	public void findElement() 
	{
	    System.out.println("Find element from IEDriver");
	}

	public void clickElement()
	{
	    System.out.println("Click element from IEDriver");
	}
	  
}

class WebDriverAdapter implements WebDriver 
{
	IEDriver ieDriver;
	public WebDriverAdapter(IEDriver ieDriver) 
	{
	    this.ieDriver = ieDriver;
	}
	  
	@Override
	public void getElement() 
	{
	    ieDriver.findElement();
	    
	}

	@Override
	public void selectElement() 
	{
	    ieDriver.clickElement();
	}
	  
}

public class AdapterPattern
{
    public static void main(String[] args) 
	{
	    ChromeDriver a = new ChromeDriver();
	    a.getElement();
	    a.selectElement();
	    
	    IEDriver e = new IEDriver();
	    e.findElement();
	    e.clickElement();
	    
	    WebDriver wID = new WebDriverAdapter(e);
	    wID.getElement();
	    wID.selectElement();
	    
	}
}