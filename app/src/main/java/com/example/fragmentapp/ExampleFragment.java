package com.example.fragmentapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fragmentapp.databinding.FragmentExampleBinding;

public class ExampleFragment extends Fragment {

    private static final String ARG_DATA_KEY = "arg_data_key";

    private FragmentExampleBinding binding;
    private FragmentInteractor fragmentInteractor;
    private String data;

    public static ExampleFragment newInstance(String data) {
        ExampleFragment fragment = new ExampleFragment();
        Bundle arguments = new Bundle();
        arguments.putString(ARG_DATA_KEY, data);
        fragment.setArguments(arguments);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentExampleBinding.inflate(inflater);
        data = requireArguments().getString(ARG_DATA_KEY);
        binding.text.setText(data);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.show.setOnClickListener(v -> {
            if (fragmentInteractor != null) {
                fragmentInteractor.showToast(data);
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof FragmentInteractor) {
            fragmentInteractor = (FragmentInteractor) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        fragmentInteractor = null;
    }
}
