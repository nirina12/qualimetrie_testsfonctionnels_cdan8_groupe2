/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package mg.inclusiv.cdan008;

import java.io.File;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import static org.openqa.selenium.By.className;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Inclusiv Academy
 */
public class TpSelenium {

    public static void main(String[] args) {

        // Instanciation du pilote Chrome
        WebDriver chromedriver = new ChromeDriver();

        // Ouvrir le premier résultat de la recherche "Inclusiv Academy sur google.com
//         Ouvrir Google.com
//        chromedriver.get("https://google.com");
//        
//        // Trouver la barre de recherche
//        WebElement barreRecherche = chromedriver.findElement(By.name("q"));
//        
//        // Saisir la recherche "inclusiv academy"
//        barreRecherche.sendKeys("inclusiv academy");
//        
//        
//       // Appuyer sur la touche Entrée pour effectuer la recherche
//        barreRecherche.sendKeys(Keys.RETURN);
//        
//        // Patienter un peu pour que la page de résultats se charge
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        
//        // Trouver tous les liens dans la page de résultats
//        List<WebElement> resultats = chromedriver.findElements(By.xpath("//*[@id='rso']/div[1]/div/div/div/div/div/div/div/div[1]/div/span/a/h3"));
//      
        // Ouvrir le premier résultat
//        if (!resultats.isEmpty()) {
//            WebElement premierResultat = resultats.get(0);
//            premierResultat.click();
//        }
//        
//        // Patienter un peu pour voir le résultat
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        
//        // Fermer le navigateur chrome
//        chromedriver.quit();
        // Chemin vers le pilote Edge
//        System.setProperty("webdriver.edge.driver", "C:\\Users\\Inclusiv Academy\\Documents\\DriverWeb\\edgedriver_win64\\msedgedriver.exe");
//
//        WebDriver edgedriver = new EdgeDriver();
//        
//        edgedriver.get("https://selenium.dev");
//        
//        edgedriver.quit();
        // Effectuer une commande de 5 iphones sur kibo.mg et capturer l'écran de la page de paiement
        // Ouvrir Google.com
        chromedriver.get("https://google.com");

        // Trouver la barre de recherche
        WebElement barreRecherche = chromedriver.findElement(By.name("q"));

        // Saisir la recherche "kibo.mg"
        barreRecherche.sendKeys("kibo.mg");

        // Appuyer sur la touche Entrée pour effectuer la recherche
        barreRecherche.sendKeys(Keys.RETURN);

        // Patienter un peu pour que la page de résultats se charge
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Trouver tous les liens dans la page de résultats
        WebElement resultats = chromedriver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div/div[1]/div/span/a/h3"));
        resultats.click();

        // Trouver la barre de recherche
        WebElement RechercheKibo = chromedriver.findElement(By.name("s"));

        // Saisir la recherche "iphone"
        RechercheKibo.sendKeys("iphone");

        // Appuyer sur la touche Entrée pour effectuer la recherche
        RechercheKibo.sendKeys(Keys.RETURN);

        //Afficher tous les résultats de la recherche
        WebElement resultatiphone = chromedriver.findElement(By.xpath("//*[@id=\"js-product-list\"]/div[1]/article[3]/div"));
        resultatiphone.click();

        //Modifier la quantité à commander en 5
        WebElement nombrephone = chromedriver.findElement(By.xpath("//*[@id=\"quantity_wanted\"]"));
        nombrephone.clear();
        nombrephone.sendKeys("5");

        //Clicker sur le bouton "Commander"
        WebElement commander = chromedriver.findElement(By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[3]/div/div[2]/button"));
        commander.click();

        //Patientez un moment pendant que ça charge
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Confirmer la commande
        WebElement confirmationCommande = chromedriver.findElement(By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a"));
        confirmationCommande.click();

        //Patientez un moment pendant que ça charge
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Valider la commande et procéder au paiement
        //WebElement validerCommande = chromedriver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div[2]/div/div[2]/div/a"));
//        validerCommande.click();
//
//        try {
//            Thread.sleep(8000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        // Capturer l'écran de la page de paiement
        File captureEcran = ((TakesScreenshot) chromedriver).getScreenshotAs(OutputType.FILE);

        // Spécifier le chemin de destination de la capture d'écran
        File destination = new File("C:\\Users\\Inclusiv Academy\\Documents\\captureTP\\capture.png");

        // Copier le fichier de capture d'écran vers le dossier de destination avec gestion d'erreur
        try {

            FileUtils.copyFile(captureEcran, destination);
            System.out.println("Capture d'écran enregistrée avec succès à : " + destination.getAbsolutePath());

        } catch (Exception e) {
            System.out.println("Erreur lors de l'enregistrement de la capture d'écran : " + e.getMessage());
        }
        chromedriver.quit();
    }
}
