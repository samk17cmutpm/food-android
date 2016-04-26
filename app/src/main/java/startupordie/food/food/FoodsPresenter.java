package startupordie.food.food;

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
    public void loadViewPager() {
        foodsView.showViewPager();
    }

    @Override
    public void start() {  // Start viewpager in this fragment
        loadViewPager();
    }

}
