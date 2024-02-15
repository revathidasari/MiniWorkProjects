package com.example.myrecorderapp

import android.app.Activity
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat

class AllowRuntimePermissions (
    private val activity: Activity,
    private val permissionList: Array<String>
): Activity() {

    private val REQUEST_PERMISSION_CODE = 11
    private var permissionAllowed = false
//    private var permissions: Array<String> = arrayOf(android.Manifest.permission.RECORD_AUDIO)

    fun requestPermissions() {
        ActivityCompat.requestPermissions(activity, permissionList, 0)
    }

    //callback on requestPermissions(...) call
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        permissionAllowed = if (requestCode == REQUEST_PERMISSION_CODE) {
            grantResults[0] == PackageManager.PERMISSION_GRANTED
        } else {
            false
        }

        if (!permissionAllowed)
            requestPermissions()

    }


}