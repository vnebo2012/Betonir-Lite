package com.betonirlite.nikolay.betonir;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PlusActivity extends AppCompatActivity {

    EditText edittextEmailAddress;
    EditText edittextEmailSubject;
    EditText edittextEmailText;
    TextView textImagePath;

    final int RQS_LOADIMAGE = 0;

    Uri imageUri = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plus);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Toolbar my_toolbar4 = (Toolbar)findViewById(R.id.my_toolbar7);
        setSupportActionBar(my_toolbar4);

        getSupportActionBar().setTitle(R.string.web_plus);


        my_toolbar4.setNavigationIcon(R.mipmap.ic_12);

        my_toolbar4.setNavigationOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent a = new Intent(PlusActivity.this,MainActivity.class);
                a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(a);
            }
        });

        //String a = "betonir1@gmail.com";
        //mWebView.loadUrl (a + " ");
       // edittextEmailAddress = (a);
        //edittextEmailAddress = (EditText) findViewById(R.id.email_address);
        edittextEmailSubject = (EditText) findViewById(R.id.email_subject);
        edittextEmailText = (EditText) findViewById(R.id.email_text);
        textImagePath = (TextView) findViewById(R.id.imagepath);

    }

    public void onSelectImageClick(View v) {
        Intent intent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        Animation anim1 = AnimationUtils.loadAnimation(
                  getApplicationContext(), R.anim.scale);
          final Button button1 = (Button) findViewById(R.id.selectimage);
           button1.startAnimation(anim1);
        startActivityForResult(intent, RQS_LOADIMAGE);
    }

    public void onEmailClick(View v) {
        String emailAddress = "betonir1@gmail.com";
        String emailSubject = edittextEmailSubject.getText().toString();
        String emailText = edittextEmailText.getText().toString();
        String emailAddressList[] = { emailAddress };

        Intent intent = new Intent(Intent.ACTION_SEND);

        intent.putExtra(Intent.EXTRA_EMAIL, emailAddressList);
        intent.putExtra(Intent.EXTRA_SUBJECT, emailSubject);
        intent.putExtra(Intent.EXTRA_TEXT, emailText);

        if (imageUri != null) {
            intent.putExtra(Intent.EXTRA_STREAM, imageUri);
            intent.setType("image/png");
        } else {
            intent.setType("plain/text");
        }

        startActivity(Intent.createChooser(intent, "Отправить с помощью:"));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case RQS_LOADIMAGE:
                    imageUri = data.getData();
                    textImagePath.setText(imageUri.toString());
                    break;
            }
        }
    }
    @Override
    public void onBackPressed() {
        // do something on back.

        Intent a = new Intent(this,MainActivity.class);
        a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(a);
    }
}
