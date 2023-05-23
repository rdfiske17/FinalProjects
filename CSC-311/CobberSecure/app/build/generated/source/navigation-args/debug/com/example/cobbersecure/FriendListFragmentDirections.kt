package com.example.cobbersecure

import android.os.Bundle
import androidx.navigation.NavDirections
import kotlin.Int

public class FriendListFragmentDirections private constructor() {
  private data class ActionFriendListFragmentToEditFriendFragment(
    public val friendNumber: Int
  ) : NavDirections {
    public override val actionId: Int = R.id.action_friendListFragment_to_editFriendFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putInt("friendNumber", this.friendNumber)
        return result
      }
  }

  public companion object {
    public fun actionFriendListFragmentToEditFriendFragment(friendNumber: Int): NavDirections =
        ActionFriendListFragmentToEditFriendFragment(friendNumber)
  }
}
