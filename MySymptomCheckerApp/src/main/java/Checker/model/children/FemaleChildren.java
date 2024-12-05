package Checker.model.children;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "femaleChildren")
public class FemaleChildren {
    @Id
    private int id;
    private String causes;
    private String icd;
}
