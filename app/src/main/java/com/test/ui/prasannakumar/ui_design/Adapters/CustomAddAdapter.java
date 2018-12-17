package com.test.ui.prasannakumar.ui_design.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.test.ui.prasannakumar.ui_design.Global.GlobalApplication;
import com.test.ui.prasannakumar.ui_design.Interface.CategoryInterface;
import com.test.ui.prasannakumar.ui_design.R;
import com.wajahatkarim3.easyflipview.EasyFlipView;

import java.util.ArrayList;

/**
 * Created by prasannakumar on 17/12/18.
 */

public class CustomAddAdapter extends RecyclerView.Adapter<CustomAddAdapter.RecyclerViewHolders> {

    ArrayList personNames;
    ArrayList personImages;

    private Context context;
    public ArrayList<Integer> count=new ArrayList<>();
    public ArrayList<String> countValue=new ArrayList<>();
    int back=0;
    int front=0;
    CategoryInterface categoryInterface;

    public CustomAddAdapter(Context context, ArrayList personNames, ArrayList personImages) {
        this.context = context;
        this.personNames = personNames;
        this.personImages = personImages;
        //categoryInterface=inter;
    }

    @Override
    public CustomAddAdapter.RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_2_layout, null);
        CustomAddAdapter.RecyclerViewHolders rcv = new CustomAddAdapter.RecyclerViewHolders(layoutView);
        return rcv;
    }



    @Override
    public void onBindViewHolder(CustomAddAdapter.RecyclerViewHolders holder, int position) {
        try {


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
            //countryName = (TextView)itemView.findViewById(R.id.name);
           // countryPhoto = (ImageView)itemView.findViewById(R.id.image);
           //x mFlip=itemView.findViewById(R.id.Flip);
        }

        @Override
        public void onClick(View view) {
        }
    }
}