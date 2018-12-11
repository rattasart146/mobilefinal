package e59070146.kmitl.ac.th.mobilefinal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import e59070146.kmitl.ac.th.mobilefinal.tools.Account;
import e59070146.kmitl.ac.th.mobilefinal.tools.AccountDB;

public class RegisterFragment extends Fragment {
    private AccountDB accountDB;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TextView userId = (TextView) getView().findViewById(R.id.register_user_id);
        TextView userName = (TextView) getView().findViewById(R.id.register_name);
        TextView age = (TextView) getView().findViewById(R.id.register_age);
        TextView password = (TextView) getView().findViewById(R.id.register_password);

        String userIdStr = userId.getText().toString();
        String userNameStr = userName.getText().toString();
        int ageInt = Integer.parseInt(age.getText().toString());
        String passwordStr = password.getText().toString();

        if(userIdStr.isEmpty() || userNameStr.isEmpty() || age.getText().toString().isEmpty() || passwordStr.isEmpty()) {
            Toast.makeText(getActivity(), "กรุณาระบุข้อมูลให้ครบถ้วน", Toast.LENGTH_SHORT).show();
            Log.i("REGISTER", "Field Name is Empyty");
        }
        else if(accountDB.checkUserAvailable(userIdStr)){
            Toast.makeText(getActivity(), "user นี้มีอยู่ในระบบแล้ว", Toast.LENGTH_SHORT).show();
            Log.i("REGISTER","USER ALREADY EXITS");
        }
        else if(passwordStr.length() > 6){
            Toast.makeText(getActivity(), "Wrong password", Toast.LENGTH_SHORT).show();
            Log.i("REGISTER", "Wrong password");
        }
        else if(ageInt <= 10 && ageInt >= 80){
            Toast.makeText(getActivity(), "อายุต้องอยู่ในช่วง 10 ปี - 80 ปี", Toast.LENGTH_SHORT).show();
            Log.i("REGISTER", "Wrong age");
        }
        else if(userIdStr.length() < 6 && userIdStr.length() > 12){
            Toast.makeText(getActivity(), "User Id ต้องมี 6 - 12 ตัวอักษร", Toast.LENGTH_SHORT).show();
            Log.i("REGISTER", "Wrong userID");
        }
        else{
            Account account = new Account();
            account.setUserId(userIdStr);
            account.setAge(ageInt);
            account.setUserName(userNameStr);
            account.setPassword(passwordStr);

            accountDB.updateAccount(account);

            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_view, new LoginFragment())
                    .commit();
        }
    }
}
