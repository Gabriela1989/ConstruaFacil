package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Resultado {
    WebDriver driver;


    @FindBy(css = "h3")
    WebElement indicadorDeCurso;


    @FindBy(css = "span.comprar")
    WebElement btnMatriculese;

    public Resultado(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String LerIndicadorDeCurso(){
        return indicadorDeCurso.getText();

    }
    public void clicarMatriculese(){
        btnMatriculese.click();
    }

    public By verificarElemento(){
        return By.cssSelector("h3");

    }
}
