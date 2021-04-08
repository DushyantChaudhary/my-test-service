package com.example.demo.controller;

import com.example.demo.entities.TestResults;
import com.example.demo.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.Result;
import java.util.List;

@RestController
public class TestRestController {
    public static final String PATH="/greetings";

    @Autowired
    ResultService service;

    @GetMapping("/add")
    public ResponseEntity<Integer> getASum(@RequestParam int a ,@RequestParam int b){


        Integer sum = service.saveResults(a+b);
        return new ResponseEntity<Integer>(a+b , new HttpHeaders(), HttpStatus.OK);


    }

    @GetMapping("/multiple")
    public ResponseEntity<Integer> getAProduct(@RequestParam int a){

        Integer multiple = service.saveResults(a);
        return new ResponseEntity<Integer>(multiple , new HttpHeaders(), HttpStatus.OK);

    }

    @GetMapping("/power")
    public ResponseEntity<Integer> getAPower(@RequestParam Integer a){

        Integer result = service.savePowerResults(a);
        return new ResponseEntity<Integer>(result , new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(PATH)
    public ResponseEntity<String> getGreetings(){

        return new ResponseEntity<String>("Hello World" , new HttpHeaders(), HttpStatus.OK);
    }

    //To check that all results are persisted in db
    @GetMapping("/results")
    public ResponseEntity<List<TestResults>> getAllResults(){

        List<TestResults> allResults= service.getAllResults();
        return new ResponseEntity<List<TestResults>>(allResults , new HttpHeaders(), HttpStatus.OK);
    }

}
