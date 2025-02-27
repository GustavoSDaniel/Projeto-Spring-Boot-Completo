package dev.gustavosdaniel.projetospringboot.service;

import dev.gustavosdaniel.projetospringboot.model.Produto;
import dev.gustavosdaniel.projetospringboot.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) { // INJETANDO O REPOSITORY
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> buscarPorId(Long id) { // OPTIONAL É USADO POR CONTA QUE PODE EXISTIR UM UM ID OU NÃO POR ISSO USAR OPTIONAL
        return produtoRepository.findById(id); // RETORNE O ID QUE FOI PESQUISADO
    }

    public Produto salvarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void deletarProdutoPorId(Long id) { //TEM QUE SER VOID (VAZIO) POIS NÃO VAI RETORNAR NADA SO VAI APAGAR
        produtoRepository.deleteById(id);
    }
}
