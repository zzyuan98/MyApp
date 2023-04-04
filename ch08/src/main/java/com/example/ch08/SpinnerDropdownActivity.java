package com.example.ch08;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.ch08.util.ToastUtil;

public class SpinnerDropdownActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    // 定义下拉列表需要显示的文本数组
    private final static String[] starArray = {"水星", "金星", "地球", "火星", "木星", "土星"};

    private Spinner sp_dropdown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_dropdown);
        sp_dropdown = findViewById(R.id.sp_dropdown);
        ArrayAdapter<String> startAdapter = new ArrayAdapter<>(this,R.layout.item_select,starArray);
        sp_dropdown.setAdapter(startAdapter);
        sp_dropdown.setSelection(0);
        sp_dropdown.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        ToastUtil.show(this,"选择的是" + starArray[position]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}