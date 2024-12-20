package com.example.jaime_lopez_taller_3.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.jaime_lopez_taller_3.R;
import com.example.jaime_lopez_taller_3.model.UserViewModel;
import com.example.jaime_lopez_taller_3.task.SimulatedNetworkTask;
import com.example.jaime_lopez_taller_3.util.BackgroundUtil;

public class RedActivity extends AppCompatActivity {

    private EditText nameEditText;
    private TextView nameTextView;
    private UserViewModel userViewModel;
    BackgroundUtil backgroundUtil;

    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        backgroundUtil = new BackgroundUtil(this);

        // Aplicar el fondo al iniciar la actividad.
        backgroundUtil.applyBackground(this);

        nameEditText = findViewById(R.id.nameEditText);
        Button saveButton = findViewById(R.id.saveButton);
        nameTextView = findViewById(R.id.nameTextView);
        Button startTaskButton = findViewById(R.id.startTaskButton);

        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        userViewModel.getUserName().observe(this, name -> {
            if (name != null && !name.isEmpty()) {
                nameTextView.setText("Nombre: " + name);
            } else {
                nameTextView.setText("No se ha guardado ningún nombre.");
            }
        });

        saveButton.setOnClickListener(v -> {
            String name = nameEditText.getText().toString().trim();
            if (TextUtils.isEmpty(name)) {
                Toast.makeText(RedActivity.this, "Por favor ingresa un nombre.", Toast.LENGTH_SHORT).show();
            } else {
                userViewModel.saveUserName(name);
                Toast.makeText(RedActivity.this, "Nombre guardado correctamente.", Toast.LENGTH_SHORT).show();
                nameEditText.setText("");
            }
        });
        startTaskButton.setOnClickListener(v -> {
            // Ejecutar la tarea simulada de red
            new SimulatedNetworkTask(this, nameTextView).execute();
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        backgroundUtil.applyBackground(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        backgroundUtil.shutdown();
    }
}
