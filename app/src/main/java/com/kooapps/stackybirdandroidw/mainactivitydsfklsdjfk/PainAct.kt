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
import com.kooapps.stackybirdandroidw.mamitaclasita.MadreClasses.Companion.pampampapapapapapapapa
import com.kooapps.stackybirdandroidw.R
import com.kooapps.stackybirdandroidw.filerekika.PrequelMeNow
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class PainAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(pampampapapapapapapapa["AppsCh"] == "1") {
            appsSignwerwrwerrsdfwe(application, this)
        } else {
            startActivity(Intent(this, PrequelMeNow::class.java))
        }

        GlobalScope.launch {
            val adInfo = AdvertisingIdClient.getAdvertisingIdInfo(applicationContext).id
            pampampapapapapapapapa["GAID"] = adInfo.toString()
            Log.d("Uid", adInfo.toString())
        }

    }
    private val conversionDataListenerwerwerwerrwer  = object : AppsFlyerConversionListener {
        override fun onConversionDataSuccess(data: MutableMap<String, Any>?) {
            val obsdfjkshdfjkehrjwkr = Observable.just(data?.get("campaign").toString())
            val observerwkewqehgqwejqwh: Observer<String> = object : Observer<String> {
                override fun onSubscribe(d: Disposable) {
                    Log.d("ObseObse","onSubscribe")
                }
                override fun onError(e: Throwable) {
                    Log.d("ObseObse","onError");
                }
                override fun onComplete() {
                    Log.d("ObseObse","onComplete");
                    startActivity(Intent(this@PainAct, PrequelMeNow::class.java))
                    finish()
                }
                override fun onNext(t: String) {
                    pampampapapapapapapapa["AppsData"] = t
                    Log.d("ObseObse", pampampapapapapapapapa["AppsData"].toString())
                }
            }
            obsdfjkshdfjkehrjwkr.subscribe(observerwkewqehgqwejqwh)
        }
        override fun onConversionDataFail(error: String?) {
        }
        override fun onAppOpenAttribution(data: MutableMap<String, String>?) {
        }
        override fun onAttributionFailure(error: String?) {
        }
    }

    fun appsSignwerwrwerrsdfwe(application: Application, context: Context){
        AppsFlyerLib.getInstance()
            .init("dX6RPWf8UF6zHPtK3rifoJ", conversionDataListenerwerwerwerrwer, application)
        AppsFlyerLib.getInstance().start(context)
    }



}


