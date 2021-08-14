package com.epam.engx.cleancode.functions.task3;

import com.epam.engx.cleancode.functions.task3.thirdpartyjar.SessionManager;
import com.epam.engx.cleancode.functions.task3.thirdpartyjar.User;
import com.epam.engx.cleancode.functions.task3.thirdpartyjar.UserService;

import java.util.Optional;

public abstract class UserAuthenticator implements UserService {

    private SessionManager sessionManager;

    public Optional<Object> login(String userName, String password) {
        return checkPasswordAndSetUser(getUserByName(userName), password);
    }

    private Optional<Object> checkPasswordAndSetUser(User user, String password) {
        if (isPasswordCorrect(user, password)) {
            sessionManager.setCurrentUser(user);
            return Optional.ofNullable(user);
        }
        return Optional.empty();
    }

    public void setSessionManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }
}
