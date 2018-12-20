package com.example.inaki.flowersmvp.network;

import com.example.inaki.flowersmvp.data.FlowersModel;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

public class ConnectionServices implements IFlowers_Interacter {

    private static Retrofit retrofit;
    private static OkHttpClient okHttpClient;

    public ConnectionServices(){getConnection();}

    public static IRequestInterface getConnection(){
        //BUILDER DESIGN PATTERN
        retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(API_Request.FLOWERS_BASE_URL).build();

        return retrofit.create(IRequestInterface.class);
    }

    @Override
    public Observable<List<FlowersModel>> getFlowersList() {
        return getConnection().getFlowersList();
    }
}
