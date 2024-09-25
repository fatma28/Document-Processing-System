package com.docusecure.processingsystem.controller;

import com.docusecure.processingsystem.model.Document;
import com.docusecure.processingsystem.service.DocumentService;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.concurrent.CompletableFuture;


@RestController
public class DocumentController {


    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }


    @PreAuthorize("T(ValidationUtil).validateAdminPermission(#authorization)")
    @RequestMapping(value = "/documents", method = RequestMethod.POST, produces = "application/json")
    @Async
    public CompletableFuture<Document> sendDocument(@RequestParam("file") MultipartFile file, @RequestHeader String authorization) {
        return documentService.processAndSaveDocument(file);
    }

    @RequestMapping(value = "/documents/{documentId}/metadata", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getDocument(@PathVariable String documentId) {
        return documentService.getDocumentById(documentId);
    }

    @RequestMapping(value = "/documents/{documentId}/status", method = RequestMethod.GET, produces = "application/json")
    public Document getDocumentStatus(@PathVariable String documentId) {
        return documentService.getDocumentStatusById(documentId);
    }

//    @RequestMapping(value = "/documents/status", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
//    public String getDocumentStatus() {
//        return "OK";
//    }

}
