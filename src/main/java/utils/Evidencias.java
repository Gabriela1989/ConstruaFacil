package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Evidencias {

    public void print(WebDriver driver, String casoDeTeste, String nomePrint) throws IOException {
        File foto = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(foto, new File("target/prints/" + casoDeTeste + "/" + nomePrint +".png"));

    }
}
