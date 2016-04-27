package startupordie.food.food_detail;

/**
 * Created by samnguyen on 27/04/2016.
 */
public class FoodsDetailPresenter implements FoodsDetailsContract.Presenter{
    private final FoodsDetailsContract.View foodsDetailView;

    public FoodsDetailPresenter(FoodsDetailsContract.View foodsDetailView) {
        this.foodsDetailView = foodsDetailView;
        this.foodsDetailView.setPrensenter(this);
    }
    @Override
    public void loadViewPager() {
        foodsDetailView.showViewPager();
    }

    @Override
    public void start() {

    }
}
