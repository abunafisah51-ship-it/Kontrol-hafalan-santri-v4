package com.santri.kontrolhafalanv4;
import com.santri.kontrolhafalanv4.R;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class SurahAdapter extends RecyclerView.Adapter<SurahAdapter.ViewHolder> {

    private List<String> surahList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public SurahAdapter(List<String> surahList, OnItemClickListener listener) {
        this.surahList = surahList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_surah, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String surah = surahList.get(position);
        holder.textNamaSurah.setText(surah);
        holder.textNomor.setText(String.valueOf(position + 1));
        holder.textJuzAyat.setText("Ketuk untuk mencatat hafalan");

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return surahList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textNomor, textNamaSurah, textJuzAyat;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textNomor = itemView.findViewById(R.id.textNomor);
            textNamaSurah = itemView.findViewById(R.id.textNamaSurah);
            textJuzAyat = itemView.findViewById(R.id.textJuzAyat);
        }
    }
}
