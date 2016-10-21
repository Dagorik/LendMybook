package com.lendmybook.dagorik.lendmybook.interfaces;

import com.lendmybook.dagorik.lendmybook.models.BookArray;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Dagorik on 18/10/2016.
 */

public interface LendMyBookServices {

    @GET("/api/basebooks/showallbasebooks")
    Call<List<BookArray>> getAllBooks();

    @FormUrlEncoded
    @POST("/api/user/login")
    public void createUser(@Field("id_face") String id_face,
                           @Field("nombre") String full_name,
                           @Field("email") String email);

}
