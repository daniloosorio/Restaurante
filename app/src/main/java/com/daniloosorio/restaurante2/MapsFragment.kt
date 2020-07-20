package com.daniloosorio.restaurante2

import android.Manifest
import android.content.pm.PackageManager
import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import kotlinx.android.synthetic.main.fragment_maps.*
import kotlinx.android.synthetic.main.fragment_two.*

class MapsFragment : Fragment() {
      private lateinit var mMap :GoogleMap
    var dato = arrayOf(0,0,0,0,0,0,0,0)
    private val callback = OnMapReadyCallback { googleMap ->
        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        mMap=googleMap
        activarMyLocation()
        mMap.uiSettings.isZoomControlsEnabled =true
        val manila = LatLng(6.214168,-75.5723182)
        val Central = LatLng(6.2389624,-75.5476718)
        val Junin = LatLng(6.2508982,-75.566061)
        val Moda = LatLng(6.2185654,-75.5839945)
        val Rio = LatLng(6.2245509,-75.5747391)
        val Strada = LatLng(6.2018907,-75.5720429)
        val Urbana = LatLng(6.2140756,-75.5726413)
        val Origen = LatLng(6.2484523,-75.5673213)
        val marcador1 = mMap.addMarker(MarkerOptions().position(manila).title("Hacienda-Manila").icon(
            BitmapDescriptorFactory.fromResource(R.drawable.logo)))
            marcador1.isVisible=false
        val marcador2 = mMap.addMarker(MarkerOptions().position(Central).title("Hacienda-La Central").icon(
            BitmapDescriptorFactory.fromResource(R.drawable.logo)))
        marcador2.isVisible=false
        val marcador3 = mMap.addMarker(MarkerOptions().position(Junin).title("Hacienda-Junin").icon(
            BitmapDescriptorFactory.fromResource(R.drawable.logo)))
        marcador3.isVisible=false
        val marcador4 = mMap.addMarker(MarkerOptions().position(Moda).title("Hacienda-De Moda").icon(
            BitmapDescriptorFactory.fromResource(R.drawable.logo)))
        marcador4.isVisible=false
        val marcador5 = mMap.addMarker(MarkerOptions().position(Rio).title("Hacienda-Ciudad del Rio").icon(
            BitmapDescriptorFactory.fromResource(R.drawable.logo)))
        marcador5.isVisible=false
        val marcador6 = mMap.addMarker(MarkerOptions().position(Strada).title("Hacienda-La Strada").icon(
            BitmapDescriptorFactory.fromResource(R.drawable.logo)))
        marcador6.isVisible=false
        val marcador7 = mMap.addMarker(MarkerOptions().position(Urbana).title("Hacienda-Urbana").icon(
            BitmapDescriptorFactory.fromResource(R.drawable.logo)))
        marcador7.isVisible=false
        val marcador8 = mMap.addMarker(MarkerOptions().position(Origen).title("Hacienda-Origen junin").icon(
            BitmapDescriptorFactory.fromResource(R.drawable.logo)))
        marcador8.isVisible=false
        button2.setOnClickListener {
            dato= (activity as MainActivity?)?.back!!
            visualizarMarker(marcador1, manila,dato[0])
            visualizarMarker(marcador2, Central,dato[1])
            visualizarMarker(marcador3, Junin,dato[2])
            visualizarMarker(marcador4, Moda,dato[3])
            visualizarMarker(marcador5, Rio,dato[4])
            visualizarMarker(marcador6, Strada,dato[5])
            visualizarMarker(marcador7, Urbana,dato[6])
            visualizarMarker(marcador8, Urbana,dato[7])
            /*val sydney = LatLng(6.521117, -76.0963054)
            mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
            //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 18F))
            dato= (activity as MainActivity?)?.back!!
            mMap.mapType=GoogleMap.MAP_TYPE_HYBRID
            mMap.uiSettings.isZoomControlsEnabled =true
            Toast.makeText(context, "${dato[0]},${dato[1]},${dato[2]},${dato[3]},${dato[4]},${dato[5]},${dato[6]}", Toast.LENGTH_SHORT).show()*/
        }
        bt_satelite.setOnClickListener {
            mMap.mapType=GoogleMap.MAP_TYPE_HYBRID
        }
        bt_normal.setOnClickListener {
            mMap.mapType=GoogleMap.MAP_TYPE_NORMAL
        }
    }

    private fun visualizarMarker(marcador: Marker, restaurante: LatLng, data:Int) {
        if (data== 1) {
            marcador.isVisible = true
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(restaurante, 14F))
        }
        if (data == 0) {
            //var marcador = mMap.addMarker(MarkerOptions().position(manila).title("Hacienda-Manila\nDireccion:Cl.12#43d11\nMedellin,Antioquia\nTel:(4)4489030"))
            marcador.isVisible = false
            //Toast.makeText(context, "llego 0", Toast.LENGTH_SHORT).show()
        }
    }

    private fun activarMyLocation() {
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION),
                1234
            )
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }
        mMap.isMyLocationEnabled = true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}