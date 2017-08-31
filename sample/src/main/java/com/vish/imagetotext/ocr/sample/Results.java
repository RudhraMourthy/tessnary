package com.vish.imagetotext.ocr.sample;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by rmkec on 23/08/17.
 */

public class Results {
    @SerializedName("lexicalEntries")
    @Expose
    private List<LexicalEntries> lexicalEntries;

    public List<LexicalEntries> getLexicalEntries() {
        return lexicalEntries;
    }

}
