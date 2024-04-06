package mg.inclusiv.cdan008;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testfonctionnelQualimetrie {

    public static void waitFonction(int timewaiting){
        try {
            Thread.sleep(timewaiting);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {

        // Instanciation du pilote Chrome
        WebDriver chromedriver = new ChromeDriver();

        // Ouvrir l'application
        chromedriver.get("http://localhost:8080");

        //Attendre 3 secondes que la page se charge
        waitFonction(3000);


        // Cliquez sur le lien S'inscrire
        WebElement sinscrire = chromedriver.findElement(By.xpath("//*[@id=\"loginForm\"]/small/a"));
        sinscrire.click();

        //Attendre 2 secondes que la fenêtre se charge
        waitFonction(2000);

        // Remplissez le formulaire d'inscription
        WebElement inputTextNom = chromedriver.findElement(By.xpath("//*[@id=\"inputNom\"]"));
        WebElement inputTextPrenom = chromedriver.findElement(By.xpath("//*[@id=\"prenom\"]"));
        WebElement inputTextMail = chromedriver.findElement(By.xpath("//*[@id=\"mail\"]"));
        WebElement inputTextPassword = chromedriver.findElement(By.xpath("//*[@id=\"input2\"]"));
        WebElement inputTextConfirmerPassword = chromedriver.findElement(By.xpath("//*[@id=\"sectioninscription\"]/div/div[2]/form/div[4]/input"));

       //Cliquez sur le bouton "S'inscrire"
        WebElement btnSinscrire = chromedriver.findElement(By.xpath("//*[@id=\"sectioninscription\"]/div/div[2]/form/div[6]/button"));

        //Cliquez sur le bouton "Annuler" (l'inscription)
        WebElement btnAnnuler = chromedriver.findElement(By.xpath("//*[@id=\"sectioninscription\"]/div/div[2]/form/div[6]/a"));


        inputTextNom.sendKeys("Rakoto");
        inputTextPrenom.sendKeys("Nandrasana");
        inputTextMail.sendKeys("rakoto@gmail.com");
        inputTextPassword.sendKeys("nandrasana");
        inputTextConfirmerPassword.sendKeys("nandrasana");

        //Attendre 4 secondes pour que la page se charge
        waitFonction(4000);
        btnSinscrire.click();

        // Accéder à la page d'authentification
        WebElement inputTextInscriptionNom = chromedriver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[1]/input"));
        WebElement inputTextInscriptionPassword = chromedriver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[2]/input"));
        WebElement btnAuthentifier = chromedriver.findElement(By.xpath("//*[@id=\"loginForm\"]/button"));

        // Saisir l'adresse email et le mot de passe
        inputTextInscriptionNom.sendKeys("rakoto@gmail.com");
        inputTextInscriptionPassword.sendKeys("nandrasana");

        //Attendre 3 secondes pour que la page se charge
        waitFonction(3000);

        btnAuthentifier.click();

        waitFonction(4000);

    }
}