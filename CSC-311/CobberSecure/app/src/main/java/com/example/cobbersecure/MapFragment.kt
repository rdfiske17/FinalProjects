package com.example.cobbersecure

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.cobbersecure.databinding.FragmentMapBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

class MapFragment : Fragment(), OnMapReadyCallback, GoogleMap.OnMapLongClickListener,
    GoogleMap.OnMapClickListener, GoogleMap.OnMarkerClickListener {

    private lateinit var mMap: GoogleMap
    private lateinit var mapView: MapView
    private var _binding: FragmentMapBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMapBinding.inflate(inflater, container, false)
        val view = binding.root

        mapView = view.findViewById(R.id.mapView)
        mapView.onCreate(savedInstanceState)

        //Notification Button Click Listener
        binding.reportButton.setOnClickListener {
            view.findNavController().navigate(R.id.action_mapFragment_to_reportIncidentFragment)
        }

        mapView.onResume()
        mapView.getMapAsync(this)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mapView.onSaveInstanceState(outState)
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val concordia = LatLng(46.8628, -96.7701)
        mMap.addMarker(MarkerOptions().position(concordia).title("Marker at Concordia"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(concordia, 16.0f))
        mMap.setOnMapLongClickListener(this)
    }

    override fun onMapLongClick(p0: LatLng) {
        mMap.addMarker(MarkerOptions().position(p0).title("Danger Here!!"))
    }

    override fun onMapClick(p0: LatLng) {
        TODO("Not yet implemented")
    }

    override fun onMarkerClick(p0: Marker): Boolean {
        p0.remove()
        return true
    }


}