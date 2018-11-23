package com.example.rajus.servicenincom;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.widget.RecyclerView;

/**
 * Created by rajus on 11/18/2018.
 */

public class AnimationUtil {
   public static void  animate(RecyclerView.ViewHolder holder,boolean goesDown){
       AnimatorSet animatorSet = new AnimatorSet();

       ObjectAnimator animatorTranslateY = ObjectAnimator.ofFloat(holder.itemView,"translationY",goesDown==true ? 100 : -100,0);
       animatorTranslateY.setDuration(1000);

       ObjectAnimator animatorTranslateX = ObjectAnimator.ofFloat(holder.itemView,"translationX",-50,50,-30,30,-20,20,-5,5,0);
       animatorTranslateX.setDuration(1000);

       animatorSet.playTogether(animatorTranslateX,animatorTranslateY);
       animatorSet.start();
   }
}
