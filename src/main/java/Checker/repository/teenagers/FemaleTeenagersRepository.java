package Checker.repository.teenagers;

import Checker.model.teenagers.FemaleTeenagers;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FemaleTeenagersRepository extends MongoRepository<FemaleTeenagers, String> {
    FemaleTeenagers getById(int id);
}
