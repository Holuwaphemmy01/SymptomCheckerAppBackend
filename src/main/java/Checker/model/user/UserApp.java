package Checker.model.user;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "userApp")
public class UserApp {
    @Id
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
}
