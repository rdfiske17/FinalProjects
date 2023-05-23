package com.example.cobbersecure

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.Int
import kotlin.jvm.JvmStatic

public data class ProfileFragmentArgs(
  public val userId: Int
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putInt("user_id", this.userId)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("user_id", this.userId)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): ProfileFragmentArgs {
      bundle.setClassLoader(ProfileFragmentArgs::class.java.classLoader)
      val __userId : Int
      if (bundle.containsKey("user_id")) {
        __userId = bundle.getInt("user_id")
      } else {
        throw IllegalArgumentException("Required argument \"user_id\" is missing and does not have an android:defaultValue")
      }
      return ProfileFragmentArgs(__userId)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): ProfileFragmentArgs {
      val __userId : Int?
      if (savedStateHandle.contains("user_id")) {
        __userId = savedStateHandle["user_id"]
        if (__userId == null) {
          throw IllegalArgumentException("Argument \"user_id\" of type integer does not support null values")
        }
      } else {
        throw IllegalArgumentException("Required argument \"user_id\" is missing and does not have an android:defaultValue")
      }
      return ProfileFragmentArgs(__userId)
    }
  }
}
