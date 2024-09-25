//package com.docusecure.docprocessingsystem.model;
//
//import com.fasterxml.jackson.annotation.JsonProperty;
//import jakarta.persistence.*;
//
//import java.util.List;
//import java.util.UUID;
//
///*
//    {
//        "document_id": "string",
//            "title": "string",
//            "author": "string",
//            "date_created": "string",
//            "keywords": ["string"]
//    }
//*/
//
//@Entity
//@Table
//public class DocumentEntity {
//
//    @Id
//    @JsonProperty("document_id")
//    private String documentId;
//    private String title;
//    private String author;
//    @JsonProperty("date_created")
//    private String dateCreated;
//
//    @ElementCollection
//    List<String> keywords;
//
//    private String status;
//    @JsonProperty("last_updated")
//    private String lastUpdated;
//
//
////    @ManyToOne(fetch = FetchType.LAZY, optional = false)
////    @JoinColumn(name = "user_id")
////    private UserEntity userEntity;
//
//
//    @PrePersist
//    public void prePersist() {
//        if (documentId == null) {
//            documentId = UUID.randomUUID().toString();
//        }
//    }
//
//    public String getDocumentId() {
//        return documentId;
//    }
//
//    public void setDocumentId(String documentId) {
//        this.documentId = documentId;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//    }
//
//    public String getDateCreated() {
//        return dateCreated;
//    }
//
//    public void setDateCreated(String dateCreated) {
//        this.dateCreated = dateCreated;
//    }
//
//    public List<String> getKeywords() {
//        return keywords;
//    }
//
//    public void setKeywords(List<String> keywords) {
//        this.keywords = keywords;
//    }
//
////    public UserEntity getUserEntity() {
////        return userEntity;
////    }
////
////    public void setUser(UserEntity userEntity) {
////        this.userEntity = userEntity;
////    }
//
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public String getLastUpdated() {
//        return lastUpdated;
//    }
//
//    public void setLastUpdated(String lastUpdated) {
//        this.lastUpdated = lastUpdated;
//    }
//}
