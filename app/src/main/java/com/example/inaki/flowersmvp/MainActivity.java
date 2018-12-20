package com.example.inaki.flowersmvp;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.inaki.flowersmvp.Adapter.DataAdapter;
import com.example.inaki.flowersmvp.FlowersList.FlowersList_Presenter;
import com.example.inaki.flowersmvp.FlowersList.IFlowersList_contract;
import com.example.inaki.flowersmvp.data.FlowersModel;
import com.example.inaki.flowersmvp.network.ConnectionServices;
import com.example.inaki.flowersmvp.network.IFlowers_Interacter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IFlowersList_contract.IView_FlowersList, SwipeRefreshLayout.OnRefreshListener{

    private FlowersList_Presenter flowersListPresenter;
    private IFlowers_Interacter flowersInteracter;
    private DataAdapter mAdapter;
    private RecyclerView mRecyclerView;

    public SwipeRefreshLayout mySwipeRefresh;


    @Override
    public void displayProgressDialog() {

    }

    @Override
    public void flowersList(List<FlowersModel> flowersModels) {

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(layoutManager);

        mAdapter = new DataAdapter(flowersModels);
        mRecyclerView.setAdapter(mAdapter);
        mySwipeRefresh.setRefreshing(false);

    }

    @Override
    public void dismissProgressDialog() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mySwipeRefresh = findViewById(R.id.swipe_refresh);

        //mySwipeRefresh.setColorSchemeResources(R.color.colorPrimary);
        //mySwipeRefresh.setProgressBackgroundColorSchemeResource(R.color.colorAccent);

        mySwipeRefresh.setOnRefreshListener(this);

        initializePresenterandCallAPI();

    }

    public void initializePresenterandCallAPI(){
        flowersInteracter = new ConnectionServices();
        flowersListPresenter = new FlowersList_Presenter(flowersInteracter);
        flowersListPresenter.onBind(this);
        flowersListPresenter.getFlowersFromAPI();
        //mySwipeRefresh.setRefreshing(false);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        flowersListPresenter.unBind();
    }


    //SWIPE TO REFRESH METHOD
    @Override
    public void onRefresh() {
        initializePresenterandCallAPI();
    }
}
