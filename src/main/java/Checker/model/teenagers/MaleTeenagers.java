package Checker.model.teenagers;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "maleTeenagers")
public class MaleTeenagers {
    @Id
    private int id;
    private String causes;
    private String icd;
}
