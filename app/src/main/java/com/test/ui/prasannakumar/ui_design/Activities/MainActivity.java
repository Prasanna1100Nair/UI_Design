package com.test.ui.prasannakumar.ui_design.Activities;

import android.app.DatePickerDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.test.ui.prasannakumar.ui_design.Adapters.CustomAdapter;
import com.test.ui.prasannakumar.ui_design.Adapters.CustomAddAdapter;
import com.test.ui.prasannakumar.ui_design.Classes.RecyclerViewItemDecorator;
import com.test.ui.prasannakumar.ui_design.Global.GlobalApplication;
import com.test.ui.prasannakumar.ui_design.Interface.CategoryInterface;
import com.test.ui.prasannakumar.ui_design.R;



import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,View.OnFocusChangeListener {
    TextInputEditText title,Desp,Cata,Date,Rate,Payment,JobTerm,Location;
    TextInputLayout title_head,title_head2,title_header_3,Title_Date;
    private int mYear, mMonth, mDay;
    private int mFinalYear, mFinalMonth, mFinalDay;
    LinearLayout layoutBottomSheet;
    BottomSheetBehavior sheetBehavior;
    RecyclerView mRecyclerView;
    ImageView bottomSheet;
    int count=0;
    public static final int REQUEST_CODE = 1;
    private CategoryInterface inter;
    ArrayList personNames = new ArrayList<>(Arrays.asList("Person 1", "Person 2", "Person 3", "Person 4", "Person 5", "Person 6", "Person 7","Person 8", "Person 9", "Person 10", "Person 11", "Person 12", "Person 13", "Person 14"));
    ArrayList personImages = new ArrayList<>(Arrays.asList(R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        Init();
    }

    private void Init() {
        //prasanna
        layoutBottomSheet=findViewById(R.id.bottom_sheet);
        sheetBehavior = BottomSheetBehavior.from(layoutBottomSheet);
        title_head=findViewById(R.id.edtTitle_header);
        title_head2=findViewById(R.id.edtTitle_header_2);
        title_header_3=findViewById(R.id.edtTitle_header_3);
        Title_Date=findViewById(R.id.edtTitle_Date);
        bottomSheet=findViewById(R.id.bottomSheet);

        title=findViewById(R.id.edtTitle);
        Desp=findViewById(R.id.edtDesp);
        Date=findViewById(R.id.edtDate);
        Cata=findViewById(R.id.edtCata);
        Rate=findViewById(R.id.edtRate);
        Payment=findViewById(R.id.edtPayment);
        JobTerm=findViewById(R.id.edtJobTerm);
        Location=findViewById(R.id.edtLocation);
        mRecyclerView=findViewById(R.id.recyclerView);
        title.setHint("");
        Desp.setHint("");
        sheetBehavior.setHideable(true);
        sheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        title.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus){
                    title.setHint("");
                    title_head.setHint("Post Title");
                }else{
                    title.setHint("Enter Post Title");
                    title_head.setHint("");
                }

            }
        });
        Desp.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus){
                    Desp.setHint("");
                    title_head2.setHint("Post Description");
                }else{
                    Desp.setHint("Describe Your Post");
                    title_head2.setHint("");
                }

            }
        });
        Cata.setOnFocusChangeListener(this);
        Date.setOnFocusChangeListener(this);
        Rate.setOnFocusChangeListener(this);
        Payment.setOnFocusChangeListener(this);
        JobTerm.setOnFocusChangeListener(this);
        Location.setOnFocusChangeListener(this);
        bottomSheet.setOnClickListener(this);

      //  Cata.setText(GlobalApplication.total+" Catagories selected");
        mRecyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this, LinearLayoutManager.HORIZONTAL));

        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(horizontalLayoutManager);

        CustomAddAdapter customAdapter = new CustomAddAdapter(MainActivity.this, personNames,personImages);
        mRecyclerView.setAdapter(customAdapter);

        sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_HIDDEN:
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED: {
                       // btnBottomSheet.setText("Close Sheet");
                    }
                    break;
                    case BottomSheetBehavior.STATE_COLLAPSED: {
                        //btnBottomSheet.setText("Expand Sheet");
                    }
                    break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
        }
    public void toggleBottomSheet() {
        if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
            sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            //btnBottomSheet.setText("Close sheet");
        } else {
            sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
           // btnBottomSheet.setText("Expand sheet");
        }
    }
    @Override
    public void onClick(View view) {

         if(bottomSheet==view)
        {

            toggleBottomSheet();
        }

    }


    public void withChoiceItems(View view ,int call ) {
        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        final CharSequence items[] = new CharSequence[] {"No Preference", "E-Payment", "Cash"};
        final CharSequence items2[] = new CharSequence[] {"No Preference", "Fixed Budget", "Hourly Rate"};
        final CharSequence items3[] = new CharSequence[] {"Recurring Job", "Same Day Job", "Multi Day Job"};
        if(call==0)
        {
            Rate.setText(items2[0]);
            adb.setSingleChoiceItems(items2, 0, new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface d, int n) {

                    Log.e("TAG1","Which:: "+n);
                    Rate.setText(items2[n]);
                }

            });
            adb.setTitle("Rate");
        }else if(call==1)
        {
            Payment.setText(items[0]);
            adb.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface d, int n) {

                    Log.e("TAG1","Which:: "+n);
                    Payment.setText(items[n]);
                }

            });
            adb.setTitle("Payment Method");
        }
        else if(call==2)
        {
            JobTerm.setText(items3[0]);
            adb.setSingleChoiceItems(items3, 0, new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface d, int n) {

                    Log.e("TAG1","Which:: "+n);
                    JobTerm.setText(items3[n]);
                }

            });
            adb.setTitle("Job Term");
        }

        adb.setPositiveButton("Select", null);
        adb.setNegativeButton("Cancel", null);

        adb.show();

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        try {
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == REQUEST_CODE  && resultCode  == RESULT_OK) {

                int requiredValue = data.getIntExtra("key",0);
                Cata.setText(requiredValue+" Catagories selected");
            }
        } catch (Exception ex) {
            Toast.makeText(MainActivity.this, ex.toString(),
                    Toast.LENGTH_SHORT).show();
        }

    }
    private void openFile(File url) {

        try {

            Uri uri = Uri.fromFile(url);

            Intent intent = new Intent(Intent.ACTION_VIEW);
            if (url.toString().contains(".doc") || url.toString().contains(".docx")) {
                // Word document
                intent.setDataAndType(uri, "application/msword");
            } else if (url.toString().contains(".pdf")) {
                // PDF file
                intent.setDataAndType(uri, "application/pdf");
            } else if (url.toString().contains(".ppt") || url.toString().contains(".pptx")) {
                // Powerpoint file
                intent.setDataAndType(uri, "application/vnd.ms-powerpoint");
            } else if (url.toString().contains(".xls") || url.toString().contains(".xlsx")) {
                // Excel file
                intent.setDataAndType(uri, "application/vnd.ms-excel");
            } else if (url.toString().contains(".zip") || url.toString().contains(".rar")) {
                // WAV audio file
                intent.setDataAndType(uri, "application/x-wav");
            } else if (url.toString().contains(".rtf")) {
                // RTF file
                intent.setDataAndType(uri, "application/rtf");
            } else if (url.toString().contains(".wav") || url.toString().contains(".mp3")) {
                // WAV audio file
                intent.setDataAndType(uri, "audio/x-wav");
            } else if (url.toString().contains(".gif")) {
                // GIF file
                intent.setDataAndType(uri, "image/gif");
            } else if (url.toString().contains(".jpg") || url.toString().contains(".jpeg") || url.toString().contains(".png")) {
                // JPG file
                intent.setDataAndType(uri, "image/jpeg");
            } else if (url.toString().contains(".txt")) {
                // Text file
                intent.setDataAndType(uri, "text/plain");
            } else if (url.toString().contains(".3gp") || url.toString().contains(".mpg") ||
                    url.toString().contains(".mpeg") || url.toString().contains(".mpe") || url.toString().contains(".mp4") || url.toString().contains(".avi")) {
                // Video files
                intent.setDataAndType(uri, "video/*");
            } else {
                intent.setDataAndType(uri, "*/*");
            }

            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(getApplicationContext(), "No application found which can open the file", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        Log.e("TAG1","B:: "+b);
        if(view==Cata && b)
        {
            Intent in=new Intent(MainActivity.this, GridActivity.class);

            startActivityForResult(in , REQUEST_CODE);
            count=0;
        }
        else if(Rate==view && b)
        {
            closeKeyboard();
            withChoiceItems(view,0);
        }
        else if(Payment==view && b)
        {
            closeKeyboard();
            withChoiceItems(view,1);
        }
        else if(JobTerm==view && b)
        {
            closeKeyboard();
            withChoiceItems(view,2);
        }
        else if(Date==view && b)
        {
            closeKeyboard();
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                            mFinalDay = dayOfMonth;
                            mFinalMonth = monthOfYear;
                            mFinalYear = year;
                            Date.setText(mFinalDay + "-" + (mFinalMonth + 1) + "-" + mFinalYear);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.setCancelable(false);
            datePickerDialog.show();
        }

    }
    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(getApplicationContext().INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
