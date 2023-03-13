package com.kooapps.stackybirdandroidw.helperititka

import android.content.Context
import android.util.Log
import com.facebook.applinks.AppLinkData
import com.kooapps.stackybirdandroidw.mamitaclasita.MamaClass.Companion.pampampapapapapapapapa
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

class Helper() {

    data class RetroBewqkleejwlkejqwelwe(val odysseusappsChecker : String, val odysseusview : String, val odysseusgeo : String)

    interface RequestInterfacewewqheqwjkehqwkeq {

        @GET("odysseuskeker.json")
        fun getDatakelqwjelqjkqwelj() : Observable<RetroBewqkleejwlkejqwelwe>
    }

    data class RetroArwejkrhwekrjwehr(val countryCode : String)

    fun deepLeqwkleqwjheklqwhddweqedqw(context: Context) {
        AppLinkData.fetchDeferredAppLinkData(
            context
        ) {
            // Process app link
            val deepDataeqkddelhzskdjwqeqwe = it!!.targetUri?.host.toString()
            Log.d("FB_TAG", "deepL: I'm alive")
            pampampapapapapapapapa["FBData"] = deepDataeqkddelhzskdjwqeqwe
        }
    }

    interface RequestAwlkejqwlekqwjelqwe {

        @GET("json/?key=15YX08nevlglWmq")
        fun getDataAweklqjeqwklejqwelkqwjqklejqw() : Observable<RetroArwejkrhwekrjwehr>
    }
}