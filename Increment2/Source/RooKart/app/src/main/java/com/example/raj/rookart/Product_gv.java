package com.example.raj.rookart;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Product_gv.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Product_gv#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Product_gv extends Fragment implements GooglePlayServicesClient,ConnectionCallbacks,
        GooglePlayServicesClient,OnConnectionFailedListener,
        LocationListener {
    private GoogleMap mMap;
    public Geocoder geocoder;
    MapView mMapView;
    private GoogleMap googleMap;
        // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Product_gv() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Product_gv.
     */
    // TODO: Rename and change types and number of parameters
    public static Product_gv newInstance(String param1, String param2) {
        Product_gv fragment = new Product_gv();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_product_gv, container, false);

        View v;
         v = inflater.inflate(R.layout.fragment_product_gv, container,
                false);
        mMapView = (MapView) v.findViewById(R.id.map);
        mMapView.getMapAsync(this);

    return v;}

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        //geocoder = new Geocoder(this);
        StringBuilder userAddress = new StringBuilder();
        // Add a marker in Sydney and move the camera
        LocationManager userCurrentLocation = (LocationManager) this
                .getSystemService(Context.LOCATION_SERVICE);
        LocationListener userCurrentLocationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {

            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };
        LatLng userCurrentLocationCorodinates = null;
        double latitute = 0, longitude = 0;
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat
                .checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            //show message or ask permissions from the user.
            return;
        }
        //Getting the current location of the user.
        userCurrentLocation.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                0, 0, userCurrentLocationListener);
        latitute = userCurrentLocation
                .getLastKnownLocation(LocationManager.GPS_PROVIDER)
                .getLatitude();
        longitude = userCurrentLocation
                .getLastKnownLocation(LocationManager.GPS_PROVIDER)
                .getLongitude();
        userCurrentLocationCorodinates = new LatLng(latitute,longitude);
        //Getting the address of the user based on latitude and longitude.
        try {
            List<Address> addresses = geocoder.getFromLocation(latitute, longitude, 1);
            Address address = addresses.get(0);
            userAddress =  new StringBuilder();
            for (int i = 0; i < address.getMaxAddressLineIndex(); i++) {
                userAddress.append(address.getAddressLine(i)).append("\t");
            }
            userAddress.append(address.getCountryName()).append("\t");

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        //Setting our image as the marker icon.
        mMap.addMarker(new MarkerOptions().position(userCurrentLocationCorodinates)
                .title("Your current address.").snippet(userAddress.toString())
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.roo)));
        //Setting the zoom level of the map.
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(userCurrentLocationCorodinates, 7));


    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
