package com.mycompany.test;

import com.unity3d.ads.android.UnityAds;
import com.unity3d.ads.android.campaign.IUnityAdsCampaignListener;
import com.unity3d.ads.android.properties.UnityAdsConstants;

import com.mycompany.test.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class UnityAdsTestStartActivity extends Activity implements IUnityAdsCampaignListener {
	private UnityAds ai = null;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	Log.d(UnityAdsConstants.LOG_NAME, "UnityAdsTestStartActivity->onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ((ImageView)findViewById(R.id.playbtn)).setAlpha(80);
		Log.d(UnityAdsConstants.LOG_NAME, "Init Unity Ads");
		ai = new UnityAds(this, "16");
		ai.setCampaignListener(this);
		ai.init();
    }
    
    @Override
    public void onResume () {
    	Log.d(UnityAdsConstants.LOG_NAME, "UnityAdsTestStartActivity->onResume()");
    	super.onResume();
		UnityAds.instance.changeActivity(this);
    }
    
	@Override
	public boolean onCreateOptionsMenu (Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.layout.menu, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected (MenuItem item) {
		switch (item.getItemId()) {
			case R.id.kill:
				finish();
				break;
		}
		
		return true;
	}
	
    @Override
	protected void onDestroy() {
    	Log.d(UnityAdsConstants.LOG_NAME, "UnityAdsTestStartActivity->onDestroy()");
    	//ai.stopAll();
    	//System.runFinalizersOnExit(true);		
		//android.os.Process.killProcess(android.os.Process.myPid());
    	super.onDestroy();		
	}
	
    @Override
	public void onFetchCompleted () {
    	Log.d(UnityAdsConstants.LOG_NAME, "UnityAdsTestStartActivity->onFetchCompleted()");
    	((ImageView)findViewById(R.id.playbtn)).setAlpha(255);
    	((ImageView)findViewById(R.id.playbtn)).setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				Intent newIntent = new Intent(getBaseContext(), UnityAdsGameActivity.class);
				newIntent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION | Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(newIntent);
			}
		});  
	}
}