package Checker.repository.children;

import Checker.model.children.FemaleChildren;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FemaleChildrenRepository extends MongoRepository<FemaleChildren, String> {
    FemaleChildren getById(int id);
}
