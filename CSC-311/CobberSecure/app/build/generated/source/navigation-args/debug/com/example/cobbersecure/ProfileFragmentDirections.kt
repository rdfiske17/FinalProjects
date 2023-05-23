package com.example.cobbersecure

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections

public class ProfileFragmentDirections private constructor() {
  public companion object {
    public fun actionProfileFragmentToFriendListFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_profileFragment_to_friendListFragment)

    public fun actionProfileFragmentToProfileEditFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_profileFragment_to_profileEditFragment)

    public fun actionProfileFragmentToNotificationsFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_profileFragment_to_notificationsFragment)
  }
}
