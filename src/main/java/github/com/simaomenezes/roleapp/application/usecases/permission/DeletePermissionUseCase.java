package github.com.simaomenezes.roleapp.application.usecases.permission;


import github.com.simaomenezes.roleapp.domain.entity.PermissionEntity;
import github.com.simaomenezes.roleapp.domain.exceptions.NotFoundException;
import github.com.simaomenezes.roleapp.domain.repository.PermissionRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class DeletePermissionUseCase {
    private PermissionRepository repository;

    @Transactional
    public void execute(Long id){
        Optional<PermissionEntity> permissionFound = repository.findById(id);
        if(permissionFound.isEmpty()){
            throw new NotFoundException("PermissionEntity not found");
        }
        permissionFound.ifPresent(permissionEntity -> repository.deleteById(permissionEntity.getId()));
    }
}
