package com.example.restaurant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class Seat extends Activity {
	private ImageView aView, bView, cView, dView, eView, fView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.seat);
		aView = (ImageView) findViewById(R.id.a);
		bView = (ImageView) findViewById(R.id.b);
		cView = (ImageView) findViewById(R.id.c);
		dView = (ImageView) findViewById(R.id.d);
		eView = (ImageView) findViewById(R.id.e);
		fView = (ImageView) findViewById(R.id.f);
		aView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent(Seat.this, menu.class));

			}
		});
		bView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent(Seat.this, menu.class));
			}
		});
		cView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent(Seat.this, menu.class));
			}
		});
		dView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent(Seat.this, menu.class));
			}
		});
		eView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent(Seat.this, menu.class));
			}
		});
		fView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent(Seat.this, menu.class));
			}
		});

	}
}
