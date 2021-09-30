package edu.sjsu.android.intentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ActivityLoaderActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonWeb = (Button) findViewById(R.id.buttonWeb);
        Button buttonCall = (Button) findViewById(R.id.buttonCall);
        try {
            buttonWeb.setOnClickListener(new ClickHandler());
            buttonCall.setOnClickListener(new ClickHandler());
        } catch (Exception e) {
            Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }


    private class ClickHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.buttonCall:
                    try {
                        String number = "tel: +194912344444";
                        Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse(number));
                        startActivity(callIntent);
                    } catch (Exception e) {
                        Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                    break;

                case R.id.buttonWeb:
                    try {
                        Intent viewWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.amazon.com"));
                        String website = "http://www.amazon.com";
                        viewWeb.putExtra("the content", website);
                        Intent chooser = Intent.createChooser(viewWeb, "Choose a browser");
                        startActivity(chooser);
                    } catch (Exception e) {
                        Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                    break;
            }


        }
    }
}

















