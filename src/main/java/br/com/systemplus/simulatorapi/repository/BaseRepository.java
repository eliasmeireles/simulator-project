package br.com.systemplus.simulatorapi.repository;

import br.com.systemplus.simulatorapi.model.BaseEntity;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity<?>, ID extends Serializable>
        extends PagingAndSortingRepository<T, ID> {

}
