package com.github.coyclab.vkmessenger.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.github.coyclab.vkmessenger.R;
import com.github.coyclab.vkmessenger.managers.TokenManager;

import constants.Constants;

public class LoginActivity extends AppCompatActivity {

    public static final String TAG = LoginActivity.class.getSimpleName();
    private TokenManager mTokenManager;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // TODO remove this later
        mTokenManager = new TokenManager(this);
        mTokenManager.removeToken();

        checkUserAuth();
    }

    private void checkUserAuth() {

        if (isTokenPresent()) {
//            startActivity(new Intent(this, VkNews.class));
        } else {
            loadLoginWebForm();
        }
    }

    private boolean isTokenPresent() {
        final SharedPreferences preferences = getSharedPreferences(Constants.APP_PREFERENCES_NAME, Context.MODE_PRIVATE);
        return preferences.contains(Constants.USER_TOKEN_KEY_NAME);
    }

    private void loadLoginWebForm() {
        final WebView webView = findViewById(R.id.login_web_view);
        webView.loadUrl(Constants.URL);
        webView.setWebViewClient(new MyWebViewClient());
    }

    private class MyWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(final WebView view, final String url) {
            //TODO should override token in app preferences
            return false;
        }
    }
}
