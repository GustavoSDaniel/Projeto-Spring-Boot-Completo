package dev.gustavosdaniel.projetospringboot.controller;

import dev.gustavosdaniel.projetospringboot.model.Produto;
import dev.gustavosdaniel.projetospringboot.service.ProdutoService;
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
    public ResponseEntity<Produto> buscarProduto(@PathVariable Long id) { //ELE PUXA O VALOR DA VARIAVEL NESSE CASO OVALOR DO ID QUE SERIA O PRODUTO PESQUISADO
        return produtoService.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build()); //SE ACHAR O ID RESPONDE OK CASO CONTRARIO VAI DAR UM MENSAGEM DE NOTFOUND
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
