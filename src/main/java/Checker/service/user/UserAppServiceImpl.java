package Checker.service.user;

import Checker.dtos.request.LoginRequest;
import Checker.dtos.request.UserAppDtos;
import Checker.dtos.response.UserAppResponse;
import Checker.model.user.UserApp;
import Checker.repository.userRepositort.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserAppServiceImpl implements UserAppService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String register(UserAppDtos user) {
        checkEmptyFields(user);
        registerValidation(user);
        saveNewRegisterUserDetails(user);
        return "Register successfully";
    }


    @Override
    public String login(LoginRequest user) {
        loginVerification(user);
        return user.getUsername();

    }

    private void checkEmptyFields(UserAppDtos user) {
        if (user.getFirstName() == null || user.getFirstName().isEmpty()) throw new IllegalArgumentException("First name cannot be empty");
        if (user.getLastName().isBlank()) throw new IllegalArgumentException("Last name cannot be empty");
        if (user.getPassword().isBlank()) throw new IllegalArgumentException("Password cannot be empty");
        if (user.getUsername().isBlank()) throw new IllegalArgumentException("Username cannot be empty");
    }

    private void registerValidation(UserAppDtos user) {
        List<UserAppResponse> result = allRegisterUser();
        for (UserAppResponse userAppResponse : result) {
            if (userAppResponse.getUsername().equals(user.getUsername())) throw new IllegalArgumentException("Username is already in use");
        }
    }

    private void saveNewRegisterUserDetails(UserAppDtos user) {
        UserApp userApp = new UserApp();
        userApp.setUserName(user.getUsername());
        userApp.setPassword(user.getPassword());
        userApp.setFirstName(user.getFirstName());
        userApp.setLastName(user.getLastName());
        userRepository.save(userApp);
    }


    private List<UserAppResponse> allRegisterUser() {
        List<UserApp> result = userRepository.findAll();
        List<UserAppResponse> userAppResponses = new ArrayList<>();
        for (UserApp userApp : result) {
            UserAppResponse userAppResponse = new UserAppResponse();
            userAppResponse.setFirstName(userApp.getFirstName());
            userAppResponse.setLastName(userApp.getLastName());
            userAppResponse.setUsername(userApp.getUserName());
            userAppResponses.add(userAppResponse);
        }
        return userAppResponses;
    }

    private void loginVerification(LoginRequest user) {
        Optional<UserApp> result = userRepository.findById(user.getUsername());
        if (result.isPresent()) {
            UserApp userApp = result.get();
            if (!userApp.getPassword().equals(user.getPassword())) throw new IllegalArgumentException("Password does not match");
        }
        if (result.isEmpty()) throw new IllegalArgumentException("User not found");
    }

}
