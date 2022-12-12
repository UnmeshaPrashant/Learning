package ControlExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.nopcomm.BaseClass;

public class SelectControl extends BaseClass {

	@Test (priority=2)
	public void selectExample() throws InterruptedException {
		Thread.sleep(3000);
		WebElement list = driver.findElement(By.cssSelector("select[name='FromLB']"));

		// handle dropdown
		// Select

		Select sel = new Select(list);

		System.out.println("listbox accept multiple selection or not: " + sel.isMultiple());

		// select value from dropdown
		sel.selectByIndex(0); // USA
		Thread.sleep(1000);
		sel.selectByValue("India"); // India
		Thread.sleep(1000);
		sel.selectByVisibleText("Spain"); // Spain
		Thread.sleep(2000);

		// deselect value from dropdown

		sel.deselectByValue("USA");

	}

	@Test (priority=1)
	public void handlelist2() throws Exception {
		Thread.sleep(3000);

		WebElement list = driver.findElement(By.tagName("select"));

		// handle dropdown
		// Select

		Select sel = new Select(list);

		System.out.println("listbox accept multiple selection or not: " + sel.isMultiple());

		// select value from dropdown
		sel.selectByIndex(1); // Saab
		Thread.sleep(1000);
		sel.selectByValue("Singapore"); // India
		Thread.sleep(1000);
		sel.selectByVisibleText("Toyota"); // Spain
		Thread.sleep(2000);

		// deselect value from dropdown

		// sel.deselectByValue("USA");

	}
	
}
