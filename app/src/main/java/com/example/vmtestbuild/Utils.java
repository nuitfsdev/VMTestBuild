package com.example.vmtestbuild;

import static android.Manifest.permission.READ_PHONE_NUMBERS;
import static android.Manifest.permission.READ_PHONE_STATE;
import static android.Manifest.permission.READ_PRECISE_PHONE_STATE;
import static android.Manifest.permission.READ_SMS;
import static android.hardware.Sensor.TYPE_GYROSCOPE;
import static android.hardware.Sensor.TYPE_ORIENTATION;


import android.Manifest;
import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Debug;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class Utils {

    //Build
    public static boolean hasEmulatorBuild(TextView textView, Context context) {
        String BOARD = android.os.Build.BOARD; // The name of the underlying board, like "unknown".
        // This appears to occur often on real hardware... that's sad
        // String BOOTLOADER = android.os.Build.BOOTLOADER; // The system bootloader version number.
        String BRAND = android.os.Build.BRAND; // The brand (e.g., carrier) the software is customized for, if any.
        // "generic"
        String DEVICE = android.os.Build.DEVICE; // The name of the industrial design. "generic"
        String HARDWARE = android.os.Build.HARDWARE; // The name of the hardware (from the kernel command line or
        // /proc). "goldfish"
        String MODEL = android.os.Build.MODEL; // The end-user-visible name for the end product. "sdk"
        String PRODUCT = android.os.Build.PRODUCT; // The name of the overall product.
        if ((BOARD.contains("unknown") == true) /* || (BOOTLOADER.compareTo("unknown") == 0) */
                || (BRAND.contains("generic") == true) || (DEVICE.contains("generic") == true)
                || (MODEL.contains("sdk") == true) || (PRODUCT.contains("sdk") == true)
                || (HARDWARE.contains("goldfish") == true)) {
            Log.d("find:","Build");
            textView.setText("An emulator build! BUILD TESTING:" + "\n" + "BOARD:" + BOARD + "\n" + "BRAND:" + BRAND + "\n" +
                    "DEVICE:" + DEVICE + "\n" + "MODEL:" + MODEL + "\n"
                    + "PRODUCT:" + PRODUCT + "\n" + "HARDWARE:" + HARDWARE + "\n");
            return true;
        }
        Log.d("test:","No build");
        textView.setText("No emulator build!" + "BUILD TESTING:" + "\n" + "BOARD:" + BOARD + "\n" + "BRAND:" + BRAND + "\n" +
                "DEVICE:" + DEVICE + "\n" + "MODEL:" + MODEL + "\n"
                + "PRODUCT:" + PRODUCT + "\n" + "HARDWARE:" + HARDWARE + "\n");
        return false;
    }


}