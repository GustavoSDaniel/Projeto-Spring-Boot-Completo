package dev.gustavosdaniel.projetospringboot.service;

import dev.gustavosdaniel.projetospringboot.exception.RecursoNaoEncontradoException;
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

    public Produto buscarPorId(Long id) { // OPTIONAL É USADO POR CONTA QUE PODE EXISTIR UM UM ID OU NÃO POR ISSO USAR OPTIONAL
        return produtoRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Produto com ID " +id+ " não encontrado")); // RETORNE O ID QUE FOI PESQUISADO
        // Caso não achar esse ID do produto vai retornar essa mensagem
    }

    public Produto salvarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void deletarProdutoPorId(Long id) { //TEM QUE SER VOID (VAZIO) POIS NÃO VAI RETORNAR NADA SO VAI APAGAR

        if (!produtoRepository.existsById(id)) { // ESSE ! SIGINIFICA NEGAÇÃO
            throw new RecursoNaoEncontradoException("Produto com ID "+id +" não encontrado.");
        }
        produtoRepository.deleteById(id);
    }


}
