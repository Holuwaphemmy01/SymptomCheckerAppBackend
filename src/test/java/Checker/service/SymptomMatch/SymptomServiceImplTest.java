package Checker.service.SymptomMatch;

import Checker.dtos.request.SymptomRequest;
import Checker.dtos.response.SymptomResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SymptomServiceImplTest {

    @Autowired
    private SymptomService symptomService;

    @Test
    public void testToConfirmMaleChildrenResponse(){
        SymptomRequest symptomRequest = new SymptomRequest();
        List<Integer> number = List.of(4);
        symptomRequest.setGender("male");
        symptomRequest.setSymptomIds(number);
        symptomRequest.setAgeCategory("Children");
        List<SymptomResponse> response = symptomService.findSymptom(symptomRequest);
        assertEquals("Raynaud's disease", response.getFirst().getCauses());

    }

    @Test
    public void testToConfirmFemaleChildrenResponse(){
        SymptomRequest symptomRequest = new SymptomRequest();
        List<Integer> number = List.of(10);
        symptomRequest.setGender("female");
        symptomRequest.setSymptomIds(number);
        symptomRequest.setAgeCategory("Children");
        List<SymptomResponse> response = symptomService.findSymptom(symptomRequest);
        assertEquals("State of stress", response.getFirst().getCauses());
    }

    @Test
    public void testToConfirmMaleTeenagerResponse(){
        SymptomRequest symptomRequest = new SymptomRequest();
        List<Integer> number = List.of(7);
        symptomRequest.setGender("male");
        symptomRequest.setSymptomIds(number);
        symptomRequest.setAgeCategory("Teenager");
        List<SymptomResponse> response = symptomService.findSymptom(symptomRequest);
        assertEquals("Problems with defecation", response.getFirst().getCauses());
    }

    @Test
    public void testToConfirmFemaleTeenagerResponse(){
        SymptomRequest symptomRequest = new SymptomRequest();
        List<Integer> number = List.of(13);
        symptomRequest.setGender("female");
        symptomRequest.setSymptomIds(number);
        symptomRequest.setAgeCategory("Teenager");
        List<SymptomResponse> response = symptomService.findSymptom(symptomRequest);
        assertEquals("Pink eye", response.getFirst().getCauses());
    }


    @Test
    public void testToConfirmMaleAdultResponse(){
        SymptomRequest symptomRequest = new SymptomRequest();
        List<Integer> number = List.of(6);
        symptomRequest.setGender("male");
        symptomRequest.setSymptomIds(number);
        symptomRequest.setAgeCategory("adult");
        List<SymptomResponse> response = symptomService.findSymptom(symptomRequest);
        assertEquals("Benign prostate enlargement", response.getFirst().getCauses());
    }

    @Test
    public void testToConfirmFemaleAdultResponse(){
        SymptomRequest symptomRequest = new SymptomRequest();
        List<Integer> number = List.of(1);
        symptomRequest.setGender("female");
        symptomRequest.setSymptomIds(number);
        symptomRequest.setAgeCategory("adult");
        List<SymptomResponse> response = symptomService.findSymptom(symptomRequest);
        assertEquals("Pregnancy", response.getFirst().getCauses());
    }



}