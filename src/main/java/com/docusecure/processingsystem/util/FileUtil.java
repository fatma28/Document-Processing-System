package com.docusecure.docprocessingsystem.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil {

    public static String[] splitFileLines(MultipartFile file, String delimiter) throws IOException {
        List<String[]> lines = new ArrayList<>();
        String[] parts = new String[0];
        try (InputStream inputStream = file.getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                parts = line.split(delimiter);
//                lines.add(parts);
            }
        }

        return parts;
    }
}
