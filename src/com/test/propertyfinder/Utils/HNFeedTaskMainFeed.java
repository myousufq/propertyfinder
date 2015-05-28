package com.test.propertyfinder.Utils;

import android.app.Activity;
import android.content.Context;

import com.test.propertyfinder.Model.PFFeed;

public class HNFeedTaskMainFeed extends HNFeedTaskBase {

	private static HNFeedTaskMainFeed instance;
	public static final String BROADCAST_INTENT_ID = "HNFeedMain";

	private static HNFeedTaskMainFeed getInstance(int taskCode) {
		synchronized (HNFeedTaskBase.class) {
			if (instance == null)
				instance = new HNFeedTaskMainFeed(taskCode);
		}
		return instance;
	}

	private HNFeedTaskMainFeed(int taskCode) {
		super(BROADCAST_INTENT_ID, taskCode);
	}

	@Override
	protected String getFeedURL() {
		return "https://www.propertyfinder.ae/mobileapi";
	}

	public static void startOrReattach(Activity activity,
			ITaskFinishedHandler<PFFeed> finishedHandler, int taskCode) {
		
		HNFeedTaskMainFeed task = getInstance(taskCode);
		task.setOnFinishedHandler(activity, finishedHandler, PFFeed.class);
		if (!task.isRunning())
			task.startInBackground();
		
	}

	public static void stopCurrent(Context applicationContext) {
		getInstance(0).cancel();
	}

	public static boolean isRunning(Context applicationContext) {
		return getInstance(0).isRunning();
	}

}
