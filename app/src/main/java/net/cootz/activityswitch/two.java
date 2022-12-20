package net.cootz.activityswitch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.zip.Inflater;

public class two extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        Intent i = getIntent();
        String transfered = i.getStringExtra("etData");

        TextView text = findViewById(R.id.intent_text_view);
        text.setText(transfered);
    }

    public void onOkClick(View view)
    {
        TextView text = findViewById(R.id.intent_text_view);

        Intent i = new Intent();
        i.putExtra("resData", text.getText());

        setResult(RESULT_OK, i);
        finish();
    }

    public void onCanceledClick(View view)
    {
        setResult(RESULT_CANCELED);
        finish();
    }

}