package startupordie.food.food;

import android.annotation.SuppressLint;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import startupordie.food.data.Food;

/**
 * Created by samnguyen on 26/04/2016.
 */
public class FoodsMostPopularPresenter implements  FoodsContract.FoodsMostPopularBasePresenter{

    private final FoodsContract.FoodsMostPopularView foodsMostPopularView;
    private final String TAG = "FoodsMostPopularPresenter";

    public FoodsMostPopularPresenter(FoodsContract.FoodsMostPopularView foodsMostPopularView) {
        this.foodsMostPopularView = foodsMostPopularView;
        this.foodsMostPopularView.setPrensenter(this);
    }

    @Override
    public void loadFoodsMostPopularData() {
        List<Food> foods = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            foods.add(new Food("Novahub Studio " + i));
        }
        foodsMostPopularView.showData(foods);
    }

    @SuppressLint("LongLogTag")
    @Override
    public void start() {
        Log.d(TAG, "Start");
    }
}
