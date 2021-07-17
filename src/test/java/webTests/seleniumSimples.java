// 1 - Pacote
package webTests;

// 2 - Bibliotecas
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Evidencias;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import utils.Evidencias;
import utils.Logs;

// 3 - Classe
public class seleniumSimples {
    // 3.1 - Atributos

    WebDriver driver;
    Evidencias evidencias;
    Logs logs;

    static String dataHora = new SimpleDateFormat("yyyy-MM-dd HH-mm").format(Calendar.getInstance().getTime());

// 3.2 - Métodos e Funções

//executa 1 única vez apenas, no inicio da execução do script
    @BeforeClass
    public void antesDeTudo() throws IOException {
        logs = new Logs();
        logs.iniciarLogCSV(dataHora);
    }

// Executa antes de cada @Test
    @BeforeMethod
    public void iniciar(){

 // A - Início

 // Aponta para onde está o driver do Chrome
        System.setProperty("webdriver.chrome.driver", "drivers/chrome/91/chromedriver.exe");
        // Instancia o objeto driver como um controlador do Chrome
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(150000, TimeUnit.MILLISECONDS);

        evidencias = new Evidencias(); //
        logs = new Logs();
    }

    @AfterMethod
    public void finalizar(){
        // Parte C - Encerramento

        driver.quit(); // Encerra o objeto do Selenium
    }

    @Test(priority = 1)
    public void consultarCursoMantis() throws IOException {
        String casoDeTeste = "Consultar Curso Mantis";

        // B - Realizar o teste
        logs.registrarCSV(casoDeTeste,"Iniciou o teste");
        driver.get("https://www.iterasys.com.br");
        logs.registrarCSV(casoDeTeste,"Abriu o site");
        evidencias.print(driver, dataHora, casoDeTeste, "Passo 1 - Abriu o site");

        driver.findElement(By.id("searchtext")).click();
        logs.registrarCSV(casoDeTeste,"Clicou na caixa de pesquisa");
        driver.findElement(By.id("searchtext")).clear();
        logs.registrarCSV(casoDeTeste,"Limpou a caixa de pesquisa");
        driver.findElement(By.id("searchtext")).sendKeys("mantis");
        logs.registrarCSV(casoDeTeste,"Escreveu Mantis na caixa de pesquisa");

        evidencias.print(driver, dataHora, casoDeTeste,"Passo 2 - Digitou Mantis");
        driver.findElement(By.id("btn_form_search")).click();
        logs.registrarCSV(casoDeTeste,"Clicou no botão da Lupa");

        assertEquals(driver.findElement(By.cssSelector("h3")).getText(), "Cursos › \"mantis\"");
        logs.registrarCSV(casoDeTeste,"Confirmou o texto indicativo da pesquisa do curso Mantis");

        evidencias.print(driver, dataHora, casoDeTeste,"Passo 3 - Exibiu a lista de cursos");
        driver.findElement(By.cssSelector("span.comprar")).click();
        logs.registrarCSV(casoDeTeste,"Clicou no botão Matricule-se");

        assertEquals(driver.findElement(By.cssSelector("span.item-title")).getText(), "Mantis");
        logs.registrarCSV(casoDeTeste,"Confirmou o nome do curso Mantis");
        assertEquals(driver.findElement(By.cssSelector("span.new-price")).getText(), "R$ 49,99");
        logs.registrarCSV(casoDeTeste,"Confirmou o preço do curso Mantis");
        evidencias.print(driver, dataHora, casoDeTeste,"Passo 4 - Exibiu o carrinho de compras");
        logs.registrarCSV(casoDeTeste,"Concluiu o teste");
    }

    @Test(priority = 2)
    public void consultarCursoCTFL() throws IOException {
        String casoDeTeste = "Consultar Curso CTFL";

        // B - Realizar o teste
        driver.get("https://www.iterasys.com.br");
        logs.registrarCSV( casoDeTeste, "Passo 1 - Abriu o site");
        evidencias.print(driver, dataHora, casoDeTeste,"Passo 1 - Abriu o site");

        driver.findElement(By.id("searchtext")).click();
        driver.findElement(By.id("searchtext")).clear();
        driver.findElement(By.id("searchtext")).sendKeys("preparatório ctfl");
        logs.registrarCSV( casoDeTeste, "Passo 2 - Digitou preparatorio CTFL");
        evidencias.print(driver, dataHora, casoDeTeste,"Passo 2 - Digitou preparatorio ctfl");
        driver.findElement(By.id("btn_form_search")).click();

        assertEquals(driver.findElement(By.cssSelector("h3")).getText(), "Cursos › \"preparatório ctfl\"");

        logs.registrarCSV( casoDeTeste, "Passo 3 - Exibiu a lista de cursos");
        evidencias.print(driver, dataHora, casoDeTeste,"Passo 3 - Exibiu a lista de cursos");
        driver.findElement(By.cssSelector("span.comprar")).click();

        assertEquals(driver.findElement(By.cssSelector("span.item-title")).getText().toUpperCase(), "PREPARATÓRIO CTFL");
        assertEquals(driver.findElement(By.cssSelector("span.new-price")).getText(), "R$ 169,00");
        logs.registrarCSV( casoDeTeste, "Passo 4 - Exibiu o carrinho de compras");
        evidencias.print(driver, dataHora, casoDeTeste,"Passo 4 - Exibiu o carrinho de compras");
    }
}