package startupordie.food.food_detail;

import startupordie.food.food.FoodsContract;

/**
 * Created by samnguyen on 27/04/2016.
 */
public class FoodsDetailInfoPresenter implements FoodsDetailsContract.FoodsDetailInfoBasePresenter{

    private final FoodsDetailsContract.FoodsDetailInfoView foodsDetailInfoView;

    public FoodsDetailInfoPresenter(FoodsDetailsContract.FoodsDetailInfoView foodsDetailInfoView) {
        this.foodsDetailInfoView = foodsDetailInfoView;
        this.foodsDetailInfoView.setPrensenter(this);
    }

    @Override
    public void loadDetail() {

    }

    @Override
    public void start() {

    }
}
