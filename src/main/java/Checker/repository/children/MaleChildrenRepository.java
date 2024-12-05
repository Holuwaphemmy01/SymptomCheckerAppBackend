package Checker.repository.children;

import Checker.model.children.MaleChildren;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MaleChildrenRepository extends MongoRepository<MaleChildren, String> {
     MaleChildren getById(int id);
}
