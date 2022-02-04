package ir.omidrezabagherian.testapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import ir.omidrezabagherian.testapp.databinding.ActivityNextBinding

class NextActivity : AppCompatActivity() {

    lateinit var bandingNext: ActivityNextBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bandingNext = ActivityNextBinding.inflate(layoutInflater)


        bandingNext.buttonSend.setOnClickListener {
            val text = bandingNext.edittextInputName.text.toString()
            val intentToBack = Intent()
            intentToBack.putExtra("NAME", text)
            Log.i("Extra",intentToBack.extras.toString())
            setResult(RESULT_OK,intentToBack)
            finish()
        }

        setContentView(bandingNext.root)
    }

    override fun onBackPressed() {
        setResult(Activity.RESULT_CANCELED)
        finish()
    }

}