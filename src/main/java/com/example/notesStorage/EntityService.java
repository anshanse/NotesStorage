package com.example.notesStorage;

import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface EntityService<T extends BaseEntity<ID>, ID> extends EntityRepository<T, ID> {


}
