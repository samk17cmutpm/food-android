package startupordie.food.hotel;

import java.util.List;

import startupordie.food.BasePrensenter;
import startupordie.food.BaseView;
import startupordie.food.data.Hotel;

/**
 * Created by samnguyen on 25/04/2016.
 */
public interface HotelsContract {

    interface View extends BaseView<Presenter> {
        void setLoadingIndicator(boolean active);

        void showHotels(List<Hotel> hotels);
    }

    interface Presenter extends BasePrensenter {
        void result(int requestCode, int resultCode);
        void loadHotels(boolean forceUpdate);
    }
}
