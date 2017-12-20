package com.github.coyclab.vkmessenger.managers;

public interface ITokenManager {

    String getToken();

    void putToken(String pTokenValue);

    void removeToken();
}
