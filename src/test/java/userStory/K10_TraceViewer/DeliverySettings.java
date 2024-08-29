package userStory.K10_TraceViewer;

import com.microsoft.playwright.*;

import java.awt.*;
import java.nio.file.Paths;

public class DeliverySettings {
    public static void main(String[] args) throws InterruptedException {

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) dimension.getWidth();
        int height = (int) dimension.getHeight();

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext context =  browser.newContext();


        // Start tracing before creating / navigating a page.
        context.tracing().start(new Tracing.StartOptions().
                setScreenshots(true).
                setSnapshots(true).
                setSources(true));



        Page page = context.newPage();
        page.setViewportSize(width,height);

        page.navigate("https://test.urbanicfarm.com/");
        System.out.println("title " + page.title());

        Locator login = page.locator("//div[@class='Navbar_linkContainer__2jWIM']/a[@href='/auth/login']");
        login.click();

        Locator email = page.getByPlaceholder("email");
        email.fill("buyer_urban@mailsac.com");

        Locator password = page.getByPlaceholder("password");
        password.fill("VHt*zzt*wQNu6XS");

        Locator loginButton = page.locator("//button[@type='submit']");
        loginButton.click();

        Locator closeButton = page.locator(" div[class='CheckDistrictModal_x-btn__sVOij']");
        closeButton.click();

        Locator deliveryButton = page.getByText("Delivery & Pick up settings");
        deliveryButton.click();

        //Locator sellerCheckBox = page.locator("(//div[@class='custom-control custom-checkbox'])[4]");
        //sellerCheckBox.click();

        page.getByLabel("Seller flexible delivery").check();

        Locator freeDelivery = page.locator("//input[@id='freeFlexibleDeliveryRange']");
        freeDelivery.click();
        freeDelivery.fill("100");

        Locator minimumOrder = page.locator("//input[@id='minFreeFlexibleDeliveryOrder']");
        minimumOrder.click();
        minimumOrder.fill("2");

        Locator perMileCost = page.locator("//input[@id='perMileCostFlex']");
        perMileCost.click();
        perMileCost.fill("5");

        Locator maxDeliveryRange = page.locator("//input[@id='maxFlexibleDeliveryRange']");
        maxDeliveryRange.click();
        maxDeliveryRange.fill("15");

        // select options
        Locator selectCategory = page.locator("(//select[@class='form-control'])[2]");

        // Select by value
        selectCategory.selectOption("Wednesday");

        Locator  updateButton = page.getByText("Update");
        updateButton.click();

















        Thread.sleep(4000);

        // Stop tracing and export it into a zip archive.
        context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("trace.zip")));



        context.close();
        page.close();
        playwright.close();



    }
}
