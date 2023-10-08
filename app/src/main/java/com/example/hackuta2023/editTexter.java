package com.example.hackuta2023;

import android.text.TextWatcher;
import android.text.Editable;
import android.os.Bundle;
import android.content.Context;
import android.widget.EditText;

public class editTexter implements TextWatcher {
//    private Context mContext;
//    EditTextView mEdittextview;
//
//    public addListenerOnTextChange(Context context, EditTextView edittextview) {
//        super();
//        this.mContext = context;
//        this.mEdittextview= edittextview;
//    }

    @Override
    public void afterTextChanged(Editable s) {
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count,
                                  int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        //What you want to do
    }
}
