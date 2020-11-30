package com.github.muellerma.coffee

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.service.quicksettings.Tile.STATE_ACTIVE
import android.service.quicksettings.Tile.STATE_INACTIVE
import android.service.quicksettings.TileService
import android.util.Log

class CoffeeTile : TileService() {
    override fun onClick() {
        Log.d(TAG, "onClick()")
        ForegroundService.startOrStop(application, this, !(application as CoffeeApplication).isRunning)
    }

    override fun onStartListening() {
        Log.d(TAG, "onStartListening()")
        setTileState()
        super.onStartListening()
    }

    override fun onStopListening() {
        Log.d(TAG, "onStopListening()")
        setTileState()
        super.onStopListening()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy()")
        super.onDestroy()
    }

    override fun onLowMemory() {
        Log.d(TAG, "onLowMemory()")
        super.onLowMemory()
    }

    override fun onTileAdded() {
        Log.d(TAG, "onTileAdded()")
        super.onLowMemory()
    }

    override fun onTileRemoved() {
        Log.d(TAG, "onTileRemoved()")
        super.onLowMemory()
    }

    override fun onTrimMemory(level: Int) {
        Log.d(TAG, "onTrimMemory()")
        super.onTrimMemory(level)
    }

    override fun onRebind(intent: Intent?) {
        Log.d(TAG, "onRebind()")
        super.onRebind(intent)
    }

    private fun setTileState() {
        val isRunning = (application as CoffeeApplication).isRunning
        Log.d(TAG, "setTileState(): running = $isRunning")
        val tile = qsTile ?: return
        tile.apply {
            state = if (isRunning) STATE_ACTIVE else STATE_INACTIVE
            updateTile()
        }
    }

    companion object {
        private val TAG = CoffeeTile::class.java.simpleName

        fun requestTileStateUpdate(context: Context) {
            Log.d(TAG, "requestTileStateUpdate()")
            requestListeningState(context, ComponentName(context, CoffeeTile::class.java))
        }
    }
}