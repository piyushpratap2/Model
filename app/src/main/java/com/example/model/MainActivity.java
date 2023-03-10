package com.example.model;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.model.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
     ActivityMainBinding binding;
     MyViewModel myviewmodel;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myviewmodel = new ViewModelProvider(this).get(MyViewModel.class);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        final Observer<String> nameObserver = new Observer<String>() {
            @Override
            public void onChanged(String s) {
                String data = binding.edit1.getText().toString();
                binding.tv1.setText(data);
            }
        };
        myviewmodel.getCurrentdata().observe(this,nameObserver);
        binding.setMyviewmodel(myviewmodel);
    }

}