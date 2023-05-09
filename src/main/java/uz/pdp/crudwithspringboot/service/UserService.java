package uz.pdp.crudwithspringboot.service;

import org.springframework.stereotype.Service;
import uz.pdp.crudwithspringboot.domain.dto.BaseResponse;
import uz.pdp.crudwithspringboot.domain.dto.LoginDto;
import uz.pdp.crudwithspringboot.domain.entity.UserEntity;

import java.util.List;
import java.util.UUID;

@Service
public interface UserService {

    BaseResponse createUser(UserEntity userEntity);

    BaseResponse login(LoginDto dto);

    BaseResponse deleteById(UUID id);

    BaseResponse getById(UUID id);

    BaseResponse updateUserInfo(UserEntity user);

    List<UserEntity> getUsersList();

}
