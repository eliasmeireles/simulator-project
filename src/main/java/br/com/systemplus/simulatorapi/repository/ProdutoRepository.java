package br.com.systemplus.simulatorapi.repository;

import br.com.systemplus.simulatorapi.model.Produto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProdutoRepository extends BaseRepository<Produto, String> {

    @Query("SELECT produto FROM Produto produto WHERE produto.nome = :nome")
    Produto findByNome(@Param("nome") String nome);

}
