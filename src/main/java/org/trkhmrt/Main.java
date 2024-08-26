package org.trkhmrt;

import com.microsoft.playwright.*;

import java.awt.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        //Varsayılan ekran ölçülerini okur sistemden
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) dimension.getWidth();
        int height = (int) dimension.getHeight();

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("http://www.hepsiemlak.com");
        System.out.println(page.title());
        page.setViewportSize(width, height);

        /*
        Locator shadowDom = page.locator("span", new Page.LocatorOptions().setHasText("Satılık")).first();
        System.out.println("Text:" + shadowDom.innerText());


        */

        Locator loginText = page.getByText("Satılık");
        System.out.println(loginText);

        Locator enter=page.getByPlaceholder("Konum, ilan no ya da emlak ofisi adıyla arayın (Örn. 1234-123456)");
        enter.click();
        enter.fill("Satılık ev Ara");

        Locator button=page.getByLabel("Arama Yap");
        button.click();



        Thread.sleep(5000);

        page.close();
        browser.close();
        playwright.close();


    }
}