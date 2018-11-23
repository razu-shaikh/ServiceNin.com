package com.example.rajus.servicenincom.PackAndShift;

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
 * Created by rajus on 11/6/2018.
 */

public class PackRecyclerViewAdapter extends RecyclerView.Adapter<PackRecyclerViewAdapter.ViewHolder> {
    int value=4;
    Context context;
    List<PackClass> MainImageUploadInfoList2;

    int previousPosition=0;

    public PackRecyclerViewAdapter(Context context, List<PackClass> TempList1) {

        this.MainImageUploadInfoList2 = TempList1;

        this.context = context;
    }

    @Override
    public PackRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pack_recyclerview, parent, false);

        PackRecyclerViewAdapter.ViewHolder viewHolder = new PackRecyclerViewAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PackRecyclerViewAdapter.ViewHolder holder, final int position) {
       // final String key1 = (String)MainImageUploadInfoList2.get(position).getKey();

        final PackClass UploadInfo1 = MainImageUploadInfoList2.get(position);
        holder.packCompanyNameTV.setText(UploadInfo1.getPackCompanyName());
        holder.packAddressTV.setText(UploadInfo1.getPackCompanyAddress());
        holder.packServiceTV.setText(UploadInfo1.getServiceArea());
        holder.packRentTV.setText(UploadInfo1.getPackRent());

        Picasso.with(context).load(UploadInfo1.getImageURL()).into(holder.imageView1);
        //Loading image from Glide library.

        holder.sendOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,RentNotification.class);
                intent.putExtra("value",value);
                intent.putExtra("name4",UploadInfo1.getPackCompanyName());
                intent.putExtra("serviceArea",UploadInfo1.getServiceArea());
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

        return MainImageUploadInfoList2.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView1;
        public TextView packCompanyNameTV, packAddressTV, packServiceTV, packRentTV;
        public Button sendOrder;


        public ViewHolder(View itemView) {
            super(itemView);

            imageView1 = (ImageView) itemView.findViewById(R.id.imageView1);

            packCompanyNameTV = (TextView) itemView.findViewById(R.id.packCompanyNameTV);
            packAddressTV = (TextView) itemView.findViewById(R.id.packAddressTV);
            packServiceTV = (TextView) itemView.findViewById(R.id.packServiceTV);
            packRentTV = (TextView) itemView.findViewById(R.id.packRentTV);

            sendOrder = (Button)itemView.findViewById(R.id.sendOrder);

        }

    }


}