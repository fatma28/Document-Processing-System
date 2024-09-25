//package com.docusecure.docprocessingsystem.model;
//
//import com.fasterxml.jackson.annotation.JsonProperty;
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "users")
//public class UserDTO {
//
//    @Id
//    @JsonProperty("user_id")
//    private String userId;
//
//    private String permission;
//
//    private boolean viewOnly;
//    private boolean editAndDelete;
//
//    public String getUserId() {
//        return userId;
//    }
//
//    public void setUserId(String userId) {
//        this.userId = userId;
//    }
//
//    public String getPermission() {
//        return permission;
//    }
//
//    public void setPermission(String permission) {
//        this.permission = permission;
//    }
//
//    public boolean isViewOnly() {
//        return viewOnly;
//    }
//
//    public void setViewOnly(boolean viewOnly) {
//        this.viewOnly = viewOnly;
//    }
//
//    public boolean isEditAndDelete() {
//        return editAndDelete;
//    }
//
//    public void setEditAndDelete(boolean editAndDelete) {
//        this.editAndDelete = editAndDelete;
//    }
//}
