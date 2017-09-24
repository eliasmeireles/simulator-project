package br.com.systemplus.simulatorapi.repository;

import br.com.systemplus.simulatorapi.model.ProdutoDescricao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProdutoDescricaoRepository extends BaseRepository<ProdutoDescricao, String> {

    @Query("SELECT produtoDescricao FROM ProdutoDescricao produtoDescricao WHERE produtoDescricao.produto.id = :id")
    Iterable<ProdutoDescricao> findAllByProduto(@Param("id") String id);
}
