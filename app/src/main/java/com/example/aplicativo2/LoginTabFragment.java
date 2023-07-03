package com.example.aplicativo2;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LoginTabFragment extends Fragment {

    private EditText emailEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private TextView errorMessageTextView;

    private SharedPreferences sharedPreferences;
    private static final String PREFS_NAME = "LoginPrefs";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login_tab, container, false);

        emailEditText = view.findViewById(R.id.login_email);
        passwordEditText = view.findViewById(R.id.login_password);
        loginButton = view.findViewById(R.id.login_button);
        errorMessageTextView = view.findViewById(R.id.error_message);


        sharedPreferences = requireActivity().getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (isValidCredentials(email, password)) {
                    // Salvar o login utilizando SharedPreferences
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_EMAIL, email);
                    editor.putString(KEY_PASSWORD, password);
                    editor.apply();

                    // Lógica de autenticação bem-sucedida
                    errorMessageTextView.setVisibility(View.GONE);
                    // Continuar com o fluxo do aplicativo
                } else {
                    // Exibir mensagem de erro
                    errorMessageTextView.setText(R.string.log_error_message);
                    errorMessageTextView.setVisibility(View.VISIBLE);
                }
            }
        });

        return view;
    }

    private boolean isValidCredentials(String email, String password) {
        // Lógica de validação das credenciais
        // Retorne true se as credenciais forem válidas, caso contrário, retorne false
        return false;
    }
}
