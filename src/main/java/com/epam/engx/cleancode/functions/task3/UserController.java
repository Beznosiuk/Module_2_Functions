package com.epam.engx.cleancode.functions.task3;

import com.epam.engx.cleancode.functions.task3.thirdpartyjar.Controller;
import com.epam.engx.cleancode.functions.task3.thirdpartyjar.User;

public abstract class UserController implements Controller {

    private UserAuthenticator userAuthenticator;

    public void checkIsUserPresentAndAuthenticate(String userName, String password) {
        if (userAuthenticator.login(userName, password).isPresent()) {
            generateSuccessLoginResponse(userName);
        } else {
            generateFailLoginResponse();
        }
    }

    public void setUserAuthenticator(UserAuthenticator userAuthenticator) {
        this.userAuthenticator = userAuthenticator;
    }
}
