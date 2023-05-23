package com.example.cobbersecure;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u0005\u00a2\u0006\u0002\u0010\u0006J&\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\rH\u0016J\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u0019H\u0016J\b\u0010%\u001a\u00020\u0019H\u0016J\u0010\u0010&\u001a\u00020\u00192\u0006\u0010\'\u001a\u00020\u0017H\u0016J\u001a\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2 = {"Lcom/example/cobbersecure/MapFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/google/android/gms/maps/OnMapReadyCallback;", "Lcom/google/android/gms/maps/GoogleMap$OnMapLongClickListener;", "Lcom/google/android/gms/maps/GoogleMap$OnMapClickListener;", "Lcom/google/android/gms/maps/GoogleMap$OnMarkerClickListener;", "()V", "_binding", "Lcom/example/cobbersecure/databinding/FragmentMapBinding;", "binding", "getBinding", "()Lcom/example/cobbersecure/databinding/FragmentMapBinding;", "mMap", "Lcom/google/android/gms/maps/GoogleMap;", "mapView", "Lcom/google/android/gms/maps/MapView;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "onLowMemory", "onMapClick", "p0", "Lcom/google/android/gms/maps/model/LatLng;", "onMapLongClick", "onMapReady", "googleMap", "onMarkerClick", "", "Lcom/google/android/gms/maps/model/Marker;", "onPause", "onResume", "onSaveInstanceState", "outState", "onViewCreated", "view", "app_debug"})
public final class MapFragment extends androidx.fragment.app.Fragment implements com.google.android.gms.maps.OnMapReadyCallback, com.google.android.gms.maps.GoogleMap.OnMapLongClickListener, com.google.android.gms.maps.GoogleMap.OnMapClickListener, com.google.android.gms.maps.GoogleMap.OnMarkerClickListener {
    private com.google.android.gms.maps.GoogleMap mMap;
    private com.google.android.gms.maps.MapView mapView;
    private com.example.cobbersecure.databinding.FragmentMapBinding _binding;
    
    public MapFragment() {
        super();
    }
    
    private final com.example.cobbersecure.databinding.FragmentMapBinding getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    public void onResume() {
    }
    
    @java.lang.Override
    public void onPause() {
    }
    
    @java.lang.Override
    public void onSaveInstanceState(@org.jetbrains.annotations.NotNull
    android.os.Bundle outState) {
    }
    
    @java.lang.Override
    public void onLowMemory() {
    }
    
    @java.lang.Override
    public void onDestroyView() {
    }
    
    @java.lang.Override
    public void onMapReady(@org.jetbrains.annotations.NotNull
    com.google.android.gms.maps.GoogleMap googleMap) {
    }
    
    @java.lang.Override
    public void onMapLongClick(@org.jetbrains.annotations.NotNull
    com.google.android.gms.maps.model.LatLng p0) {
    }
    
    @java.lang.Override
    public void onMapClick(@org.jetbrains.annotations.NotNull
    com.google.android.gms.maps.model.LatLng p0) {
    }
    
    @java.lang.Override
    public boolean onMarkerClick(@org.jetbrains.annotations.NotNull
    com.google.android.gms.maps.model.Marker p0) {
        return false;
    }
}