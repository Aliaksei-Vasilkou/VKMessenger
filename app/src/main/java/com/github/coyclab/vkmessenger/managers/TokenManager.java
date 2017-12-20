package com.github.coyclab.vkmessenger.managers;

import android.content.Context;
import android.content.SharedPreferences;

import static constants.Constants.APP_PREFERENCES_NAME;
import static constants.Constants.USER_TOKEN_KEY_NAME;

public class TokenManager implements ITokenManager {

    private final SharedPreferences mPreferences;

    public TokenManager(final Context pContext) {
        mPreferences = pContext.getSharedPreferences(APP_PREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public String getToken() {
        return mPreferences.getString(USER_TOKEN_KEY_NAME, "");
    }

    @Override
    public void putToken(final String pTokenValue) {
        final SharedPreferences.Editor editor = mPreferences.edit();
        editor.putString(USER_TOKEN_KEY_NAME, pTokenValue);
        editor.apply();
    }

    @Override
    public void removeToken() {
        final SharedPreferences.Editor editor = mPreferences.edit();
        editor.remove(USER_TOKEN_KEY_NAME);
        editor.apply();
    }
}
