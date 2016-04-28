package startupordie.food.food;

import java.util.List;

import startupordie.food.BasePrensenter;
import startupordie.food.BaseView;
import startupordie.food.data.Food;

/**
 * Created by samnguyen on 24/04/2016.
 */
public interface FoodsContract {

    interface View extends BaseView<Presenter> {

        void showViewPager();
    }

    interface Presenter extends BasePrensenter {

        void loadViewPager();

    }

    interface FoodsMostPopularView extends BaseView<FoodsMostPopularBasePresenter> {

        void showData(List<Food> foods);

        void showFoodsDetail(Food food);
    }

    interface FoodsMostPopularBasePresenter extends BasePrensenter {

        void loadFoodsMostPopularData();

        void loadFoodsDetail(Food food);
    }

    interface FoodsNearestView extends BaseView<FoodsNearestBasePresenter> {
        void showData(List<Food> foods);
        void showFoodsDetail(Food food);
    }

    interface FoodsNearestBasePresenter extends BasePrensenter {
        void loadFoodsNearest();

        void loadFoodsDetail(Food food);
    }
}
