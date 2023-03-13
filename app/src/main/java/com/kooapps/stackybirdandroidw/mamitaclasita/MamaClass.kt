package com.kooapps.stackybirdandroidw.mamitaclasita

import android.app.Application

import com.my.tracker.MyTracker
import com.onesignal.OneSignal


class MamaClass: Application() {

    companion object {
        var pampam: HashMap<String, String> = HashMap()
    }

    override fun onCreate() {
        super.onCreate()
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);
        OneSignal.initWithContext(this);
        OneSignal.setAppId("b1264196-6357-4d62-8821-86289f3acce9");
        val trackerConfig = MyTracker.getTrackerConfig()
        trackerConfig.isTrackingLaunchEnabled = true
        MyTracker.initTracker("22541511891516651603", this)
    }
}

