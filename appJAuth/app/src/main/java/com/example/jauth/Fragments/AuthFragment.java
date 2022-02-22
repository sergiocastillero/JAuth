package com.example.jauth.Fragments;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.jauth.R;
import com.example.jauth.Retrofit.Interfaces.CheckInApi;
import com.example.jauth.Retrofit.Interfaces.LoginApi;
import com.example.jauth.Retrofit.Interfaces.RegisterApi;
import com.example.jauth.Retrofit.Interfaces.URL.JAuthURL;
import com.example.jauth.Retrofit.Models.CheckIn;
import com.example.jauth.Retrofit.Models.Login;
import com.example.jauth.Retrofit.Models.Register;
import com.example.jauth.databinding.FragmentAuthBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthFragment extends Fragment {

    // Properties
    private FragmentAuthBinding binding;
    private Button CheckBtn;
    private TextView checkin_time;
    private VideoView videoview;
    private ImageView idcard;
    private CheckIn checkinResponse;

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
        CheckBtn = root.findViewById(R.id.btn_Check);
        checkin_time = root.findViewById(R.id.TextView_CheckIn);
        videoview = root.findViewById(R.id.videoview);
        //idcard = root.findViewById(R.id.idcard);

        //Calling method for show first video frame
        firstFrameAnimation();

        // If Check button is clicked
        CheckBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*
                if (CheckBtn.getText().equals(getString(R.string.CheckIn))) {
                    CheckBtn.setText(getString(R.string.CheckOut));
                    CheckBtn.setSelected(true);

                    postCheckIn("Oriol");
                } else {
                    CheckBtn.setText(getString(R.string.CheckIn));
                    CheckBtn.setSelected(false);

                }
                */
                postCheckIn("prof2");
                postRegister("prof1");
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
        CheckInApi CheckInApi = JAuthURL.getClient().create(CheckInApi.class);

        Call<CheckIn> CheckInCall = CheckInApi.postCheckIn(user_id);

        CheckInCall.enqueue(new Callback<CheckIn>() {
            @Override
            public void onResponse(Call<CheckIn> call, Response<CheckIn> response) {
                try {
                    if(response.isSuccessful()) {
                        Log.i("testauth", response.body().toString());

                        checkinResponse = response.body();

                        if (checkinResponse.getResult().equals("OK") && checkinResponse.getType().equals("Entrada") && CheckBtn.getText().equals(getString(R.string.CheckIn))) {
                            CheckBtn.setText(getString(R.string.CheckOut));
                            CheckBtn.setSelected(true);

                            checkAnimation(R.raw.idcard_ok);

                        } else if(checkinResponse.getResult().equals("OK") && checkinResponse.getType().equals("Sortida") && CheckBtn.getText().equals(getString(R.string.CheckOut))) {
                            CheckBtn.setText(getString(R.string.CheckIn));
                            CheckBtn.setSelected(false);

                            checkAnimation(R.raw.idcard_ok);

                        } else if((checkinResponse.getResult().equals("KO") && checkinResponse.getType().equals("Entrada")) || (checkinResponse.getResult().equals("KO") && checkinResponse.getType().equals("Sortida"))){
                            checkAnimation(R.raw.idcard_ko);
                            checkin_time.setText("fail check");


                        } else{
                            checkin_time.setText("another error");
                        }
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

    private void postRegister(String user_id) {
        final Register register = new Register(user_id, "Oriol", "Jauma", "oriol.jauma@asdf.com", "1233455");
        RegisterApi RegisterApi = JAuthURL.getClient().create(RegisterApi.class);

        Call<Register> RegisterCall = RegisterApi.postRegister(register, user_id);

        RegisterCall.enqueue(new Callback<Register>() {
            @Override
            public void onResponse(Call<Register> call, Response<Register> response) {
                try {
                    if(response.isSuccessful()) {
                        Log.i("testauth", response.body().toString());

                        Register registerResponse = response.body();
                        //register_result.setText("Nom: " + registerResponse.getResult());
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
        LoginApi LoginApi = JAuthURL.getClient().create(LoginApi.class);

        Call<Login> LoginCall = LoginApi.getLogin(user_id, password);

        LoginCall.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                try {

                    if(response.isSuccessful()) {
                        Log.i("testauth", response.body().toString());

                        Login loginResponse = response.body();
                        //login_result.setText("Usuari: " + loginResponse.getUser() + System.lineSeparator() + "Resultat: " + loginResponse.getResult());
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

    public void firstFrameAnimation(){
        MediaController mediacontroller = new MediaController(videoview.getContext());
        mediacontroller.setAnchorView(videoview);
        Uri uri = Uri.parse("android.resource://"+getActivity().getPackageName()+"/" + R.raw.idcard_ok);
        ViewGroup.LayoutParams params=videoview.getLayoutParams();
        videoview.setLayoutParams(params);
        videoview.setVideoURI(uri);
        videoview.requestFocus();
        videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            public void onPrepared(MediaPlayer mp) {
                videoview.seekTo(1);
            }
        });
    }

    public void checkAnimation(int video){
        Uri uri = Uri.parse("android.resource://"+getActivity().getPackageName()+"/" + video);
        videoview.setVideoURI(uri);
        videoview.start();
        checkin_time.setText("Last Timestamp: " + System.lineSeparator() + checkinResponse.getTimestamp());

    }
}