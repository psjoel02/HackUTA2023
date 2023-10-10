package com.example.hackuta2023;

import android.os.Bundle;
import android.service.autofill.UserData;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.PartMap;
import retrofit2.http.Multipart;
import retrofit2.http.QueryMap;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class AmericaPop extends AppCompatActivity {

    int statePop, countryPop;
    TextView editText;
    private static final String BASEPATH = "https://datausa.io/api/";

    public class UserData
    {
        DataClass data;
        SupportClass support;

        public DataClass getData() {
            return data;
        }

        public void setData(DataClass data) {
            this.data = data;
        }

        public SupportClass getSupport() {
            return support;
        }

        public void setSupport(SupportClass support) {
            this.support = support;
        }

        class DataClass{
            String first_name, last_name, id, email, avatar;

            public String getFirst_name() {
                return first_name;
            }

            public void setFirst_name(String first_name) {
                this.first_name = first_name;
            }

            public String getLast_name() {
                return last_name;
            }

            public void setLast_name(String last_name) {
                this.last_name = last_name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }
        }
        class SupportClass{
            String url, text;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }
        }
    }

    interface RequestUser{
        @GET("/api/users/{uid}")
        Call<UserData> getUser(@Path("uid")String user);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop);
        editText = findViewById(R.id.editIt);
//        editText.setText(popRet.toString());
        Retrofit retrofitAcc = new Retrofit.Builder()
                .baseUrl("https://reqres.in/")
                .addConverterFactory(GsonConverterFactory.create())
                        .build();
        RequestUser userRequest = retrofitAcc.create(RequestUser.class);

        userRequest.getUser("3").enqueue(new Callback<UserData>() {
            @Override
            public void onResponse(Call<UserData> call, Response<UserData> response) {
                if(response.body() != null){
                    editText.setText(response.body().data.first_name);
                }
            }

            @Override
            public void onFailure(Call<UserData> call, Throwable t) {
                editText.setText("FAILURE");
            }
        });
    }
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_pop);//this needs to go before your variables
//
//
//    }
}
