package com.docusecure.processingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;


@SpringBootApplication
public class ProcessingSystemApplication {

	private static final String ALGORITHM = "AES";

	public static void main(String[] args) throws Exception {
		System.out.println(generateKey());
		SpringApplication.run(ProcessingSystemApplication.class, args);
	}

	public static String generateKey() throws Exception {
		KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM);
		keyGen.init(128); // Key size
		SecretKey secretKey = keyGen.generateKey();
		return Base64.getEncoder().encodeToString(secretKey.getEncoded());
	}
}
