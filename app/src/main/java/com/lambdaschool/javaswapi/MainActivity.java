package com.lambdaschool.javaswapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private SwPersonListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView listView = findViewById(R.id.list_view);
        adapter = new SwPersonListAdapter(new ArrayList<Person>());
        listView.setAdapter(adapter);
        listView.setLayoutManager(new LinearLayoutManager(getBaseContext()));

        SwApiRetriever retriever = new SwApiRetriever();
        retriever.getPeople().enqueue(new Callback<SwApiPeople>() {
            @Override
            public void onResponse(Call<SwApiPeople> call, Response<SwApiPeople> response) {
                if (response != null) {
                    adapter.data.addAll(response.body().getResults());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<SwApiPeople> call, Throwable throwable) {
                System.out.println("fail");
            }
        });
    }
}
