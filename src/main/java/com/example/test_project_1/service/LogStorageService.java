package com.example.test_project_1.service;

import com.example.test_project_1.model.Data;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
@Slf4j
public class LogStorageService {
    private final ObjectMapper objectMapper;

    @Value("${log-storage-dir}")
    private String logStorageDir;

    public void writeDataToLog(Data data) {
        String fileName = getFileName(data);
        try {
            validateDirectory();
            Path path = Paths.get(fileName);

            long numRecords = 0;
            List<String> lines = new ArrayList<>(Collections.singletonList(""));
            if (path.toFile().exists()) {
                lines = Files.readAllLines(path, StandardCharsets.UTF_8);
                numRecords = StringUtils.isBlank(lines.get(0)) ? 0 : Long.parseLong(lines.get(0));
            }
            numRecords++;

            lines.set(0, String.valueOf(numRecords));

            String dataJson = objectMapper.writeValueAsString(data);
            lines.add(dataJson);
            Files.write(path, lines, StandardCharsets.UTF_8);

        } catch (NumberFormatException e) {
            log.error("Error parsing number of records in a log file. Filename: {}", fileName);
            throw new RuntimeException(format("Error parsing number of records in a log file. Filename: %1s", fileName),
                    e);
        } catch (JsonProcessingException e) {
            log.error("Error converting Data into JSON format");
            throw new RuntimeException("Error converting Data into JSON format", e);
        } catch (IOException e) {
            log.error("Error accessing log file. Filename: {}", fileName);
            throw new RuntimeException(format("Error accessing log file. Filename: %1s", fileName), e);
        }
    }



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
