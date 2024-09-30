package com.project.belajarapistar.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.project.belajarapistar.data.model.StarItem;
import com.project.belajarapistar.databinding.ItemStarBinding;

import java.util.ArrayList;

public class StarAdapter extends RecyclerView.Adapter<StarAdapter.StarViewHolder> {
    private final ArrayList<StarItem> listStar = new ArrayList<>();
    public void setListStar(ArrayList<StarItem> star) {
        listStar.clear();
        listStar.addAll(star);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public StarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemStarBinding view = ItemStarBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new StarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StarViewHolder holder, int position) {
        holder.bind(listStar.get(position));
    }

    @Override
    public int getItemCount() {
        return listStar.size();
    }

    class StarViewHolder extends RecyclerView.ViewHolder {
        private ItemStarBinding binding;

        public StarViewHolder(ItemStarBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(StarItem star) {
            binding.tvName.setText(star.getName() != null && !star.getName().isEmpty() ? star.getName() : "unknown");
            binding.tvConstellation.setText(star.getConstellation() != null && !star.getConstellation().isEmpty() ? star.getConstellation() : "unknown");
            binding.tvRightAscension.setText(star.getRightAscension() != null && !star.getRightAscension().isEmpty() ? star.getRightAscension() : "unknown");
            binding.tvDeclination.setText(star.getDeclination() != null && !star.getDeclination().isEmpty() ? star.getDeclination() : "unknown");
            binding.tvApparentMagnitude.setText(star.getApparentMagnitude() != null && !star.getApparentMagnitude().isEmpty() ? star.getApparentMagnitude() : "unknown");
            binding.tvAbsoluteMagnitude.setText(star.getAbsoluteMagnitude() != null && !star.getAbsoluteMagnitude().isEmpty() ? star.getAbsoluteMagnitude() : "unknown");
            binding.tvDistance.setText(star.getDistanceLightYear() != null && !star.getDistanceLightYear().isEmpty() ? star.getDistanceLightYear() : "unknown");
            binding.tvSpectralClass.setText(star.getSpectralClass() != null && !star.getSpectralClass().isEmpty() ? star.getSpectralClass() : "unknown");
        }
    }
}