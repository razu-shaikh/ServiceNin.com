package com.example.rajus.servicenincom.TourAndTravels;

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
import com.google.firebase.database.DatabaseReference;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by rajus on 11/5/2018.
 */

public class TourRecyclerViewAdapter extends RecyclerView.Adapter<TourRecyclerViewAdapter.ViewHolder> {
    int value=2;
    Context context;
    List<TourClass> MainImageUploadInfoList2;

    int previousPosition=0;

    public TourRecyclerViewAdapter(Context context, List<TourClass> TempList1) {

        this.MainImageUploadInfoList2 = TempList1;

        this.context = context;
    }

    @Override
    public TourRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tour_travels_recyclerview, parent, false);

        TourRecyclerViewAdapter.ViewHolder viewHolder = new TourRecyclerViewAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TourRecyclerViewAdapter.ViewHolder holder, final int position) {
        final TourClass UploadInfo1 = MainImageUploadInfoList2.get(position);

        holder.packageNameTV.setText(UploadInfo1.getNameCompany());
        holder.descriptionTV.setText(UploadInfo1.getDescription());
        holder.priceTV.setText(UploadInfo1.getPrice());
        holder.companyNameTV.setText(UploadInfo1.getNameCompany1());
        Picasso.with(context).load(UploadInfo1.getImageURL()).into(holder.imageView1);

        holder.sendOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,RentNotification.class);
                intent.putExtra("value",value);
                intent.putExtra("name2",UploadInfo1.getNameCompany1());
                intent.putExtra("package",UploadInfo1.getNameCompany());
                intent.putExtra("price",UploadInfo1.getPrice());
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

    class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView imageView1;
        public TextView packageNameTV,descriptionTV,priceTV,companyNameTV;
        public Button sendOrder;


        public ViewHolder(View itemView) {
            super(itemView);

            imageView1 = (ImageView) itemView.findViewById(R.id.imageView1);


            packageNameTV = (TextView) itemView.findViewById(R.id.packageNameTV);
            descriptionTV = (TextView) itemView.findViewById(R.id.descriptionTV);
            priceTV = (TextView) itemView.findViewById(R.id.priceTV);
            companyNameTV = (TextView) itemView.findViewById(R.id.companyNameTV);

            sendOrder = (Button)itemView.findViewById(R.id.sendOrder);

        }
    }

}
