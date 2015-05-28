package com.test.propertyfinder.Utils;

public abstract class CancelableRunnable implements Runnable {

	protected boolean mCancelled;

	public void cancel() {
		mCancelled = true;
		onCancelled();
	}

	public abstract void onCancelled();

}
