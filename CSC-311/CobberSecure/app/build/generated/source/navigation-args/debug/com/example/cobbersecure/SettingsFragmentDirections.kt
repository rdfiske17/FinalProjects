package com.example.cobbersecure

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections

public class SettingsFragmentDirections private constructor() {
  public companion object {
    public fun actionSettingsFragmentToHomeFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_settingsFragment_to_homeFragment)

    public fun actionSettingsFragmentToLoginFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_settingsFragment_to_loginFragment)
  }
}
