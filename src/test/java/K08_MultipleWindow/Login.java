package K08_MultipleWindow;

import com.microsoft.playwright.*;

import java.awt.*;
import java.nio.file.Paths;

public class Login {
    public static void main(String[] args) throws InterruptedException {

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) dimension.getWidth();
        int height = (int) dimension.getHeight();

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.setViewportSize(width,height);


        page.navigate("https://test.urbanicfarm.com/");
        System.out.println("title " + page.title());

        Locator login = page.locator("div[class='Navbar_linkContainer__2jWIM']").getByText("Login");
        //div[@class='Navbar_linkContainer__2jWIM']/a[@href='/auth/login']
        login.click();

        Locator email = page.getByPlaceholder("email");
        email.fill("buyer_urban@mailsac.com");

        Locator password = page.getByPlaceholder("password");
        password.fill("VHt*zzt*wQNu6XS");
        Thread.sleep(3000);

        Locator loginButton = page.locator("button[type='submit']");
        loginButton.click();


        Locator closeButton = page.locator("//div[@class='CheckDistrictModal_x-btn__sVOij']");
        closeButton.click();

        //Locator editButton = page.getByText("Edit");
        Locator editButton = page.locator("//table[@class='Profile_table__xQUON']//button");
        editButton.click();

        Thread.sleep(3000);

        // Select one file
        Locator fileInput = page.locator("input[class='form-control my-2 Profile_imgInput__3CXq7']");
        String filePath = System.getProperty("user.home") + "/Desktop/haluk bilginer.png";

        fileInput.setInputFiles(Paths.get(filePath));


        Locator saveButton = page.getByText("Save");
        saveButton.click();










        Thread.sleep(3000);

        page.close();
        browser.close();
        playwright.close();

















    }
}