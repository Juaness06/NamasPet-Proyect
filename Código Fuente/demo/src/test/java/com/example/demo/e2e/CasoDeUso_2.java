package com.example.demo.e2e;

import java.time.Duration;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
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
public class CasoDeUso_2 {
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
    public void casoDeUso2() {

        // *Iniciar Sesion veterinario */
        driver.get(BASE_URL + "/login");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnLogInAdministrador")));
        WebElement btnElement = driver.findElement(By.id("btnLogInAdministrador"));
        btnElement.click();

        WebElement inputCedula = driver.findElement(By.id("id"));
        WebElement inputContrasena = driver.findElement(By.id("contrasena"));
        inputCedula.sendKeys("1");
        inputContrasena.sendKeys("1234");

        WebElement btnLogIn = driver.findElement(By.id("btnIngresar"));
        btnLogIn.click();

        Alert alertC = wait.until(ExpectedConditions.alertIsPresent());
        alertC.accept();

        // *Ingresar al modulo de tratamientos */

        String btnTratamientos = "//html//body//app-root//app-header//header//div[2]//nav//ul//li[2]//a";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(btnTratamientos)));
        WebElement btnClientes = driver.findElement(By.xpath(btnTratamientos));
        btnClientes.click();

        // * Agregar Tratamiento a una mascota */
        String btnAdd = "//html//body//app-root//app-lista-drogas//main//section//div[2]//table//tbody//tr[1]//td[7]//a";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(btnAdd)));
        WebElement btnAddi = driver.findElement(By.xpath(btnAdd));
        btnAddi.click();

        WebElement inputNameTratmiento = driver.findElement(By.id("nombreTratamiento"));
        WebElement inputPrecio = driver.findElement(By.id("precioC"));
        // spinner de droga toca preguntarle al profe
        WebElement inputDroga = driver.findElement(By.id("drogaIds"));
        WebElement inputVeterinario = driver.findElement(By.id("veterinarioId"));
        WebElement inputMascotaID = driver.findElement(By.id("mascotaId"));

        inputNameTratmiento.sendKeys("Tratamiento 1");
        inputPrecio.clear();
        inputPrecio.sendKeys("100");

        Select estadoDropdown = new Select(inputDroga);
        estadoDropdown.selectByVisibleText("ALSIR");

        inputVeterinario.clear();
        inputVeterinario.sendKeys("1");

        inputMascotaID.clear();
        inputMascotaID.sendKeys("1");

        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnRegistrar1")));
        WebElement btnRegistrarElement1 = driver.findElement(By.id("btnRegistrar1"));
        btnRegistrarElement1.click();

        // *Ingresar al modulo de mascotas */

        String btnMascotaspath = "//html//body//app-root//app-header//header//div[2]//nav//ul//li[3]//a";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(btnMascotaspath)));
        WebElement btnMascotas = driver.findElement(By.xpath(btnMascotaspath));
        btnMascotas.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("IconoTarjeton")));
        WebElement btntargeton = driver.findElement(By.id("IconoTarjeton"));
        btntargeton.click();

        // buscar el perro

        //
        String btnHistorial = "btnAgregar";

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(btnHistorial)));
        WebElement btnHistorialElement = driver.findElement(By.id(btnHistorial));
        btnHistorialElement.click();

        // verificar que este el tratamiento

        driver.get(BASE_URL + "/admin/login");

        WebElement inputCedula1 = driver.findElement(By.id("nombre"));
        WebElement inputContrasena1 = driver.findElement(By.id("contrasena"));
        inputCedula1.sendKeys("grani");
        inputContrasena1.sendKeys("cafu");

        WebElement btnLogIn1 = driver.findElement(By.id("btnIngresar"));
        btnLogIn1.click();

        // verfica la lista con el assertion

    }

    @Test
    public void Dashboard() {
        driver.get(BASE_URL + "/admin/login");

        WebElement inputCedula = driver.findElement(By.id("nombre"));
        WebElement inputContrasena = driver.findElement(By.id("contrasena"));
        inputCedula.sendKeys("grani");
        inputContrasena.sendKeys("cafu");

        WebElement btnLogIn = driver.findElement(By.id("btnIngresar"));
        btnLogIn.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnDashboard")));
        WebElement btnDashboardElement = driver.findElement(By.id("btnDashboard"));
        btnDashboardElement.click();

    }
}