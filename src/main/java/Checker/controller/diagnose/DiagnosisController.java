//package Checker.controller.diagnose;
//
//import Checker.dtos.request.ApiRequest;
//import Checker.dtos.request.UserAppDtos;
//
//import Checker.service.user.UserAppServiceImpl;
//import Checker.service.user.login.Login;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("api/map")
//public class DiagnosisController {
//
//
//    @Autowired
//    private Login login;
//
//    @Autowired
//    private UserAppServiceImpl userAppService;
//
//
//    @PostMapping("/login")
//    public String login(UserAppDtos user){
//            String token = "";
//            try {
//
//                 token = userAppService.login(user);
//            }
//            catch (Exception e){
//                e.getMessage();
//            }
//            return token;
//    }
//
//
//    @PostMapping("/register")
//    public void register(UserAppDtos user){
//         userAppService.register(user);
//    }
//
//
//
//
//
//
//
//






package Checker.controller.diagnose;

import Checker.dtos.request.LoginRequest;
import Checker.dtos.request.SymptomRequest;
import Checker.dtos.request.UserAppDtos;
import Checker.dtos.response.APIResponse;
import Checker.dtos.response.SymptomResponse;
import Checker.service.SymptomMatch.SymptomServiceImpl;
import Checker.service.user.UserAppServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/user")
public class DiagnosisController {

    @Autowired
    private UserAppServiceImpl userAppService;

    @Autowired
    private SymptomServiceImpl symptomService;

    @CrossOrigin(origins = "*")
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserAppDtos user) {
        try {
            String code = userAppService.register(user);
            APIResponse apiResponse = new APIResponse();
            apiResponse.setSuccess(true);
            apiResponse.setMessage(code);
            return new ResponseEntity<>(apiResponse, CREATED);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), BAD_REQUEST);
        }


    }

    @CrossOrigin(origins = "*")
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest user) {
        try {
            userAppService.login(user);
            return "Logged in";
        } catch (Exception e) {
            return e.getMessage();
        }

    }

    @CrossOrigin(origins = "*")
    @GetMapping("/getDiagnosis")
    public List<SymptomResponse> diagnosis(@RequestBody SymptomRequest symptomRequest){
        return symptomService.findSymptom(symptomRequest);
    }


}
