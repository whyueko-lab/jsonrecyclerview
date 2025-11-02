package com.example.jsonrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Mahasiswa> mahasiswaList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        parseJSON();

        MahasiswaAdapter adapter = new MahasiswaAdapter(mahasiswaList);
        recyclerView.setAdapter(adapter);
    }

    private void parseJSON() {
        String jsonStr = "[\n" +
                "{\"nama\": \"Ari Saputro\", \"jurusan\": \"Informatika\"},\n" +
                "{\"nama\": \"Budi Santoso\", \"jurusan\": \"Sistem Informasi\"},\n" +
                "{\"nama\": \"Citra Lestari\", \"jurusan\": \"Teknik Komputer\"}\n" +
                "]";

        try {
            JSONArray jsonArray = new JSONArray(jsonStr);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                String nama = obj.getString("nama");
                String jurusan = obj.getString("jurusan");
                mahasiswaList.add(new Mahasiswa(nama, jurusan));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
