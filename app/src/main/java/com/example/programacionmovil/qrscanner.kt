package com.example.programacionmovil

import android.Manifest.permission.CAMERA
import android.Manifest.permission_group.CAMERA
import android.content.Intent
import android.content.pm.PackageManager
import android.media.MediaRecorder.VideoSource.CAMERA
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.budiyev.android.codescanner.AutoFocusMode
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.CodeScannerView
import com.budiyev.android.codescanner.DecodeCallback
import com.budiyev.android.codescanner.ErrorCallback
import com.budiyev.android.codescanner.ScanMode
import java.util.Scanner

class qrscanner : AppCompatActivity() {
    private lateinit var codeScanner: CodeScanner
    private val MY_CAMERA_PERMISSION_REQUEST =1111
    private lateinit var scannerView:CodeScannerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qrscanner)
        scannerView= findViewById(R.id.scannerView)
        codeScanner=  CodeScanner(this,scannerView)
        codeScanner.camera=CodeScanner.CAMERA_BACK

        codeScanner.formats=CodeScanner.ALL_FORMATS
        codeScanner.autoFocusMode=AutoFocusMode.SAFE
        codeScanner.scanMode=ScanMode.SINGLE
        codeScanner.isAutoFocusEnabled=true
        codeScanner.isFlashEnabled=false

        codeScanner.decodeCallback = DecodeCallback{
            runOnUiThread{
                Toast.makeText(this,"Scan Result: ${it.text}",Toast.LENGTH_LONG).show()
                val intent= Intent(this,Dialog::class.java)
                intent.putExtra("qrCodeValue",it.text)
                codeScanner.stopPreview()

                codeScanner.stopPreview()
            }

        }
        codeScanner.errorCallback =ErrorCallback{
            runOnUiThread{
                Toast.makeText(this,"Camera Error: ${it.message}",Toast.LENGTH_LONG).show()
            }
        }
        codeScanner.startPreview()
        checkPermission()
    }
    fun checkPermission(){
        if (ContextCompat.checkSelfPermission(this,android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA),MY_CAMERA_PERMISSION_REQUEST)
        }else{
            codeScanner.startPreview()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}