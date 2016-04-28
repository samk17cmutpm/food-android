package startupordie.food.restaurant;

import java.util.ArrayList;
import java.util.List;

import startupordie.food.BasePrensenter;
import startupordie.food.BaseView;
import startupordie.food.data.FoodsRestaurant;

/**
 * Created by samnguyen on 28/04/2016.
 */
public interface RestaurantsContract {

    interface View extends BaseView<Presenter> {
        void showRestaurantDetail();

        void showFoodsOfRestaurant(ArrayList<FoodsRestaurant> foodsRestaurants);
    }

    interface Presenter extends BasePrensenter {
        void loadRestaurantDetail();

        void loadFoodsOfRestaurant();
    }
}
