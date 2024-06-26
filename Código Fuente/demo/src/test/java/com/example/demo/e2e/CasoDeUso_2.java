package com.example.demo.e2e;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import com.example.demo.Servicio.PerroServicempl;
import com.example.demo.Servicio.ServicioPerro;
import com.example.demo.Servicio.TratamientosService;

import io.github.bonigarcia.wdm.WebDriverManager;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class CasoDeUso_2 {
    private final String BASE_URL = "http://localhost:4200";

    private WebDriver driver;
    private WebDriverWait wait;
    private TratamientosService servicioTratamiento;

    @Autowired
    private ServicioPerro servicioPerro;

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

        
        driver.get(BASE_URL + "/admin/login");

        WebElement inputCedula1i = driver.findElement(By.id("nombre"));
        WebElement inputContrasena1i = driver.findElement(By.id("contrasena"));
        inputCedula1i.sendKeys("grani");
        inputContrasena1i.sendKeys("cafu");

        WebElement btnLogIn1i = driver.findElement(By.id("btnIngresar"));
        btnLogIn1i.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnDashboard")));
        WebElement btnDashboardElementi = driver.findElement(By.id("btnDashboard"));
        btnDashboardElementi.click();

        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ventas")));
        WebElement ventasTotalesElementi = driver.findElement(By.id("ventas"));

        // Capturar el valor y hacer la aserción
        String ventasTotalesTexti = ventasTotalesElementi.getText().replace(",", "").trim();
        double ventasTotalesi = Double.parseDouble(ventasTotalesTexti);

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

        wait.until(ExpectedConditions.alertIsPresent()).accept();

        // Double ventasInicial = servicioPerro.calcularVentasDePerrosConTratamientos();

        // *Ingresar al modulo de tratamientos */
        String btnTratamientos = "//html//body//app-root//app-header//header//div[2]//nav//ul//li[2]//a";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(btnTratamientos)));
        WebElement btnClientes = driver.findElement(By.xpath(btnTratamientos));
        btnClientes.click();

        // Esperar hasta que la tabla esté presente
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#sectionTabla table tbody tr")));

        // Capturar la lista inicial de tratamientos y verificar que haya 20 filas
        List<WebElement> listaInicial = driver.findElements(By.cssSelector("#sectionTabla table tbody tr"));

        // *Agregar Tratamiento a una mascota*
        String btnAdd = "//html//body//app-root//app-lista-drogas//main//section//div[2]//table//tbody//tr[1]//td[7]//a";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(btnAdd)));
        WebElement btnAddi = driver.findElement(By.xpath(btnAdd));
        btnAddi.click();

        WebElement inputNameTratamiento = driver.findElement(By.id("nombreTratamiento"));
        WebElement inputPrecio = driver.findElement(By.id("precioC"));
        WebElement inputDroga = driver.findElement(By.id("drogaIds"));
        WebElement inputVeterinario = driver.findElement(By.id("veterinarioId"));
        WebElement inputMascotaID = driver.findElement(By.id("mascotaId"));

        inputNameTratamiento.sendKeys("Tratamiento 1");
        inputPrecio.clear();
        inputPrecio.sendKeys("100");

        Select estadoDropdown = new Select(inputDroga);
        estadoDropdown.selectByVisibleText("ALSIR");

        inputVeterinario.clear();
        inputVeterinario.sendKeys("1");

        inputMascotaID.clear();
        inputMascotaID.sendKeys("1");

        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
        driver.findElement(By.cssSelector("html")).sendKeys(Keys.CONTROL, Keys.END);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnRegistrar1")));
        WebElement btnRegistrarElement1 = driver.findElement(By.id("btnRegistrar1"));
        btnRegistrarElement1.click();

        // recargar la pagina
        driver.navigate().refresh();
        driver.navigate().refresh();
        driver.navigate().refresh();

        // Captura la nueva lista de tratamientos
        List<WebElement> listaFinal = driver.findElements(By.cssSelector("#sectionTabla table tbody tr"));

        // Comprueba que el tamaño de la lista ha aumentado en uno
        Assertions.assertThat(listaFinal.size()).isEqualTo(listaInicial.size() + 1);

        // *Ingresar al módulo de mascotas*
        String btnMascotaspath = "//html//body//app-root//app-header//header//div[2]//nav//ul//li[3]//a";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(btnMascotaspath)));
        WebElement btnMascotas = driver.findElement(By.xpath(btnMascotaspath));
        btnMascotas.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("iconotarjeton")));
        WebElement btntargeton = driver.findElement(By.id("iconotarjeton"));
        btntargeton.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("searchBar")));
        WebElement searchBar = driver.findElement(By.id("searchBar"));
        searchBar.sendKeys("bella");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("card-image-container")));
        WebElement btnMascota = driver.findElement(By.className("card-image-container"));
        btnMascota.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnAgregar")));
        WebElement btnHistorialElement = driver.findElement(By.id("btnAgregar"));
        btnHistorialElement.click();

        // Inicia sesión en el módulo administrativo
        driver.get(BASE_URL + "/admin/login");

        WebElement inputCedula1 = driver.findElement(By.id("nombre"));
        WebElement inputContrasena1 = driver.findElement(By.id("contrasena"));
        inputCedula1.sendKeys("grani");
        inputContrasena1.sendKeys("cafu");

        WebElement btnLogIn1 = driver.findElement(By.id("btnIngresar"));
        btnLogIn1.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnDashboard")));
        WebElement btnDashboardElement = driver.findElement(By.id("btnDashboard"));
        btnDashboardElement.click();

        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ventas")));
        WebElement ventasTotalesElement = driver.findElement(By.id("ventas"));

        // Capturar el valor y hacer la aserción
        String ventasTotalesText = ventasTotalesElement.getText().replace(",", "").trim();
        double ventasTotales = Double.parseDouble(ventasTotalesText);

        Assertions.assertThat(ventasTotales).isEqualTo(ventasTotalesi+100);
        
    }

    @Test
    public void ingresarHistorial() {

        driver.get(BASE_URL + "/mascotas/all");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("iconotarjeton")));
        WebElement btntargeton = driver.findElement(By.id("iconotarjeton"));
        btntargeton.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("searchBar")));
        WebElement searchBar = driver.findElement(By.id("searchBar"));
        searchBar.sendKeys("bella");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("card-image-container")));
        WebElement btnMascota = driver.findElement(By.className("card-image-container"));
        btnMascota.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnAgregar")));
        WebElement btnHistorialElement = driver.findElement(By.id("btnAgregar"));
        btnHistorialElement.click();

        driver.get(BASE_URL + "/admin/login");

        WebElement inputCedula1 = driver.findElement(By.id("nombre"));
        WebElement inputContrasena1 = driver.findElement(By.id("contrasena"));
        inputCedula1.sendKeys("grani");
        inputContrasena1.sendKeys("cafu");

        WebElement btnLogIn1 = driver.findElement(By.id("btnIngresar"));
        btnLogIn1.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnDashboard")));
        WebElement btnDashboardElement = driver.findElement(By.id("btnDashboard"));
        btnDashboardElement.click();

        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);

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

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ventas")));
        WebElement ventasTotalesElement = driver.findElement(By.id("ventas"));

        // Capturar el valor y hacer la aserción
        String ventasTotalesText = ventasTotalesElement.getText().replace(",", "").trim();
        double ventasTotales = Double.parseDouble(ventasTotalesText);

        double expectedVentasTotales = 10047110; // Reemplaza este valor con el esperado
        Assertions.assertThat(ventasTotales).isEqualTo(expectedVentasTotales);
    }

}
