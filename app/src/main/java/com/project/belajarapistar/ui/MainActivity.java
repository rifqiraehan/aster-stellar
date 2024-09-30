package com.project.belajarapistar.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import com.project.belajarapistar.R;
import com.project.belajarapistar.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainViewModel viewModel;
    private StarAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        adapter = new StarAdapter();
        adapter.notifyDataSetChanged();

        viewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(MainViewModel.class);

        binding.rvStar.setLayoutManager(new LinearLayoutManager(this));
        binding.rvStar.setHasFixedSize(true);
        binding.rvStar.setAdapter(adapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        binding.rvStar.addItemDecoration(dividerItemDecoration);

        binding.btnSearch.setOnClickListener(v -> searchStar());

        binding.etQuery.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                    searchStar();
                    return true;
                }
                return false;
            }
        });

        viewModel.getListStar().observe(this, it -> {
            if(it != null && !it.isEmpty()) {
                adapter.setListStar(it);
                binding.tvNoStar.setVisibility(View.GONE);
                binding.tvStartMessage.setVisibility(View.GONE);
            }
        });

        viewModel.getIsLoading().observe(this, isLoading -> {
            showLoading(isLoading);
            if (isLoading) {
                binding.tvNoStar.setVisibility(View.GONE);
            } else if (viewModel.getListStar().getValue() == null) {
                binding.tvNoStar.setVisibility(View.GONE);
            } else if (viewModel.getListStar().getValue().isEmpty()) {
                binding.tvNoStar.setVisibility(View.VISIBLE);
            } else {
                binding.tvNoStar.setVisibility(View.GONE);
            }
        });
    }

    private void searchStar() {
        String query = binding.etQuery.getText().toString().trim();
        if (query.isEmpty()) return;

        adapter.setListStar(new ArrayList<>());

        viewModel.setSearchStar(query);
        binding.tvStartMessage.setVisibility(View.GONE);
    }

    private void showLoading(Boolean state) {
        if (state) {
            binding.progressBar.setVisibility(View.VISIBLE);
        } else {
            binding.progressBar.setVisibility(View.GONE);
        }
    }
}