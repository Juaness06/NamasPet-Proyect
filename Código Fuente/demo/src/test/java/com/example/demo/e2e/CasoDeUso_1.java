package com.example.demo.e2e;

import java.time.Duration;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import io.github.bonigarcia.wdm.WebDriverManager;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("default")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class CasoDeUso_1 {
    private final String BASE_URL = "http://localhost:4200";

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void init(){

        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("--disaible-notifications");
        chromeOptions.addArguments("--disaible-extensions");

        this.driver = new ChromeDriver(chromeOptions);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    @Test
    public void casoDeUso1(){

        driver.get(BASE_URL + "/login");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnLogInAdministrador")));
        WebElement btnElement = driver.findElement(By.id("btnLogInAdministrador"));
        btnElement.click();

        WebElement inputCedula = driver.findElement(By.id("id"));
        WebElement inputContrasena = driver.findElement(By.id("contrasena"));
        inputCedula.sendKeys("12");
        inputContrasena.sendKeys("123");


        //AQUI TOCA PONER LO DE UNDIR ESA NOTIFICACION


        //AQUI ACABA
        WebElement inputCedulaC = driver.findElement(By.id("id"));
        WebElement inputContrasenaC = driver.findElement(By.id("contrasena"));
        inputCedulaC.sendKeys("1");
        inputContrasenaC.sendKeys("123");


         //AQUI TOCA PONER LO DE UNDIR ESA NOTIFICACION DE ACEPTAR


        //AQUI ACABA
        String btnClientespath = "//html//body//app-root//app-header//header//div[2]//nav//ul//li[5]//a";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(btnClientespath)));
        WebElement btnClientes = driver.findElement(By.xpath(btnClientespath));
        btnClientes.click();


       // btnAgregar
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

        //falta revisar esto osea lo de liStudentName
        List<WebElement> listaIncial = driver.findElements(By.className("liStudentName"));
        //
        String pathbottom = "//html//body//app-root//app-agregar-clientes//section[2]//div//form//div[6]//button";
        WebElement btnSubmit = driver.findElement(By.xpath(pathbottom));
        btnSubmit.click();

        wait.until(lambda -> driver.findElements(By.className("liStudentName")).size() == listaIncial.size()+1);


    }

    @Test
    public void ingresarVeterinario(){

        driver.get(BASE_URL + "/login");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnLogInAdministrador")));
        WebElement btnElement = driver.findElement(By.id("btnLogInAdministrador"));
        btnElement.click();

        WebElement inputCedula = driver.findElement(By.id("id"));
        WebElement inputContrasena = driver.findElement(By.id("contrasena"));
        inputCedula.sendKeys("12");
        inputContrasena.sendKeys("123");


        //AQUI TOCA PONER LO DE UNDIR ESA NOTIFICACION


        //AQUI ACABA
        WebElement inputCedulaC = driver.findElement(By.id("id"));
        WebElement inputContrasenaC = driver.findElement(By.id("contrasena"));
        inputCedulaC.sendKeys("1");
        inputContrasenaC.sendKeys("123");

    }

    @Test
    public void Llegarclientes(){
        driver.get(BASE_URL);
        String btnClientespath = "//html//body//app-root//app-header//header//div[2]//nav//ul//li[5]//a";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(btnClientespath)));
        WebElement btnClientes = driver.findElement(By.xpath(btnClientespath));
        btnClientes.click();
    }
    @Test
    public void agregarCliente(){
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
         btnSubmit.click();
    }

    @Test
    public void editarCLiente(){

        List<WebElement> botonesDetalle = driver.findElements(By.className("btnEdi"));
        botonesDetalle.get(botonesDetalle.size()-1).click();
        
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
        btnSubmit.click();
    }

    @Test
    public void irseAMascota(){
        String btnMascotaspath = "//html//body//app-root//app-header//header//div[2]//nav//ul//li[3]//a";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(btnMascotaspath)));
        WebElement btnMascotas = driver.findElement(By.xpath(btnMascotaspath));
        btnMascotas.click();
    }

    @Test
    public void agreagarMascota(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnAgregar")));
        WebElement btnagregar = driver.findElement(By.id("btnagregar"));
        btnagregar.click();

        WebElement inputNombreMas = driver.findElement(By.id("nombre"));
         WebElement inputRaza = driver.findElement(By.id("raza"));
         WebElement inputedad = driver.findElement(By.id("edad"));
         WebElement inputPeso = driver.findElement(By.id("peso"));
         //aqui falta lo del estado porque es un spinner entonces nose
         WebElement inputimagen = driver.findElement(By.id("imagen"));
         WebElement inputdueno = driver.findElement(By.id("dueno"));
         // este se debe sacar algo tipo asi
         // listaIncial.size()+1
         int iddueño = 101;
         inputNombreMas.sendKeys("Sebastian");
         inputRaza.sendKeys("Bulldog");
         inputedad.sendKeys("2");
         inputPeso.sendKeys("4.5");
         inputimagen.sendKeys("https://media.istockphoto.com/id/1482199015/es/foto/feliz-cachorro-gal%C3%A9s-corgi-14-semanas-de-edad-perro-gui%C3%B1ando-un-ojo-jadeando-y-sentado-aislado.jpg?s=612x612&w=0&k=20&c=lX65jf64HFLnR8XDD7pphv5KVRMmBCNTQBvzggRvQ14=");
         inputdueno.sendKeys("5");
         String RegistrarMascota = "//html//body//app-root//app-agregar-mascotas//section[2]//div//form//div[7]//button";
         WebElement btnSubmit = driver.findElement(By.xpath(RegistrarMascota));
         btnSubmit.click();

    }
}
