package com.k99sharma.tulip.user.repository;

/**
 * Queries to be used in user related DB operation.
 */
public class Queries {
    public static final String IS_USERNAME_VALID = """
                    SELECT CASE WHEN COUNT(*) > 0
                    THEN FALSE ELSE TRUE END AS validity
                    FROM UserEntity u
                    WHERE u.username = :username
            """;

    public static final String IS_EMAIL_VALID = """
                    SELECT CASE WHEN COUNT(*) > 0
                    THEN FALSE ELSE TRUE END AS validity
                    FROM UserEntity u
                    WHERE u.email = :email
            """;
}
