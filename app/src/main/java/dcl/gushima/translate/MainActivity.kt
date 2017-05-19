package dcl.gushima.translate

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.content.Intent
import android.content.ClipboardManager
import android.content.Context
import android.net.Uri
import android.content.ClipDescription
import android.content.ClipData

class MainActivity : AppCompatActivity() {
    private var input: String? = null
    private var bt: Button ?= null
    private var edit: EditText ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bt = findViewById(R.id.button) as Button

        bt!!.setOnClickListener{
            //システムのクリップボードを取得
            val cm = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            //クリップボードからClipDataを取得
            val cd = cm.primaryClip
            //クリップデータからItemを取得
            if (cd != null) {
                val copiedItem = cd.getItemAt(0)
                input = copiedItem.text.toString()
                input = input!!.replace(oldValue = "\n", newValue = " ",ignoreCase = false)
                input = input!!.replace(oldValue = "\r", newValue = " ",ignoreCase = false)
                input = input!!.replace(oldValue = "\r\n", newValue = " ",ignoreCase = false)

//                input = input!!.replace(oldValue = " ", newValue = "%20",ignoreCase = false)
                //クリップボードに格納するItemを作成
                val createdItem = ClipData.Item(input)
                //MIMETYPEの作成
                val mimeType = arrayOfNulls<String>(1)
                mimeType[0] = ClipDescription.MIMETYPE_TEXT_URILIST
                //クリップボードに格納するClipDataオブジェクトの作成
                val cd = ClipData(ClipDescription("text_data", mimeType), createdItem)
                //クリップボードにデータを格納
                val cm = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                cm.primaryClip = cd
//                val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://translate.google.co.jp/m/translate?hl=ja#auto/ja/"))
//                startActivity(i)

                val webViewFragment = WebViewFragment.newInstance("https://translate.google.co.jp/m/translate?hl=ja#auto/ja/")
                webViewFragment.show(this.supportFragmentManager, WebViewFragment::class.simpleName)

            }
        }
    }
}
