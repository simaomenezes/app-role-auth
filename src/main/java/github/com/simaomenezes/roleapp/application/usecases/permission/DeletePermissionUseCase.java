package github.com.simaomenezes.roleapp.application.usecases.permission;


import github.com.simaomenezes.roleapp.domain.repository.PermissionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DeletePermissionUseCase {
    private PermissionRepository repository;

    public void execute(Long id){
    }
}
