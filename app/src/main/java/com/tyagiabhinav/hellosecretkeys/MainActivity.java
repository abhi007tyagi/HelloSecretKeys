package com.tyagiabhinav.hellosecretkeys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static {
        System.loadLibrary("keys");
    }

    public native String getNativeKey1();
    public native String getNativeKey2();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String key1 = new String(Base64.decode(getNativeKey1(),Base64.DEFAULT));
        String key2 = new String(Base64.decode(getNativeKey2(),Base64.DEFAULT));

        ((TextView)findViewById(R.id.key)).setText("Key1-->"+key1+"\nKey2-->"+key2);
    }
}
