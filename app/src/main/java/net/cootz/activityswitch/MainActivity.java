package net.cootz.activityswitch;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText text;
    CheckBox ch1;
    CheckBox ch2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.transfer_data_edit_text);
        ch1 = findViewById(R.id.checkbox_one);
        ch2 = findViewById(R.id.checkbox_two);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 555)
        {
            if (data != null)
            {
                String res = data.getStringExtra("resData");
                Boolean sw1 = data.getBooleanExtra("sw1", false);
                Boolean sw2 = data.getBooleanExtra("sw2", false);

                ch1.setChecked(sw1);
                ch2.setChecked(sw2);
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    public void onExitCLick(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.warning_sign_red);
        builder.setView(R.layout.dialog_exit);
        builder.setPositiveButton(
                R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }
        ).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void onEditDialogCLick(View view)
    {
        EditText editText = new EditText(this);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.warning_sign_red);
        builder.setView(editText);
        builder.setPositiveButton(
                R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        text.setText(editText.getText());
                    }
                }
        ).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void onDialogClick(View view)
    {
        Intent i = new Intent(this, two.class);
        i.putExtra("etData", text.getText().toString());
        i.putExtra("ch1", ch1.isChecked());
        i.putExtra("ch2", ch2.isChecked());

        startActivityForResult(i, 555);
    }


}