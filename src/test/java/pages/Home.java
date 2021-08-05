package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {// Classe de mapeamento possui 03 seções
    // 1 - Mapemanento de Elementos (Atributos)
    WebDriver driver;
    @FindBy(id = "searchtext")
    WebElement caixaDePesquisa; // txtPesquisa
    @FindBy(id = "btn_form_search")
    WebElement botaoProcurar; // btnProcurar

    // 2 - Construtor entre os Elementos e os Passos
    public Home(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // 3 - Funções e Métodos Mapeados
    public void pesquisarPorCurso(String curso) {
        caixaDePesquisa.click();
        caixaDePesquisa.clear();
        caixaDePesquisa.sendKeys(curso);

    }
    public void clicarNaLupa() {
        botaoProcurar.click();


    }
}
