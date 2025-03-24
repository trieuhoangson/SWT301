/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Hoang
 */
public class Test {

    public static void main(String[] args) {
        try {
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.selenium.dev/selenium/web/web-form.html");

            Thread.sleep(1*3000);
            driver.quit();
        } catch (Exception e) {
        }

    }
}
