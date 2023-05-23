package com.example.cobbersecure

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections

public class MapFragmentDirections private constructor() {
  public companion object {
    public fun actionMapFragmentToReportIncidentFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_mapFragment_to_reportIncidentFragment)
  }
}
