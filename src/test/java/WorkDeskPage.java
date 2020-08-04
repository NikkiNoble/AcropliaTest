import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class WorkDeskPage {
    private static By blueContinueButton = By.cssSelector(".btn-size-3-normal");
    private static By skipAllButton = By.className("_3cKnd");
    private static By contactButton = By.cssSelector("[href='/connect/96725197-6ca5-3cda-bd4e-abd4c6b9a5c4']");
    private static By messageInput = By.cssSelector("[placeholder='Сообщение']");
    private static By sendMessageButton  = By.className("_3iqDM");
    private static By message = By.xpath("//*[contains(text(), 'Hello!')]");
    private static By emojiIcon = By.cssSelector("[title='Эмоджи']");
    private static By emoji = By.cssSelector("._1NapJ");
    private static By workSpace = By.cssSelector("[href='/my-desk']");
    private static By notePadBlank = By.cssSelector(".ql-editor");
    private static By taskMakerButton = By.cssSelector("[title='Список задач']");
    private static By taskPlateTitle = By.cssSelector("._39FI3");
    static void sendTextMessage() {
        LoginPage.loginToAcroplia();
        WebDriverWait wait = new WebDriverWait(Driver.driver, 15);
        wait.until(visibilityOfElementLocated(blueContinueButton));
        Driver.driver.findElement(blueContinueButton).click();
        Driver.driver.findElement(contactButton).click();
        wait.until(visibilityOfElementLocated(skipAllButton));
        Driver.driver.findElement(skipAllButton).click();
        Driver.driver.findElement(messageInput).sendKeys("Hello!");
        Driver.driver.findElement(sendMessageButton).click();
        Driver.driver.findElement(message).isDisplayed();
        Driver.driver.findElement(emojiIcon).click();
        Driver.driver.findElement(emoji).click();
        Driver.driver.findElement(messageInput).sendKeys("Привет!");
        Driver.driver.findElement(messageInput).sendKeys(Keys.ENTER);
    }
    static void writeInTextPad() {
        LoginPage.loginToAcroplia();
        WebDriverWait wait = new WebDriverWait(Driver.driver, 15);
        wait.until(visibilityOfElementLocated(blueContinueButton));
        Driver.driver.findElement(blueContinueButton).click();
        Driver.driver.findElement(workSpace).click();
        wait.until(visibilityOfElementLocated(skipAllButton));
        Driver.driver.findElement(skipAllButton).click();
        Driver.driver.findElement(notePadBlank).sendKeys("Мама мыла раму.");
        Driver.driver.findElement(taskMakerButton).click();
        Driver.driver.findElement(taskPlateTitle).click();
        Driver.driver.findElement(By.cssSelector("textarea")).sendKeys("Meeting");
    }
}
