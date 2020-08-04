# AcropliaTest
Тесты написаны на Selenium, Java 8, Gradle. Для запуска необходим chromedriver.
## Как запустить авто-тесты.

1. Зайти на https://sites.google.com/a/chromium.org/chromedriver/downloads и скачать необходимую версию chromedriver.
2. Распаковать архив в удобное место на компьютере, скопировать путь к chromedriver.exe
3. Зайти в класс Driver, в коде на строке 7 вместо `"C:\\chromedriver_win32\\chromedriver.exe"` вписать свой путь.

Тесты должны запуститься.

ВНИМАНИЕ! 

В моем случае с demo.acroplia.com/login всегда происходил редирект на  https://demo.acroplia.com/unsupported-browser?returnUrl=/login.
Если редиректа не происходит, все тесты могут упасть.  Как это исправить:
1. В методе openPage в классе LoginPage нужно поменять url на содержащий *unsupported-browser?returnUrl=/login*.

2. Второй вариант - в этом же методе просто удалить строки 

	`wait.until(visibilityOfElementLocated(continueButton));`

	`Driver.driver.findElement(continueButton).click();`
