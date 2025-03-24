/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab4;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Hoang
 */
public class Test {

    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<>();
    }

    public void tearDown() {
        driver.quit();
    }

    public void demo52() throws InterruptedException {
        driver.get("http://localhost:8080/SWP/login.jsp");
        driver.manage().window().setSize(new Dimension(784, 912));

        Thread.sleep(1000);
        driver.findElement(By.linkText("Register Now")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("username")).sendKeys("anh12");
        Thread.sleep(1000);
        driver.findElement(By.name("fullname")).sendKeys("adddd");
        Thread.sleep(1000);
        driver.findElement(By.name("email")).sendKeys("cuong@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.name("phone")).sendKeys("0122331322");
        Thread.sleep(1000);
        driver.findElement(By.name("address")).sendKeys("aaaaaa");
        Thread.sleep(1000);
        driver.findElement(By.name("dateOfBirth")).sendKeys("4-02-2004");
        Thread.sleep(1000);
        driver.findElement(By.id("gender")).sendKeys("Male");
        Thread.sleep(1000);
        driver.findElement(By.name("password")).sendKeys("Hoangvhhy1z@");
        Thread.sleep(1000);
        driver.findElement(By.name("confirm_password")).sendKeys("Hoangvhhy1z@");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".btn")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("user")).sendKeys("anh12");
        Thread.sleep(1000);
        driver.findElement(By.id("password")).sendKeys("Hoangvhhy1z@");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".btn-primary")).click();
        Thread.sleep(1000);
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.setUp();
        try {
            test.demo52();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            test.tearDown();
        }
    }
}
