package com.example.jauth.Fragments;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.jauth.R;
import com.example.jauth.databinding.FragmentAuthBinding;

public class AuthFragment extends Fragment {

    // Properties
    private FragmentAuthBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        binding = FragmentAuthBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Layout properties linked to add logic
        Button CheckBtn = root.findViewById(R.id.btn_Check);

        // If Check button is clicked
        CheckBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (CheckBtn.getText().equals(getString(R.string.CheckIn))) {
                    CheckBtn.setText(getString(R.string.CheckOut));
                    CheckBtn.setSelected(true);
                } else {
                    CheckBtn.setText(getString(R.string.CheckIn));
                    CheckBtn.setSelected(false);
                }
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}