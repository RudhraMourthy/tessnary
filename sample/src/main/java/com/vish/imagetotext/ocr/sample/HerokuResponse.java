package com.vish.imagetotext.ocr.sample;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by rmkec on 21/08/17.
 */

public class HerokuResponse {
    @SerializedName("results")
    @Expose
    private List<Results> results;
    public List<Results> getMetadata(){
        return results;
    }
}
