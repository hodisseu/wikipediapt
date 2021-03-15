package simples;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Artigo {
    String url;         // endereço do site alvo
    WebDriver driver;   // Objeto do Selenium WebDriver

    @Before             // Antes do Teste
    public void iniciar(){
        url = "http://pt.wikipedia.org";
        System.setProperty("webdriver.chrome.driver", "Drivers/chrome/88/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
    }

    @Test               // Durante o Teste
    public void consultarArtigo(){
        driver.get(url);
        driver.findElement(By.id("searchInput")).sendKeys("Ovos de P?scoa");
        driver.findElement(By.id("searchButton")).click();
        assertEquals("Ovos de Páscoa - Wikipédia, a enciclopédia livre", driver.getTitle());
        //assertTrue(driver.getTitle().contains("Ovo de Páscoa"));

    }

    @After              // Depois do Teste
    public void finalizar(){
        //driver.quit();

    }
}
