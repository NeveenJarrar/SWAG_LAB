import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SwagLab extends Swaglab_Parameters{

	@BeforeTest
	public void Sign_in() {
		// sign in process
		driver.get(URL);
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(User_name);
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(Password);
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

	}

	@Test
	public void Add_all_items_to_cart() {

		// create a list of all the buttons that add items to the cart.
		List<WebElement> Add_to_Cart_list = driver.findElements(By.className("btn_primary"));

		for (int k = 0; k < Add_to_Cart_list.size(); k++) {
			Add_to_Cart_list.get(k).click();
		}
		// to know the number of items in the cart
		String all_items = driver.findElement(By.className("shopping_cart_badge")).getText();

		int all_itemas_int = Integer.parseInt(all_items);
		myassertion.assertEquals(all_itemas_int, Add_to_Cart_list.size());

	}

	@Test()
	public void Remove_all_items_from_cart() {
		// create a list of all the buttons that remove items from cart.
		List<WebElement> remove_from_cart = driver.findElements(By.className("btn_secondary"));

		for (int k = 0; k < remove_from_cart.size(); k++) {
			remove_from_cart.get(k).click();
		}
		// create a list to ensure that all items are removed from the cart
		List<WebElement> All_items_removed = driver.findElements(By.className("shopping_cart_badge"));
		int size = All_items_removed.size();
		myassertion.assertEquals(size, 0);

	}

	@AfterTest
	public void AterTesting() {

		myassertion.assertAll();

	}
}
