import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Ordering_of_items extends ordering_class_Parameters {

	@BeforeTest
	public void Sign_in() throws InterruptedException {
		driver.get(URL);
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(User_name);
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(Password);
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

	}

	@Test
	public void ordering_of_items() throws InterruptedException {
		// create a to add all option of ordering items.
		List<WebElement> Ordering_of_items = driver.findElements(By.tagName("option"));
		System.out.println(Ordering_of_items.size());

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
		System.out.println(Actual__ordering);

		if (Actual__ordering.contains(ordering_by_Name)) {

			myassertion.assertEquals(Actual__ordering.contains("price"), Actual__ordering.contains(ordering_by_price),
					Actual__ordering);
		} else {

			myassertion.assertEquals(Actual__ordering.contains("price"), Actual__ordering.contains(ordering_by_price),
					Actual__ordering);
			

		}
	}

	@AfterTest
	public void AterTesting() {
		myassertion.assertAll();

	}
}
