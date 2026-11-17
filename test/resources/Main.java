import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C://Users//Pablo//Desktop//Новая папка (3)//chromedriver.exe/");

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.sharelane.com/cgi-bin/register.py");
            System.out.println("Выполняется позитивный тест...");

            WebElement zipField = driver.findElement(By.name("zip_code"));
            zipField.sendKeys("12345");

            WebElement continueButton = driver.findElement(By.cssSelector("input[type='submit']"));
            continueButton.click();

            String pageSource = driver.getPageSource();
            if (pageSource.contains("Sign Up")) {
                System.out.println("Тест 1 пройден: Переход на следующую страницу выполнен.");
            } else {
                System.out.println("Тест 1 не пройден: Перехода не произошло.");
            }

            System.out.println("Выполняется негативный тест...");
            driver.get("https://www.sharelane.com/cgi-bin/register.py"); // Возвращаемся на страницу формы

            WebElement emptyZipField = driver.findElement(By.name("zip_code"));
            emptyZipField.clear();

            WebElement emptyContinueButton = driver.findElement(By.cssSelector("input[type='submit']"));
            emptyContinueButton.click();


            System.out.println("Тест 2: Проверка пустого поля завершена (нужно посмотреть визуально, есть ли реакция).");

        } catch (Exception e) {
            System.out.println("Произошла ошибка во время выполнения: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}