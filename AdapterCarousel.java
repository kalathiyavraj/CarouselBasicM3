package com.screens.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.screens.R;
import com.screens.model.Image;
import com.screens.utils.Tools;
import java.util.List;

public class AdapterCarousel extends RecyclerView.Adapter<ViewHolder> {
    List<Image> arrayList;
    Context context;
    OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onClick(ImageView imageView, String str);
    }

    static /* synthetic */ void lambda$onBindViewHolder$0(View view) {
    }

    public AdapterCarousel(Context context2, List<Image> list) {
        this.context = context2;
        this.arrayList = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(this.context).inflate(R.layout.item_carousel_basic, viewGroup, false));
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Tools.displayImageOriginal(this.context, viewHolder.imageView, this.arrayList.get(i).image);
        viewHolder.itemView.setOnClickListener(new AdapterCarousel$$ExternalSyntheticLambda0());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.arrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ViewHolder(View view) {
            super(view);
            this.imageView = (ImageView) view.findViewById(R.id.image);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener2) {
        this.onItemClickListener = onItemClickListener2;
    }
}
