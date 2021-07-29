package com.example.caller_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText text;
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bstar,bhash,bsave,bcall,bdel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=(EditText)findViewById(R.id.inputtxt) ;
        b1=findViewById(R.id.btn1);
        b2=findViewById(R.id.btn2);
        b3=findViewById(R.id.btn3);
        b4=findViewById(R.id.btn4);
        b5=findViewById(R.id.btn5);
        b6=findViewById(R.id.btn6);
        b7=findViewById(R.id.btn7);
        b8=findViewById(R.id.btn8);
        b9=findViewById(R.id.btn9);
        b0=findViewById(R.id.button0);
        bstar=findViewById(R.id.btn10);
        bhash=findViewById(R.id.button12);
        bsave=findViewById(R.id.btnsave);
        bcall=findViewById(R.id.btncall);
        bdel=findViewById(R.id.btndel);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        b0.setOnClickListener(this);
        bstar.setOnClickListener(this);
        bhash.setOnClickListener(this);
        bcall.setOnClickListener(this);
        bsave.setOnClickListener(this);
        bdel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.equals(b1))
            text.append("1"+"");
        else if (v.equals(b2))
            text.append("2"+"");
        else if (v.equals(b3))
            text.append("3"+"");
        else if (v.equals(b4))
            text.append("4"+"");
        else if (v.equals(b5))
            text.append("5"+"");
        else if (v.equals(b6))
            text.append("6"+"");
        else if (v.equals(b7))
            text.append("7"+"");
        else if (v.equals(b8))
            text.append("8"+"");
        else if (v.equals(b9))
            text.append("9"+"");
        else if (v.equals(b0))
            text.append("0"+"");
        else if (v.equals(bstar))
            text.append("*"+"");
        else if (v.equals(bhash))
            text.append("#"+"");
        else if (v.equals(bsave)) {
            Intent contactIntent = new Intent(ContactsContract.Intents.Insert.ACTION);
            contactIntent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
            contactIntent.putExtra(ContactsContract.Intents.Insert.NAME, "UNKNOWN");
            contactIntent.putExtra(ContactsContract.Intents.Insert.PHONE, text.getText().toString());
            startActivity(contactIntent);
        }
        else if (v.equals(bdel))
        {
            String data = text.getText().toString();
            if(data.length()>0)
                text.setText(data.substring(0,data.length()-1));
        }
        else if(v.equals(bcall))
        {
            String data=text.getText().toString();
            Intent intent=new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel"+data));
            startActivity(intent);
        }
        else
            text.setText("");

    }
}