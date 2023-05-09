package uz.pdp.crudwithspringboot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.crudwithspringboot.domain.dto.BaseResponse;
import uz.pdp.crudwithspringboot.domain.dto.LoginDto;
import uz.pdp.crudwithspringboot.domain.entity.UserEntity;
import uz.pdp.crudwithspringboot.repository.UserRepository;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public BaseResponse createUser(UserEntity userEntity) {
        userRepository.save(userEntity);
        return new BaseResponse("OK", 200, userEntity);
    }

    @Override
    public BaseResponse login(LoginDto dto) {
        UserEntity user = userRepository.findByEmail(dto.email());
        if(user == null){
            return new BaseResponse("Not Found", 404, null);
        } else if(!Objects.equals(user.getPassword(), dto.password()))
            return new BaseResponse("Failed", 400, null);
        return new BaseResponse("OK", 200, user);
    }

    @Override
    public BaseResponse deleteById(UUID id) {
        userRepository.deleteById(id);
        return new BaseResponse("OK", 200);
    }

    @Override
    public BaseResponse getById(UUID id) {
        UserEntity user = userRepository.getById(id);
        return new BaseResponse("OK", 200, user);
    }

    @Override
    public BaseResponse updateUserInfo(UserEntity user) {
        UserEntity update = userRepository.update(user);
        return new BaseResponse("OK", 200, update);
    }

    @Override
    public List<UserEntity> getUsersList() {
        return userRepository.getAll();
    }
}
