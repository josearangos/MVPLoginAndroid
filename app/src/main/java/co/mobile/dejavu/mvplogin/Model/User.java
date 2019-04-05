package co.mobile.dejavu.mvplogin.Model;

import android.text.TextUtils;
import android.util.Patterns;


public class User implements IUser {

    private String email,password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isValidData() {
        /*
        * 1. Check email is empty
        * 2. Check email is matches pattern
        * 3. Check password length >6
        * */

        return !TextUtils.isEmpty(getEmail()) &&
                Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches() &&
                getPassword().length()>6;
    }
}
