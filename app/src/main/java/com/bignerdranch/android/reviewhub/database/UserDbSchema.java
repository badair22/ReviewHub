package com.bignerdranch.android.reviewhub.database;

public class UserDbSchema {
    public static final class UserTable {
        public static final String NAME = "users";

        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String FIRST = "firstname";
            public static final String LAST = "lastname";
            public static final String EMAIL = "email";
            public static final String USERNAME = "username";
        }
    }
}
