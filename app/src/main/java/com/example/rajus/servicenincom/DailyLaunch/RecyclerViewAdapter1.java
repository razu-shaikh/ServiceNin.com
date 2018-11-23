package com.example.rajus.servicenincom.DailyLaunch;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rajus.servicenincom.AnimationUtil;
import com.example.rajus.servicenincom.SendPackage.SendNotification;
import com.example.rajus.servicenincom.R;

import com.squareup.picasso.Picasso;


import java.util.List;

/**
 * Created by rajus on 10/8/2018.
 */

public class RecyclerViewAdapter1 extends RecyclerView.Adapter<RecyclerViewAdapter1.ViewHolder> {

        Context context;
        List<Upload1> MainImageUploadInfoList1;
        int previousPosition=0;

public RecyclerViewAdapter1(Context context, List<Upload1> TempList1) {

        this.MainImageUploadInfoList1 = TempList1;

        this.context = context;
        }

@Override
public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_items_items, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
        }

@Override
public void onBindViewHolder(ViewHolder holder, final int position) {
        final Upload1 UploadInfo1 = MainImageUploadInfoList1.get(position);

         holder.NameTextView.setText(UploadInfo1.getItemName());
         holder.PriceTextView.setText(UploadInfo1.getItemPrice());
        //Loading image from Glide library.

        Picasso.with(context).load(UploadInfo1.getImageURL1()).into(holder.imageView1);

    holder.sendOrder.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context,SendNotification.class);
            intent.putExtra("name",UploadInfo1.getItemName());
            intent.putExtra("companyN", DisplayItemActivity.companyNam);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    });
    if (position>previousPosition){
        AnimationUtil.animate(holder,true);
    }
    else{
        AnimationUtil.animate(holder,false);
    }

}



    @Override
public int getItemCount() {

        return MainImageUploadInfoList1.size();
        }

class ViewHolder extends RecyclerView.ViewHolder{

    public ImageView imageView1;
    public TextView NameTextView;
    public TextView PriceTextView;
    public Button sendOrder;


    public ViewHolder(View itemView) {
        super(itemView);

        imageView1 = (ImageView) itemView.findViewById(R.id.imageView1);

        NameTextView = (TextView) itemView.findViewById(R.id.NameTextView);
        PriceTextView = (TextView) itemView.findViewById(R.id.PriceTextView);
        sendOrder = (Button)itemView.findViewById(R.id.sendOrder);

    }
}

}

