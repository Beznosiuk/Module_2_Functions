package com.epam.engx.cleancode.functions.task3;

import com.epam.engx.cleancode.functions.task3.thirdpartyjar.SessionManager;
import com.epam.engx.cleancode.functions.task3.thirdpartyjar.User;
import com.epam.engx.cleancode.functions.task3.thirdpartyjar.UserService;

import java.io.IOException;

public abstract class UserAuthenticator implements UserService {

    SessionManager sessionManager;

    public void login(String userName, String password) throws IOException {
        checkPasswordAndSetUser(getUserByName(userName), password);
    }

    private void checkPasswordAndSetUser(User user, String password) throws IOException {
        if (isPasswordCorrect(user, password)) {
            sessionManager.setCurrentUser(user);
        } else {
            throw new IOException("Password is incorrect!");
        }
    }

    public void setSessionManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }
}
