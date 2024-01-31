package com.example.minipojects.sampleFiles.feature_tile

import android.content.Intent
import android.graphics.drawable.Icon
import android.os.Build
import android.service.quicksettings.Tile
import android.service.quicksettings.TileService
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.minipojects.R
import java.util.*

@RequiresApi(Build.VERSION_CODES.N)
class MyTileService : TileService() {


    private val SERVICE_STATUS_FLAG = "serviceStatus"
    private val PREFERENCES_KEY = "com.google.android_quick_settings"


    // Called when the user adds your tile.
    override fun onTileAdded() {
        Log.d("revathi", "onTileAdded() called")
        super.onTileAdded()
    }

    // Called when your app can update your tile.
    override fun onStartListening() {
        Log.d("revathi", "onStartListening() called")
        super.onStartListening()

        val tile = qsTile
        tile.label = "New label"
//        tile.state = Tile.STATE_ACTIVE
        tile.icon = Icon.createWithResource(this, R.drawable.ic_baseline_calendar_today_24)
        tile.updateTile()

    }

    // Called when your app can no longer update your tile.
    override fun onStopListening() {
        Log.d("revathi", "onStopListening() called")
        super.onStopListening()
    }

    // Called when the user taps on your tile in an active or inactive state.
    override fun onClick() {
        Log.d("revathi", "onClick() called")
        super.onClick()
   //     updateTile()

        if (qsTile.state == Tile.STATE_INACTIVE) {
            qsTile.state = Tile.STATE_ACTIVE
            qsTile.label = "launching"
/*
            val calendarIntent = Intent(Intent.ACTION_EDIT)
            calendarIntent.type = "vnd.android.cursor.item/event"
            calendarIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivityAndCollapse(calendarIntent)*/
            val intent = Intent(this, CustomTileActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivityAndCollapse(intent)
        } else {
            qsTile.state = Tile.STATE_INACTIVE
            qsTile.label = "already done"
        }

        qsTile.updateTile()
    }

    // Called when the user removes your tile.
    override fun onTileRemoved() {
        Log.d("revathi", "onTileRemoved() called")
        super.onTileRemoved()
    }


    private fun updateTile() {
        val tile = this.qsTile
        val isActive: Boolean = getServiceStatus()
        val newIcon: Icon
        val newLabel: String
        val newState: Int

        // Change the tile to match the service status.
        if (isActive) {
            newLabel = java.lang.String.format(
                Locale.US,
                "%s %s",
                "MyTile",
                "Service active"
            )
            newIcon = Icon.createWithResource(
                applicationContext,
                R.drawable.ic_baseline_notifications_24
            )
            newState = Tile.STATE_ACTIVE
        } else {
            newLabel = java.lang.String.format(
                Locale.US,
                "%s %s",
                "MyTile",
                "Service inactive"
            )
            newIcon = Icon.createWithResource(
                applicationContext,
                android.R.drawable.ic_dialog_alert
            )
            newState = Tile.STATE_INACTIVE
        }

        // Change the UI of the tile.
        tile.label = newLabel
        tile.icon = newIcon
        tile.state = newState

        // Need to call updateTile for the tile to pick up changes.
        tile.updateTile()
    }

    private fun getServiceStatus(): Boolean {
        val prefs = applicationContext
            .getSharedPreferences(
                PREFERENCES_KEY,
                MODE_PRIVATE
            )
        var isActive = prefs.getBoolean(SERVICE_STATUS_FLAG, false)
        isActive = !isActive
        prefs.edit().putBoolean(SERVICE_STATUS_FLAG, isActive).apply()
        return isActive
    }

}