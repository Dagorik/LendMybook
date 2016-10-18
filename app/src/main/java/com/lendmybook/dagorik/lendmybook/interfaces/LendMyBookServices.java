package com.lendmybook.dagorik.lendmybook.interfaces;

import com.lendmybook.dagorik.lendmybook.models.BookArray;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Dagorik on 18/10/2016.
 */

public interface LendMyBookServices  {

    @GET ("/api/basebooks/showallbasebooks")
    Call<BookArray> getAllBooks();

}
