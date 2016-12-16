package com.example.kuaidian;

import com.example.kuaidian.MainActivity;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button regsiterButton, exitButton, loginButton,cleanButton1,cleanButton2,forgetbtn;
	public String loginName, loginPwd;
	private EditText usernameEditText2, userpwdEditText2;
	private CheckBox rememberpwdBox;
	private SharedPreferences preferences;
	private SharedPreferences.Editor editor;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		rememberpwdBox = (CheckBox) findViewById(R.id.remember_pwd);
		preferences = PreferenceManager
				.getDefaultSharedPreferences(getApplicationContext());
		boolean isRemember = preferences.getBoolean("remember_password", false);
		if (isRemember) {
			String account = preferences.getString("account", "");
			String password = preferences.getString("password", "");
			usernameEditText2.setText(account);
			userpwdEditText2.setText(password);
			rememberpwdBox.setChecked(true);
		}

		usernameEditText2 = (EditText) findViewById(R.id.username);
		cleanButton1 = (Button) findViewById(R.id.bt1_username_clear);
		usernameEditText2.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				cleanButton1.setVisibility(View.VISIBLE);
				cleanButton1.setOnClickListener(new OnClickListener() {
					public void onClick(View arg0) {
						usernameEditText2.setText("");
					}
				});
			}
		});
		userpwdEditText2 = (EditText) findViewById(R.id.password);
		cleanButton2 =(Button) findViewById(R.id.bt2_username_clear);
		userpwdEditText2.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				cleanButton2.setVisibility(View.VISIBLE);
				cleanButton2.setOnClickListener(new OnClickListener() {
					public void onClick(View arg0) {
						userpwdEditText2.setText("");
					}
				});
			}
		});
		
		loginButton = (Button) findViewById(R.id.login);
		loginButton.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				loginName = usernameEditText2.getText().toString();
				loginPwd = userpwdEditText2.getText().toString();

				SharedPreferences preferences = getSharedPreferences("data",
						MODE_PRIVATE);

				if (loginName.equals(preferences.getString("name", ""))
						&& loginPwd.equals(preferences
								.getString("password", ""))) {
					editor = preferences.edit();
					if (rememberpwdBox.isChecked()) {
						editor.putBoolean("remember_password", true);
					} else {
						editor.clear();
					}
					editor.commit();
					Intent intent = new Intent();
					intent.setClass(MainActivity.this, First.class);
					intent.putExtra("userName", loginName);
					startActivity(intent);
					MainActivity.this.finish();
				} else if (loginName.length() == 0 || loginPwd.length() == 0) {
					Toast.makeText(getApplicationContext(), "输入不能为空",
							Toast.LENGTH_SHORT).show();
				} else {
					Toast.makeText(getApplicationContext(), "用户名或密码不对",
							Toast.LENGTH_LONG).show();
				}
			}
		});

		regsiterButton = (Button) findViewById(R.id.register);
		regsiterButton.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, Regsiter.class);
				startActivity(intent);
				MainActivity.this.finish();

			}
		});

		exitButton = (Button) findViewById(R.id.exit);
		exitButton.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				new AlertDialog.Builder(MainActivity.this)
						.setTitle("退出提示")
						.setMessage("确定要退出?")
						.setPositiveButton("确定",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface arg0,
											int arg1) {
										finish();
									}
								})
						.setNegativeButton("取消",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface arg0,
											int arg1) {

									}
								}).show();

			}
		});
		forgetbtn=(Button)findViewById(R.id.forgetpwd);
		forgetbtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(MainActivity.this,Forgetpwd.class);
				startActivity(intent);
				MainActivity.this.finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
