package dcl.gushima.translate

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private var input: String? = null
    private var fab: FloatingActionButton ?= null
    private var edit: EditText ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fab = findViewById(R.id.floatingActionButton) as FloatingActionButton

        fab!!.setOnClickListener{
            input = edit!!.text.toString()
        }
    }
}
