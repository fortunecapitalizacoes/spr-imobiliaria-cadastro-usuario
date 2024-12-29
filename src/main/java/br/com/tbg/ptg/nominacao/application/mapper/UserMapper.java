package br.com.tbg.ptg.nominacao.application.mapper;

import org.springframework.stereotype.Component;
import br.com.tbg.ptg.nominacao.application.dto.UserDTO;
import br.com.tbg.ptg.nominacao.domain.models.User;

@Component
public class UserMapper {

    /**
     * Converts a UserDTO to a User model using the Builder pattern.
     *
     * @param dto the UserDTO to be converted
     * @return the resulting User model
     */
    public User fromDtoToModel(UserDTO dto) {
        if (dto == null) {
            return null;
        }

        return User.builder()
                .id(dto.getId())
                .name(dto.getName())
                .email(dto.getEmail())
                .login(dto.getLogin())
                .password(dto.getPassword())
                .roles(dto.getRoles())
                .build();
    }

    /**
     * Converts a User model to a UserDTO using the Builder pattern.
     *
     * @param user the User model to be converted
     * @return the resulting UserDTO
     */
    public UserDTO fromModelToDto(User user) {
        if (user == null) {
            return null;
        }

        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .login(user.getLogin())
                .password(user.getPassword())
                .roles(user.getRoles())
                .build();
    }
}
