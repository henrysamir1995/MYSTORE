package MyStore.steps;

import MyStore.pageobject.PaginaPrincipal;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.ScenarioActor;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.Matchers;

import java.awt.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class UserMyStore extends ScenarioActor {

    String actor;

    @Steps(shared=true)
    PaginaPrincipal paginaPrincipal;

    public void ingresarAPagina(){
    paginaPrincipal.setDefaultBaseUrl("http://automationpractice.com/index.php");
    paginaPrincipal.open();
    Serenity.takeScreenshot();
     }

     public void iniciarSesion(){
        paginaPrincipal.loguearse();
     }

     public void deberiaVerSuNombreDeUsuario(String nombreDeUsuario) {
        String texto= paginaPrincipal.obtener_nombre_del_usuario();
        System.out.println(texto);
        assertThat(texto,containsString(nombreDeUsuario));
     }

     public void agregarProductoAlCarrito(){
        paginaPrincipal.agregar_producto();
     }

     public void confirmarPagoBancario() throws InterruptedException {
        paginaPrincipal.realizar_pago_bancario();
    }

    public void visualizarMensajeExitoso() throws InterruptedException {
        String texto= paginaPrincipal.obtener_mensaje_confirmacion();
        System.out.println(texto);
        assertThat(texto,containsString("Your order on"));
    }

}
