package com.example.rajus.servicenincom.BusinessManagement;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.rajus.servicenincom.R;
import com.example.rajus.servicenincom.SendPackage.RentNotification;

import java.util.List;

/**
 * Created by rajus on 11/7/2018.
 */

public class ManagementRecyclerViewAdapter extends RecyclerView.Adapter<ManagementRecyclerViewAdapter.ViewHolder> {

    Context context;
    List<ManagementClass> MainImageUploadInfoList2;
    int value=6;


    public ManagementRecyclerViewAdapter(Context context, List<ManagementClass> TempList1) {

        this.MainImageUploadInfoList2 = TempList1;

        this.context = context;
    }

    @Override
    public ManagementRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.management_recyclerview, parent, false);

        ManagementRecyclerViewAdapter.ViewHolder viewHolder = new ManagementRecyclerViewAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ManagementRecyclerViewAdapter.ViewHolder holder, final int position) {

        final ManagementClass UploadInfo1 = MainImageUploadInfoList2.get(position);
        holder.managementCompanyNameTV.setText(UploadInfo1.getManagementCompanyName());
        holder.managementCompanyAddressTV.setText(UploadInfo1.getManagementCompanyAddress());

        holder.sendOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,RentNotification.class);
                intent.putExtra("value",value);
                intent.putExtra("name6",UploadInfo1.getManagementCompanyName());
                intent.putExtra("address6",UploadInfo1.getManagementCompanyAddress());
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

        public TextView managementCompanyNameTV,managementCompanyAddressTV;
        public Button sendOrder;


        public ViewHolder(View itemView) {
            super(itemView);

            managementCompanyNameTV = (TextView) itemView.findViewById(R.id.managementCompanyNameTV);
            managementCompanyAddressTV = (TextView) itemView.findViewById(R.id.managementCompanyAddressTV);

            sendOrder = (Button)itemView.findViewById(R.id.sendOrder);

        }
    }

}
