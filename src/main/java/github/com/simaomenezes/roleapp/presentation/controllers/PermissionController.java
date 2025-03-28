package github.com.simaomenezes.roleapp.presentation.controllers;

import github.com.simaomenezes.roleapp.application.dtos.PermissionDTO;
import github.com.simaomenezes.roleapp.application.usecases.permission.CreatePermissionUseCase;
import github.com.simaomenezes.roleapp.presentation.dtos.PermissionRequestDTO;
import github.com.simaomenezes.roleapp.presentation.exception.ResourceNotFoundException;
import github.com.simaomenezes.roleapp.presentation.utils.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@AllArgsConstructor
@RestController
@RequestMapping("/permissions")
public class PermissionController {

    private final CreatePermissionUseCase createPermissionUseCase;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> create(@RequestBody PermissionRequestDTO permissionRequestDTO){
        final PermissionDTO permissionDTO = new PermissionDTO(permissionRequestDTO.getName());
        try {
            PermissionDTO result = createPermissionUseCase.execute(permissionDTO);
            return ResponseEntity.status(CREATED).body(new ApiResponse("Add permission with success!", result));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }
}
