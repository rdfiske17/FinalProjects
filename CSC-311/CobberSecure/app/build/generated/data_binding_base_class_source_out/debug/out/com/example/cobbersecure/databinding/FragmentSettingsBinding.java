// Generated by view binder compiler. Do not edit!
package com.example.cobbersecure.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.cobbersecure.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentSettingsBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView AlarmDesc;

  @NonNull
  public final TextView OptionsTitle;

  @NonNull
  public final TextView alarmVolumeDesc;

  @NonNull
  public final SeekBar alarmVolumeSeekBar;

  @NonNull
  public final SwitchCompat allNotificationsSwitch;

  @NonNull
  public final SwitchCompat dangerousAreaNotificationsSwitch;

  @NonNull
  public final SwitchCompat darkModeSwitch;

  @NonNull
  public final SwitchCompat emergencyNotificationsSwitch;

  @NonNull
  public final SwitchCompat friendsNotificationsSwitch;

  @NonNull
  public final Button settingsLogin;

  private FragmentSettingsBinding(@NonNull LinearLayout rootView, @NonNull TextView AlarmDesc,
      @NonNull TextView OptionsTitle, @NonNull TextView alarmVolumeDesc,
      @NonNull SeekBar alarmVolumeSeekBar, @NonNull SwitchCompat allNotificationsSwitch,
      @NonNull SwitchCompat dangerousAreaNotificationsSwitch, @NonNull SwitchCompat darkModeSwitch,
      @NonNull SwitchCompat emergencyNotificationsSwitch,
      @NonNull SwitchCompat friendsNotificationsSwitch, @NonNull Button settingsLogin) {
    this.rootView = rootView;
    this.AlarmDesc = AlarmDesc;
    this.OptionsTitle = OptionsTitle;
    this.alarmVolumeDesc = alarmVolumeDesc;
    this.alarmVolumeSeekBar = alarmVolumeSeekBar;
    this.allNotificationsSwitch = allNotificationsSwitch;
    this.dangerousAreaNotificationsSwitch = dangerousAreaNotificationsSwitch;
    this.darkModeSwitch = darkModeSwitch;
    this.emergencyNotificationsSwitch = emergencyNotificationsSwitch;
    this.friendsNotificationsSwitch = friendsNotificationsSwitch;
    this.settingsLogin = settingsLogin;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentSettingsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentSettingsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_settings, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentSettingsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.AlarmDesc;
      TextView AlarmDesc = ViewBindings.findChildViewById(rootView, id);
      if (AlarmDesc == null) {
        break missingId;
      }

      id = R.id.OptionsTitle;
      TextView OptionsTitle = ViewBindings.findChildViewById(rootView, id);
      if (OptionsTitle == null) {
        break missingId;
      }

      id = R.id.alarmVolumeDesc;
      TextView alarmVolumeDesc = ViewBindings.findChildViewById(rootView, id);
      if (alarmVolumeDesc == null) {
        break missingId;
      }

      id = R.id.alarmVolumeSeekBar;
      SeekBar alarmVolumeSeekBar = ViewBindings.findChildViewById(rootView, id);
      if (alarmVolumeSeekBar == null) {
        break missingId;
      }

      id = R.id.allNotificationsSwitch;
      SwitchCompat allNotificationsSwitch = ViewBindings.findChildViewById(rootView, id);
      if (allNotificationsSwitch == null) {
        break missingId;
      }

      id = R.id.dangerousAreaNotificationsSwitch;
      SwitchCompat dangerousAreaNotificationsSwitch = ViewBindings.findChildViewById(rootView, id);
      if (dangerousAreaNotificationsSwitch == null) {
        break missingId;
      }

      id = R.id.darkModeSwitch;
      SwitchCompat darkModeSwitch = ViewBindings.findChildViewById(rootView, id);
      if (darkModeSwitch == null) {
        break missingId;
      }

      id = R.id.emergencyNotificationsSwitch;
      SwitchCompat emergencyNotificationsSwitch = ViewBindings.findChildViewById(rootView, id);
      if (emergencyNotificationsSwitch == null) {
        break missingId;
      }

      id = R.id.friendsNotificationsSwitch;
      SwitchCompat friendsNotificationsSwitch = ViewBindings.findChildViewById(rootView, id);
      if (friendsNotificationsSwitch == null) {
        break missingId;
      }

      id = R.id.settings_login;
      Button settingsLogin = ViewBindings.findChildViewById(rootView, id);
      if (settingsLogin == null) {
        break missingId;
      }

      return new FragmentSettingsBinding((LinearLayout) rootView, AlarmDesc, OptionsTitle,
          alarmVolumeDesc, alarmVolumeSeekBar, allNotificationsSwitch,
          dangerousAreaNotificationsSwitch, darkModeSwitch, emergencyNotificationsSwitch,
          friendsNotificationsSwitch, settingsLogin);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
