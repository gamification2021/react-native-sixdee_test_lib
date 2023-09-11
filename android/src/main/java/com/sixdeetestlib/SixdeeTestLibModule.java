package com.sixdeetestlib;

import android.content.Intent;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.sixdeetestlib.gamification.ui.MainActivity;

@ReactModule(name = SixdeeTestLibModule.NAME)
public class SixdeeTestLibModule extends ReactContextBaseJavaModule {
  public static final String NAME = "SixdeeTestLib";

  public SixdeeTestLibModule(ReactApplicationContext reactContext) {
    super(reactContext);
  }

  @Override
  @NonNull
  public String getName() {
    return NAME;
  }

  // Example method
  // See https://reactnative.dev/docs/native-modules-android
  @ReactMethod
  public void loadActivity(Promise promise) {
    Intent i = new Intent(getCurrentActivity(), MainActivity.class);
    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    getCurrentActivity().startActivity(i);
    promise.resolve("activity loaded...");
  }
}
