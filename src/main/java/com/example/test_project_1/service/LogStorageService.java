package com.example.test_project_1.service;

import com.example.test_project_1.model.Data;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
@Slf4j
public class LogStorageService {
    private final ObjectMapper objectMapper;

    @Value("${log-storage-dir}")
    private String logStorageDir;



    @SuppressWarnings("ResultOfMethodCallIgnored")
    private void validateDirectory() {
        File storageDir = new File(logStorageDir);
        if (!storageDir.exists()) {
            storageDir.mkdir();
        }
    }

    private String getFileName(Data data) {
        String logFilePrefix = data.getType();
        String logFileSuffix = getLogFileSuffix(data);
        return logStorageDir + "/" + logFilePrefix + "-" + logFileSuffix + ".log";
    }

    private String getLogFileSuffix(Data data) {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd").format(data.getCreation().getDate());
    }

}
