package com.example.ch08;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;

import com.example.ch08.adapter.PlanetBaseAdapter;
import com.example.ch08.entity.Planet;
import com.example.ch08.util.ToastUtil;
import com.example.ch08.util.Utils;

import java.util.List;

public class ListViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, CompoundButton.OnCheckedChangeListener {

    private List<Planet> planetList;
    private CheckBox ck_divider;
    private CheckBox ck_selector;
    private ListView lv_planet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        lv_planet = findViewById(R.id.lv_planet);
        planetList = Planet.getDefaultList();
        PlanetBaseAdapter adapter = new PlanetBaseAdapter(this, planetList);
        lv_planet.setAdapter(adapter);

        lv_planet.setOnItemClickListener(this);

        ck_divider = findViewById(R.id.ck_divider);
        ck_divider.setOnCheckedChangeListener(this);
        ck_selector = findViewById(R.id.ck_selector);
        ck_selector.setOnCheckedChangeListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ToastUtil.show(this,"您选择的是"+planetList.get(position).name);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()){
            case R.id.ck_divider:
                if(ck_divider.isChecked()){
                    Drawable drawable = getResources().getDrawable(R.color.black, getTheme());
                    lv_planet.setDivider(drawable);
                    lv_planet.setDividerHeight(Utils.dip2px(this,1));
                }else {
                    lv_planet.setDivider(null);
                    lv_planet.setDividerHeight(0);
                }
                break;

            case R.id.ck_selector:
                if(ck_selector.isChecked()){
                    lv_planet.setSelection(R.drawable.list_selector);
                } else {
                    Drawable drawable = getResources().getDrawable(R.color.transparent, getTheme());
                    lv_planet.setSelector(drawable);
                }

                break;

        }
    }
}