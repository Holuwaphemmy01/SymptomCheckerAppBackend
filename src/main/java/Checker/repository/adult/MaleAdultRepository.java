package Checker.repository.adult;

import Checker.model.adult.FemaleAdult;
import Checker.model.adult.MaleAdult;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MaleAdultRepository extends MongoRepository<MaleAdult, String> {
    MaleAdult getById(Integer attr0);
}
