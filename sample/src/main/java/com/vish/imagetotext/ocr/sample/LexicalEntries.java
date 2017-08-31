package com.vish.imagetotext.ocr.sample;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by rmkec on 23/08/17.
 */

public class LexicalEntries {
    @SerializedName("entries")
    @Expose
    private List<Entries> entries;
    public List<Entries> getEntries(){
        return entries;
    }
}
