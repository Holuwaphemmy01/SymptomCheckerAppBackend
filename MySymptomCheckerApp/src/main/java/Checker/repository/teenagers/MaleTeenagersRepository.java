package Checker.repository.teenagers;

import Checker.model.children.MaleChildren;
import Checker.model.teenagers.MaleTeenagers;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MaleTeenagersRepository extends MongoRepository<MaleChildren, String> {
    MaleTeenagers getById(int id);
}
