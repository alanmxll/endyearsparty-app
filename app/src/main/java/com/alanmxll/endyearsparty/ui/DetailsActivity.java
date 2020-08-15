package com.alanmxll.endyearsparty.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.alanmxll.endyearsparty.R;
import com.alanmxll.endyearsparty.constant.EndYearConstants;
import com.alanmxll.endyearsparty.data.SecurityPreferences;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();
    private SecurityPreferences mSecurityPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        this.mSecurityPreferences = new SecurityPreferences(this);

        this.mViewHolder.checkParticipate = findViewById(R.id.check_participate);
        this.mViewHolder.checkParticipate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.check_participate) {
            if (this.mViewHolder.checkParticipate.isChecked()) {
                this.mSecurityPreferences.storeString(EndYearConstants.PRESENCE_KEY, EndYearConstants.CONFIRMATION_YES);
            } else {
                this.mSecurityPreferences.storeString(EndYearConstants.PRESENCE_KEY, EndYearConstants.CONFIRMATION_NO);
            }
        }
    }

    private static class ViewHolder {
        CheckBox checkParticipate;
    }
}