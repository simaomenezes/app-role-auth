package github.com.simaomenezes.roleapp.presentation.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message, Long id){
        super(String.format("%s not found with id: %d", message, id));
    }

    public ResourceNotFoundException(String message){
        super(message);
    }
}
