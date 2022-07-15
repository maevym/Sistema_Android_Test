package com.example.sistemaandroidtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.sistemaandroidtest.Adapter.FoodAdapter;
import com.example.sistemaandroidtest.Adapter.IngredientsAdapter;
import com.example.sistemaandroidtest.Model.Ingredients;
import com.example.sistemaandroidtest.Model.Meals;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Vector;

public class MealsDetail extends AppCompatActivity {

    TextView mealName, mealCategory, mealLocation, mealInstruction;
    RecyclerView drv;
    ImageView mealPic;

    String mealId, _mealName, _mealCategory, _mealLocation, _mealInstruction, _mealImage, _mealIngredients, _mealMeasure;

    Vector<Ingredients> ingredients = new Vector<>();
    IngredientsAdapter ingredientsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals_detail);

        mealId = getIntent().getStringExtra("id");

        mealName = findViewById(R.id.detailName);
        mealCategory = findViewById(R.id.detailCategory);
        mealLocation = findViewById(R.id.detailLocation);
        mealInstruction = findViewById(R.id.detailInstruction);
        drv = findViewById(R.id.detailView);
        mealPic = findViewById(R.id.detailPic);

        getDetailMealInfo();

        ingredientsAdapter = new IngredientsAdapter(this);
        ingredientsAdapter.setIngredients(ingredients);
        drv.setAdapter(ingredientsAdapter);
        drv.setLayoutManager(new LinearLayoutManager(this));
    }

    public void getDetailMealInfo(){
        ingredients.clear();
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        final String url = "https://www.themealdb.com/api/json/v1/1/lookup.php?i=" + mealId;

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                response -> {
                    try {
                        JSONArray array = response.getJSONArray("meals");
                        for(int i=0; i<array.length(); i++){
                            JSONObject object = array.getJSONObject(i);

                            _mealName = object.getString("strMeal");
                            _mealCategory = object.getString("strCategory");
                            _mealLocation = object.getString("strArea");
                            _mealInstruction = object.getString("strInstructions");
                            _mealImage = object.getString("strMealThumb");

                            for(int j=1;j<=20;j++){
                                _mealIngredients = object.getString("strIngredient"+j);
                                _mealMeasure = object.getString("strMeasure"+j);
                                if(_mealMeasure.isEmpty() || _mealName.isEmpty()){
                                    continue;
                                }else{
                                    Ingredients temp = new Ingredients(_mealIngredients, _mealMeasure);
                                    ingredients.add(temp);
                                }
                            }

                        }

                        for (Ingredients i: ingredients
                             ) {
                            Log.wtf("ingredients", i.getIngredientsName() +  i.getIngredientsMeasure());
                        }

                        mealName.setText(_mealName);
                        mealCategory.setText(_mealCategory);
                        mealLocation.setText(_mealLocation);
                        mealInstruction.setText(_mealInstruction);
                        Glide.with(this).load(_mealImage).into(mealPic);
                        ingredientsAdapter.notifyDataSetChanged();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                error -> {
                    Log.wtf("error", error.toString());
                }
        );
        requestQueue.add(request);
    }
}