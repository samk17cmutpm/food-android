package startupordie.food.food_detail;

/**
 * Created by samnguyen on 27/04/2016.
 */
public class FoodsDetailMapPresenter implements FoodsDetailsContract.FoodsDetailMapBasePresenter {
    private final FoodsDetailsContract.FoodsDetailMapView foodsDetailMapView;
    public FoodsDetailMapPresenter(FoodsDetailsContract.FoodsDetailMapView foodsDetailMapView) {
        this.foodsDetailMapView = foodsDetailMapView;
        this.foodsDetailMapView.setPrensenter(this);
    }
    @Override
    public void loadMap() {

    }

    @Override
    public void start() {

    }
}
