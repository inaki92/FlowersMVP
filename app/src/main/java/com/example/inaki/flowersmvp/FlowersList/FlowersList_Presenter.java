package com.example.inaki.flowersmvp.FlowersList;

import com.example.inaki.flowersmvp.Adapter.DataAdapter;
import com.example.inaki.flowersmvp.data.FlowersModel;
import com.example.inaki.flowersmvp.network.IFlowers_Interacter;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.Observer;

public class FlowersList_Presenter implements IFlowersList_contract.IPresenter_FlowersList {

    private IFlowersList_contract.IView_FlowersList iView_flowersList;
    private IFlowers_Interacter iFlowers_interacter;

    public FlowersList_Presenter (IFlowers_Interacter iFlowers_interacter){
        this.iFlowers_interacter = iFlowers_interacter;
    }


    @Override
    public void onBind(IFlowersList_contract.IView_FlowersList iViewFlowersList) {

        this.iView_flowersList = iViewFlowersList;
    }

    @Override
    public void getFlowersFromAPI() {

        iFlowers_interacter.getFlowersList().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<FlowersModel>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<FlowersModel> flowersModels) {
                        iView_flowersList.flowersList(flowersModels);
                    }
                });

    }

    @Override
    public void unBind() {

        this.iView_flowersList = null;

    }
}
