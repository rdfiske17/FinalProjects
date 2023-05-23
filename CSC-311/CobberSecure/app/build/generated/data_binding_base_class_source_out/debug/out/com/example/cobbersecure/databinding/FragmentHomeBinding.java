// Generated by view binder compiler. Do not edit!
package com.example.cobbersecure.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.cobbersecure.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentHomeBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final Button home911;

  @NonNull
  public final ImageView homeAlarm;

  @NonNull
  public final Button homeCampusSecurity;

  @NonNull
  public final Button homeFireDept;

  @NonNull
  public final Button homeFriendpage;

  @NonNull
  public final Button homeLogin;

  @NonNull
  public final Button homeMap;

  @NonNull
  public final ImageView homeNotifications;

  @NonNull
  public final Button homeProfile;

  @NonNull
  public final Button homeReportIncident;

  @NonNull
  public final Button homeResources;

  @NonNull
  public final ImageView homeSettings;

  @NonNull
  public final TextView homeTitle;

  private FragmentHomeBinding(@NonNull FrameLayout rootView, @NonNull Button home911,
      @NonNull ImageView homeAlarm, @NonNull Button homeCampusSecurity,
      @NonNull Button homeFireDept, @NonNull Button homeFriendpage, @NonNull Button homeLogin,
      @NonNull Button homeMap, @NonNull ImageView homeNotifications, @NonNull Button homeProfile,
      @NonNull Button homeReportIncident, @NonNull Button homeResources,
      @NonNull ImageView homeSettings, @NonNull TextView homeTitle) {
    this.rootView = rootView;
    this.home911 = home911;
    this.homeAlarm = homeAlarm;
    this.homeCampusSecurity = homeCampusSecurity;
    this.homeFireDept = homeFireDept;
    this.homeFriendpage = homeFriendpage;
    this.homeLogin = homeLogin;
    this.homeMap = homeMap;
    this.homeNotifications = homeNotifications;
    this.homeProfile = homeProfile;
    this.homeReportIncident = homeReportIncident;
    this.homeResources = homeResources;
    this.homeSettings = homeSettings;
    this.homeTitle = homeTitle;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_home, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentHomeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.home_911;
      Button home911 = ViewBindings.findChildViewById(rootView, id);
      if (home911 == null) {
        break missingId;
      }

      id = R.id.home_alarm;
      ImageView homeAlarm = ViewBindings.findChildViewById(rootView, id);
      if (homeAlarm == null) {
        break missingId;
      }

      id = R.id.home_campus_security;
      Button homeCampusSecurity = ViewBindings.findChildViewById(rootView, id);
      if (homeCampusSecurity == null) {
        break missingId;
      }

      id = R.id.home_fire_dept;
      Button homeFireDept = ViewBindings.findChildViewById(rootView, id);
      if (homeFireDept == null) {
        break missingId;
      }

      id = R.id.home_friendpage;
      Button homeFriendpage = ViewBindings.findChildViewById(rootView, id);
      if (homeFriendpage == null) {
        break missingId;
      }

      id = R.id.home_login;
      Button homeLogin = ViewBindings.findChildViewById(rootView, id);
      if (homeLogin == null) {
        break missingId;
      }

      id = R.id.home_map;
      Button homeMap = ViewBindings.findChildViewById(rootView, id);
      if (homeMap == null) {
        break missingId;
      }

      id = R.id.home_notifications;
      ImageView homeNotifications = ViewBindings.findChildViewById(rootView, id);
      if (homeNotifications == null) {
        break missingId;
      }

      id = R.id.home_profile;
      Button homeProfile = ViewBindings.findChildViewById(rootView, id);
      if (homeProfile == null) {
        break missingId;
      }

      id = R.id.home_report_incident;
      Button homeReportIncident = ViewBindings.findChildViewById(rootView, id);
      if (homeReportIncident == null) {
        break missingId;
      }

      id = R.id.home_resources;
      Button homeResources = ViewBindings.findChildViewById(rootView, id);
      if (homeResources == null) {
        break missingId;
      }

      id = R.id.home_settings;
      ImageView homeSettings = ViewBindings.findChildViewById(rootView, id);
      if (homeSettings == null) {
        break missingId;
      }

      id = R.id.home_title;
      TextView homeTitle = ViewBindings.findChildViewById(rootView, id);
      if (homeTitle == null) {
        break missingId;
      }

      return new FragmentHomeBinding((FrameLayout) rootView, home911, homeAlarm, homeCampusSecurity,
          homeFireDept, homeFriendpage, homeLogin, homeMap, homeNotifications, homeProfile,
          homeReportIncident, homeResources, homeSettings, homeTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}