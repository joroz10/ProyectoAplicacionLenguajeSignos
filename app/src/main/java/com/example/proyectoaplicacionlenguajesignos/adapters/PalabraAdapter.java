package com.example.proyectoaplicacionlenguajesignos.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectoaplicacionlenguajesignos.R;
import com.example.proyectoaplicacionlenguajesignos.models.Palabra;

import java.util.List;

public class PalabraAdapter extends RecyclerView.Adapter<PalabraAdapter.RecyclerDataHolder>{
    @NonNull
    List<Palabra> list;
    private View.OnClickListener listener;
    private OnItemClickListener itemListener;

    public PalabraAdapter(List<Palabra> list, OnItemClickListener listener){
        this.list = list;
        this.itemListener = listener;
    }

    @Override
    public PalabraAdapter.RecyclerDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, null, false);
        return new RecyclerDataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PalabraAdapter.RecyclerDataHolder holder, int position) {
        holder.assignData(list.get(position), itemListener);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RecyclerDataHolder extends RecyclerView.ViewHolder {
        TextView tw;
        ImageView img;
        public RecyclerDataHolder(@NonNull View itemView) {
            super(itemView);
            tw = itemView.findViewById(R.id.lblItemView);
            img = itemView.findViewById(R.id.imgItemView);
        }

        public void assignData(Palabra p, OnItemClickListener itemListener) {
            tw.setText(p.palabra);
            img.setImageResource(p.drawable);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {itemListener.onItemClick(p,getItemCount());
                }
            });
        }
    }
    public interface OnItemClickListener{
        void onItemClick(Palabra p, int position);
    }
}
