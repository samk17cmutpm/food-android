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

        void setLoadingIndicator(boolean active);

        void showFoods(List<Food> foods);
    }

    interface Presenter extends BasePrensenter {

        void result(int requestCode, int resultCode);

        void loadFoods(boolean forceUpdate);

    }
}
