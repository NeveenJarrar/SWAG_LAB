import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.asserts.SoftAssert;

public class ordering_class_Parameters {
	WebDriver driver = new EdgeDriver();
	SoftAssert myassertion = new SoftAssert();
	Random rand = new Random();
	String URL= "https://www.saucedemo.com/inventory.html";
	String User_name="standard_user";
	String Password="secret_sauce";
String ordering_by_price="price";
String ordering_by_Name="Name" ;
}