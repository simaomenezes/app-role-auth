package github.com.simaomenezes.roleapp.presentation.controllers;

import github.com.simaomenezes.roleapp.application.dtos.PermissionDTO;
import github.com.simaomenezes.roleapp.application.usecases.permission.CreatePermissionUseCase;
import github.com.simaomenezes.roleapp.application.usecases.permission.ListAllPermissionUseCase;
import github.com.simaomenezes.roleapp.application.usecases.permission.UpdatePermissionUseCase;
import github.com.simaomenezes.roleapp.presentation.dtos.PermissionRequestDTO;
import github.com.simaomenezes.roleapp.presentation.exception.ResourceNotFoundException;
import github.com.simaomenezes.roleapp.presentation.utils.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@AllArgsConstructor
@RestController
@RequestMapping("/permissions")
public class PermissionController {
    private final CreatePermissionUseCase createPermissionUseCase;
    private final ListAllPermissionUseCase listAllPermissionUseCase;
    private final UpdatePermissionUseCase updatePermissionUseCase;

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

    @GetMapping
    public ResponseEntity<ApiResponse> listAllPermissionUseCase(){
        try {
            List<PermissionDTO> permissionLisAll = listAllPermissionUseCase.execute();
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("List all permission with success!", permissionLisAll));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse> update(@PathVariable Long id, @RequestBody PermissionRequestDTO permissionRequestDTO){
        final PermissionDTO permissionDTO = new PermissionDTO(id, permissionRequestDTO.getName());
        try {
            PermissionDTO result = updatePermissionUseCase.execute(permissionDTO);
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Update permission with success!", result));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }
}