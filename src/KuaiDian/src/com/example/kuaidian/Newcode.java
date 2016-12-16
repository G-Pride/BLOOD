package com.example.kuaidian;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Newcode extends Activity{
	private EditText new1;
	private Button finish1;
	@Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.newcode);  
  
        new1 = (EditText) findViewById(R.id.editText1);  
        finish1= (Button) findViewById(R.id.button1);  
        finish1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 Intent intent =new Intent(Newcode.this,MainActivity.class);
	                startActivity(intent);
	                Newcode.this.finish();
			}
		});
    }  
}
