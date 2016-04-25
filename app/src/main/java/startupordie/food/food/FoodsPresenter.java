package startupordie.food.food;

import android.util.Log;

/**
 * Created by samnguyen on 24/04/2016.
 */
public class FoodsPresenter implements FoodsContract.Presenter {

    private final FoodsContract.View mFoodView;

    public FoodsPresenter(FoodsContract.View foodsView) {
        mFoodView = foodsView;
        mFoodView.setPrensenter(this);
    }



    @Override
    public void result(int requestCode, int resultCode) {

    }

    @Override
    public void loadFoods(boolean forceUpdate) {

    }

    @Override
    public void start() {
        loadFoodsTemp();
    }

    private void loadFoodsTemp() {
        Log.d("TESTING", "Start Food Fragment");
    }
}
