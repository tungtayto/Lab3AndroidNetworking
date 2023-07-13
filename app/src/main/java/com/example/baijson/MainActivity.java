package com.example.baijson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcvAlbum;
    private List<Contact> mContact;
    private ProgressBar progressBar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcvAlbum = (RecyclerView) findViewById(R.id.rcv_album);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvAlbum.setLayoutManager(linearLayoutManager);

        DividerItemDecoration itemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        rcvAlbum.addItemDecoration(itemDecoration);

        mContact = new ArrayList<>();
        callApiGetAlbum();
    }

    private void callApiGetAlbum(){
        APIService.apiService.getListAlbum(1).enqueue(new Callback<List<Contact>>() {
            @Override
            public void onResponse(Call<List<Contact>> call, Response<List<Contact>> response) {
                mContact = response.body();
                ContactAdapter adapter = new ContactAdapter(mContact);
                rcvAlbum.setAdapter(adapter);
                rcvAlbum.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<List<Contact>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Fail", Toast.LENGTH_SHORT).show();
            }
        });
    }
}