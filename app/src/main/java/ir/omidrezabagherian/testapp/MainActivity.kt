package ir.omidrezabagherian.testapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import ir.omidrezabagherian.testapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var bandingMain: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bandingMain = ActivityMainBinding.inflate(layoutInflater)

        bandingMain.buttonActivityNext.setOnClickListener {
            val intent = Intent(this, NextActivity::class.java)
            resultContract.launch(intent)
        }

        setContentView(bandingMain.root)
    }

    private val resultContract =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult? ->
            val txt = result?.data?.extras?.get("NAME")
            Log.i("Tag",txt.toString())
            if (result?.resultCode == Activity.RESULT_OK)
                Toast.makeText(this, txt.toString(), Toast.LENGTH_SHORT).show()
        }
}

