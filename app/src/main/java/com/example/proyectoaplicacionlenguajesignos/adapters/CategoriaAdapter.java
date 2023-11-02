package com.example.proyectoaplicacionlenguajesignos.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectoaplicacionlenguajesignos.R;
import com.example.proyectoaplicacionlenguajesignos.models.Palabra;

import java.util.List;

public class CategoriaAdapter extends RecyclerView.Adapter<CategoriaAdapter.RecyclerDataHolder>{
    @NonNull
    List<String> list;
    private View.OnClickListener listener;
    private OnItemClickListener itemListener;

    public CategoriaAdapter(@NonNull List<String> list, OnItemClickListener itemListener) {
        this.list = list;
        this.itemListener = itemListener;
    }

    @Override
    public CategoriaAdapter.RecyclerDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categoria_item_view, null, false);
        return new RecyclerDataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriaAdapter.RecyclerDataHolder holder, int position) {
        holder.assignData(list.get(position), itemListener);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RecyclerDataHolder extends RecyclerView.ViewHolder {
        TextView tw;
        public RecyclerDataHolder(@NonNull View itemView) {
            super(itemView);
            tw = itemView.findViewById(R.id.lblCategoria);
        }

        public void assignData(String s, OnItemClickListener itemListener) {
            tw.setText(s);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {itemListener.onItemClick(s,getItemCount());
                }
            });
        }
    }
    public interface OnItemClickListener{
        void onItemClick(String s, int position);
    }
}
