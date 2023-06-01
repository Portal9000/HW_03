
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class FormTest {
    @Test
    public void checkRegistrationFormData() {
        WebDriver driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");

        WebElement firstNameField = driver.findElement(By.xpath("//input[@id=\"firstName\"]"));
        firstNameField.sendKeys("Sasha");

        WebElement lastNameField = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
        lastNameField.sendKeys("Zinchuk");

        WebElement eMailField = driver.findElement(By.xpath("//input[@class='mr-sm-2 form-control']"));
        // Этот икспас - единственный. Выделяет только его. Есть еще 3 таких же, но с пробелом в начале. Зачем так сделано? Косяк разработчика?
        eMailField.sendKeys("abrakadabra@site.com");

        WebElement genderFemaleRadioButton = driver.findElement(By.xpath("//label[@for=\"gender-radio-1\"]"));
        genderFemaleRadioButton.click();

        WebElement dateOfBirthField = driver.findElement(By.xpath("//*[@id=\"dateOfBirthInput\"]"));
        dateOfBirthField.click();                // Открываем календарь для выбора даты
        WebElement dateOfBirthChoose = driver.findElement(By.xpath("//div[@aria-label='Choose Monday, May 1st, 2023']"));
        dateOfBirthChoose.click();

        // Закомментил, потому как не происходит активация чек-бокса. Это делается не через click() ?
//        WebElement hobbyCheckBoxes = driver.findElement(By.xpath("//input[@type='checkbox'][@value='1']"));
//        hobbyCheckBoxes.click();

        // Закомментил, потому как не нажимается кнопка. Это делается не через click() ?
//        WebElement selectPictureButton = driver.findElement(By.xpath("//input[@type='file']"));
//        selectPictureButton.click();
    }
}