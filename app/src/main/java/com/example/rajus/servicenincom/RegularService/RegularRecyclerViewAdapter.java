package com.example.rajus.servicenincom.RegularService;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rajus.servicenincom.R;
import com.example.rajus.servicenincom.SendPackage.RentNotification;

import java.util.List;

/**
 * Created by rajus on 11/7/2018.
 */

public class RegularRecyclerViewAdapter extends RecyclerView.Adapter<RegularRecyclerViewAdapter.ViewHolder> {

    Context context;
    List<RegularClass> MainImageUploadInfoList2;

    int value=5;


    public RegularRecyclerViewAdapter(Context context, List<RegularClass> TempList1) {

        this.MainImageUploadInfoList2 = TempList1;

        this.context = context;
    }

    @Override
    public RegularRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.regular_recyclerview, parent, false);

        RegularRecyclerViewAdapter.ViewHolder viewHolder = new RegularRecyclerViewAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RegularRecyclerViewAdapter.ViewHolder holder, final int position) {

        final RegularClass UploadInfo1 = MainImageUploadInfoList2.get(position);
        holder.regularCompanyNameTV.setText(UploadInfo1.getRegularCompanyName());
        holder.regularCompanyAddressTV.setText(UploadInfo1.getRegularCompanyAddress());
        holder.regularMinimumRentTV.setText(UploadInfo1.getRegularMinimumRent());

        holder.sendOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,RentNotification.class);
                intent.putExtra("value",value);
                intent.putExtra("nameregular",UploadInfo1.getRegularCompanyName());
                intent.putExtra("address5",UploadInfo1.getRegularCompanyAddress());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {

        return MainImageUploadInfoList2.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public TextView regularCompanyNameTV,regularCompanyAddressTV,regularMinimumRentTV;
        public Button sendOrder;


        public ViewHolder(View itemView) {
            super(itemView);

            regularCompanyNameTV = (TextView) itemView.findViewById(R.id.regularCompanyNameTV);
            regularCompanyAddressTV = (TextView) itemView.findViewById(R.id.regularCompanyAddressTV);
            regularMinimumRentTV = (TextView) itemView.findViewById(R.id.regularMinimumRentTV);

            sendOrder = (Button)itemView.findViewById(R.id.sendOrder);

        }
    }

}
