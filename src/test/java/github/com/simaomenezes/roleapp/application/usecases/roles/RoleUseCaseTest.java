package github.com.simaomenezes.roleapp.application.usecases.roles;

import github.com.simaomenezes.roleapp.application.dtos.RoleDTO;
import github.com.simaomenezes.roleapp.application.usecases.role.CreateRoleUseCase;
import github.com.simaomenezes.roleapp.application.usecases.role.FindByNameUseCase;
import github.com.simaomenezes.roleapp.application.usecases.role.ListAllRoleUseCase;
import github.com.simaomenezes.roleapp.domain.entity.RoleEntity;
import github.com.simaomenezes.roleapp.domain.repository.RoleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
public class RoleUseCaseTest {

    @Mock
    private RoleRepository repository;
    @InjectMocks
    private CreateRoleUseCase createRoleUseCase;
    @InjectMocks
    private FindByNameUseCase findByNameUseCase;

    @InjectMocks
    private ListAllRoleUseCase listAllRoleUseCase;

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
        // Given / Arrange
        given(repository.findByName(roleDTO.getName())).willReturn(Optional.empty());
        given(repository.save(any(RoleEntity.class))).willReturn(roleEntity);
        // When / Act
        RoleDTO roleDTOCreated = createRoleUseCase.execute(roleDTO);
        // Then / Assert
        assertNotNull(roleDTOCreated);
        assertEquals(roleDTO.getName(), roleDTOCreated.getName());
        verify(repository, times(1)).save(any(RoleEntity.class));
    }

    @DisplayName("Given a name Role when find by name then return Role found")
    @Test
    void testGivenNameRole_whenFindByName_ThenReturnRoleFound(){
        // Given / Arrange
        given(repository.findByName(roleDTO.getName())).willReturn(Optional.of(roleEntity));
        // When / Act
        RoleDTO found = findByNameUseCase.execute(roleDTO.getName());
        // Then // Assert
        assertNotNull(found);
    }

    @DisplayName("Given Role list when findAll then return Role list")
    @Test
    void testGivenRoleList_whenFindAll_thenReturnRoleList(){
        // Given / Arrange
        given(repository.findAll()).willReturn(List.of(roleEntity));
        //When / Act
        List<RoleDTO> listReturn = listAllRoleUseCase.execute();
        // Then / Assert /
        assertNotNull(listReturn);
        assertEquals(1, listReturn.size());
    }
}
