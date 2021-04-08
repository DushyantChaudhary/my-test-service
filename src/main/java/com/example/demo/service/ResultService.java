package com.example.demo.service;

import com.example.demo.entities.TestResults;
import com.example.demo.repository.ResultRepository;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResultService {

    @Autowired
    ResultRepository resultRepository;

    public Integer saveResults(Integer a, Integer b)
    {
        TestResults testResults = new TestResults();
        testResults.setExecutionResult(a+b);
        testResults = resultRepository.save(testResults);

        return testResults.getExecutionResult();
    }

    public Integer saveResults(Integer a)
    {
        TestResults testResults = new TestResults();
        testResults.setExecutionResult(a*2);
        testResults = resultRepository.save(testResults);

        return testResults.getExecutionResult();
    }

    public Integer savePowerResults(Integer a)
    {
        TestResults testResults = new TestResults();
        testResults.setExecutionResult(a*a);
        testResults = resultRepository.save(testResults);

        return testResults.getExecutionResult();
    }

    public List<TestResults> getAllResults()
    {
        List<TestResults> allResults= new ArrayList<TestResults>();
         resultRepository.findAll().forEach(result-> allResults.add(result));
         return allResults;
    }
}
