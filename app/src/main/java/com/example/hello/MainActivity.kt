package com.example.hello

//import uniffi.rust.helloFromRust
import dev.test.rust.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.hello.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.kotlin.text = "Hello from kotlin"
        // Example of a call to a native method
        binding.cpp.text = stringFromJNI()

        binding.rust.text = helloFromRust()
    }

    /**
     * A native method that is implemented by the 'hello' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    //external fun stringFromRust(): String

    companion object {
        // Used to load the 'hello' library on application startup.
        init {
            System.loadLibrary("hello")
            //System.loadLibrary("rust")
        }
    }
}