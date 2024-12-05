package Checker.repository.userRepositort;

import Checker.model.user.UserApp;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<UserApp, String> {

}
