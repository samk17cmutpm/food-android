package startupordie.food.food_detail;

import startupordie.food.BasePrensenter;
import startupordie.food.BaseView;

/**
 * Created by samnguyen on 27/04/2016.
 */
public interface FoodsDetailsContract {

    interface View extends BaseView<Presenter> {
        void showViewPager();
    }

    interface Presenter extends BasePrensenter {
        void loadViewPager();
    }

    interface FoodsDetailInfoView extends BaseView<FoodsDetailInfoBasePresenter> {
        void showDetail();
    }

    interface FoodsDetailInfoBasePresenter extends BasePrensenter {
        void loadDetail();
    }

    interface FoodsDetailMapView extends BaseView<FoodsDetailMapBasePresenter> {
        void showMap();
    }

    interface FoodsDetailMapBasePresenter extends BasePrensenter {
        void loadMap();
    }
}
