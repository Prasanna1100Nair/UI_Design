package com.test.ui.prasannakumar.ui_design.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.test.ui.prasannakumar.ui_design.Adapters.CustomAdapter;
import com.test.ui.prasannakumar.ui_design.Classes.RecyclerViewItemDecorator;
import com.test.ui.prasannakumar.ui_design.Interface.CategoryInterface;
import com.test.ui.prasannakumar.ui_design.R;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by prasannakumar on 16/12/18.
 */

public class GridActivity  extends AppCompatActivity {
    RecyclerView mRecyclerView;
    ArrayList personNames = new ArrayList<>(Arrays.asList("Person 1", "Person 2", "Person 3", "Person 4", "Person 5", "Person 6", "Person 7","Person 8", "Person 9", "Person 10", "Person 11", "Person 12", "Person 13", "Person 14"));
    ArrayList personImages = new ArrayList<>(Arrays.asList(R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher));
   // ArrayList personImages = new ArrayList<>(Arrays.asList(R.drawable.test,R.drawable.test,R.drawable.test,R.drawable.test,R.drawable.test,R.drawable.test,R.drawable.test,R.drawable.test,R.drawable.test,R.drawable.test,R.drawable.test,R.drawable.test,R.drawable.test,R.drawable.test,R.drawable.test));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_vew_layout);
        Intent intent = getIntent();
        CategoryInterface inter = (MainActivity) intent.getSerializableExtra("interface");

        Init(inter);
    }

    private void Init(CategoryInterface inter) {
        mRecyclerView=findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),3);
        //gridLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL); // set Horizontal Orientation
        mRecyclerView.setHasFixedSize(true);
        RecyclerViewItemDecorator itemDecoration = new RecyclerViewItemDecorator(GridActivity.this, R.dimen.my_value);
        mRecyclerView.addItemDecoration(itemDecoration);

        mRecyclerView.setLayoutManager(gridLayoutManager);
        CustomAdapter customAdapter = new CustomAdapter(GridActivity.this, personNames,personImages,inter);
        mRecyclerView.setAdapter(customAdapter);
    }
}
