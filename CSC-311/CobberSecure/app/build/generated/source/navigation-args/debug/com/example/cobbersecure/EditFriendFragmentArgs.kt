package com.example.cobbersecure

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.Int
import kotlin.jvm.JvmStatic

public data class EditFriendFragmentArgs(
  public val friendNumber: Int
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putInt("friendNumber", this.friendNumber)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("friendNumber", this.friendNumber)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): EditFriendFragmentArgs {
      bundle.setClassLoader(EditFriendFragmentArgs::class.java.classLoader)
      val __friendNumber : Int
      if (bundle.containsKey("friendNumber")) {
        __friendNumber = bundle.getInt("friendNumber")
      } else {
        throw IllegalArgumentException("Required argument \"friendNumber\" is missing and does not have an android:defaultValue")
      }
      return EditFriendFragmentArgs(__friendNumber)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): EditFriendFragmentArgs {
      val __friendNumber : Int?
      if (savedStateHandle.contains("friendNumber")) {
        __friendNumber = savedStateHandle["friendNumber"]
        if (__friendNumber == null) {
          throw IllegalArgumentException("Argument \"friendNumber\" of type integer does not support null values")
        }
      } else {
        throw IllegalArgumentException("Required argument \"friendNumber\" is missing and does not have an android:defaultValue")
      }
      return EditFriendFragmentArgs(__friendNumber)
    }
  }
}
