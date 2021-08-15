package com.epam.engx.cleancode.functions.task1;

import com.epam.engx.cleancode.functions.task1.thirdpartyjar.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static com.epam.engx.cleancode.functions.task1.thirdpartyjar.CheckStatus.OK;

public class RegisterAccountAction {

    private static final int MINIMAL_ACCOUNT_NAME_LENGTH = 6;
    private static final int MINIMAL_PASSWORD_LENGTH = 9;

    private PasswordChecker passwordChecker;
    private AccountManager accountManager;

    public void registerNewAccount(Account account) {
        validateAccountNameLength(account.getName());
        validatePasswordLength(account.getPassword());
        validatePassword(account.getPassword());

        account.setCreatedDate(new Date());
        account.setAddresses(setAddressesList(account));

        accountManager.createNewAccount(account);
    }

    private void validateAccountNameLength(String name) {
        if (name.length() < MINIMAL_ACCOUNT_NAME_LENGTH) {
            throw new WrongAccountNameException();
        }
    }

    private void validatePasswordLength(String password) {
        if (password.length() < MINIMAL_PASSWORD_LENGTH) {
            throw new TooShortPasswordException();
        }
    }

    private void validatePassword(String password) {
        if (passwordChecker.validate(password) != OK) {
            throw new WrongPasswordException();
        }
    }

    private List<Address> setAddressesList(Account account) {
        return Arrays.asList(account.getHomeAddress(), account.getWorkAddress(), account.getAdditionalAddress());
    }

    public void setAccountManager(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    public void setPasswordChecker(PasswordChecker passwordChecker) {
        this.passwordChecker = passwordChecker;
    }

}
