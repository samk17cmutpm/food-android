package startupordie.food.food;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import startupordie.food.data.Food;

/**
 * Created by samnguyen on 24/04/2016.
 */
public class FoodsPresenter implements FoodsContract.Presenter {

    private final FoodsContract.View foodsView;

    public FoodsPresenter(FoodsContract.View foodsView) {
        this.foodsView = foodsView;
        this.foodsView.setPrensenter(this);
    }



    @Override
    public void result(int requestCode, int resultCode) {

    }

    @Override
    public void loadFoods(boolean forceUpdate) {
        List<Food> foods = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            foods.add(new Food(i + " Novahub Studio"));
        }
        foodsView.showFoods(foods);
    }

    @Override
    public void start() {
        loadFoodsTemp();
    }

    private void loadFoodsTemp() {
        foodsView.setLoadingIndicator(true);
    }
}
