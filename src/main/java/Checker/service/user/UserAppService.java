package Checker.service.user;

import Checker.dtos.request.LoginRequest;
import Checker.dtos.request.UserAppDtos;

public interface UserAppService {
    void register(UserAppDtos user);
    String login(LoginRequest user);
}
