package com.example.inaki.flowersmvp.network;

import com.example.inaki.flowersmvp.data.FlowersModel;

import java.util.List;
import rx.Observable;

import retrofit2.http.GET;

public interface IRequestInterface {

@GET(API_Request.API_FLOWERS_LIST)
Observable<List<FlowersModel>> getFlowersList();

}
