package com.example.rajus.servicenincom.EventManagement;

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
 * Created by rajus on 11/6/2018.
 */

public class EventRecyclerViewAdapter extends RecyclerView.Adapter<EventRecyclerViewAdapter.ViewHolder> {

    int value=3;
    Context context;
    List<EventClass> MainImageUploadInfoList2;


    public EventRecyclerViewAdapter(Context context, List<EventClass> TempList1) {

        this.MainImageUploadInfoList2 = TempList1;

        this.context = context;
    }

    @Override
    public EventRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_recyclerview, parent, false);

        EventRecyclerViewAdapter.ViewHolder viewHolder = new EventRecyclerViewAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(EventRecyclerViewAdapter.ViewHolder holder, final int position) {
        final EventClass UploadInfo1 = MainImageUploadInfoList2.get(position);

        holder.eventCompanyNameTV.setText(UploadInfo1.getEventCompanyName());
        holder.eventCompanyAddressTV.setText(UploadInfo1.getEventCompanyAddress());
        holder.eventPackageTV.setText(UploadInfo1.getEventPackage());

        holder.sendOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,RentNotification.class);
                intent.putExtra("value",value);
                intent.putExtra("name3",UploadInfo1.getEventCompanyName());
                intent.putExtra("package",UploadInfo1.getEventPackage());
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

        public TextView eventCompanyNameTV,eventCompanyAddressTV,eventPackageTV;

        public Button sendOrder;

        public ViewHolder(View itemView) {
            super(itemView);

            eventCompanyNameTV = (TextView) itemView.findViewById(R.id.eventCompanyNameTV);
            eventCompanyAddressTV = (TextView) itemView.findViewById(R.id.eventCompanyAddressTV);
            eventPackageTV = (TextView) itemView.findViewById(R.id.eventPackageTV);

            sendOrder = (Button)itemView.findViewById(R.id.sendOrder);

        }
    }

}