import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class LoginPage {
    private static By continueButton = By.className("btn-nofiled-blue");
    private static By mailInput = By.xpath("//input[@name='email'][@placeholder='Заполните...']");
    private static By blueNextButton = By.xpath("//*[contains(text(), 'Далее')]");
    private static By wrongAddress = By.xpath("//*[contains(text(), 'Неверный адрес электронной почты')]");
    private static By wrongUser = By.xpath("//*[contains(text(), 'Пользователь не найден')]");
    static By passwordInput = By.xpath("//input[@name='password'][@placeholder='Пароль']");
    private static By enterButton = By.cssSelector(".btn-size-4");
    private static By wrongPassword = By.xpath("//*[contains(text(), 'Неверный пароль')]");
    static By workingDesk = By.className("_14CaT");
    static By messageAlert = By.xpath("//*[contains(text(), 'Не отправлено. Повторить?')]");
    static boolean findElement(By element) {
        try {
            Driver.driver.findElement(element).isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    private static void openPage() {
        WebDriverWait wait = new WebDriverWait(Driver.driver, 15);
        Driver.driver.get("https://demo.acroplia.com/login");
        wait.until(visibilityOfElementLocated(continueButton));
        Driver.driver.findElement(continueButton).click();
    }
    private static void findWrongAddressAlert() {
        Driver.driver.findElement(wrongAddress).isDisplayed();
    }
    private static void findWrongUserAlert() {
        Driver.driver.findElement(wrongUser).isDisplayed();
    }
    static void findWrongPasswordAlert() {
        Driver.driver.findElement(wrongPassword).isDisplayed();
    }
    static void loginToAcroplia() {
        LoginPage.openPage();
        Driver.driver.findElement(mailInput).sendKeys("simpletest00@mail.ru");
        Driver.driver.findElement(blueNextButton).click();
        WebDriverWait wait = new WebDriverWait(Driver.driver, 15);
        wait.until(visibilityOfElementLocated(passwordInput));
        Driver.driver.findElement(passwordInput).sendKeys("simple123456");
        Driver.driver.findElement(enterButton).click();
        wait.until(visibilityOfElementLocated(workingDesk));
    }
    static void loginWithEmptyEmail() {
        LoginPage.openPage();
        Driver.driver.findElement(blueNextButton).click();
        LoginPage.findWrongAddressAlert();
        Driver.driver.findElement(blueNextButton).click();
    }
    static void loginWithIncorrectEmail() {
        LoginPage.openPage();
        Driver.driver.findElement(mailInput).sendKeys("motolovanastya");
        LoginPage.findWrongAddressAlert();
        Driver.driver.findElement(blueNextButton).click();
    }
    static void loginWithNotExistingUser() {
        LoginPage.openPage();
        Driver.driver.findElement(mailInput).sendKeys("ivanova@test.ru");
        LoginPage.findWrongUserAlert();
        Driver.driver.findElement(blueNextButton).click();
    }
    static void loginWithInvalidInput() {
        LoginPage.openPage();
        Driver.driver.findElement(mailInput).sendKeys(" “”‘~!@#$%^&*()?>,./\\<][ /*<!–”\", “${code}”;–>");
        LoginPage.findWrongAddressAlert();
        Driver.driver.findElement(mailInput).clear();
        Driver.driver.findElement(mailInput).sendKeys("   motolovanastya@gmail.com");
        LoginPage.findWrongAddressAlert();
        Driver.driver.findElement(mailInput).clear();
        Driver.driver.findElement(mailInput).sendKeys("<script>document.getElementByID(“…”).disabled=true</script>");
    }
    static void loginWithMailRegister() {
        LoginPage.openPage();
        Driver.driver.findElement(mailInput).sendKeys("MotoLovanaStya@gmail.com");
        Driver.driver.findElement(blueNextButton).click();
        WebDriverWait wait = new WebDriverWait(Driver.driver, 15);
        wait.until(visibilityOfElementLocated(passwordInput));
        Driver.driver.findElement(passwordInput).sendKeys("nokilnokil");
        Driver.driver.findElement(enterButton).click();
        wait.until(visibilityOfElementLocated(workingDesk));
    }
    static void loginWithEmptyPassword() {
        LoginPage.openPage();
        Driver.driver.findElement(mailInput).sendKeys("motolovanastya@gmail.com");
        Driver.driver.findElement(blueNextButton).click();
        WebDriverWait wait = new WebDriverWait(Driver.driver, 15);
        wait.until(visibilityOfElementLocated(passwordInput));
        Driver.driver.findElement(enterButton).click();

    }
    static void loginWithPasswordRegister() {
        LoginPage.openPage();
        Driver.driver.findElement(mailInput).sendKeys("motolovanastya@gmail.com");
        Driver.driver.findElement(blueNextButton).click();
        WebDriverWait wait = new WebDriverWait(Driver.driver, 15);
        wait.until(visibilityOfElementLocated(passwordInput));
        Driver.driver.findElement(passwordInput).sendKeys("NOKILnokil");
        Driver.driver.findElement(enterButton).click();
    }
}
