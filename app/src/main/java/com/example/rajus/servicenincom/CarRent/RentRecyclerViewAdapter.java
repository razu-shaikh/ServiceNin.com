package com.example.rajus.servicenincom.CarRent;

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

public class RentRecyclerViewAdapter extends RecyclerView.Adapter<RentRecyclerViewAdapter.ViewHolder> {

    Context context;
    List<RentClass> MainImageUploadInfoList2;
    int previousPosition=0;

    public RentRecyclerViewAdapter(Context context, List<RentClass> TempList1) {

        this.MainImageUploadInfoList2 = TempList1;

        this.context = context;
    }

    @Override
    public RentRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rent_recyclerview, parent, false);

        RentRecyclerViewAdapter.ViewHolder viewHolder = new RentRecyclerViewAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RentRecyclerViewAdapter.ViewHolder holder, final int position) {
       // final String key1 = (String)MainImageUploadInfoList2.get(position).getKey();
        final RentClass UploadInfo1 = MainImageUploadInfoList2.get(position);

        holder.vehiclesNameTV.setText(UploadInfo1.getVehiclesName());
        holder.vehiclesConditionTV.setText(UploadInfo1.getVehiclesCondition());
        holder.minimumRentTV.setText(UploadInfo1.getMinimumRent());
        holder.serviceAreaTV.setText(UploadInfo1.getServiceArea());
        Picasso.with(context).load(UploadInfo1.getImageURL()).into(holder.imageView1);
        holder.sendOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,RentNotification.class);
                intent.putExtra("name",UploadInfo1.getVehiclesName());
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
        public TextView vehiclesNameTV,vehiclesConditionTV,minimumRentTV,serviceAreaTV;
        public Button sendOrder;


        public ViewHolder(View itemView) {
            super(itemView);

            imageView1 = (ImageView) itemView.findViewById(R.id.imageView1);

            vehiclesNameTV = (TextView) itemView.findViewById(R.id.vehiclesNameTV);
            vehiclesConditionTV = (TextView) itemView.findViewById(R.id.vehiclesConditionTV);
            minimumRentTV = (TextView) itemView.findViewById(R.id.minimumRentTV);
            serviceAreaTV = (TextView) itemView.findViewById(R.id.serviceAreaTV);

            sendOrder = (Button)itemView.findViewById(R.id.sendOrder);

        }
    }
}
