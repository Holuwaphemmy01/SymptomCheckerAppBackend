package Checker.dtos.request;

import lombok.Data;

import java.util.List;

@Data
public class SymptomRequest {
    private List<Integer> symptomIds;
    private String gender;
    private String ageCategory;
}
