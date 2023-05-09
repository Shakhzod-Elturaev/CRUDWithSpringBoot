package uz.pdp.crudwithspringboot.repository;

import org.springframework.stereotype.Repository;
import uz.pdp.crudwithspringboot.domain.entity.UserEntity;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository {
    void save(UserEntity userEntity);

    UserEntity findByEmail(String email);
    void deleteById(UUID id);

    UserEntity getById(UUID id);

    UserEntity update(UserEntity userEntity);

    List<UserEntity> getAll();
}
