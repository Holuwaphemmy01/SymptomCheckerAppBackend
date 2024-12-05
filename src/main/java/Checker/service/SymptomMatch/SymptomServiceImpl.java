package Checker.service.SymptomMatch;

import Checker.dtos.request.SymptomRequest;
import Checker.dtos.response.SymptomResponse;
import Checker.model.adult.FemaleAdult;
import Checker.model.adult.MaleAdult;
import Checker.model.children.FemaleChildren;
import Checker.model.children.MaleChildren;
import Checker.model.teenagers.FemaleTeenagers;
import Checker.model.teenagers.MaleTeenagers;
import Checker.repository.adult.FemaleAdultRepository;
import Checker.repository.adult.MaleAdultRepository;
import Checker.repository.children.FemaleChildrenRepository;
import Checker.repository.children.MaleChildrenRepository;
import Checker.repository.teenagers.FemaleTeenagersRepository;
import Checker.repository.teenagers.MaleTeenagersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SymptomServiceImpl implements SymptomService {
    
    @Autowired
    private MaleChildrenRepository maleChildrenRepository;

    @Autowired
    private FemaleChildrenRepository femaleChildrenRepository;

    @Autowired
    private MaleTeenagersRepository teenagersRepository;
    @Autowired
    private MaleTeenagersRepository maleTeenagersRepository;

    @Autowired
    private FemaleTeenagersRepository femaleTeenagersRepository;

    @Autowired
    private MaleAdultRepository maleAdultRepository;

    @Autowired
    private FemaleAdultRepository femaleAdultRepository;


    @Override
    public List<SymptomResponse> findSymptom(SymptomRequest symptomRequest) {
        List<SymptomResponse> symptomResponse = new ArrayList<>();
        if (symptomRequest.getAgeCategory().equalsIgnoreCase("Children")&&symptomRequest.getGender().equalsIgnoreCase("male")) {
             symptomResponse = getMaleChildrenSymptoms(symptomRequest.getSymptomIds());
        }

        if (symptomRequest.getAgeCategory().equalsIgnoreCase("Children")&&symptomRequest.getGender().equalsIgnoreCase("female")) {
            symptomResponse = getFemaleChildrenSymptoms(symptomRequest.getSymptomIds());
        }

        if (symptomRequest.getAgeCategory().equalsIgnoreCase("Teenager")&&symptomRequest.getGender().equalsIgnoreCase("male")) {
            symptomResponse = getMaleTeenagersSymptoms(symptomRequest.getSymptomIds());
        }

        if (symptomRequest.getAgeCategory().equalsIgnoreCase("Teenager")&&symptomRequest.getGender().equalsIgnoreCase("female")) {
            symptomResponse = getFemaleTeenagersSymptoms(symptomRequest.getSymptomIds());
        }

        if (symptomRequest.getAgeCategory().equalsIgnoreCase("adult")&&symptomRequest.getGender().equalsIgnoreCase("male")) {
            symptomResponse = getMaleAdultsSymptoms(symptomRequest.getSymptomIds());
        }

        if (symptomRequest.getAgeCategory().equalsIgnoreCase("adult")&&symptomRequest.getGender().equalsIgnoreCase("female")) {
            symptomResponse = getFemaleAdultsSymptoms(symptomRequest.getSymptomIds());
        }

        return symptomResponse;
    }

    private List<SymptomResponse> getFemaleAdultsSymptoms(List<Integer> symptomIds) {
        List<SymptomResponse> responses = new ArrayList<>();
        for (Integer symptomId : symptomIds) {
            SymptomResponse symptomResponse = new SymptomResponse();
            FemaleAdult femaleAdult = femaleAdultRepository.getById(symptomId);
            symptomResponse.setCauses(femaleAdult.getCauses());
            symptomResponse.setICD(femaleAdult.getIcd());
            responses.add(symptomResponse);
        }
        return responses;
    }

    private List<SymptomResponse> getMaleAdultsSymptoms(List<Integer> symptomIds) {
        List<SymptomResponse> responses = new ArrayList<>();
        for (Integer symptomId : symptomIds) {
            SymptomResponse symptomResponse = new SymptomResponse();
            MaleAdult maleAdult = maleAdultRepository.getById(symptomId);
            symptomResponse.setCauses(maleAdult.getCauses());
            symptomResponse.setICD(maleAdult.getIcd());
            responses.add(symptomResponse);
        }
        return responses;
    }

    private List<SymptomResponse> getFemaleTeenagersSymptoms(List<Integer> symptomIds) {
        List<SymptomResponse> responses = new ArrayList<>();
        for (Integer symptomId : symptomIds) {
            SymptomResponse symptomResponse = new SymptomResponse();
            FemaleTeenagers femaleTeenagers = femaleTeenagersRepository.getById(symptomId);
            symptomResponse.setCauses(femaleTeenagers.getCauses());
            symptomResponse.setICD(femaleTeenagers.getIcd());
            responses.add(symptomResponse);
        }
        return responses;
    }

    private List<SymptomResponse> getMaleTeenagersSymptoms(List<Integer> symptomIds) {
        List<SymptomResponse> responses = new ArrayList<>();
        for (Integer symptomId : symptomIds) {
            SymptomResponse symptomResponse = new SymptomResponse();
            MaleTeenagers male = maleTeenagersRepository.getById(symptomId);
            symptomResponse.setCauses(male.getCauses());
            symptomResponse.setICD(male.getIcd());
            responses.add(symptomResponse);
        }
        return responses;
    }


    private List<SymptomResponse> getFemaleChildrenSymptoms(List<Integer> symptomIds) {
        List<SymptomResponse> responses = new ArrayList<>();
        for (Integer symptomId : symptomIds) {
            SymptomResponse symptomResponse = new SymptomResponse();
            FemaleChildren female = femaleChildrenRepository.getById(symptomId);
            symptomResponse.setCauses(female.getCauses());
            symptomResponse.setICD(female.getIcd());
            responses.add(symptomResponse);
        }
        return responses;
    }

    private List<SymptomResponse> getMaleChildrenSymptoms(List<Integer> symptomIds) {
        List<SymptomResponse> responses = new ArrayList<>();
        for (Integer symptomId : symptomIds) {
            SymptomResponse symptomResponse = new SymptomResponse();
            MaleChildren male = maleChildrenRepository.getById(symptomId);
            symptomResponse.setCauses(male.getCauses());
            symptomResponse.setICD(male.getIcd());
            responses.add(symptomResponse);
        }
        return responses;
    }
}
