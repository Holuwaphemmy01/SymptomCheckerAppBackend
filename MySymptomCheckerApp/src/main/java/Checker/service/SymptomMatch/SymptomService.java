package Checker.service.SymptomMatch;

import Checker.dtos.request.SymptomRequest;
import Checker.dtos.response.SymptomResponse;

import java.util.List;

public interface SymptomService {
    List<SymptomResponse> findSymptom(SymptomRequest symptomRequest);
}
