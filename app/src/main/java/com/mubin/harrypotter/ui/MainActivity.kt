package com.mubin.harrypotter.ui

import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.mubin.harrypotter.R
import com.mubin.harrypotter.broadcastReceiver.ConnectionStatus
import com.mubin.harrypotter.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@Suppress("DEPRECATION")
@AndroidEntryPoint
class MainActivity : AppCompatActivity() , ConnectionStatus.ConnectivityReceiverListener {

    private lateinit var binding: ActivityMainBinding

    private var mSnackBar: Snackbar? = null
    private val connectionStatus = ConnectionStatus()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(connectionStatus)
    }

    override fun onPostResume() {
        super.onPostResume()
        registerReceiver(connectionStatus, IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
        ConnectionStatus.connectivityReceiverListener = this
    }

    override fun onNetworkConnectionChanged(isConnected: Boolean) {
        if (!isConnected) {
            mSnackBar = Snackbar
                .make(findViewById(R.id.mainCl), getString(R.string.alert_no_internet), Snackbar.LENGTH_INDEFINITE)
                .setAction(getString(R.string.turn_on_wifi)) {
                    startActivity(Intent(Settings.ACTION_WIFI_SETTINGS))
                }
                .setActionTextColor(resources.getColor(R.color.white))
            mSnackBar?.show()
        } else {
            mSnackBar?.dismiss()
        }
    }
}