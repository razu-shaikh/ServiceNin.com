package com.example.rajus.servicenincom.OfficeAndHomeEquipment;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.rajus.servicenincom.R;

import java.util.List;

/**
 * Created by rajus on 11/9/2018.
 */

public class RecyclerViewCompany extends RecyclerView.Adapter<RecyclerViewCompany.ViewHolder> {

    Context context;
    List<AddCompany> MainImageUploadInfoList;

    public RecyclerViewCompany(Context context, List<AddCompany> TempList) {
        this.MainImageUploadInfoList = TempList;
        this.context = context;
    }
    @Override
    public RecyclerViewCompany.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.company_recyclerview, parent, false);
        RecyclerViewCompany.ViewHolder viewHolder = new RecyclerViewCompany.ViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(RecyclerViewCompany.ViewHolder holder, final int position) {
        final AddCompany UploadInfo = MainImageUploadInfoList.get(position);

        holder.eqCompanyNameTV.setText(UploadInfo.getCompanyNameEq());
        holder.eqCompanyAddressTV.setText(UploadInfo.getCompanyAddressEq());

        holder.showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ShowEquipmentActivity.class);
                intent.putExtra("pos", position);
                intent.putExtra("companyName",UploadInfo.getCompanyNameEq());
                intent.putExtra("value",ShowHomeAndOfficeActivity .value);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
//
    }
    @Override
    public int getItemCount() {
        return MainImageUploadInfoList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView eqCompanyNameTV;
        public TextView eqCompanyAddressTV;
        Button showBtn;
        public ViewHolder(View itemView) {
            super(itemView);
            eqCompanyNameTV = (TextView) itemView.findViewById(R.id.eqCompanyNameTV);
            eqCompanyAddressTV = (TextView) itemView.findViewById(R.id.eqCompanyAddressTV);
            showBtn = (Button) itemView.findViewById(R.id.showBtn);
        }
    }
}
