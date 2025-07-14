package com.example.smallproject2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.smallproject2.Domain.BannerModel;
import com.example.smallproject2.R;
import com.bumptech.glide.Glide;

import java.time.Instant;
import java.util.ArrayList;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.SlideViewHolder> {
    private final ArrayList<BannerModel> sliderItems;
    private final ViewPager2 viewPager2;
    private Context context;
    private final Runnable runnable = new Runnable() {
        @Override
        public void run() {
            sliderItems.addAll(sliderItems);
            notifyDataSetChanged();
    }
    };

    public SliderAdapter(ArrayList<BannerModel> sliderItems, ViewPager2 viewPager2) {
        this.sliderItems = sliderItems;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public SliderAdapter.SlideViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new SlideViewHolder(LayoutInflater.from(context).inflate(R.layout.slider_item, parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull SliderAdapter.SlideViewHolder holder, int position) {
        holder.setImage(sliderItems.get(position ));
        if(position == sliderItems.size() -2) {
            viewPager2.post(runnable);
        }
    }

    @Override
    public int getItemCount() {
        return sliderItems.size();
    }
    public class SlideViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageView;
        public SlideViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageSlide);
        }
        void setImage (BannerModel bannerModel) {
            Glide.with(context)
                    .load(bannerModel.getUrl())
                    .into(imageView);
        }

    }


}
