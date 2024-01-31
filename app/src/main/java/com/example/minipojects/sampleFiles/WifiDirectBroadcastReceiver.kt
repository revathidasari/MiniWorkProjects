package com.example.minipojects.sampleFiles

import android.Manifest
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.wifi.p2p.WifiP2pDeviceList
import android.net.wifi.p2p.WifiP2pManager
import androidx.core.app.ActivityCompat

/**
 * A BroadcastReceiver that notifies of important Wi-Fi p2p events.
 * For Security purpose it uses WPA2 encryption protection.
 * Wi-Fi Direct can operate at up to 100m. Some reference site says 656 feet too.
 */

/*Note: On apps that target Android 13 (API level 33) and higher, both discoverPeers() and connect() require the android.permission.NEARBY_WIFI_DEVICES permission.
On apps that target earlier versions of Android, these methods require the ACCESS_FINE_LOCATION permission instead.
Since these permissions are dangerous permissions, you must request them at runtime before you can call discoverPeers() or connect().*/
class WifiDirectBroadcastReceiver(
    private val manager: WifiP2pManager,
    private val channel: WifiP2pManager.Channel,
    private val activity: WifiP2PActivity
) : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val action: String? = intent.action
        when (action) {
            WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION -> {
                // Check to see if Wi-Fi is enabled and notify appropriate activity
                val state = intent.getIntExtra(WifiP2pManager.EXTRA_WIFI_STATE, -1)
                when (state) {
                    WifiP2pManager.WIFI_P2P_STATE_ENABLED -> {
                        // Wifi P2P is enabled
                    }
                    else -> {
                        // Wi-Fi P2P is not enabled
                    }
                }
            }
            WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION -> {
                // Call WifiP2pManager.requestPeers() to get a list of current peers
                if (ActivityCompat.checkSelfPermission(
                        activity,
                        Manifest.permission.ACCESS_FINE_LOCATION
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return
                }
                manager?.requestPeers(channel) { peers: WifiP2pDeviceList? ->
                    // Handle peers list
                }
            }
            WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION -> {
                // Respond to new connection or disconnections
                //Applications can use requestConnectionInfo(), requestNetworkInfo(), or requestGroupInfo() to retrieve the current connection information.
            }
            WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION -> {
                // Respond to this device's wifi state changing
                //Applications can use requestDeviceInfo() to retrieve the current connection information.
            }
        }
    }
}