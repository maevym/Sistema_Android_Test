package com.example.sistemaandroidtest.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sistemaandroidtest.Model.Ingredients;
import com.example.sistemaandroidtest.R;

import java.util.Vector;

public class IngredientsAdapter extends RecyclerView.Adapter<IngredientsAdapter.ViewHolder>{

    Context ctx;
    Vector<Ingredients> ingredients = new Vector<>();

    public IngredientsAdapter(Context ctx){
        this.ctx = ctx;
    }

    public void setIngredients(Vector<Ingredients> ingredients) {
        this.ingredients = ingredients;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.ingredients_detail, parent, false);
        return new IngredientsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.ingredients.setText(ingredients.get(position).getIngredientsName());
        holder.measure.setText(ingredients.get(position).getIngredientsMeasure());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView ingredients;
        TextView measure;

        public ViewHolder(View view) {
            super(view);
            ingredients = view.findViewById(R.id.detailIngredients);
            measure = view.findViewById(R.id.detailMeasure);
        }
    }
}
