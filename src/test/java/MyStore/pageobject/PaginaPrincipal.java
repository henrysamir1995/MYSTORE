package MyStore.pageobject;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import java.awt.*;
import java.awt.event.KeyEvent;


public class PaginaPrincipal extends PageObject {


    @FindBy(css = "#header > div.nav > div > div > nav > div.header_user_info > a")
    WebElementFacade btnSignIn;

    @FindBy(id = "email")
    WebElementFacade btnUser;

    @FindBy(name="passwd")
    WebElementFacade btnPssw;

    @FindBy(id="SubmitLogin")
    WebElementFacade btnSignIn2;

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span")
    WebElementFacade nombreUsuario;

    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/a")
    WebElementFacade btnDresses;

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a")
    WebElementFacade image;

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a[1]/span")
    WebElementFacade btnAgregar;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")
    WebElementFacade btnProceed;

    @FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]/span")
    WebElementFacade btnProceed2;

    @FindBy(css = "#ordermsg > textarea")
    WebElementFacade textComment;

    @FindBy(xpath = "//*[@id=\"center_column\"]/form/p/button/span")
    WebElementFacade btnProceed3;

    @FindBy(xpath="//*[@id=\"uniform-cgv\"]")
    WebElementFacade checkbox;

    @FindBy(xpath = "//*[@id=\"form\"]/p/button/span")
    WebElementFacade btnProceed4;

    @FindBy(xpath = "//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")
    WebElementFacade btnPaymentBank;

    @FindBy(css = "#cart_navigation > button > span")
    WebElementFacade btnConfirmOrder;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div/p/strong")
    WebElementFacade textConfirm;

    Robot robot= new Robot();

    public PaginaPrincipal() throws AWTException {
    }

    public void loguearse() {
        btnSignIn.click();
        Serenity.takeScreenshot();
        btnUser.sendKeys("henrysamir1995@yahoo.com");
        btnPssw.sendKeys("henryxd");
        Serenity.takeScreenshot();
        btnSignIn2.click();
    }

    public String obtener_nombre_del_usuario(){
        Serenity.takeScreenshot();
        return nombreUsuario.getText();
    }

    public void agregar_producto() {
        Serenity.takeScreenshot();
        btnDresses.click();
        Actions actions= new Actions(getDriver());
        actions.moveToElement(image).moveToElement(btnAgregar).click().build().perform();
        Serenity.takeScreenshot();
    }

    public void realizar_pago_bancario() throws InterruptedException {
        btnProceed.click();
        Serenity.takeScreenshot();
        btnProceed2.click();
        textComment.sendKeys("Enviarlo lo más pronto posible");
        btnProceed3.click();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        Thread.sleep(3000);
        checkbox.click();
        btnProceed4.click();
        btnPaymentBank.click();
        btnConfirmOrder.click();
        Serenity.takeScreenshot();

    }

    public String obtener_mensaje_confirmacion() throws InterruptedException {
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(3000);
        Serenity.takeScreenshot();
        return textConfirm.getText();
    }
}
