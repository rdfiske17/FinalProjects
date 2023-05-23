package com.example.cobbersecure

import android.os.Bundle
import androidx.navigation.NavDirections
import kotlin.Int

public class ProfileEditFragmentDirections private constructor() {
  private data class ActionProfileEditFragmentToProfileFragment(
    public val userId: Int
  ) : NavDirections {
    public override val actionId: Int = R.id.action_profileEditFragment_to_profileFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putInt("user_id", this.userId)
        return result
      }
  }

  public companion object {
    public fun actionProfileEditFragmentToProfileFragment(userId: Int): NavDirections =
        ActionProfileEditFragmentToProfileFragment(userId)
  }
}
