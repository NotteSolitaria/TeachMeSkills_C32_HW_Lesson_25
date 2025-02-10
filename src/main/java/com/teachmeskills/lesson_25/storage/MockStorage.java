package com.teachmeskills.lesson_25.storage;

import com.teachmeskills.lesson_25.user.UserInfo;

import java.util.HashMap;
import java.util.Map;

public class MockStorage {

    private static Map<UserInfo, String> dataBase;

    static {
        dataBase = new HashMap<>();
        dataBase.put(new UserInfo("admin", "123"), "ADMIN");
        dataBase.put(new UserInfo("user", "123"), "USER");
    }

    public static boolean doesUserExist(String username, String password) {
        return dataBase != null && dataBase.containsKey(new UserInfo(username, password));
    }

    public static String getRole(String username, String password) {
        if (dataBase != null && dataBase.containsKey(new UserInfo(username, password))) {
            return dataBase.get(new UserInfo(username, password));
        } else {
            return null;
        }
    }
}
