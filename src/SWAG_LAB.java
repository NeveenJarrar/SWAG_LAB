
import java.time.Duration;
	import java.util.List;

	import org.openqa.selenium.By;
	import org.openqa.selenium.StaleElementReferenceException;
	import org.openqa.selenium.WebElement;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	public class SWAG_LAB extends Swaglab_Parameters  {


		@BeforeTest
		public void Sign_in() throws InterruptedException {
			driver.get(URL);
		
		WebElement User_name=	driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
		WebElement Password =driver.findElement(By.xpath("//*[@id=\"password\"]"));
		WebElement Submit =driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
		User_name.sendKeys("standard_user");
			Password.sendKeys("secret_sauce");
			Submit.click();
		}

		@Test
		public void ordering_of_items() throws InterruptedException {
			// create a to add all option of ordering items.
			List<WebElement> Ordering_of_items = driver.findElements(By.tagName("option"));
		
			int index_Filtering_tools = rand.nextInt(0, Ordering_of_items.size());

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			Thread.sleep(2000);
			// Ordering_of_items.get(index_Filtering_tools).click();
			boolean staleElement = true;

			while (staleElement) {

				try {

					Ordering_of_items.get(index_Filtering_tools).click();

					staleElement = false;

				} catch (StaleElementReferenceException e) {

					staleElement = true;

				}
			}

			Thread.sleep(4000);
			String Actual__ordering = driver.findElement(By.className("active_option")).getText();

			if (Actual__ordering.contains(ordering_by_Name)) {

				Assert.assertEquals(Actual__ordering.contains("price"), Actual__ordering.contains(ordering_by_price),
				Actual__ordering);
			} else {

				Assert.assertEquals(Actual__ordering.contains("price"), Actual__ordering.contains(ordering_by_price),
						Actual__ordering);
				

			}
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
			Assert.assertEquals(all_itemas_int, Add_to_Cart_list.size());

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
			Assert.assertEquals(size, 0);

		}

		@AfterTest
		public void AterTesting() {
			Assert.assertAll();

		}
	}



