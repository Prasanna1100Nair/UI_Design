package com.test.ui.prasannakumar.ui_design.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.test.ui.prasannakumar.ui_design.Global.GlobalApplication;
import com.test.ui.prasannakumar.ui_design.Interface.CategoryInterface;
import com.test.ui.prasannakumar.ui_design.R;
import com.wajahatkarim3.easyflipview.EasyFlipView;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by prasannakumar on 16/12/18.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.RecyclerViewHolders> {

    ArrayList personNames;
    ArrayList personImages;

    private Context context;
    public ArrayList<Integer> count=new ArrayList<>();
    public ArrayList<String> countValue=new ArrayList<>();
    int back=0;
    int front=0;
    CategoryInterface categoryInterface;

    public CustomAdapter(Context context, ArrayList personNames, ArrayList personImages) {
        this.context = context;
        this.personNames = personNames;
        this.personImages = personImages;
        //categoryInterface=inter;
    }

    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.sample_layout, null);
        RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {
        try {
            Log.e("TAG1","position:: "+position);
            holder.countryName.setText(""+personNames.get(position));
          //  holder.countryPhoto.setImageResource((Integer) personImages.get(position));
            holder.countryPhoto.setColorFilter(context.getResources().getColor(R.color.colorAccent));
            holder.mFlip.setTag(position);
holder.mFlip.setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
    @Override
    public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
        Log.e("TAG1","easyFlipView:: "+easyFlipView);
        Log.e("TAG1","Tag: "+easyFlipView.getTag());
        Log.e("TAG1","newCurrentSide:: "+newCurrentSide);
        String value=""+newCurrentSide;
        if(value.equals("BACK_SIDE"))
        {
            back++;
        }else
        {
            front++;
        }
        GlobalApplication.total=back-front;
        Log.e("TAG1","total:: "+ GlobalApplication.total);
       // categoryInterface.totalCount(1);
    }
});

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        }

    @Override
    public int getItemCount() {
        return this.personNames.size();
    }
    public class RecyclerViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView countryName;
        public ImageView countryPhoto;
public EasyFlipView mFlip;
        public RecyclerViewHolders(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            countryName = (TextView)itemView.findViewById(R.id.name);
            countryPhoto = (ImageView)itemView.findViewById(R.id.image);
mFlip=itemView.findViewById(R.id.Flip);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(), "Clicked Country Position = " + getPosition(), Toast.LENGTH_SHORT).show();
        }
    }
}