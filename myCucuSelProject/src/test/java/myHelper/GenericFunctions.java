package myHelper;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class GenericFunctions 
{
	WebDriver driver;
	Base base;
	public GenericFunctions(Base base) 
	{
		this.base=base;
	}
	public byte[] getByteScreenshot() throws IOException 
	{
	    File src = ((TakesScreenshot) base.getDriver()).getScreenshotAs(OutputType.FILE);
	    byte[] fileContent = FileUtils.readFileToByteArray(src);
	    return fileContent;
	}
	/*public static String getBase64Screenshot() throws IOException 
	{
		String Base64StringOfScreenshot = "";
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMYYYY_HHmmss");
		String sDate = sdf.format(date);
		FileUtils.copyFile(src, new File(screenshotdir + "image_" + sDate + ".png"));

		byte[] fileContent = FileUtils.readFileToByteArray(src);
		Base64StringOfScreenshot = "data:image/png;base64," + Base64.getEncoder().encodeToString(fileContent);
		return Base64StringOfScreenshot;
	}*/

}
