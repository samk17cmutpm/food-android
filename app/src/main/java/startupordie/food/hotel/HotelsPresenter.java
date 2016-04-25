package startupordie.food.hotel;

import android.util.Log;

/**
 * Created by samnguyen on 25/04/2016.
 */
public class HotelsPresenter implements HotelsContract.Presenter {

    private final HotelsContract.View hotelView;

    public HotelsPresenter(HotelsContract.View hotelView) {
        this.hotelView = hotelView;
        this.hotelView.setPrensenter(this);
    }

    @Override
    public void result(int requestCode, int resultCode) {

    }

    @Override
    public void loadHotels(boolean forceUpdate) {

    }

    @Override
    public void start() {
        loadHotelsTemp();
    }

    private void loadHotelsTemp() {
        Log.d("TESTING", "Start Hotel Fragment");
    }
}
