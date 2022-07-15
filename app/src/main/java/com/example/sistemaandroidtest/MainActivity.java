package com.example.sistemaandroidtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.sistemaandroidtest.Adapter.FoodAdapter;
import com.example.sistemaandroidtest.Model.Meals;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    Vector<Meals> meals = new Vector<>();
    private String strMeal;
    private String strMealThumb;
    private String idMeal;
    TextView errorMsg;

    RecyclerView mrv;
    FoodAdapter mealsAdapt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mrv = findViewById(R.id.mealsView);
        errorMsg = findViewById(R.id.errorMsg);

        getAllSeafoodMeals();
        mealsAdapt = new FoodAdapter(this);
        mealsAdapt.setFood(meals);
        mrv.setAdapter(mealsAdapt);
        mrv.setLayoutManager(new LinearLayoutManager(this));
    }

    public void getAllSeafoodMeals(){
        meals.clear();

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        final String url = "https://www.themealdb.com/api/json/v1/1/filter.php?c=Seafood";

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                response -> {
                    try {
                        JSONArray array = response.getJSONArray("meals");
                        for(int i=0; i<array.length(); i++){
                            JSONObject object = array.getJSONObject(i);

                            strMeal = object.getString("strMeal");
                            strMealThumb = object.getString("strMealThumb");
                            idMeal = object.getString("idMeal");

                            Meals temp = new Meals(strMeal, strMealThumb, idMeal);
                            meals.add(temp);
                        }
                        mealsAdapt.notifyDataSetChanged();
                        if(meals.size()>0){
                            errorMsg.setVisibility(View.GONE);
                        }else if(meals.size()==0){
                            errorMsg.setVisibility(View.VISIBLE);
                        }

                        for (Meals e: meals) {
                            Log.wtf("success", e.getStrMeal());
                        }
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