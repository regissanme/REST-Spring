package br.com.regissanme.entity;

import br.com.regissanme.exceptions.ProductPriceException;
import br.com.regissanme.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Projeto: REST-Spring
 * Desenvolvedor: Reginaldo Santos de Medeiros (regissanme)
 * Data: 09/08/2022
 * Hora: 09:58
 */

@SpringBootTest
class ProdutoTest {

    @Autowired
    private ProdutoService produtoService;

    @Test
    public void verificaValorNegativoNoProduto() throws Exception {
        Produto produto = new Produto();
        produto.setNome("Teste");
        produto.setPreco(-10.0);

        assertThrows(ProductPriceException.class, () -> produtoService.save(produto));
    }


}