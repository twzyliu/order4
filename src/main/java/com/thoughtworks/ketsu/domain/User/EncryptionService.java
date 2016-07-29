package com.thoughtworks.ketsu.domain.User;

public interface EncryptionService {
    String encrypt(String password);
    boolean check(String checkPassword, String realPassword);
}
