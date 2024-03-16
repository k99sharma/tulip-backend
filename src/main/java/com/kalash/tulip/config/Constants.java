package com.kalash.tulip.config;

public class Constants {
    // user role enums
    public enum Roles {
        ADMIN("admin"),
        USER("user");

        private final String abbreviation;

        Roles(String abbreviation){
            this.abbreviation = abbreviation;
        }

        public String getValue(){
            return abbreviation;
        }
    }
}
