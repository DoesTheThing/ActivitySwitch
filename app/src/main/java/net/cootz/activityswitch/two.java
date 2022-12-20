package net.cootz.activityswitch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import java.util.zip.Inflater;

public class two extends AppCompatActivity {
    private Switch sw1;
    private Switch sw2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        sw1 = findViewById(R.id.switch_one);
        sw2 = findViewById(R.id.switch_two);

        Intent i = getIntent();
        String transfered = i.getStringExtra("etData");
        Boolean issw1 = i.getBooleanExtra("ch1", false);
        Boolean issw2 = i.getBooleanExtra("ch2", false);

        sw1.setChecked(issw1);
        sw2.setChecked(issw2);

        TextView text = findViewById(R.id.intent_text_view);
        text.setText(transfered);
    }

    public void onOkClick(View view)
    {
        TextView text = findViewById(R.id.intent_text_view);

        Intent i = new Intent();
        i.putExtra("resData", text.getText());
        i.putExtra("sw1", sw1.isChecked());
        i.putExtra("sw2", sw2.isChecked());

        setResult(RESULT_OK, i);
        finish();
    }

    public void onCanceledClick(View view)
    {
        setResult(RESULT_CANCELED);
        finish();
    }

}