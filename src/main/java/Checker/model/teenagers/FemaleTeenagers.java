package Checker.model.teenagers;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;

@Data
@Document(collection = "femaleTeenagers")
public class FemaleTeenagers {
    @Id
    private int id;
    private String causes;
    private String icd;
}
