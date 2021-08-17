package com.epam.engx.cleancode.functions.task3;

import com.epam.engx.cleancode.functions.task3.thirdpartyjar.Controller;

import java.io.IOException;

public abstract class UserController implements Controller {

    private UserAuthenticator userAuthenticator;

    public void authenticateUser(String userName, String password) {
        try {
            userAuthenticator.login(userName, password);
            generateSuccessLoginResponse(userName);
        } catch (IOException ioException) {
            generateFailLoginResponse();
        }
    }

    public void setUserAuthenticator(UserAuthenticator userAuthenticator) {
        this.userAuthenticator = userAuthenticator;
    }
}
