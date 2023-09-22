package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import pages.elementsTrivago;
import suporte.Web;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PaginaTrivagoTest {

    private WebDriver navegador;
    @Before
    public void setUP(){
        navegador = Web.createChromeTrivago();
    }

    @Test
    public void testPesquisar() throws InterruptedException {

        List<String> CardAtual = new elementsTrivago(navegador).inserirDestino("Manaus")
                .clicarSugestaoDestino()
                .fecharCalendario()
                .clicarPesquisar()
                .clicarPesquisar().tempoDeEspera(40000)
                .refreshPagina().tempoDeEspera(1000)
                .selecionarOrdemListagem("6").tempoDeEspera(10000)
                .cardPrimeiroLista();

        List<String> listaEsperada = Arrays.asList(new String[]{"ibis budget Manaus","2","R$ 220"});

        Assert.assertEquals(listaEsperada,CardAtual);

    }

    @After
    public void saida(){
        navegador.quit();
    }


}
