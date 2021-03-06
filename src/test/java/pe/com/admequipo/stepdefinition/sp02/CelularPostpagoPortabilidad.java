package pe.com.admequipo.stepdefinition.sp02;


import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pe.com.admequipo.stepdefinition.BaseStep;

public class CelularPostpagoPortabilidad extends BaseStep{
	
	private WebDriver driver;
	//private String url="https://tiendaclaro.pe/";
	private String url="http://9f39e279-us-south.lb.appdomain.cloud/";
	
	By cancelar = By.xpath("//button[@class=\"pushcrew-chrome-style-notification-btn pushcrew-btn-close\"]");
	
	By celulares = By.xpath("//a[contains(text(),'Celulares')]");
	By modalidad = By.xpath("//div[@id='dropdown10']/div[2]/a");
	By porta = By.xpath("//div[@id='dropdown10']/div[3]/a[1]");

	By productos = By.xpath("//div[@id='contentcatalog']/app-product/div/div[11]/section/div[3]/div/img");
	
	By continuar1 = By.xpath("//button[@id='Equipo-a?adir-bolsa']/span");
	By aniadir = By.xpath("//*[@id=\"Equipo-a?adir-bolsa\"]/span");
	By addaccesorio = By.xpath("//button[@class=\"bundle add\"]");
	By addservice =  By.xpath("//div[@id='content-wrap']/div/section/div[2]/div/div[2]/button");
	By accesorios = By.xpath("//button[@id='Mibolsa-comenzar-pago']");
	
	By siguiente = By.id("Mibolsa-comenzar-pago");
	
	By campodoc = By.id("field-doc");
	By campocel1 = By.id("field-cel");
	By campocel2 = By.id("field-celaccion");
	By camponom = By.id("field-name");
	By campoape = By.id("field-last");
	By campomail = By.id("field-mail");
	By terminos = By.xpath("//a[contains(@href, '/mibolsa/informacion')]");
	By aceptar = By.xpath("(//button[@type='button'])[6]");
	
	By calc_ubica = By.xpath("//div[@id='content-wrap']/div/section/form/div[2]/section/div/div/div/div[3]");
	By ubica = By.xpath("//div[2]/div[3]/div/div/input");
	By urbani = By.xpath("//div[@id='calcularUbicacionModal']/div/div/div/app-geodir/div/div[2]/div[3]/div/div[2]/div");
	By flecha = By.xpath("//div[@id='calcularUbicacionModal']/div/div/div/app-geodir/div/div[2]/div[3]/button");
	By confr = By.xpath("//app-geodir/div/div[2]/button");
	By contcompra = By.xpath("//button[contains(.,'Continuar compra')]");
	
	By metodopago = By.xpath("//*[@id=\"formRegistro\"]/div/div[1]/div/div[3]/div[1]/div[2]/div[1]/h1");
	String text1;
	By pag = By.xpath("//span[@class='titulo']");
	By botonf = By.xpath("//button[@id='Info-comenzar']");
	
	By termocond = By.xpath("//form[@id='formRegistro']/div/div/div/div[4]/ul/li/label/span");
	By confirmarpago = By.xpath("//button[@id='Confirmar-pago']");
	
	By frame = By.xpath("//iframe[@id='visaNetJS']");
	By nmrtarjeta = By.id("number");
	By fecha = By.id("expiry");
	By cvc = By.id("cvc");
	By cuota = By.xpath("//select[@id='quota']");
	By pagar = By.xpath("//button[@type='submit']");
	
	By checkpoint1 = By.xpath("//*[@id=\'attributeproduct\']/div/div/div[2]/h2[1]");
	By checkpoint2 = By.xpath("//*[@id=\'content-wrap\']/div/section[2]/div[3]/div[2]/span[1]");
	
	public CelularPostpagoPortabilidad() {
		driver = super.getDriver();
		driver.manage().window().maximize();
	}
	/*
Given estoy en la pagina principal de tienda claro PRT
When selecciono el menu celulares, luego el submenu postpago y luego seleccion la opcion Portabilidad PRT
And selecciono un producto del catalogo PRT
And selecciono Aniadir a mi bolsa PRT
And observo el resumen de mi compra y selecciono Siguiente PRT
And completo el formulario con mis datos personales y seleccion Siguiente PRT
And acepto los terminos y condiciones de pago y las condiciones y selecciono Siguiente PRT
Then visualizo el checkout PRT
	*/
	
	@Given("^estoy en la pagina principal de tienda claro PRT$")
	public void estoyEnPaginaPrincipal() throws InterruptedException, AWTException {		
		driver.get(url);
		esperarSegundos(2);
		//click(cancelar);
	}
	
