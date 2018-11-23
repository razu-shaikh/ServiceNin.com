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
import com.example.rajus.servicenincom.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by rajus on 10/6/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    Context context;
    List<Upload> MainImageUploadInfoList;
    //String key2;
    int previousPosition=0;

    public RecyclerViewAdapter(Context context, List<Upload> TempList) {

        this.MainImageUploadInfoList = TempList;

        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_items, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        final Upload UploadInfo = MainImageUploadInfoList.get(position);

        holder.imageNameTextView.setText(UploadInfo.getResturantName());
        holder.location.setText(UploadInfo.getLocation());
        holder.time.setText(UploadInfo.getTime());
        Picasso.with(context).load(UploadInfo.getImageURL()).into(holder.imageView);

        //Glide.with(context).load(UploadInfo.getImageURL()).into(holder.imageView);

        holder.showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(context, DisplayItemActivity.class);
                intent.putExtra("pos", position);
                intent.putExtra("companyName",UploadInfo.getResturantName());
                intent.putExtra("value", DisplayImagesActivity.value);
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

    class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView imageNameTextView;
        public TextView location;
        public TextView time;
        public Button showBtn;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.imageView);

            imageNameTextView = (TextView) itemView.findViewById(R.id.ImageNameTextView);
            location = (TextView) itemView.findViewById(R.id.LocationTextView);
            time = (TextView) itemView.findViewById(R.id.TimeTextView);
            showBtn = (Button) itemView.findViewById(R.id.showBtn);


        }
    }
}
