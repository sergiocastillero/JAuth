package com.example.jauth.Fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.jauth.R;
import com.example.jauth.Retrofit.Interfaces.CheckInApi;
import com.example.jauth.Retrofit.Interfaces.LoginApi;
import com.example.jauth.Retrofit.Interfaces.RegisterApi;
import com.example.jauth.Retrofit.Models.CheckIn;
import com.example.jauth.Retrofit.Models.Login;
import com.example.jauth.Retrofit.Models.Register;
import com.example.jauth.databinding.FragmentAuthBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AuthFragment extends Fragment {

    // Properties
    private FragmentAuthBinding binding;
    private String checkText;
    private TextView login_result;
    private TextView register_result;
    private TextView checkin_result;


    // Declare a SharedPreferences object reference since you are going to store
    // the clicked button's state using Android SharedPreferences class.
    SharedPreferences prefs;
    SharedPreferences.Editor editor;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        binding = FragmentAuthBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Layout properties linked to add logic
        Button CheckBtn = root.findViewById(R.id.btn_Check);
        login_result = root.findViewById(R.id.TextView_Login);
        register_result = root.findViewById(R.id.TextView_Register);
        checkin_result = root.findViewById(R.id.TextView_CheckIn);

        // If Check button is clicked
        CheckBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (CheckBtn.getText().equals(getString(R.string.CheckIn))) {
                    CheckBtn.setText(getString(R.string.CheckOut));
                    CheckBtn.setSelected(true);

                    postRegister("Oriol","password1234");

                    getLogin("Oriol","password1234");

                    postCheckIn("Oriol");
                } else {
                    CheckBtn.setText(getString(R.string.CheckIn));
                    CheckBtn.setSelected(false);

                }
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

   private void postCheckIn(String user_id) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://private-11f82e-jauth.apiary-mock.com/v0/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CheckInApi CheckInApi = retrofit.create(CheckInApi.class);

        Call<CheckIn> CheckInCall = CheckInApi.postCheckIn(user_id);

        CheckInCall.enqueue(new Callback<CheckIn>() {
            @Override
            public void onResponse(Call<CheckIn> call, Response<CheckIn> response) {
                try {
                    if(response.isSuccessful()) {
                        Log.i("testauth", response.body().toString());

                        CheckIn checkinResponse = response.body();
                        checkin_result.setText("Resultat: " + checkinResponse.getResult() + System.lineSeparator() + "Data: " + checkinResponse.getTimestamp() + System.lineSeparator() + "Tipus: " + checkinResponse.getType());
                    }
                } catch (Exception e) {
                    Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CheckIn> call, Throwable t) {
                Toast.makeText(getActivity(), "Error de conexión", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void postRegister(String user_id, String password) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://private-11f82e-jauth.apiary-mock.com/v0/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RegisterApi RegisterApi = retrofit.create(RegisterApi.class);

        Call<Register> RegisterCall = RegisterApi.postRegister(user_id,password);

        RegisterCall.enqueue(new Callback<Register>() {
            @Override
            public void onResponse(Call<Register> call, Response<Register> response) {
                try {
                    if(response.isSuccessful()) {
                        Log.i("testauth", response.body().toString());

                        Register registerResponse = response.body();
                        register_result.setText("Nom: " + registerResponse.getName() + System.lineSeparator() + "Cognom: " + registerResponse.getLast_name() + System.lineSeparator() + "Email: " + registerResponse.getEmail() + System.lineSeparator() + "Contraseña: " + registerResponse.getPassword());
                    }
                } catch (Exception e) {
                    Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Register> call, Throwable t) {
                Toast.makeText(getActivity(), "Error de conexión", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void getLogin(String user_id, String password) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://private-11f82e-jauth.apiary-mock.com/v0/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LoginApi LoginApi = retrofit.create(LoginApi.class);

        Call<Login> LoginCall = LoginApi.getLogin(user_id, password);

        LoginCall.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                try {

                    if(response.isSuccessful()) {
                        Log.i("testauth", response.body().toString());

                        Login loginResponse = response.body();
                        login_result.setText("Usuari: " + loginResponse.getUser() + System.lineSeparator() + "Resultat: " + loginResponse.getResult());
                    }
                } catch (Exception e) {
                    Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                Toast.makeText(getActivity(), "Error de conexión", Toast.LENGTH_SHORT).show();

            }
        });
    }

}