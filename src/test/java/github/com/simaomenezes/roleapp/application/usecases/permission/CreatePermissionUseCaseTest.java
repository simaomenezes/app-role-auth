package github.com.simaomenezes.roleapp.application.usecases.permission;

import github.com.simaomenezes.roleapp.application.dtos.PermissionDTO;
import github.com.simaomenezes.roleapp.domain.entity.PermissionEntity;
import github.com.simaomenezes.roleapp.domain.repository.PermissionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class CreatePermissionUseCaseTest {

    @Mock
    private PermissionRepository repository;
    @InjectMocks
    private CreatePermissionUseCase createPermissionUseCase;

    private PermissionDTO permissionDTO;

    @BeforeEach
    public void setup(){
        permissionDTO = new PermissionDTO(
                "CREATE_USER"
        );
    }

    @DisplayName("Given Permission Object when Save Permission then Return Permission Object")
    @Test
    void testGivenPermissionObject_whenSavePermission_thenReturnPermissionObject(){
        // Given / Arrange
        given(repository.findByName(permissionDTO.getName())).willReturn(Optional.empty());
        given(repository.save(any(PermissionEntity.class))).willAnswer(invocation  -> invocation.getArgument(0));

        // When / Act
        PermissionDTO permissionDTOCreated = createPermissionUseCase.execute(permissionDTO);

        // Then / assert
        assertNotNull(permissionDTOCreated);
        assertEquals(permissionDTO.getName(), permissionDTOCreated.getName());
        verify(repository, times(1)).save(any(PermissionEntity.class));
    }





}

