package startupordie.food.food_popular;

import java.util.List;

import startupordie.food.BasePrensenter;
import startupordie.food.BaseView;
import startupordie.food.data.Restaurant;

/**
 * Created by samnguyen on 28/04/2016.
 */
public interface FoodsPopularContract {

    interface View extends BaseView<Presenter> {
        void showRestaurants(List<Restaurant> restaurants);
    }

    interface Presenter extends BasePrensenter {
        void loadRestaurants();
    }
}
