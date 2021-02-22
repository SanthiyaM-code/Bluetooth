package com.codewithsandy.bluetooth

import android.bluetooth.BluetoothAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    private val REQUEST_ENABLE_BT: Int = 1



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button: Button
        button = findViewById<Button>(R.id.button)


        val bluetoothAdapter: BluetoothAdapter? = BluetoothAdapter.getDefaultAdapter()
        if (bluetoothAdapter == null) {
            Toast.makeText(applicationContext, "This device does not support Bluetooth", Toast.LENGTH_SHORT).show()

        }

        button.setOnClickListener()
        {
            if (bluetoothAdapter?.isEnabled() == false) {

                val enableBtIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)

                startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT)
                button.setText("Turn Off Bluetooth")

            } else {

                bluetoothAdapter?.disable()
                button.setText("Turn On Bluetooth")
            }

        }



    }
}