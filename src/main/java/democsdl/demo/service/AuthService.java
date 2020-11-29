package democsdl.demo.service;

import democsdl.demo.dto.MessageResponse;
import democsdl.demo.model.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    public ResponseEntity<MessageResponse> registerUser(Customer customer){
        MessageResponse message = new MessageResponse(HttpStatus.OK.value(), "test ok");
        return ResponseEntity
                .ok()
                .body(message);
    }

}
