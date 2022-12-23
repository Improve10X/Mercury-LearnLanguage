package com.example.learnlanguage.videos;

import android.os.Bundle;
import android.widget.EditText;

import com.example.learnlanguage.BaseActivity;
import com.example.learnlanguage.R;
import com.example.learnlanguage.databinding.ActivityBaseAddEditVideoBinding;

public class BaseAddEditVideoActivity extends BaseActivity {

    protected ActivityBaseAddEditVideoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBaseAddEditVideoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}