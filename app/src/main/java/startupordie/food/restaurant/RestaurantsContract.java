package startupordie.food.restaurant;

import startupordie.food.BasePrensenter;
import startupordie.food.BaseView;

/**
 * Created by samnguyen on 28/04/2016.
 */
public interface RestaurantsContract {

    interface View extends BaseView<Presenter> {
        void showRestaurantDetail();
    }

    interface Presenter extends BasePrensenter {
        void loadRestaurantDetail();
    }
}
