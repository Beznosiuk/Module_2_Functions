package com.epam.engx.cleancode.functions.task1;

import com.epam.engx.cleancode.functions.task1.thirdpartyjar.*;
import org.junit.Before;
import org.junit.Test;

public class RegisterAccountActionTest {

    private AccountManagerMock accountManagerMock;

    private final RegisterAccountAction registerAccountAction = new RegisterAccountAction();
    private final Account validAccountStub = new ValidAccountStub();
    private final ValidAccountMock validAccountMock = new ValidAccountMock();

    @Before
    public void setUp() throws Exception {
        accountManagerMock = new AccountManagerMock();
        registerAccountAction.setAccountManager(accountManagerMock);
        registerAccountAction.setPasswordChecker(new OkPasswordChecker());
    }

    @Test
    public void shouldRegisterAccount() {
        registerAccountAction.registerNewAccount(validAccountStub);
        accountManagerMock.assertAccountRegistered(validAccountStub);
    }

    @Test
    public void shouldPopulateAccountWhenCreate() {
        registerAccountAction.registerNewAccount(validAccountMock);
        validAccountMock.assertCreationDateExist();
        validAccountMock.assertHomeAddressInAddresses();
        validAccountMock.assertWorkAddressInAddresses();
        validAccountMock.assertAdditionalAddressInAddresses();
    }

    @Test (expected = WrongAccountNameException.class)
    public void shouldThrowExceptionWhenNameIsTooShort() {
        registerAccountAction.registerNewAccount(new ShortNameAccountStub());
    }

    @Test (expected = TooShortPasswordException.class)
    public void shouldThrowExceptionWhenPasswordIsTooShort() {
        registerAccountAction.registerNewAccount(new ShortPasswordAccountStub());
    }


    @Test (expected = WrongPasswordException.class)
    public void shouldThrowExceptionWhenPasswordIsNotOk() {
        registerAccountAction.setPasswordChecker(new NotOkPasswordChecker());
        registerAccountAction.registerNewAccount(validAccountStub);
    }

}
