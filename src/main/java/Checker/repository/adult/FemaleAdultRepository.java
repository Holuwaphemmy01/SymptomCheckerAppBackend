package Checker.repository.adult;

import Checker.model.adult.FemaleAdult;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FemaleAdultRepository extends MongoRepository<FemaleAdult, String> {
    FemaleAdult getById(int id);
}
