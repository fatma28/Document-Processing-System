package com.docusecure.processingsystem.service;

import com.docusecure.processingsystem.dao.DocumentRepository;
import com.docusecure.processingsystem.model.Document;
import com.docusecure.processingsystem.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.concurrent.CompletableFuture;

@Service
public class DocumentService {

    private final DocumentRepository documentRepository;
    private final DocumentProcessingService processingService;

    public DocumentService(DocumentRepository documentRepository, DocumentProcessingService processingService) {
        this.documentRepository = documentRepository;
        this.processingService = processingService;
    }

    private Document proccessDocument(MultipartFile file) {
        return processingService.processDocument(file);
    }

    public CompletableFuture<Document> processAndSaveDocument(MultipartFile file) {
        return CompletableFuture.supplyAsync(() -> proccessDocument(file))
                .handleAsync((document, throwable) -> {
                    document.setStatus("CREATED");
                    Document entity = documentRepository.save(document);
                    Document savedDocument = new Document();
                    savedDocument.setDocumentId(entity.getDocumentId());
                    return savedDocument;
                });
    }


    public ResponseEntity<?> getDocumentById(String id) {

        Document document = documentRepository.findById(id)
                .map(this::convertFromDocumentEntityToDocument)
                .orElse(null);

        if (document == null) {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND, "Document is not found!", "Document with Id : " + id + " not exist");
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(document, HttpStatus.OK);
    }


    public Document getDocumentStatusById(String id) {
        Document entity = documentRepository.getReferenceById(id);

        return entity;
    }

    public Document convertFromDocumentEntityToDocument(Document documentEntity) {
        Document document = new Document();
        document.setDocumentId(documentEntity.getDocumentId());
        document.setAuthor(documentEntity.getAuthor());
        document.setTitle(documentEntity.getTitle());
        document.setDateCreated(documentEntity.getDateCreated());
        document.setKeywords(documentEntity.getKeywords());
//        document.setUser(documentEntity.getUser());
        return document;
    }

    public Document convertFromDocumentToDocumentEntity(Document document) {
//        DocumentEntity documentEntity = new DocumentEntity();
//        documentEntity.setDocumentId(document.getDocumentId());
//        documentEntity.setAuthor(document.getAuthor());
//        documentEntity.setTitle(document.getTitle());
//        documentEntity.setDateCreated(document.getDateCreated());
//        documentEntity.setKeywords(document.getKeywords());
//        documentEntity.setUser(document.getUser());

        return null;
    }


}
