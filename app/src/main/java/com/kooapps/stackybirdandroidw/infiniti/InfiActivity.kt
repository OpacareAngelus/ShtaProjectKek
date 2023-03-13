package com.kooapps.stackybirdandroidw.infiniti

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.webkit.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class InfiActivity : AppCompatActivity() {


    private val INPUT_FILE_REQUEST_CODE_WEKQWHEJKQWEHQWKJEK = 1
    protected var mRequestCodeFilePickerwqkleqwhejkhqwekjqwehqw: Int = INPUT_FILE_REQUEST_CODE_WEKQWHEJKQWEHQWKJEK
    var filePathCallbacksqwlekqweklqejwqlekjqw: ValueCallback<Array<Uri>>? = null

    lateinit var webBewewqehqwjkehqwkqjheqkwe: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        webBewewqehqwjkehqwkqjheqkwe = WebView(this)
        setOfSettewqkhqwjkehqejkqwhe()
        setContentView(webBewewqehqwjkehqwkqjheqkwe)

        webBewewqehqwjkehqwkqjheqkwe.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView,
                url: String
            ): Boolean {

                val pmwejhqwejkqwhekqjehqwekjqwh = applicationContext.packageManager
                val isInstalledjwekrhwkrjwehrkwejrhwjkr = isPackageInstalledwerewjkrhwerjkhwerkwjhrkwe("org.telegram.messenger", pmwejhqwejkqwhekqjehqwekjqwh)

                try {
                    if (URLUtil.isNetworkUrl(url)) {
                        return false
                    }
                    if (isInstalledjwekrhwkrjwehrkwejrhwjkr) {
                        val intentwejkeljkwlqkejqwklejqweqw = Intent(Intent.ACTION_VIEW)
                        intentwejkeljkwlqkejqwklejqweqw.data = Uri.parse(url)
                        this@InfiActivity.startActivity(intentwejkeljkwlqkejqwklejqweqw)
                    } else {
                        Toast.makeText(
                            this@InfiActivity,
                            "Application is not installed",
                            Toast.LENGTH_LONG
                        ).show()
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://play.google.com/store/apps/details?id=org.telegram.messenger")
                        )
                    }
                    return true
                } catch (e: Exception) {
                    return false
                }
            }

            override fun onReceivedError(
                view: WebView?,
                errorCode: Int,
                description: String?,
                failingUrl: String?
            ) {
                Toast.makeText(this@InfiActivity, description, Toast.LENGTH_SHORT).show()
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
//                saveUrl(url)
            }
        }

        webBewewqehqwjkehqwkqjheqkwe.webChromeClient = object : WebChromeClient() {
            override fun onShowFileChooser(
                webView: WebView?,
                filePathCallback: ValueCallback<Array<Uri>>?,
                fileChooserParams: FileChooserParams
            ):Boolean {

                filePathCallbacksqwlekqweklqejwqlekjqw?.onReceiveValue(null)
                filePathCallbacksqwlekqweklqejwqlekjqw = filePathCallback

                try {
                    openChooserewrkljelrkjwerkwelrkwej()
                } catch (e: java.lang.Exception) {
                    Toast.makeText(this@InfiActivity, e.toString(), Toast.LENGTH_LONG).show()
                }
                return true
            }
        }
        webBewewqehqwjkehqwkqjheqkwe.loadUrl(ururururururururqwejkqwhejkqwehkwqjqeh())
    }

    fun setOfSettewqkhqwjkehqejkqwhe() {
        CookieManager.getInstance().setAcceptCookie(true)
        CookieManager.getInstance().setAcceptThirdPartyCookies( webBewewqehqwjkehqwkqjheqkwe, true)
        val webViewSetweklqwjeklqwejl = webBewewqehqwjkehqwkqjheqkwe.settings
        webViewSetweklqwjeklqwejl.javaScriptEnabled = true
        webViewSetweklqwjeklqwejl.useWideViewPort = true
        webViewSetweklqwjeklqwejl.loadWithOverviewMode = true
        webViewSetweklqwjeklqwejl.allowFileAccess = true
        webViewSetweklqwjeklqwejl.domStorageEnabled = true
        webViewSetweklqwjeklqwejl.userAgentString = webViewSetweklqwjeklqwejl.userAgentString.replace("; wv", "")
        webViewSetweklqwjeklqwejl.javaScriptCanOpenWindowsAutomatically = true
        webViewSetweklqwjeklqwejl.setSupportMultipleWindows(false)
        webViewSetweklqwjeklqwejl.displayZoomControls = false
        webViewSetweklqwjeklqwejl.builtInZoomControls = true
        webViewSetweklqwjeklqwejl.allowFileAccess = true
        webViewSetweklqwjeklqwejl.allowContentAccess = true
        webViewSetweklqwjeklqwejl.setSupportZoom(true)
        webViewSetweklqwjeklqwejl.pluginState = WebSettings.PluginState.ON
        webViewSetweklqwjeklqwejl.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        webViewSetweklqwjeklqwejl.cacheMode = WebSettings.LOAD_DEFAULT
        webViewSetweklqwjeklqwejl.allowContentAccess = true
        webViewSetweklqwjeklqwejl.mediaPlaybackRequiresUserGesture = false
    }

    var exitexitexitexitewjqlqkejqwlejqwelkqj = false
    var urlfifififwqekljqwheklqwjehqwek = ""

    private fun isPackageInstalledwerewjkrhwerjkhwerkwjhrkwe(packageName: String, packageManager: PackageManager): Boolean {
        return try {
            packageManager.getPackageInfo(packageName, 0)
            true
        } catch (e: PackageManager.NameNotFoundException) {
            false
        }
    }

    fun saveUrlwelkqwjeqweklqwjekl(lurlurlurlurlurewklrjwelrwerklwejrw: String?) {
        if (!lurlurlurlurlurewklrjwelrwerklwejrw!!.contains("t.me")) {

            if (urlfifififwqekljqwheklqwjehqwek == "") {

                    urlfifififwqekljqwheklqwjehqwek = getSharedPreferences(
                        "SP_WEBVIEW_PREFS",
                        AppCompatActivity.MODE_PRIVATE
                    ).getString(
                        "SAVED_URL",
                        lurlurlurlurlurewklrjwelrwerklwejrw
                    ).toString()

                val spspspspsppspspspewklqejqwlekqwjeklqwej =
                    getSharedPreferences(
                        "SP_WEBVIEW_PREFS",
                        AppCompatActivity.MODE_PRIVATE
                    )
                val edededededededqweklwjelqwjkewlk = spspspspsppspspspewklqejqwlekqwjeklqwej?.edit()
                edededededededqweklwjelqwjkewlk?.putString("SAVED_URL", lurlurlurlurlurewklrjwelrwerklwejrw)
                edededededededqweklwjelqwjkewlk?.apply()
            }
        }
    }

    private fun openChooserewrkljelrkjwerkwelrkwej() {

        val chooserIntentwekjqwldkjflwfjklwq = Intent(Intent.ACTION_GET_CONTENT).apply {
            addCategory(Intent.CATEGORY_OPENABLE)
            type = "image/*"
        }
        val intentzxbbczxmnczxbmnzxbc = Intent(Intent.ACTION_CHOOSER).apply {
            putExtra(Intent.EXTRA_INTENT, chooserIntentwekjqwldkjflwfjklwq)
            putExtra(Intent.EXTRA_TITLE, "Image Chooser")
        }
        startActivityForResult(Intent.createChooser(intentzxbbczxmnczxbmnzxbc, "File Chooser"), INPUT_FILE_REQUEST_CODE_WEKQWHEJKQWEHQWKJEK);
    }

    override fun onBackPressed() {
        if (webBewewqehqwjkehqwkqjheqkwe.canGoBack()) {
            if (exitexitexitexitewjqlqkejqwlejqwelkqj) {
                webBewewqehqwjkehqwkqjheqkwe.stopLoading()
                webBewewqehqwjkehqwkqjheqkwe.loadUrl(urlfifififwqekljqwheklqwjehqwek)
            }
            this.exitexitexitexitewjqlqkejqwlejqwelkqj = true
            webBewewqehqwjkehqwkqjheqkwe.goBack()
            Handler(Looper.getMainLooper()).postDelayed({
                exitexitexitexitewjqlqkejqwlejqwelkqj = false
            }, 2000)

        } else {
            super.onBackPressed()
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == INPUT_FILE_REQUEST_CODE_WEKQWHEJKQWEHQWKJEK && (resultCode == RESULT_OK)) {

            if ((null == filePathCallbacksqwlekqweklqejwqlekjqw )) {
                return;
            } else {
                val dataString: String? = data?.dataString

                if (dataString != null) {
                    val result = arrayOf(Uri.parse(dataString))
                    filePathCallbacksqwlekqweklqejwqlekjqw?.onReceiveValue(result)
                    filePathCallbacksqwlekqweklqejwqlekjqw = null
                }
            }
        }
    }

    private fun ururururururururqwejkqwhejkqwehkwqjqeh(): String {


        val sharPreweqeqwiqdo = getSharedPreferences("NEWPR",
            Context.MODE_PRIVATE)

        val linkeweqweqwehd = sharPreweqeqwiqdo.getString("link", null)
        Log.d("Lololol", linkeweqweqwehd.toString())

        return linkeweqweqwehd.toString()

    }
}

