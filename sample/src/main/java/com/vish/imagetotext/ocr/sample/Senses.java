package com.vish.imagetotext.ocr.sample;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by rmkec on 23/08/17.
 */

public class Senses {
    @SerializedName("definitions")
    @Expose
    private String[] definitions;
    public String[] getDefinitions(){
        return definitions;
    }
}
