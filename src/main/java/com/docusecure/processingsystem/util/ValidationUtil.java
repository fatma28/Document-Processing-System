package com.docusecure.processingsystem.util;

import java.util.Base64;

public class ValidationUtil {

    public static String getTokenFromHeader(String authorization) {
        if (authorization != null && authorization.startsWith("Bearer ")) {
            return authorization.substring(7);
        } else {
            throw new IllegalArgumentException("Invalid Authorization header");
        }
    }

    public static String getPermission(String authorization) {
        return Base64.getEncoder().encodeToString(authorization.getBytes());
    }

//    private static void notNullOrEmptyAuthorizationHeader(String authorization) {
//        if(authorization == null || authorization.isEmpty()) {
//            throw new RuntimeException("Authorization header is empty");
//        }
//    }

    public static void validateAdminPermission(String authorization) {
//        notNullOrEmptyAuthorizationHeader(authorization);

        String token = getTokenFromHeader(authorization);
        if (!getPermission(token).equals("Admin")) {
            throw new RuntimeException("Admin permission not valid!");
        }
    }

    public static void validViewOnlyPermission(String authorization) {
        String token = getTokenFromHeader(authorization);
        if (!getPermission(token).equals("viewOnly")) {
            throw new RuntimeException("View only permission not valid!");
        }
    }



}
