package com.epam.engx.cleancode.functions.task1;

import com.epam.engx.cleancode.functions.task1.thirdpartyjar.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static com.epam.engx.cleancode.functions.task1.thirdpartyjar.CheckStatus.OK;

public class RegisterAccountAction {


    private PasswordChecker passwordChecker;
    private AccountManager accountManager;

    private static final int MINIMAL_ACCOUNT_NAME_LENGTH = 5;
    private static final int MINIMAL_PASSWORD_LENGTH = 8;

    public void registerNewAccount(Account account) {
        checkAccountNameLength(account);
        checkPasswordLength(account);
        validatePassword(account);

        account.setCreatedDate(new Date());
        account.setAddresses(setAddressesList(account));

        accountManager.createNewAccount(account);
    }

    public void checkAccountNameLength(Account account) {
        if (account.getName().length() <= MINIMAL_ACCOUNT_NAME_LENGTH) {
            throw new WrongAccountNameException();
        }
    }

    public void checkPasswordLength(Account account) {
        if (account.getPassword().length() <= MINIMAL_PASSWORD_LENGTH) {
            throw new TooShortPasswordException();
        }
    }

    public void validatePassword(Account account) {
        if (passwordChecker.validate(account.getPassword()) != OK) {
            throw new WrongPasswordException();
        }
    }

    public List<Address> setAddressesList(Account account) {
        return Arrays.asList(account.getHomeAddress(), account.getWorkAddress(), account.getAdditionalAddress());
    }

    public void setAccountManager(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    public void setPasswordChecker(PasswordChecker passwordChecker) {
        this.passwordChecker = passwordChecker;
    }

}
