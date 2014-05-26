package com.relayr.core.storage;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.relayr.Relayr_Application;
import com.relayr.core.user.Relayr_User;


public class Relayr_DataStorage {

	static SharedPreferences localStorage;
	static String storageIdentifier = "relayrPreferences";
	static String tokenField = "RELAYR_TOKEN";

	public static void saveLocalData() {
		Activity currentActivity = Relayr_Application.currentActivity();
		localStorage = currentActivity.getSharedPreferences(storageIdentifier, Context.MODE_PRIVATE);
		Editor edit = localStorage.edit();
		edit.putString(tokenField, Relayr_User.getUserToken());
		edit.apply();
	}

	public static void loadLocalData() {
		Activity currentActivity = Relayr_Application.currentActivity();
		localStorage = currentActivity.getSharedPreferences(storageIdentifier, Context.MODE_PRIVATE);
		Relayr_User.setToken(localStorage.getString(tokenField, null));
	}
}
