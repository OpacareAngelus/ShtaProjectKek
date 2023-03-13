package com.kooapps.stackybirdandroidw.mainactivitydsfklsdjfk

import android.app.Application
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import com.kooapps.stackybirdandroidw.mamitaclasita.MamaClass.Companion.pampam
import com.kooapps.stackybirdandroidw.R
import com.kooapps.stackybirdandroidw.filerekika.FilerMeNow
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(pampam["AppsCh"] == "1") {
            appsSign(application, this)
        } else {
            startActivity(Intent(this, FilerMeNow::class.java))
        }

        GlobalScope.launch {
            val adInfo = AdvertisingIdClient.getAdvertisingIdInfo(applicationContext).id
            pampam["GAID"] = adInfo.toString()
            Log.d("Uid", adInfo.toString())
        }

    }
        fun appsSign(application: Application, context: Context){
            AppsFlyerLib.getInstance()
                .init("dX6RPWf8UF6zHPtK3rifoJ", conversionDataListener, application)
            AppsFlyerLib.getInstance().start(context)
        }

    private val conversionDataListener  = object : AppsFlyerConversionListener {
        override fun onConversionDataSuccess(data: MutableMap<String, Any>?) {
            val obs = Observable.just(data?.get("campaign").toString())
            val observer: Observer<String> = object : Observer<String> {
                override fun onSubscribe(d: Disposable) {
                    Log.d("ObseObse","onSubscribe")
                }
                override fun onError(e: Throwable) {
                    Log.d("ObseObse","onError");
                }
                override fun onComplete() {
                    Log.d("ObseObse","onComplete");
                    startActivity(Intent(this@MainActivity, FilerMeNow::class.java))
                    finish()
                }
                override fun onNext(t: String) {
                    pampam["AppsData"] = t
                    Log.d("ObseObse", pampam["AppsData"].toString())
                }
            }
            obs.subscribe(observer)
        }
        override fun onConversionDataFail(error: String?) {
        }
        override fun onAppOpenAttribution(data: MutableMap<String, String>?) {
        }
        override fun onAttributionFailure(error: String?) {
        }
    }



}


