package dcl.gushima.translate

import android.annotation.TargetApi
import android.app.Dialog
import android.support.v4.app.DialogFragment
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.*
import android.webkit.*
import dcl.gushima.translate.R.id.webView
import java.io.UnsupportedEncodingException
import java.net.URLDecoder
import java.util.HashMap

/**
 * Created by gushima on 2017/05/19.
 */

class WebViewFragment: DialogFragment() {
    private var main_layout: Int = R.layout.fragment_webview
    private var url_string: String? = null

    override fun onResume() {
        super.onResume()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(main_layout, null)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.window!!.requestFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(main_layout)
        dialog.window!!.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return dialog
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadView()
    }

    override fun onDetach() {
        super.onDetach()
    }

    private fun loadView() {

        val extraHeaders = HashMap<String, String>()
        //        webview.loadUrl(url_string);
        //viewportを有効にする
        webView
    }

    private fun webViewReceiveError(errorCode: Int?) {
        if (errorCode ?: 0 < 0) {
//            val intent = Intent(activity.applicationContext, ErrorInfoActivity::class.java)
//            startActivity(intent)
//            activity.finish()
        }
    }


    companion object {
        internal val MY_INTENT_BROWSER = 0
        private val B_URL = "url"

        fun newInstance(url: String): WebViewFragment {
            val selfFragment = WebViewFragment ()
            val args = Bundle()
            args.putString(B_URL, url)
            selfFragment.arguments = args
            return selfFragment
        }
    }
}