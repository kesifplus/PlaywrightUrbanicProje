package K08_MultipleWindow;

import com.microsoft.playwright.*;

import java.awt.*;

public class TabTUF {
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


        Locator linkedin = page.locator("a[href='https://www.linkedin.com/company/urbanicfarm/']");
        //linkedin.click(new Locator.ClickOptions().setForce(true));

        Page newPage = page.context().waitForPage(() -> {

            //linkedin.evaluate("linkedin => linkedin.scrollIntoViewIfNeeded()");
            linkedin.scrollIntoViewIfNeeded();

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            linkedin.click(); //opens new tab
        });

        newPage.waitForLoadState();
        System.out.println("title " + newPage.title());

        Thread.sleep(3000);

        // Eski sekmeye geri don
        page.bringToFront();

        Thread.sleep(6000);
        page.close();
        browser.close();
        playwright.close();
































    }
}
