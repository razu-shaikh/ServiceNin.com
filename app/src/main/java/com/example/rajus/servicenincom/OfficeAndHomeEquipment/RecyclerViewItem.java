package com.example.rajus.servicenincom.OfficeAndHomeEquipment;

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
import com.example.rajus.servicenincom.SendPackage.SendNotification;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by rajus on 11/9/2018.
 */

public class RecyclerViewItem extends RecyclerView.Adapter<RecyclerViewItem.ViewHolder> {

    Context context;
    List<AddItem> MainImageUploadInfoList1;
    int value=1;
    int previousPosition=0;


    public RecyclerViewItem(Context context, List<AddItem> TempList1) {

        this.MainImageUploadInfoList1 = TempList1;

        this.context = context;
    }

    @Override
    public RecyclerViewItem.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_items_items, parent, false);

        RecyclerViewItem.ViewHolder viewHolder = new RecyclerViewItem.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewItem.ViewHolder holder, final int position) {
       final AddItem UploadInfo1 = MainImageUploadInfoList1.get(position);

        holder.NameTextView.setText(UploadInfo1.getItemName());
        holder.PriceTextView.setText(UploadInfo1.getItemPrice());
        Picasso.with(context).load(UploadInfo1.getImageURL1()).into(holder.imageView1);
        //Loading image from Glide library.
        holder.sendOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,SendNotification.class);
                intent.putExtra("value",value);
                intent.putExtra("name1",UploadInfo1.getItemName());
                intent.putExtra("company",ShowEquipmentActivity.companyName);
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
