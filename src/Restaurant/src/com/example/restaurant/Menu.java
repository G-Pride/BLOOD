package com.example.restaurant;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class menu extends Activity {
	Button menu,help,quit;
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.menu);
	menu=(Button)findViewById(R.id.menu);
	help=(Button)findViewById(R.id.help);
	quit=(Button)findViewById(R.id.quit);
	menu.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			setContentView(R.layout.cai);
		}
	});
	help.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			
		}
	});
quit.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			setContentView(R.layout.activity_main);
		}
	});
}
}
