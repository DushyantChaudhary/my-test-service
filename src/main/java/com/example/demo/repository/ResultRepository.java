package com.example.demo.repository;

import com.example.demo.entities.TestResults;
import org.springframework.data.repository.CrudRepository;

public interface ResultRepository extends CrudRepository<TestResults,Long> {
}
