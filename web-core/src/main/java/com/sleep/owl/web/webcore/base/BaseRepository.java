package com.sleep.owl.web.webcore.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/*@NoRepositoryBean
public interface BaseRepository<T extends AbstractBaseModel, ID extends Serializable> extends Repository<T, ID> {
    List<AbstractBaseModel> findByIdOrderByCreateTimeDesc(String id);
}*/
@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends JpaSpecificationExecutor<T>, JpaRepository<T, ID> {
}