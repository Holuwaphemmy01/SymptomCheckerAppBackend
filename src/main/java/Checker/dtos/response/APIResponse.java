package Checker.dtos.response;

import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
public class APIResponse {
    private String message;
    private boolean success;
}
