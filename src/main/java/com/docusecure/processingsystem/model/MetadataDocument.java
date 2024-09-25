package com.docusecure.processingsystem.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/*{
          "status": "string",
          "message": "string",
          "extracted_metadata":{
          "title": "string",
          "author": "string",
          "date_created": "string",
          "keywords": ["string"]
          }
          }*/
public class MetadataDocument {

    private String status;
    private String message;
    @JsonProperty("extracted_metadata")
    private Document extractedMetadata;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Document getExtractedMetadata() {
        return extractedMetadata;
    }

    public void setExtractedMetadata(Document extractedMetadata) {
        this.extractedMetadata = extractedMetadata;
    }
}
