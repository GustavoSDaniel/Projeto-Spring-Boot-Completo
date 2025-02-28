package dev.gustavosdaniel.projetospringboot.controller;

import dev.gustavosdaniel.projetospringboot.exception.RecursoNaoEncontradoException;
import dev.gustavosdaniel.projetospringboot.model.Produto;
import dev.gustavosdaniel.projetospringboot.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoService produtoService; //INJETANDO AS FUNÇÕES DO PRODUTOSERVICE

    public ProdutoController(ProdutoService produtoService) { // INJETANDO O PRODUTO SERVICE
        this.produtoService = produtoService;
    }

    @GetMapping //PESQUISAR O PRODUTO
    public List<Produto> listarProdutos() {
        return produtoService.listarProdutos();
    }

    @GetMapping("/{id}") // PESQUISAR O PRODUTO PELO ID
    public ResponseEntity<?> buscarProduto(@PathVariable Long id) { //ELE PUXA O VALOR DA VARIAVEL NESSE CASO OVALOR DO ID QUE SERIA O PRODUTO PESQUISADO, O ? INDICA UM VALOR GENERICO
            Produto produto = produtoService.buscarPorId(id);
           return ResponseEntity.ok(produto);
    }

    @PostMapping // criar um produto
    public Produto criarProduto(@RequestBody Produto produto) { // REQUESTBODY VAI MOSTRAR O PRODUTO CRIADO NESSE CASO
        return produtoService.salvarProduto(produto);
    }

    @DeleteMapping("/{id}") //VAI DELETAR O PRODUTO PELO IDD
    public ResponseEntity<Void> deletarProdutoPorId(@PathVariable Long id) {
        produtoService.deletarProdutoPorId(id);
        return ResponseEntity.noContent().build(); // FALA QUE A AÇÃO FOI BEM SUCEDIDA POREM COMO É UM DELETE ELE NÃO VAI RETORNAR NADA PQ É VOID
    }





}
