package com.example.cobbersecure

import android.os.Bundle
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import kotlin.Int

public class HomeFragmentDirections private constructor() {
  private data class ActionHomeFragmentToProfileFragment(
    public val userId: Int
  ) : NavDirections {
    public override val actionId: Int = R.id.action_homeFragment_to_profileFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putInt("user_id", this.userId)
        return result
      }
  }

  public companion object {
    public fun actionHomeFragmentToResourcesFragment2(): NavDirections =
        ActionOnlyNavDirections(R.id.action_homeFragment_to_resourcesFragment2)

    public fun actionHomeFragmentToNotificationsFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_homeFragment_to_notificationsFragment)

    public fun actionHomeFragmentToSettingsFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_homeFragment_to_settingsFragment)

    public fun actionHomeFragmentToProfileFragment(userId: Int): NavDirections =
        ActionHomeFragmentToProfileFragment(userId)

    public fun actionHomeFragmentToFriendListFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_homeFragment_to_friendListFragment)

    public fun actionHomeFragmentToReportIncidentFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_homeFragment_to_reportIncidentFragment)

    public fun actionHomeFragmentToMapFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_homeFragment_to_mapFragment)

    public fun actionHomeFragmentToLoginFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_homeFragment_to_loginFragment)
  }
}
