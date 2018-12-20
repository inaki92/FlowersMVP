package com.example.inaki.flowersmvp.Adapter;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.inaki.flowersmvp.FlowersList.FlowersList_Presenter;
import com.example.inaki.flowersmvp.MainActivity;
import com.example.inaki.flowersmvp.data.FlowersModel;
import com.example.inaki.flowersmvp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private List<FlowersModel> mFlowersModel;
    private String url;


    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTvName,mTvInstructions,mTvPrice,mCategory,mId;
        private ImageView mImage;

        public ViewHolder(View itemView) {
            super(itemView);

            mTvName = itemView.findViewById(R.id.tv_name);
            mTvInstructions = itemView.findViewById(R.id.tv_instructions);
            mTvPrice = itemView.findViewById(R.id.tv_price);
            mImage = itemView.findViewById(R.id.imageView);
            mCategory = itemView.findViewById(R.id.tv_category);
            mId = itemView.findViewById(R.id.tv_id);

        }
    }

    public DataAdapter (List<FlowersModel> FlowersList){mFlowersModel = FlowersList;}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_data,viewGroup,false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull DataAdapter.ViewHolder holder, int i) {

        holder.mTvName.setText(mFlowersModel.get(i).getName());
        holder.mTvInstructions.setText(mFlowersModel.get(i).getInstructions());
        holder.mTvPrice.setText("$ " + mFlowersModel.get(i).getPrice().toString());
        holder.mCategory.setText(mFlowersModel.get(i).getCategory());
        holder.mId.setText("ID: " + mFlowersModel.get(i).getProductId().toString());

        url = "http://services.hanselandpetal.com/photos/" + mFlowersModel.get(i).getPhoto();
        Picasso.get().load(url)
                .resize(50, 50).centerCrop().into(holder.mImage);

    }

    @Override
    public int getItemCount() {
        return mFlowersModel.size();
    }
}
