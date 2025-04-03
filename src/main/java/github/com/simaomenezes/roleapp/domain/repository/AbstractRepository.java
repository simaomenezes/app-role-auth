package github.com.simaomenezes.roleapp.domain.repository;

import github.com.simaomenezes.roleapp.domain.entity.PermissionEntity;

import java.util.List;
import java.util.Optional;

public interface AbstractRepository<T> {

    T save(T object);
    T update(T object);
    void deleteById(Long id);
    List<T> findAll();
    Optional<T> findByName(String name);
    Optional<T> findById(Long id);
}
