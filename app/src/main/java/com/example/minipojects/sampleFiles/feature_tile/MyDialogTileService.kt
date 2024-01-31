package com.example.minipojects.sampleFiles.feature_tile

import android.content.Context
import android.content.DialogInterface
import android.graphics.drawable.Icon
import android.os.Build
import android.os.Bundle
import android.service.quicksettings.Tile
import android.service.quicksettings.TileService
import android.util.Log
import android.view.WindowManager
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.minipojects.R

//import com.example.mymodule.feature_tile.QSDialog.QSDialogListener


@RequiresApi(Build.VERSION_CODES.N)
class MyDialogTileService : TileService() {

    private var isDialogTileActive :  Boolean = false


    override fun onCreate() {
        super.onCreate()
        setTheme(android.R.style.Theme_Dialog)
    }
    // Called when your app can update your tile.
    override fun onStartListening() {
        Log.d("revathi", "onStartListening() called")
        super.onStartListening()

        val tile = qsTile
        tile.label = "Dialog tile 1 "
//        tile.state = Tile.STATE_ACTIVE
        tile.icon = Icon.createWithResource(this, android.R.drawable.ic_dialog_dialer)
        tile.updateTile()

    }

    // Called when your app can no longer update your tile.
    override fun onStopListening() {
        Log.d("revathi", "onStopListening() called")
        super.onStopListening()
    }

    override fun onClick() {
        super.onClick()
        Toast.makeText(applicationContext, "dialog click", Toast.LENGTH_SHORT).show()
        val tile: Tile = qsTile

        isDialogTileActive = (tile.state == Tile.STATE_ACTIVE)
        updateTile()
        val dialogTile = DialogTile(this)

//        dialogTile.setStyle(DialogFragment.STYLE_NO_TITLE, android.R.style.Theme_Material_Dialog_MinWidth)
        val args = Bundle()
        args.putBoolean(dialogTile.TILE_STATE_KEY, isDialogTileActive)
        showDialog(dialogTile.onCreateDialog(args))

/*        val dialogBuilder = QSDialog.Builder(this.applicationContext)
        Log.d("revathi", "service on click")

        val dialog = dialogBuilder
            .setClickListener(object : QSDialogListener {
                override fun onDialogPositiveClick(dialog: DialogFragment) {
                    Log.d("revathi", "Positive registed")
                    isDialogTileActive = !isDialogTileActive
                    updateTile()
                }

                override fun onDialogNegativeClick(dialog: DialogFragment) {
                    Log.d("QS", "Negative registered")
                }
            })
            .create()*/

        // Pass the tile's current state to the dialog.

        // Pass the tile's current state to the dialog.
/*        val args = Bundle()
        args.putBoolean(QSDialog().TILE_STATE_KEY, isDialogTileActive)
        Log.d("revathi", "before show dialog call")
        this.showDialog(dialog.onCreateDialog(args))*/
    }
    private fun updateTile() {
        val tile = super.getQsTile()
        val activeState = if (isDialogTileActive) Tile.STATE_ACTIVE else Tile.STATE_INACTIVE
        tile.state = activeState
        tile.updateTile()
    }
}

class DialogTile(context: Context) : DialogFragment() {
     lateinit var mContext: Context
    val TILE_STATE_KEY = "tileState"


/*    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.dialog_tile, container, false)
        val no = view.findViewById<Button>(R.id.noDialog)
        val yes = view.findViewById<Button>(R.id.yesDialog)
        val title = view.findViewById<TextView>(R.id.headingDialogTile)
        val message = view.findViewById<TextView>(R.id.messageDialogTile)

        no.setOnClickListener{
            dismiss()
        }
        yes.setOnClickListener {
            Log.d("revathi","clicked on yes option")
            dismiss()
        }
        return view
    }*/
    init {
        mContext = context
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): AlertDialog {
        //super.onCreateDialog(savedInstanceState)

        var isTileActive = false
        Log.d("revathi", "oncreate dialog")
        if (savedInstanceState?.containsKey(TILE_STATE_KEY) == true) {
            isTileActive = savedInstanceState.getBoolean(TILE_STATE_KEY)
        }

        val actionButtonText = if(isTileActive) "Dialog Active" else "Dialog Inactive"
        val alertBuilder = AlertDialog.Builder(mContext)
        alertBuilder.setView(R.layout.dialog_tile)
        alertBuilder.setNegativeButton("Cancel", DialogInterface.OnClickListener{ dialogInterface, i ->
           // dListener.onDialogNegativeClick(this)
            dismiss()
        })
        alertBuilder.setPositiveButton(actionButtonText, DialogInterface.OnClickListener{dialogInterface, i ->
//            dialogInterface.dismiss()
//            dListener.onDialogPositiveClick(this)
            dismiss()
        })
        alertBuilder.create().window?.setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT)
        return alertBuilder.create()

    }
}


/*
class QSDialog : DialogFragment() {

    val TILE_STATE_KEY = "tileState"
    lateinit var mContext : Context
    lateinit var dListener : QSDialogListener

    class Builder(private val context: Context) {
        private var dialogListener : QSDialogListener? = null

        fun setClickListener(listener : QSDialogListener) : Builder {
            Log.d("revathi", "in builder set click listener")
            dialogListener = listener
            return this
        }

        fun create() : QSDialog {
            Log.d("revathi", "daialog on create")
            val qsDialog =  QSDialog()
            qsDialog.setContext(context)
            dialogListener?.let { qsDialog.setClickListener(it) }
            return qsDialog
        }
    }

    private fun setClickListener(listener: QSDialogListener) : QSDialog {
        this.dListener = listener
        return this
    }
    private fun setContext(context: Context) : QSDialog {
        this.mContext = context
        return this
    }

    interface QSDialogListener {
        fun onDialogPositiveClick(dialog : DialogFragment)
        fun onDialogNegativeClick(dialog : DialogFragment)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
//        return super.onCreateDialog(savedInstanceState)
        var isTileActive = false
        Log.d("revathi", "oncreate dialog")
        if (savedInstanceState?.containsKey(TILE_STATE_KEY) == true) {
            isTileActive = savedInstanceState.getBoolean(TILE_STATE_KEY)
        }

        val actionButtonText = if(isTileActive) "Dialog Active" else "Dialog Inactive"
        val alertBuilder : AlertDialog.Builder = AlertDialog.Builder(this.mContext)
        alertBuilder.setView(R.layout.dialog_tile)
        alertBuilder.setNegativeButton("Cancel", DialogInterface.OnClickListener{ dialogInterface, i ->
            dListener.onDialogNegativeClick(this)
        })
        alertBuilder.setPositiveButton(actionButtonText, DialogInterface.OnClickListener{dialogInterface, i ->
            dialogInterface.dismiss()
            dListener.onDialogPositiveClick(this)
        })
        return alertBuilder.create()

    }
}
*/
