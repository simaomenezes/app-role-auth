package github.com.simaomenezes.roleapp.application.usecases.role;

import github.com.simaomenezes.roleapp.application.dtos.RoleDTO;
import github.com.simaomenezes.roleapp.domain.entity.RoleEntity;
import github.com.simaomenezes.roleapp.domain.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class FindByNameUseCase {
    private RoleRepository repository;

    public RoleDTO execute(String name){
        RoleEntity entityFound = repository.findByName(name).get();
        //TODO when not find any role return exception with a message
        return new RoleDTO(entityFound.getName());
    }
}
