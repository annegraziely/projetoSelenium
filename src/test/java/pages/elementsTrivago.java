package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.List;

public class elementsTrivago extends BasePage{

    public elementsTrivago(WebDriver navegador){
        super(navegador);}

    public elementsTrivago inserirDestino(String cidade){
        navegador.findElement(By.name("query")).sendKeys(cidade);
        return this;
    }
    public elementsTrivago clicarSugestaoDestino(){
        navegador.findElement(By.xpath("//span[@data-testid='suggestion-title']")).click();
        return this;
    }
    public elementsTrivago fecharCalendario(){
        navegador.findElement(By.xpath("//button[@data-testid='calendar-button-close']")).click();
        return this;
    }
    public elementsTrivago clicarPesquisar(){
        navegador.findElement(By.xpath("//button[@data-testid='search-button']")).click();
        return this;
    }
    public elementsTrivago tempoDeEspera(int tempo) throws InterruptedException {
        Thread.sleep(tempo);
        return this;
    }
    public elementsTrivago refreshPagina() {
        navegador.navigate().refresh();
        return this;
    }
    public  elementsTrivago selecionarOrdemListagem(String item){
        new Select(navegador.findElement(By.id("sorting-selector"))).selectByValue(item);
        return this;
    }
    public List<String> cardPrimeiroLista() throws InterruptedException {
        //nome do Hotel
        String nomeHotel = navegador.findElement(By.xpath("//button[@data-testid='item-name']")).getText();
        System.out.println("nome:"+nomeHotel);
        //avaliação do Hotel
        WebElement elementAvaliacao = navegador.findElement(By.xpath("//meta[@itemprop='ratingValue']"));
        String valorAvaliacao = elementAvaliacao.getAttribute("content").toString();
        System.out.println("nome:"+valorAvaliacao);
        //valor do Hotel
        String valorHotel = navegador.findElement(By.xpath("//p[@data-testid='recommended-price']")).getText();
        System.out.println("nome:"+valorHotel);

        List<String> listaCardPrimeiroItemLista = Arrays.asList(new String[]{nomeHotel, valorAvaliacao, valorHotel});
        return listaCardPrimeiroItemLista;
    }




}
