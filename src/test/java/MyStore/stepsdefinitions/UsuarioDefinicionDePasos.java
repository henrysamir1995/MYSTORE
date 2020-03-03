package MyStore.stepsdefinitions;

import MyStore.steps.UserMyStore;
import com.google.common.annotations.GwtIncompatible;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.awt.*;

public class UsuarioDefinicionDePasos {

    @Steps(shared = true)
    UserMyStore usuario;

    @Given("^(.*) ingresa a la pagina de Mystore$")
    public void ingresaMyStore(String nombreDeUsuario){
        usuario.isCalled(nombreDeUsuario);
        usuario.ingresarAPagina();
    }

    @When("^(.*) se loguea$")
    public void iniciaSesion(String nombreDeUsuario) {
        usuario.isCalled(nombreDeUsuario);
        usuario.iniciarSesion();
    }

    @Then("^visualiza su nombre de usuario:(.*)$")
    public void visualizaNombre(String username) {
        usuario.deberiaVerSuNombreDeUsuario(username);
    }

    @Given("^(.*) agrega un producto a su carrito$")
    public void agregaProducto(String nombreDeUsuario){
        usuario.isCalled(nombreDeUsuario);
        usuario.agregarProductoAlCarrito();
    }

    @When("^confirma el meto de pago bancario$")
    public void ConfirmaPago() throws InterruptedException {
        usuario.confirmarPagoBancario();
    }

    @Then("^visualiza el mensaje de pago exitoso$")
    public void visualizaMensaje() throws InterruptedException {
        usuario.visualizarMensajeExitoso();
    }
}
