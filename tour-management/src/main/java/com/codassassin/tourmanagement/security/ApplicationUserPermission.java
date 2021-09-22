package com.codassassin.tourmanagement.security;

public enum ApplicationUserPermission {
    USER_READ("user:read"),
    USER_WRITE("user:write"),
    PACKAGE_READ("package:read"),
    PACKAGE_WRITE("package:write");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
