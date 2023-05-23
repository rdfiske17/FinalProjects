package com.example.cobbersecure

import android.os.Bundle
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import kotlin.Int

public class NotificationsFragmentDirections private constructor() {
  private data class ActionNotificationsFragmentToEditFriendFragment(
    public val friendNumber: Int
  ) : NavDirections {
    public override val actionId: Int = R.id.action_notificationsFragment_to_editFriendFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putInt("friendNumber", this.friendNumber)
        return result
      }
  }

  public companion object {
    public fun actionNotificationsFragmentToEditFriendFragment(friendNumber: Int): NavDirections =
        ActionNotificationsFragmentToEditFriendFragment(friendNumber)

    public fun actionNotificationsFragmentToMapFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_notificationsFragment_to_mapFragment)
  }
}
