package com.example.demo.e2e;

import java.time.Duration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import io.github.bonigarcia.wdm.WebDriverManager;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class CasoDeUso_1 {
    private final String BASE_URL = "http://localhost:4200";

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void init() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("--disaible-notifications");
        chromeOptions.addArguments("--disaible-extensions");

        this.driver = new ChromeDriver(chromeOptions);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void casoDeUso1() {

        // *Log in fallido y log in acertado de veterinario */

        driver.get(BASE_URL + "/login");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnLogInAdministrador")));
        WebElement btnElement = driver.findElement(By.id("btnLogInAdministrador"));
        btnElement.click();

        WebElement inputCedula = driver.findElement(By.id("id"));
        WebElement inputContrasena = driver.findElement(By.id("contrasena"));
        inputCedula.sendKeys("12");
        inputContrasena.sendKeys("1234");

        WebElement btnLogIn = driver.findElement(By.id("btnIngresar"));
        btnLogIn.click();

        // Dar okay en la alerta que va a mandar
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();

        inputCedula.clear();
        inputCedula.sendKeys("1");
        inputContrasena.clear();
        inputContrasena.sendKeys("1234");

        btnLogIn.click();
        Alert alertC = wait.until(ExpectedConditions.alertIsPresent());
        alertC.accept();

        // * Llegar a clientes */
        String btnClientespath = "//html//body//app-root//app-header//header//div[2]//nav//ul//li[5]//a";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(btnClientespath)));
        WebElement btnClientes = driver.findElement(By.xpath(btnClientespath));
        btnClientes.click();

        // * Agregar cliente */
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnAgregar")));
        WebElement btnAgregar = driver.findElement(By.id("btnAgregar"));
        btnAgregar.click();

        WebElement inputName = driver.findElement(By.id("nombre"));
        WebElement inputEmail = driver.findElement(By.id("correo"));
        WebElement inputPhone = driver.findElement(By.id("celular"));
        WebElement inputUsuario = driver.findElement(By.id("usuario"));
        WebElement inputContraseña = driver.findElement(By.id("contrasena"));

        inputName.sendKeys("Sebastian");
        inputEmail.sendKeys("juseanto@javeriana.edu.co");
        inputPhone.sendKeys(Keys.BACK_SPACE);
        inputPhone.sendKeys("1234567890");
        inputUsuario.sendKeys("Sebastian");
        inputContraseña.sendKeys("123456");

        String pathbottom = "//html//body//app-root//app-agregar-clientes//section[2]//div//form//div[6]//button";
        WebElement btnSubmit = driver.findElement(By.xpath(pathbottom));
        Actions actions = new Actions(driver);
        actions.moveToElement(btnSubmit).perform();
        btnSubmit.click();

        // ?falta revisar esto osea lo de liStudentName
        // ?List<WebElement> listaIncial =
        // driver.findElements(By.className("liStudentName"));
        // ?wait.until(lambda ->
        // driver.findElements(By.className("liStudentName")).size() ==
        // listaIncial.size() + 1);

        // * Editar cliente */

        // Recargar pagina
        driver.navigate().refresh();

        // Hacer scroll hacia abajo hasta la última fila de la tabla
        WebElement lastRow = driver.findElement(By.xpath("//table/tbody/tr[last()]"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", lastRow);

        // Esperar un momento para asegurarse de que la última fila esté completamente
        // visible
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Hacer clic en el botón de editar de la última fila
        WebElement btnEditar = lastRow.findElement(By.className("btnEdi"));
        btnEditar.click();

        // ! Se va editar el celular y la contraseña

        WebElement inputTelefono = driver.findElement(By.id("celular"));
        WebElement inputContra = driver.findElement(By.id("contrasena"));

        inputTelefono.clear();
        inputTelefono.sendKeys("73548563");
        inputContra.clear();
        inputContra.sendKeys("4321");

        String pathbottomU = "//html//body//app-root//app-editar-clientes//section[2]//div//form//div[6]//button";
        WebElement btnSubmitU = driver.findElement(By.xpath(pathbottomU));
        Actions actionsU = new Actions(driver);
        actionsU.moveToElement(btnSubmitU).perform();
        btnSubmitU.click();

        // *Irse a mascotas */
        String btnMascotaspath = "//html//body//app-root//app-header//header//div[2]//nav//ul//li[3]//a";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(btnMascotaspath)));
        WebElement btnMascotas = driver.findElement(By.xpath(btnMascotaspath));
        btnMascotas.click();
        

        // *Agregar Mascota */
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("anchorAgregarMascota")));
        WebElement btnagregar = driver.findElement(By.id("anchorAgregarMascota"));
        btnagregar.click();

        WebElement inputNombreMas = driver.findElement(By.id("nombre"));
        WebElement inputRaza = driver.findElement(By.id("raza"));
        WebElement inputedad = driver.findElement(By.id("edad"));
        WebElement inputPeso = driver.findElement(By.id("peso"));
        WebElement inputEstado = driver.findElement(By.id("actividad"));
        WebElement inputimagen = driver.findElement(By.id("imagen"));
        WebElement inputdueno = driver.findElement(By.id("dueno"));

        // este se debe sacar algo tipo asi
        // listaIncial.size()+1

        String iddueño = "101";
        inputNombreMas.sendKeys("Santi");
        inputRaza.sendKeys("Bulldog");
        inputedad.clear();
        inputedad.sendKeys("2");
        inputPeso.clear();
        inputPeso.sendKeys("4.5");

        Select estadoDropdown = new Select(inputEstado);
        estadoDropdown.selectByVisibleText("Activo");

        inputimagen.sendKeys(
                "https://media.istockphoto.com/id/1482199015/es/foto/feliz-cachorro-gal%C3%A9s-corgi-14-semanas-de-edad-perro-gui%C3%B1ando-un-ojo-jadeando-y-sentado-aislado.jpg?s=612x612&w=0&k=20&c=lX65jf64HFLnR8XDD7pphv5KVRMmBCNTQBvzggRvQ14=");
        inputdueno.clear();
        inputdueno.sendKeys(iddueño);

        String RegistrarMascota = "//html//body//app-root//app-agregar-mascotas//section[2]//div//form//div[7]//button";
        WebElement btnSubmitt = driver.findElement(By.xpath(RegistrarMascota));
        Actions actionss = new Actions(driver);
        actionss.moveToElement(btnSubmitt).perform();
        btnSubmitt.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnLogin")));
        WebElement btnLogin = driver.findElement(By.id("btnLogin"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", btnLogin);

        WebElement inputCedulaC = driver.findElement(By.id("cedula"));
        inputCedulaC.sendKeys("101");

        WebElement btnLogInC = driver.findElement(By.id("btnIngresar"));
        btnLogInC.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("card-image-container")));
        WebElement btnMascotaCliente = driver.findElement(By.className("card-image-container"));
        btnMascotaCliente.click();


    }

    @Test
    public void ingresarVeterinario() {

        driver.get(BASE_URL + "/login");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnLogInAdministrador")));
        WebElement btnElement = driver.findElement(By.id("btnLogInAdministrador"));
        btnElement.click();

        WebElement inputCedula = driver.findElement(By.id("id"));
        WebElement inputContrasena = driver.findElement(By.id("contrasena"));
        inputCedula.sendKeys("12");
        inputContrasena.sendKeys("1234");

        WebElement btnLogIn = driver.findElement(By.id("btnIngresar"));
        btnLogIn.click();

        // Dar okay en la alerta que va a mandar
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();

        inputCedula.clear();
        inputCedula.sendKeys("1");
        inputContrasena.clear();
        inputContrasena.sendKeys("1234");

        btnLogIn.click();
        Alert alertC = wait.until(ExpectedConditions.alertIsPresent());
        alertC.accept();

    }

    @Test
    public void Llegarclientes() {
        driver.get(BASE_URL);
        String btnClientespath = "//html//body//app-root//app-header//header//div[2]//nav//ul//li[5]//a";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(btnClientespath)));
        WebElement btnClientes = driver.findElement(By.xpath(btnClientespath));
        btnClientes.click();
    }

    @Test
    public void agregarCliente() {
        driver.get(BASE_URL + "/clientes/all");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnAgregar")));
        WebElement btnagregar = driver.findElement(By.id("btnAgregar"));
        btnagregar.click();

        WebElement inputName = driver.findElement(By.id("nombre"));
        WebElement inputEmail = driver.findElement(By.id("correo"));
        WebElement inputPhone = driver.findElement(By.id("celular"));
        WebElement inputUsuario = driver.findElement(By.id("usuario"));
        WebElement inputContraseña = driver.findElement(By.id("contrasena"));

        inputName.sendKeys("Sebastian");
        inputEmail.sendKeys("juseanto@javeriana.edu.co");
        inputPhone.sendKeys(Keys.BACK_SPACE);
        inputPhone.sendKeys("1234567890");
        inputUsuario.sendKeys("Sebastian");
        inputContraseña.sendKeys("123456");

        String pathbottom = "//html//body//app-root//app-agregar-clientes//section[2]//div//form//div[6]//button";
        WebElement btnSubmit = driver.findElement(By.xpath(pathbottom));
        Actions actions = new Actions(driver);
        actions.moveToElement(btnSubmit).perform();
        btnSubmit.click();

    }

    @Test
    public void editarCLiente() {

        driver.get(BASE_URL + "/clientes/all");

        // Hacer scroll hacia abajo hasta la última fila de la tabla
        WebElement lastRow = driver.findElement(By.xpath("//table/tbody/tr[last()]"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", lastRow);

        // Esperar un momento para asegurarse de que la última fila esté completamente
        // visible
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Hacer clic en el botón de editar de la última fila
        WebElement btnEditar = lastRow.findElement(By.className("btnEdi"));
        btnEditar.click();

        // ! Se va editar el celular y la contraseña

        WebElement inputPhone = driver.findElement(By.id("celular"));
        WebElement inputContraseña = driver.findElement(By.id("contrasena"));

        inputPhone.clear();
        inputPhone.sendKeys("73548563");
        inputContraseña.clear();
        inputContraseña.sendKeys("4321");

        String pathbottom = "//html//body//app-root//app-editar-clientes//section[2]//div//form//div[6]//button";
        WebElement btnSubmit = driver.findElement(By.xpath(pathbottom));
        Actions actions = new Actions(driver);
        actions.moveToElement(btnSubmit).perform();
        btnSubmit.click();
    }

    @Test
    public void irseAMascota() {
        driver.get(BASE_URL + "/clientes/all");
        String btnMascotaspath = "//html//body//app-root//app-header//header//div[2]//nav//ul//li[3]//a";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(btnMascotaspath)));
        WebElement btnMascotas = driver.findElement(By.xpath(btnMascotaspath));
        btnMascotas.click();
    }

    @Test
    public void agreagarMascota() {

        driver.get(BASE_URL + "/mascotas/all");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("anchorAgregarMascota")));
        WebElement btnagregar = driver.findElement(By.id("anchorAgregarMascota"));
        btnagregar.click();

        WebElement inputNombreMas = driver.findElement(By.id("nombre"));
        WebElement inputRaza = driver.findElement(By.id("raza"));
        WebElement inputedad = driver.findElement(By.id("edad"));
        WebElement inputPeso = driver.findElement(By.id("peso"));
        WebElement inputEstado = driver.findElement(By.id("actividad"));
        WebElement inputimagen = driver.findElement(By.id("imagen"));
        WebElement inputdueno = driver.findElement(By.id("dueno"));

        // este se debe sacar algo tipo asi
        // listaIncial.size()+1

        String idDueno = "101";
        inputNombreMas.sendKeys("Santi");
        inputRaza.sendKeys("Bulldog");
        inputedad.clear();
        inputedad.sendKeys("2");
        inputPeso.clear();
        inputPeso.sendKeys("4.5");

        Select estadoDropdown = new Select(inputEstado);
        estadoDropdown.selectByVisibleText("Activo");

        inputimagen.sendKeys(
                "https://media.istockphoto.com/id/1482199015/es/foto/feliz-cachorro-gal%C3%A9s-corgi-14-semanas-de-edad-perro-gui%C3%B1ando-un-ojo-jadeando-y-sentado-aislado.jpg?s=612x612&w=0&k=20&c=lX65jf64HFLnR8XDD7pphv5KVRMmBCNTQBvzggRvQ14=");
        inputdueno.clear();
        inputdueno.sendKeys(idDueno);

        String RegistrarMascota = "//html//body//app-root//app-agregar-mascotas//section[2]//div//form//div[7]//button";
        WebElement btnSubmit = driver.findElement(By.xpath(RegistrarMascota));
        Actions actions = new Actions(driver);
        actions.moveToElement(btnSubmit).perform();
        btnSubmit.click();

    }

    @Test
    public void irIniciarSesionCliente() {

        driver.get(BASE_URL + "/mascotas/all");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnLogin")));
        WebElement btnLogin = driver.findElement(By.id("btnLogin"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", btnLogin);

    }

    @Test
    public void iniciarSesionCliente() {

        driver.get(BASE_URL + "/login");

        WebElement inputCedula = driver.findElement(By.id("cedula"));
        inputCedula.sendKeys("101");

        WebElement btnLogIn = driver.findElement(By.id("btnIngresar"));
        btnLogIn.click();

        
    }

    @Test
    public void mirarMascotaCliente(){

        driver.get(BASE_URL + "/cliente/101/mascotas");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("card-image-container")));
        WebElement btnMascotaCliente = driver.findElement(By.className("card-image-container"));
        btnMascotaCliente.click();


    }

}
