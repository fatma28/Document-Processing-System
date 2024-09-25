package com.docusecure.processingsystem.service;

import com.docusecure.docprocessingsystem.util.FileUtil;
import com.docusecure.processingsystem.model.Document;
import com.docusecure.processingsystem.util.AESUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class DocumentProcessingService {

    @Value("${ENCRYPTION_KEY}")
    private String ENCRYPTION_KEY;

    public Document processDocument(MultipartFile file) {

        Document document = new Document();

        String[] fields;
        try {
            fields = FileUtil.splitFileLines(file, ", (?=[A-Za-z])");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (String field : fields) {
            String[] keyValue = field.split(": ", 2);  // Split by ': ' into key and value
            String key = keyValue[0].trim();
            String value = keyValue[1].trim();
            String encryptedValue = null;
            try {
                encryptedValue = AESUtil.encrypt(value, ENCRYPTION_KEY);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            switch (key) {
                case "Document_Id":
                    document.setDocumentId(encryptedValue);
                    break;
                case "Title":
                    document.setTitle(encryptedValue);
                    break;
                case "Author":
                    document.setAuthor(encryptedValue);
                    break;
                case "Date Created":
                    document.setDateCreated(encryptedValue);
                    break;
                case "Keywords":
                    String keywordsString = value.replace("[", "").replace("]", "");

                    List<String> keywords = new ArrayList<>(Arrays.asList(keywordsString.split(" - ")));
                    List<String> encryptedKeywords = keywords
                            .stream()
                            .map(keyword -> {
                                try {
                                    return AESUtil.encrypt(keyword, ENCRYPTION_KEY);
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                            })
                            .collect(Collectors.toList());

                    document.setKeywords(encryptedKeywords);
                    break;
            }
        }

        return document;
    }

    private String extractTitle(String text) {
        // Implement title extraction logic
        return "Extracted Title"; // Placeholder
    }

    private String extractAuthor(String text) {
        // Implement author extraction logic
        return "Extracted Author"; // Placeholder
    }

    private LocalDateTime extractDateCreated(String text) {
        // Implement date extraction logic
        return LocalDateTime.now(); // Placeholder
    }

    private List<String> extractKeywords(String text) {
        // Implement keyword extraction logic
        return List.of("keyword1", "keyword2"); // Placeholder
    }
}
