package com.example.ch08;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ch08.util.ToastUtil;

public class SpinnerDialogActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    // 定义下拉列表需要显示的文本数组
    private final static String[] starArray = {"水星", "金星", "地球", "火星", "木星", "土星"};

    private Spinner sp_dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_dialog);
        sp_dialog = findViewById(R.id.sp_dialog);
        sp_dialog.setPrompt("请选择行星");
        ArrayAdapter<String> startAdapter = new ArrayAdapter<>(this,R.layout.item_select,starArray);
        sp_dialog.setAdapter(startAdapter);
        sp_dialog.setSelection(0);
        sp_dialog.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        ToastUtil.show(this,"选择的是" + starArray[position]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}