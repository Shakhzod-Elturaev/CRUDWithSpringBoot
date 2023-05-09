package uz.pdp.crudwithspringboot.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import uz.pdp.crudwithspringboot.domain.entity.UserEntity;

@AllArgsConstructor
@Getter
public class BaseResponse {
    private String message;
    private Integer status;
    private UserEntity userEntity;

    public BaseResponse(String message, Integer status) {
        this.message = message;
        this.status = status;
    }
}
