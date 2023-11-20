package TaskList;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import BasePackage.BaseClass;

public class TestTotalResult extends BaseClass {
@Test
	public void TotalSEarchResultForEveryPage() throws InterruptedException {

		// go to base url
		navigateUrl(myProperties.getProperty("url"));
		Thread.sleep(3000);
		// sending value to the search option
		//// input[@type='search
		//driver.findElement(By.xpath(myProperties.getProperty("landing_page_search_box"))).sendKeys("camera" + Keys.ENTER);
		sendKeys(By.xpath(myProperties.getProperty("landing_page_search_box")),"camera" +Keys.ENTER);
		
		Thread.sleep(3000);
		int lastPage, count = 1, pageResult = 0, totalResult = 0;

		// total number of pages
		String last = getText(By.xpath(myProperties.getProperty("paginator_last_page")));

		// converting string to int
		lastPage = Integer.parseInt(last);
		System.out.println("Late page = " + lastPage);

		for (int num = 1; num <= lastPage; num++) {

			Thread.sleep(3000);

			List<WebElement> itemForSEarchTag = driver.findElements(By.xpath(myProperties.getProperty("page_item_list_against_search_tag")));
			pageResult = itemForSEarchTag.size();
			System.out.println("Items for page[" + count + " ] :" + pageResult);

			totalResult = totalResult + pageResult;
			count++;

			try {
				click(By.xpath(myProperties.getProperty("paginator_next_page_button")));
			} catch (NoSuchElementException e) {
				System.out.println("No such element ");
			}
		}

		System.out.println("total Search Result =" + totalResult);
		
		Assert.assertTrue(totalResult>500, "Total Result is less than 500");

	}

}
