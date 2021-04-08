package com.example.demo.entities;

import javax.persistence.*;

@Entity
@Table(name="result")
public class TestResults {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name= "executionResult")
    private Integer executionResult;

    public TestResults(){

    }

    public TestResults(Long id,Integer executionResult){

        this.executionResult =executionResult;
        this.id = id;

    }

    public void setExecutionResult(Integer executionResult) {
        this.executionResult = executionResult;
    }
    public Integer getExecutionResult(){
        return executionResult;
    }
}
