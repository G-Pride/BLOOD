package com.example.kuaidian;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class First extends Activity{
	private TextView usernameTextView;
	private Button enterButton,exitButton;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.first);
		
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowHomeEnabled(true);
		actionBar.setDisplayHomeAsUpEnabled(true);
		
		usernameTextView = (TextView) findViewById(R.id.tV_userName);
		Intent intent1 = getIntent();
		usernameTextView.setText("" + intent1.getStringExtra("userName"));
		exitButton = (Button) findViewById(R.id.bt_exit);
		exitButton.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setClass(First.this, MainActivity.class);
				startActivity(intent);
				First.this.finish();
				
			}
		});
		enterButton = (Button) findViewById(R.id.bt_enter);
		enterButton.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setClass(First.this, ShopCar.class);
				startActivity(intent);
				First.this.finish();
				
			}
		});
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case android.R.id.home:
			Intent intent = new Intent(this, MainActivity.class);
			// 添加额外的Flag，将Activity栈中处于MainActivity之上的Activity弹出
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);

			break;

		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}

