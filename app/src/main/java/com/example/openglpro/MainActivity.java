package com.example.openglpro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.openglpro.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'openglpro' library on application startup.
    static {
        System.loadLibrary("openglpro");
    }

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        MyGLSurfaceView mGlSurfaceView = new MyGLSurfaceView(this);
        ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT,
                ConstraintLayout.LayoutParams.MATCH_PARENT);
        addContentView(mGlSurfaceView, params);
    }

    /**
     * A native method that is implemented by the 'openglpro' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}