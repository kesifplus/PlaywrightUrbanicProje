package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.options.AriaRole.TEXTBOX;

public class MainPage1 {

    private Page page;
    public Locator phoneNumber;


    // Sayfa nesnesini ayarla
    public MainPage1(Page page) {
        this.page = page;
        this.phoneNumber = page.getByRole(TEXTBOX, new Page.GetByRoleOptions().setName("Telefon "));


        Locator phoneNumber = page.getByRole(TEXTBOX, new Page.GetByRoleOptions().setName("Telefon "));





    }

















}
