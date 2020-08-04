import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AcropliaLoginTest {
    @BeforeAll
    static void setUpAll() {
        Driver.setUpAll();
    }
    @BeforeEach
    void setUp() {
        Driver.setUp();
    }
    @AfterEach
    void tearDown() {
        Driver.tearDown();
    }
    @Test
//  test checks successful login to demo.acroplia.com (mail, password)
    void shouldLogin() {
        LoginPage.loginToAcroplia();
    }
    @Test
//  test checks successful login to demo.acroplia.com (mail written in register, password)
    void shouldLoginWithRegister() {
        LoginPage.loginWithMailRegister();
    }
    @Test
//  checks impossibility to login with empty email field
    void shouldNotLoginWithEmptyEmail() {
        LoginPage.loginWithEmptyEmail();
        assertFalse(LoginPage.findElement(LoginPage.passwordInput));
    }
    @Test
//  checks impossibility to login with incorrect email field
    void shouldNotLoginWithIncorrectEmail() {
        LoginPage.loginWithIncorrectEmail();
        assertFalse(LoginPage.findElement(LoginPage.passwordInput));
    }
    @Test
//  checks impossibility to login with correct email field with not registered user
    void shouldNotLoginAsUnknownUser() {
        LoginPage.loginWithNotExistingUser();
        assertFalse(LoginPage.findElement(LoginPage.passwordInput));
    }
    @Test
//  checks impossibility to login with incorrect data in email field
    void shouldNotLoginInvalidInput() {
        LoginPage.loginWithInvalidInput();
        assertFalse(LoginPage.findElement(LoginPage.passwordInput));
    }
    @Test
//  checks impossibility to login with empty password field
    void shouldNotLoginWithEmptyPassword() {
        LoginPage.loginWithEmptyPassword();
        LoginPage.findWrongPasswordAlert();
        assertFalse(LoginPage.findElement(LoginPage.workingDesk));
    }
    @Test
// checks impossibility to login with password in Register
    void shouldNotLoginWithRegisterInPassword() {
        LoginPage.loginWithPasswordRegister();
        LoginPage.findWrongPasswordAlert();
        assertFalse(LoginPage.findElement(LoginPage.workingDesk));
    }
    @Test
//  checks message sending (as for now test fails, because when the message is sent an alert (not sent) is shown)
    void shouldSendTextMessage() {
        WorkDeskPage.sendTextMessage();
        assertFalse(LoginPage.findElement(LoginPage.messageAlert));
    }
    @Test
//  checks main functions of text pad
    void shouldWriteInTextPad() {
        WorkDeskPage.writeInTextPad();
    }
}
