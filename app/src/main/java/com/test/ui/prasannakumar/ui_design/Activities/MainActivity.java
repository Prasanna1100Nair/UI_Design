package com.test.ui.prasannakumar.ui_design.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.test.ui.prasannakumar.ui_design.Interface.CategoryInterface;
import com.test.ui.prasannakumar.ui_design.R;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextInputEditText title,Desp,Cata;
    TextInputLayout title_head,title_head2,title_header_3;
    int count=0;
    private CategoryInterface inter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Init();
    }

    private void Init() {
        title_head=findViewById(R.id.edtTitle_header);
        title_head2=findViewById(R.id.edtTitle_header_2);
        title_header_3=findViewById(R.id.edtTitle_header_3);
        title=findViewById(R.id.edtTitle);
        Desp=findViewById(R.id.edtDesp);
        Cata=findViewById(R.id.edtCata);
        Cata.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        if(Cata==view)
        {
            Intent in=new Intent(MainActivity.this, GridActivity.class);

            startActivity(in);
            count=0;
        }
    }


}
