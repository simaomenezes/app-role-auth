package github.com.simaomenezes.roleapp.application.usecases.permission;

import github.com.simaomenezes.roleapp.application.dtos.PermissionDTO;
import github.com.simaomenezes.roleapp.domain.entity.PermissionEntity;
import github.com.simaomenezes.roleapp.domain.exceptions.NotFoundException;
import github.com.simaomenezes.roleapp.domain.repository.PermissionRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class PermissionUseCaseTest {

    @Mock
    private PermissionRepository repository;
    @InjectMocks
    private CreatePermissionUseCase createPermissionUseCase;
    @InjectMocks
    private DeletePermissionUseCase deletePermissionUseCase;
    @InjectMocks
    private UpdatePermissionUseCase updatePermissionUseCase;

    private PermissionDTO permissionDTO;
    private PermissionEntity permissionEntity;

    @BeforeEach
    public void setup(){
        permissionDTO = new PermissionDTO("CREATE_USER");
        permissionEntity = new PermissionEntity(permissionDTO.getName());
    }

    @DisplayName("Given Permission Object when Save Permission then Return Permission Object")
    @Test
    void testGivenPermissionObject_whenSavePermission_thenReturnPermissionObject(){
        // Given / Arrange
        given(repository.findByName(permissionDTO.getName())).willReturn(Optional.empty());
        given(repository.save(any(PermissionEntity.class))).willReturn(permissionEntity);
        // When / Act
        PermissionDTO permissionDTOCreated = createPermissionUseCase.execute(permissionDTO);
        // Then / assert
        assertNotNull(permissionDTOCreated);
        assertEquals(permissionDTO.getName(), permissionDTOCreated.getName());
        verify(repository, times(1)).save(any(PermissionEntity.class));
    }

    @DisplayName("Given Id Permission when delete by Id Permission then do nothing")
    @Test
    void testGivenIdPermission_whenDeleteByIdPermission_thenDoNothing(){
        // Given / Arrange
        given(repository.findById(permissionDTO.getId())).willReturn(Optional.of(permissionEntity));
        willDoNothing().given(repository).deleteById(permissionDTO.getId());
        // When / Act
        deletePermissionUseCase.execute(permissionDTO.getId());
        // Then /Assert
        verify(repository, times(1)).deleteById(permissionDTO.getId());
    }

    @DisplayName("Given Id Permission when Not Found Permission Object then NotFoundException")
    @Test
    void testGivenIdPermission_whenNotFoundPermissionObject_thenNotFoundException(){
        // Given / Arrange
        given(repository.findById(anyLong())).willReturn(Optional.empty());
        // When / Act
        assertThrows(NotFoundException.class, ()->{
            deletePermissionUseCase.execute(anyLong());
        });
        // Then /Assert
        verify(repository, never()).deleteById(anyLong());
    }

    @DisplayName("Given Permission Object when Set Update Permission Object then Return Permission Object Updated.")
    @Test
    void testGivenPermissionObject_whenSetUpdatePermissionObject_thenReturnPermissionObjectUpdated(){
        // Given / Arrange
        permissionDTO.setId(1L);
        permissionEntity.setId(1L);

        given(repository.findByName(permissionDTO.getName())).willReturn(Optional.empty());
        given(repository.update(any(PermissionEntity.class))).willReturn(permissionEntity);
        // When / Act
        PermissionDTO permissionDTOUpdated = updatePermissionUseCase.execute(permissionDTO);

        // Then / Assert
        assertNotNull(permissionDTOUpdated);
        assertEquals("CREATE_USER", permissionDTOUpdated.getName());
        assertEquals(1L, permissionDTOUpdated.getId());
        then(repository).should(times(1)).update(any(PermissionEntity.class));
    }









}

