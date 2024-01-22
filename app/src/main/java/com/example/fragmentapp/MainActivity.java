package com.example.fragmentapp;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.fragmentapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements FragmentInteractor {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater(), null, false);
        setContentView(binding.getRoot());

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragmentContainer, ExampleFragment.newInstance("instance 1"))
                    .add(R.id.fragmentContainer2, ExampleFragment.newInstance("instance 2"))
                    .addToBackStack(null)
                    .commit();
        }
    }

    @Override
    public void showToast(String data) {
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
    }
}
