package com.vish.imagetotext.ocr.sample;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/**
 * Created by rmkec on 21/08/17.
 */

public interface HerokuClient {
    @Headers(
            {
                    "app_id:ab03a94e",
                    "app_key:50eb826a284bb6a2cd6fc33516f0e877"

            }
    )
    @GET("/api/v1/entries/en/{word}")
    Call<HerokuResponse> GetResponse(@Path("word") String word);

}
