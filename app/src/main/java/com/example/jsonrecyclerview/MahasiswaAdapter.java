package com.example.jsonrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.ViewHolder> {

    private List<Mahasiswa> mahasiswaList;

    public MahasiswaAdapter(List<Mahasiswa> mahasiswaList) {
        this.mahasiswaList = mahasiswaList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_mahasiswa, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Mahasiswa mhs = mahasiswaList.get(position);
        holder.textNama.setText(mhs.getNama());
        holder.textJurusan.setText(mhs.getJurusan());
    }

    @Override
    public int getItemCount() {
        return mahasiswaList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textNama, textJurusan;

        ViewHolder(View itemView) {
            super(itemView);
            textNama = itemView.findViewById(R.id.textNama);
            textJurusan = itemView.findViewById(R.id.textJurusan);
        }
    }
}
