package com.vish.imagetotext.ocr.sample;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by rmkec on 23/08/17.
 */

public class Entries {
    @SerializedName("senses")
    @Expose
    private List<Senses> senses;
    public List<Senses> getSenses(){
        return senses;
    }
}