	@When("^selecciono el menu celulares, luego el submenu postpago y luego seleccion la opcion Portabilidad PRT$")
	public void seleccionoLineaNueva() throws InterruptedException {
		Thread.sleep(1000);	
		click(celulares);
		Thread.sleep(1000);
		List<WebElement> paqueteopcio = findElements(modalidad);		
		WebElement term1 = paqueteopcio.get(0);
		mover(term1);
		esperarSegundos(2);
		captura("PERSONA_celular_postPRT","1");
		click(porta);
		esperarSegundos(1);		
	}
	
	@When("^selecciono un producto del catalogo PRT$")
	public void seleccionoCelular() throws InterruptedException {
		scroll(ubicacion(productos),"");
		Thread.sleep(3000);	
		captura("PERSONA_celular_postPRT","2");
		click(productos);	
		esperarSegundos(2);
	}
	
	@When("^selecciono Aniadir a mi bolsa PRT$")
	public void addMiBolsa() throws InterruptedException {
		Thread.sleep(3000);	
		findElement(checkpoint1).isDisplayed(); //validacion 
		captura("PERSONA_celular_postPRT","3");
		click(continuar1);	
		Thread.sleep(2000);
		click(aniadir);	
		Thread.sleep(5000);
	}

	@When("^observo el resumen de mi compra y selecciono Siguiente PRT$")
	public void verResumenCompra() throws InterruptedException {
		esperarSegundos(1);
		scroll("(0,200)","");
		esperarSegundos(1);
		captura("PERSONA_celular_postPRT","4");
		findElement(checkpoint2).isDisplayed(); //validacion 
		click(siguiente);
		esperarSegundos(3);
	}

	@When("^completo el formulario con mis datos personales y seleccion Siguiente PRT$")
	public void completarFormulario() throws InterruptedException {
		clear(campodoc);
		type("23232323",campodoc);
		clear(campocel1);
		type("999999991",campocel1);
		clear(campocel2);
		type("999999992",campocel2);
		clear(camponom);
		clear(campoape);
		clear(campomail);		
		type("Prueba Nombre",camponom);
		type("Prueba Apellido",campoape);
		type("somosclaro@prueba.com",campomail);
		captura("PERSONA_celular_postPRT","5");

		scroll("(0,600)","");
		Thread.sleep(1000);
		List<WebElement> paqueteopcio = findElements(terminos);
		WebElement term1 = paqueteopcio.get(0);
		term1.click();
		captura("PERSONA_celular_postPRT","6");
		click(aceptar);

		click(calc_ubica);
		Thread.sleep(5000);		
		captura("PERSONA_celular_postPRT","7");
		type("proc", ubica);
		Thread.sleep(2000);		

		captura("PERSONA_celular_postPRT","8");
		click(urbani);
		Thread.sleep(2000);		
		click(flecha);
		Thread.sleep(3000);		
		click(confr);
		Thread.sleep(4000);		
		captura("PERSONA_celular_postPRT","9");
		click(contcompra);
		Thread.sleep(2000);		
		scroll("(0,1700)","");
		Thread.sleep(3000);
		click(pag);
		captura("PERSONA_celular_postPRT","10");
		click(botonf);
	}

	@When("^acepto los terminos y condiciones de pago y las condiciones y selecciono Siguiente PRT$")
	public void aceptTermConditions() throws InterruptedException {
		Thread.sleep(2000);
		scroll("(0,570)","");
		Thread.sleep(2000);
		List<WebElement> paqueteopcio = findElements(termocond);
		WebElement term1 = paqueteopcio.get(0);
		term1.click();
		Thread.sleep(1000);
		if (paqueteopcio.size()>1) {
			WebElement term2 = paqueteopcio.get(1);
			term2.click();			
		}
		
		Thread.sleep(2000);
		scroll("(0,1000)","");
		Thread.sleep(2000);
		text1 = findElement(metodopago).getText();
		captura("PERSONA_celular_postPRT","11");
		click(confirmarpago);
		Thread.sleep(5000);
	}	

	@Then("^visualizo el checkout PRT$")
	public void muestraConfirmacion1() throws InterruptedException {
		if (text1!="Pago contraentrega") {
			Thread.sleep(5000);
			captura("PERSONA_celular_postPRT","12");
			switchTo(frame);
			Thread.sleep(5000);
			type("4919",nmrtarjeta);
			Thread.sleep(1000);
			type("1481",nmrtarjeta);
			Thread.sleep(1000);
			type("0785",nmrtarjeta);
			Thread.sleep(1000);
			type("9067",nmrtarjeta);
			Thread.sleep(3000);
			type("11",fecha);
			type("24",fecha);
			Thread.sleep(1000);
			type("545",cvc);

			Thread.sleep(3000);
			captura("PERSONA_celular_postPRT","13");
			click(pagar);
			Thread.sleep(10000);
		}
	}
}
