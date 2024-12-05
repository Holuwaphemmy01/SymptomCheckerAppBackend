package Checker.service.user;

import Checker.dtos.request.LoginRequest;
import Checker.dtos.request.UserAppDtos;
import Checker.repository.userRepositort.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserAppServiceImplTest {

    @Autowired
    private UserAppService userAppService;

    @Autowired
    private UserRepository userRepository;



    @Test
    public void testToCreateRegisterAndCountRegisterCountIs1(){
        UserAppDtos userAppDtos = new UserAppDtos();
        userAppDtos.setFirstName("firstName");
        userAppDtos.setLastName("lastName");
        userAppDtos.setUsername("username");
        userAppDtos.setPassword("password");
        userAppService.register(userAppDtos);
        assertEquals(1, userRepository.count());
    }

    @Test
    public void testThatUserFirstNameIsEmptyAndExceptionIsThrown(){
        UserAppDtos userAppDtos = new UserAppDtos();
        userAppDtos.setFirstName(" ");
        userAppDtos.setLastName("lastName");
        userAppDtos.setUsername("username");
        userAppDtos.setPassword("password");
        assertThrows(IllegalArgumentException.class, () -> userAppService.register(userAppDtos));
    }

    @Test
    public void testThatUserLastNameIsEmptyAndExceptionIsThrown(){
        UserAppDtos userAppDtos = new UserAppDtos();
        userAppDtos.setFirstName("firstName");
        userAppDtos.setLastName("");
        userAppDtos.setUsername("username");
        userAppDtos.setPassword("password");
        assertThrows(IllegalArgumentException.class, () -> userAppService.register(userAppDtos));
    }

    @Test
    public void testThatUserUsernameIsEmptyAndExceptionIsThrown(){
        UserAppDtos userAppDtos = new UserAppDtos();
        userAppDtos.setFirstName("firstName");
        userAppDtos.setLastName("lastName");
        userAppDtos.setUsername(" ");
        userAppDtos.setPassword("password");
        assertThrows(IllegalArgumentException.class, () -> userAppService.register(userAppDtos));
    }

    @Test
    public void testThatUserPasswordIsEmptyAndExceptionIsThrown(){
        UserAppDtos userAppDtos = new UserAppDtos();
        userAppDtos.setFirstName("firstName");
        userAppDtos.setLastName("lastname");
        userAppDtos.setUsername("username");
        userAppDtos.setPassword(" ");
        assertThrows(IllegalArgumentException.class, () -> userAppService.register(userAppDtos));
    }

    @Test
    public void testThatRegisteredUserCannotRegisterAgain(){
        UserAppDtos userAppDtos = new UserAppDtos();
        userAppDtos.setFirstName("firstName");
        userAppDtos.setLastName("lastName");
        userAppDtos.setUsername("username");
        userAppDtos.setPassword("password");
        userAppService.register(userAppDtos);
        UserAppDtos userAppDtos2 = new UserAppDtos();
        userAppDtos2.setFirstName("firstName");
        userAppDtos2.setLastName("lastName");
        userAppDtos2.setUsername("username");
        userAppDtos2.setPassword("password");
        assertThrows(IllegalArgumentException.class, () -> userAppService.register(userAppDtos2));
    }

    @Test
    public void testThatRegisteredUserCanLoginAndLoginSuccessfulWillBeDisplayed(){
        UserAppDtos userAppDtos = new UserAppDtos();
        userAppDtos.setFirstName("firstName");
        userAppDtos.setLastName("lastName1");
        userAppDtos.setUsername("username1");
        userAppDtos.setPassword("password");
        userAppService.register(userAppDtos);
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("username1");
        loginRequest.setPassword("password");
        assertEquals(userAppDtos.getUsername(), userAppService.login(loginRequest));
    }


    @Test
    public void testToLoginWithWrongUserNameAndExceptionIsThrown(){
        UserAppDtos userAppDtos = new UserAppDtos();
        userAppDtos.setFirstName("firstName");
        userAppDtos.setLastName("lastName");
        userAppDtos.setUsername("username");
        userAppDtos.setPassword("password");
        userAppService.register(userAppDtos);
        LoginRequest loginRequest = new LoginRequest();
        userAppDtos.setUsername("usernae");
        assertThrows(IllegalArgumentException.class, () -> userAppService.login(loginRequest));
    }

    @Test
    public void testToLoginWithWrongPasswordAndExceptionIsThrown(){
        UserAppDtos userAppDtos = new UserAppDtos();
        userAppDtos.setFirstName("firstName");
        userAppDtos.setLastName("lastName");
        userAppDtos.setUsername("username");
        userAppDtos.setPassword("password");
        userAppService.register(userAppDtos);
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("username");
        userAppDtos.setPassword("passwrd");
        assertThrows(IllegalArgumentException.class, () -> userAppService.login(loginRequest));
    }


}