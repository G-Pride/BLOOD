package com.example.kuaidian;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Regsiter extends Activity {
	private Button regsiterButton, cleanButton3, cleanButton4,cleanButton5;
	public String loginName, loginPwd1,loginPwd2;
	private EditText usernameEditText1, userpwdEditText1,userpwdEditText2;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.regsiter);

		ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowHomeEnabled(true);
		actionBar.setDisplayHomeAsUpEnabled(true);

		usernameEditText1 = (EditText) findViewById(R.id.username);
		cleanButton3 = (Button) findViewById(R.id.bt3_username_clear);
		usernameEditText1.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				loginName = usernameEditText1.getText().toString();
				cleanButton3.setVisibility(View.VISIBLE);					
					cleanButton3.setOnClickListener(new OnClickListener() {
						public void onClick(View arg0) {
							usernameEditText1.setText("");
						}
					});
			}
		});
		
		userpwdEditText2 = (EditText) findViewById(R.id.password3);
		cleanButton5 = (Button) findViewById(R.id.bt5_username_clear);
		userpwdEditText2.setOnClickListener(new OnClickListener() {			
			public void onClick(View arg0) {
				loginPwd2 = userpwdEditText2.getText().toString();
				cleanButton5.setVisibility(View.VISIBLE);					
					cleanButton5.setOnClickListener(new OnClickListener() {
						public void onClick(View arg0) {
							userpwdEditText2.setText("");
						}
					});				
			}
		});

		userpwdEditText1 = (EditText) findViewById(R.id.password2);
		cleanButton4 = (Button) findViewById(R.id.bt4_username_clear);
		userpwdEditText1.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				loginPwd1 = userpwdEditText1.getText().toString();
				cleanButton4.setVisibility(View.VISIBLE);			
					cleanButton4.setOnClickListener(new OnClickListener() {
						public void onClick(View arg0) {
							userpwdEditText1.setText("");
						}
					});
							}
		});

		regsiterButton = (Button) findViewById(R.id.regsiter);
		regsiterButton.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				loginName = usernameEditText1.getText().toString();
				loginPwd1 = userpwdEditText1.getText().toString();
				loginPwd2 = userpwdEditText2.getText().toString();
				if (loginName.length() == 0 || loginPwd1.length() == 0||loginPwd2.length()==0) {
					Toast.makeText(getApplicationContext(), "输入不能为空",
							Toast.LENGTH_SHORT).show();
				}
				
				else if(loginPwd1.equals(loginPwd2)){
					Toast.makeText(getApplicationContext(), "注册成功",
							Toast.LENGTH_SHORT).show();
					SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
					editor.putString("name", loginName);
					editor.putString("password", loginPwd1);
					editor.commit();
					finish();
					Intent intent = new Intent();
					intent.setClass(Regsiter.this, MainActivity.class);
					startActivity(intent);
					Regsiter.this.finish();

				}
				else  {
					Toast.makeText(getApplicationContext(), "密码不一致",
							Toast.LENGTH_SHORT).show();
				} 

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
