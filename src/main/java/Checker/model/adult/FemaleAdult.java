package Checker.model.adult;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "femaleAdult")
public class FemaleAdult {
    @Id
    private int id;
    private String causes;
    private String icd;
}
