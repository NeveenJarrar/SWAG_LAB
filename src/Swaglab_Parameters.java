import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.asserts.SoftAssert;

public class Swaglab_Parameters {
	WebDriver driver = new EdgeDriver();
	SoftAssert Assert = new SoftAssert();
	Random rand = new Random();
	String URL= "https://www.saucedemo.com/inventory.html";
	String ordering_by_price="price";
	String ordering_by_Name="Name" ;
}
