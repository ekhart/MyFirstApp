package com.example.myfirstapp;

import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

public class DisplayMessageActivity
	extends ActionBarActivity {

	//lifecycle 1.
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//set the user interface layout for this Activity
		//the layout file is defined in the procject res/layout/*.xml
		setContentView(R.layout.activity_display_message);

		// Show the Up button in the action bar.
		//setupActionBar();
		
		//if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			ActionBar bar = getSupportActionBar();
			bar.setDisplayHomeAsUpEnabled(true);			
		//}
		
		//for older version
//		if (savedInstanceState == null) {
//			getSupportFragmentManager()
//				.beginTransaction()
//				.add(R.id.container, new PlaceholderFragment())
//				.commit();
//		}
		
		String hello = getResources().getString(R.string.hello_world);
		
		Intent intent = getIntent();
		String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
		
		TextView textView = new TextView(this);
		textView.setTextSize(40);
		textView.setText(message + "\n" + hello);
		
		setContentView(textView);
	}
	
	//lifecycle 2.
	@Override
	protected void onStart() {
		//activity visible
		
		LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		boolean gpsEnabled = manager.isProviderEnabled(LocationManager.GPS_PROVIDER);
		if (!gpsEnabled) {
			//create a dialog here thath requests the user to enable gps,
			// and use an intent with the android.provider.settings.ACTION_LOCATION_SETTINGS
			//action to take the user to the setting screen to enable
			//gps when they click "ok"
		}
	};
	
	//lifecycle 3.
	@Override
	protected void onResume() {
		//visible, active
		
		//activity become active, foreground
		super.onResume();
		
//		if (mCamera == null) {
//			initializeCamera();
//		}
	};

	@Override 
	protected void onPause() {
		//resumed -> paused state (visible, inactive)
		//perform clean up
		
		//ex: open dialog
		//stop animations, commit changes (autosave), release resources
		super.onPause();
		
//		if (mCamera != null) {
//			mCamera.release();
//			mCamera = null;
//		}
	};
	
	@Override
	protected void onStop() {
		//paused -> stopped (hidden)
		//perform clean up
		
		//app switched, started to another by user
		super.onStop();
		
		//Save the note's current draft, because the activity is stopping
		//and we want to be sure the current note progress isnt lost
//		ContentValues values = new ContentValues();
//		values.put(Notepad.Notes.COLUMN_NAME_NOTE, getCurrentNoteText());
//		values.put(Notepad.Notes.COLUMN_NAME_TITLE, getCurrentNoteTitle());
//	
//		getContentResolver().update(
//				uri,		// uri for note to update 
//				values, 	// map of column names and new values
//				null, 		// no select criteria are used
//				null);		// no where columns are used
	};
	
	@Override
	protected void onRestart() {
		//stopped -> started //before onStart
		
		//app switched to this from another
		super.onRestart();
	};
	
	@Override
	protected void onDestroy() {
		//destroyed
		//background thread, long-running resource - memory leak
		super.onDestroy();
		
		//Stop method tracing that activity started during onCreate
		android.os.Debug.stopMethodTracing();
		
	};
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		//resumed -> destroyed
		
		//save activity state
		//automatically save edittext, scroll etc
		
		
//		savedInstanceState.putInt(STATE_SCORE, mCurrentScore);
//		savedInstanceState.putInt(STATE_LEVEL, mCurrentLevel);
		
		super.onSaveInstanceState(outState);
	};
	
	
	static final String STATE_SCORE = "playerScore",
			STATE_LEVEL = "playerLevel";
	
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		//created -> resumed
		//same bundle as in onCreate
		//dont need to check if bundle is null
		
//		super.onRestoreInstanceState(savedInstanceState);
//		   
//	    // Restore state members from saved instance
//	    mCurrentScore = savedInstanceState.getInt(STATE_SCORE);
//	    mCurrentLevel = savedInstanceState.getInt(STATE_LEVEL);
	};
	
	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_message, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
