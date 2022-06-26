package com.example.test_project_1.controller;

import com.example.test_project_1.model.Data;
import com.example.test_project_1.service.LogStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class DataController {
    private final LogStorageService logStorageService;

    @PostMapping(value = "/", consumes = {MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Void> convertXmlToJson(@RequestBody Data data) throws IOException {

        logStorageService.writeDataToLog(data);

        return ResponseEntity.ok().build();
    }
}
