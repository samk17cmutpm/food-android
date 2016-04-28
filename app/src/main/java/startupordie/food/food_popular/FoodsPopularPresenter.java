package startupordie.food.food_popular;

import java.util.List;

import startupordie.food.data.Restaurant;

/**
 * Created by samnguyen on 28/04/2016.
 */
public class FoodsPopularPresenter implements FoodsPopularContract.Presenter {
    private final FoodsPopularContract.View foodsPopularView;
    public FoodsPopularPresenter(FoodsPopularContract.View foodsPopularView) {
        this.foodsPopularView = foodsPopularView;
        this.foodsPopularView.setPrensenter(this);
    }
    @Override
    public void loadRestaurants(List<Restaurant> restaurants) {

    }

    @Override
    public void start() {

    }
}
