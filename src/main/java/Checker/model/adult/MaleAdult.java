package Checker.model.adult;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "maleAdult")

public class MaleAdult {
    @Id
    private int id;
    private String causes;
    private String icd;
}
