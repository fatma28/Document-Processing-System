package com.docusecure.processingsystem.model;


    /*{
            "status": "string",
            "classification": "string",
            "confidence": "float"
            }*/

public class DocumentClassification {

    private String status;
    private String classification;
    private String confidence;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getConfidence() {
        return confidence;
    }

    public void setConfidence(String confidence) {
        this.confidence = confidence;
    }
}
