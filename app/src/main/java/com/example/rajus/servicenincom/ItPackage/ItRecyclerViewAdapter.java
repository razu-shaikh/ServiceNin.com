package com.example.rajus.servicenincom.ItPackage;

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
import com.example.rajus.servicenincom.R;
import com.example.rajus.servicenincom.SendPackage.RentNotification;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by rajus on 10/20/2018.
 */

public class ItRecyclerViewAdapter extends RecyclerView.Adapter<ItRecyclerViewAdapter.ViewHolder> {

    int value=1;
    Context context;
    List<ItClass> MainImageUploadInfoList;
    int previousPosition=0;

    public ItRecyclerViewAdapter(Context context, List<ItClass> TempList1) {

        this.MainImageUploadInfoList = TempList1;

        this.context = context;
    }

    @Override
    public ItRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.it_recyclerview, parent, false);

        ItRecyclerViewAdapter.ViewHolder viewHolder = new ItRecyclerViewAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ItRecyclerViewAdapter.ViewHolder holder, final int position) {
        final ItClass UploadInfo1 = MainImageUploadInfoList.get(position);

        holder.companyNameTV.setText(UploadInfo1.getCompanyName());
        holder.addressTV.setText(UploadInfo1.getCompanyAddress());
        holder.serviceTV.setText(UploadInfo1.getServiceSection());
        Picasso.with(context).load(UploadInfo1.getImageURL()).into(holder.imageView1);
        //Loading image from Glide library.
        holder.sendOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,RentNotification.class);
                intent.putExtra("value",value);
                intent.putExtra("name1",UploadInfo1.getCompanyName());
                intent.putExtra("address",UploadInfo1.getCompanyAddress());
                intent.putExtra("service",UploadInfo1.getServiceSection());
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

        return MainImageUploadInfoList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView imageView1;
        public TextView companyNameTV,addressTV,serviceTV;
        private Button sendOrder;


        public ViewHolder(View itemView) {
            super(itemView);

            imageView1 = (ImageView) itemView.findViewById(R.id.imageView1);

            companyNameTV = (TextView) itemView.findViewById(R.id.companyNameTV);
            addressTV = (TextView) itemView.findViewById(R.id.addressTV);
            serviceTV = (TextView) itemView.findViewById(R.id.serviceTV);
            sendOrder = (Button)itemView.findViewById(R.id.sendOrder);

        }
    }

}
