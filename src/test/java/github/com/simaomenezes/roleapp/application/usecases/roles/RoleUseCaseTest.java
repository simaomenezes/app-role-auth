package github.com.simaomenezes.roleapp.application.usecases.roles;

import github.com.simaomenezes.roleapp.application.dtos.RoleDTO;
import github.com.simaomenezes.roleapp.application.usecases.role.CreateRoleUseCase;
import github.com.simaomenezes.roleapp.domain.entity.RoleEntity;
import github.com.simaomenezes.roleapp.domain.repository.RoleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
public class RoleUseCaseTest {

    @Mock
    private RoleRepository repository;
    @InjectMocks
    private CreateRoleUseCase createRoleUseCase;

    private RoleEntity roleEntity;
    private RoleDTO roleDTO;

    @BeforeEach
    public void setup(){
        roleDTO = new RoleDTO("ADM");
        roleEntity = new RoleEntity(roleDTO.getName());
    }

    @DisplayName("Given Role Object when Save Roles then Return Role Object")
    @Test
    void testGivenRoleObject_whenSaveRole_thenReturnRoleObject(){
        // Given // Arrange
        given(repository.findByName(roleDTO.getName())).willReturn(Optional.empty());
        given(repository.save(any(RoleEntity.class))).willReturn(roleEntity);
        // When // Act
        RoleDTO roleDTOCreated = createRoleUseCase.execute(roleDTO);
        // Then / Assert
        assertNotNull(roleDTOCreated);
        assertEquals(roleDTO.getName(), roleDTOCreated.getName());
        verify(repository, times(1)).save(any(RoleEntity.class));
    }
}
