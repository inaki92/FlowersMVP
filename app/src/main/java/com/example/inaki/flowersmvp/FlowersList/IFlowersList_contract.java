package com.example.inaki.flowersmvp.FlowersList;

import com.example.inaki.flowersmvp.data.FlowersModel;

import java.util.List;

public interface IFlowersList_contract {

    public interface IView_FlowersList {

        void displayProgressDialog();
        void flowersList(List<FlowersModel> flowersModels);
        void dismissProgressDialog();
    }

    public interface IPresenter_FlowersList{

        void onBind(IView_FlowersList iViewFlowersList);
        void getFlowersFromAPI();
        void unBind();
    }


}
