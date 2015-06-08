package edu.bbu.bibiospring.api.assembler;

import edu.bbu.bibliospring.backend.model.User;
import edu.bbu.bibliospring.common.dto.UserDto;

/**
 *
 * @author zsvitalyos
 */
public class UserAssembler implements BaseAssembler<UserDto, User>{

    @Override
    public User createModel() {
        return new User();
    }

    @Override
    public UserDto createDto() {
        return new UserDto();
    }

    @Override
    public UserDto modelToDto(User model) {
        UserDto dto = createDto();
        dto.setFirstName(model.getFirstName());
        dto.setLastName(model.getLastName());
        dto.setUserName(model.getUserName());
        dto.setId(model.getId());
        return dto;
    }

    @Override
    public User dtoToModel(UserDto dto) {
        User model = createModel();
        model.setFirstName(dto.getFirstName());
        model.setLastName(dto.getLastName());
        model.setUserName(dto.getUserName());
        model.setId(dto.getId());
        return model;
    }
    
}
