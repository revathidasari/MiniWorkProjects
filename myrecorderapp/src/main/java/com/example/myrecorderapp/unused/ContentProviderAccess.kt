package com.example.myrecorderapp.unused

import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import android.util.Log

class ContentProviderAccess(
    private val context: Context
) {

    private val CURRENT_USER_URI = "content://com.example.myapp.contentprovider/user"

    @SuppressLint("Range")
    fun uriAccess(): String? {
        var cursor = context.contentResolver.query(
            Uri.parse(CURRENT_USER_URI),
            null,
            null,
            null,
            null
        )
        val id = cursor?.let {
            it.moveToNext()
            it.getString(it.getColumnIndex("UDA_UUID"))
        }
        Log.d("revathi","userid $id")

        return id
    }
}