package com.github.muellerma.coffee

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import com.github.muellerma.coffee.tiles.TimeoutTile

class BootReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action != Intent.ACTION_BOOT_COMPLETED) {
            return
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            TimeoutTile.requestTileStateUpdate(context)
        }
    }
}