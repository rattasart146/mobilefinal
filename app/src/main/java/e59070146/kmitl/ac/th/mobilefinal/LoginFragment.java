package e59070146.kmitl.ac.th.mobilefinal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import e59070146.kmitl.ac.th.mobilefinal.tools.Account;
import e59070146.kmitl.ac.th.mobilefinal.tools.AccountDB;

public class LoginFragment extends Fragment {

    private AccountDB accountDB;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Button loginButton = (Button) getView().findViewById(R.id.button_login);
        Button registerButton = (Button) getView().findViewById(R.id.button_register);

        loginButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        TextView userId = (TextView) getView().findViewById(R.id.user_id);
                        TextView password = (TextView) getView().findViewById(R.id.password);

                        String userIdText = userId.getText().toString();
                        String passwordText = password.getText().toString();

                        if(userIdText.isEmpty() || passwordText.isEmpty()){
                            Log.i("LOGIN","Please fill out this form");
                            Toast.makeText(getActivity(), "กรุณาระบุ Username หรือ Password",Toast.LENGTH_SHORT).show();
                        }else if(userId.equals("admin") && passwordText.equals("admin")){
                            Log.i("LOGIN","Invalid user or password");
                            Toast.makeText(getActivity(), "Username และ Password ไม่ถูกต้อง",Toast.LENGTH_SHORT).show();
                        }else{
                            Log.i("LOGIN","Login success");

                        }
                    }
                }
        );

        registerButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        getActivity().getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.main_view, new RegisterFragment())
                                .commit();
                    }
                }
        );


    }
}
