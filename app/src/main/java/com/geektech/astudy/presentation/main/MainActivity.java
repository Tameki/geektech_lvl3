package com.geektech.astudy.presentation.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.geektech.astudy.AdvancedApp;
import com.geektech.astudy.R;
import com.geektech.astudy.injection.component.DaggerBasicComponent;
import com.geektech.astudy.injection.component.DaggerLoginComponent;
import com.geektech.astudy.injection.module.BasicModule;
import com.geektech.astudy.model.ConstValues;
import com.geektech.astudy.presentation.main.MainFragment;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    public ConstValues mConstValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }

        ((AdvancedApp) getApplicationContext())
                .basicComponent()
                .inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ololo", mConstValues.toString());
    }
}
