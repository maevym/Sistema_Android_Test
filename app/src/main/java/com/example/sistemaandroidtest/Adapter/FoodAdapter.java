package com.example.sistemaandroidtest.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.sistemaandroidtest.MealsDetail;
import com.example.sistemaandroidtest.Model.Meals;
import com.example.sistemaandroidtest.R;

import java.util.Vector;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {
    
    Context ctx;
    Vector<Meals> meals;
    private String url;

    public FoodAdapter(Context ctx){
        this.ctx = ctx;
    }

    public void setFood(Vector<Meals> meals) {
        this.meals = meals;
    }

    @NonNull
    @Override
    public FoodAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.meals_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodAdapter.ViewHolder holder, int position) {
        url = meals.get(position).getStrMealThumb();
        Glide.with(ctx).load(url).into(holder.mealsPic);
        holder.mealsName.setText(meals.get(position).getStrMeal());
        holder.mealsId = meals.get(position).getIdMeal();
    }

    @Override
    public int getItemCount() {
        return meals.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        CardView mealsView;
        ImageView mealsPic;
        TextView mealsName;
        String mealsId;

        public ViewHolder(View itemView) {
            super(itemView);
            mealsView = itemView.findViewById(R.id.mealsView);
            mealsView.setOnClickListener(this);
            mealsPic = itemView.findViewById(R.id.mealsPic);
            mealsName = itemView.findViewById(R.id.mealsName);
        }

        @Override
        public void onClick(View view) {
            Log.wtf("testRecycler", mealsId);
            Intent i = new Intent(view.getContext(), MealsDetail.class);
            i.putExtra("id", mealsId);
            view.getContext().startActivity(i);
        }
    }
}
