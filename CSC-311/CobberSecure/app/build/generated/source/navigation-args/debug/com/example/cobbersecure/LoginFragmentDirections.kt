package com.example.cobbersecure

import android.os.Bundle
import androidx.navigation.NavDirections
import kotlin.Int

public class LoginFragmentDirections private constructor() {
  private data class ActionLoginFragmentToProfileFragment(
    public val userId: Int
  ) : NavDirections {
    public override val actionId: Int = R.id.action_loginFragment_to_profileFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putInt("user_id", this.userId)
        return result
      }
  }

  public companion object {
    public fun actionLoginFragmentToProfileFragment(userId: Int): NavDirections =
        ActionLoginFragmentToProfileFragment(userId)
  }
}
