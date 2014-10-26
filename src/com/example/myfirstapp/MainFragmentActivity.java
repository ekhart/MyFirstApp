package com.example.myfirstapp;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class MainFragmentActivity extends FragmentActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.news_articles);
	}
}
