package com.lendmybook.dagorik.lendmybook;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

public class LoginActivity extends AppCompatActivity {

    private LoginButton loginButton;
    private CallbackManager callbackManager;
    private ImageView imagenPerfil;
    private String url;
    private String nameJson;
    private String profileGrande;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        callbackManager = CallbackManager.Factory.create();

        loginButton = (LoginButton) findViewById(R.id.login_button);

        loginButton.setReadPermissions(Arrays.asList("email,public_profile,user_photos"));

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {

            @Override
            public void onSuccess(LoginResult loginResult) {
                AccessToken accessToken = loginResult.getAccessToken();
                Bundle params = new Bundle();
                params.putString("fields", "id,name,email,last_name,first_name,picture");
                GraphRequest profileGraph = GraphRequest.newMeRequest(accessToken, new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        try {
                            Log.i("response", "json: " + object.toString(1));
                            JSONObject data = object.getJSONObject("picture").getJSONObject("data");
                            url = data.getString("url");
                            JSONObject name = object;
                            nameJson = name.getString("name");
                            Log.e("myLog", url);
                            Log.e("MylogName", nameJson);

                            Profile profile = Profile.getCurrentProfile();
                            profileGrande = profile.getProfilePictureUri(300, 300).toString();


                            SharedPreferences preferences = getSharedPreferences("sesion", getApplicationContext().MODE_PRIVATE);
                            SharedPreferences.Editor editor = preferences.edit();
                            editor.putString("img_perfil", url);
                            editor.putString("img_perfilG", profileGrande);
                            editor.putString("name_face", nameJson);
                            editor.commit();


                        } catch (JSONException e) {
                            e.printStackTrace();

                        }
                    }

                });
                profileGraph.setParameters(params);
                profileGraph.executeAsync();
                goMainScreen();


            }

            @Override
            public void onCancel() {
                Toast.makeText(getApplicationContext(), "Has cancelado el inicio de sesion.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
                Log.i("MyLogError", "" + error);
            }
        });


    }

    private void goMainScreen() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);

    }
}


