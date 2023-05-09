package uz.pdp.crudwithspringboot.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceUnit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import uz.pdp.crudwithspringboot.domain.entity.UserEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository{

    @PersistenceContext
    private final EntityManager entityManager;

    @Transactional
    @Override
    public void save(UserEntity userEntity) {
        entityManager.persist(userEntity);
    }

    @Override
    public UserEntity findByEmail(String email) {
        return entityManager.createQuery("select u from users u where email = :email", UserEntity.class)
                .setParameter("email", email)
                .getSingleResult();
    }

    @Transactional
    @Override
    public void deleteById(UUID id) {
        UserEntity user = getById(id);
        entityManager.remove(user);
    }

    @Override
    public UserEntity getById(UUID id) {
        return entityManager.createQuery("select u from users u where id=:id", UserEntity.class)
                .setParameter("id", id).getSingleResult();
    }

    @Transactional
    @Override
    public UserEntity update(UserEntity userEntity) {
        UserEntity userEntity1 = entityManager.find(UserEntity.class, userEntity.getId());
        userEntity.setCreated_date(userEntity1.getCreated_date());
        userEntity.setUpdated_date(LocalDateTime.now());
        return entityManager.merge(userEntity);
    }

    @Override
    public List<UserEntity> getAll() {
        return entityManager.createQuery("select u from users u", UserEntity.class)
                .getResultList();
    }
}
