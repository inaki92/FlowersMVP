package com.example.inaki.flowersmvp.network;

import com.example.inaki.flowersmvp.data.FlowersModel;

import java.util.List;

import rx.Observable;

public interface IFlowers_Interacter {

    Observable<List<FlowersModel>> getFlowersList();

}
