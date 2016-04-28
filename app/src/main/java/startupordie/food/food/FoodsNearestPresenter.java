package startupordie.food.food;

import java.util.ArrayList;
import java.util.List;

import startupordie.food.data.Food;

/**
 * Created by samnguyen on 26/04/2016.
 */
public class FoodsNearestPresenter implements FoodsContract.FoodsNearestBasePresenter {
    private final FoodsContract.FoodsNearestView foodsNearestView;

    public FoodsNearestPresenter(FoodsContract.FoodsNearestView foodsMostPopularView) {
        this.foodsNearestView = foodsMostPopularView;
        this.foodsNearestView.setPrensenter(this);
    }
    @Override
    public void loadFoodsNearest() {
        List<Food> foods = new ArrayList<>();
        // fake data foods
        for (int i = 0; i < 10; i++) {
            foods.add(new Food("N" + 1));
        }
        foodsNearestView.showData(foods);
    }

    @Override
    public void loadFoodsDetail(Food food) {
        foodsNearestView.showFoodsDetail(food);
    }

    @Override
    public void start() {

    }
}
