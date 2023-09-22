package suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Web {

    public static WebDriver createChromeTrivago(){

        System.setProperty("webdriver.chrome.driver","C:\\Users\\anneg\\OneDrive\\Documentos\\drivers\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().window().maximize();
        navegador.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        navegador.get("https://www.trivago.com.br/");

        return navegador;

    }
}
