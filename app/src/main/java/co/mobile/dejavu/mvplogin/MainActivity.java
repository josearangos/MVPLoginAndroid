package co.mobile.dejavu.mvplogin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import co.mobile.dejavu.mvplogin.Login.Presenter.ILoginPresenter;
import co.mobile.dejavu.mvplogin.Login.Presenter.LoginPresenter;
import co.mobile.dejavu.mvplogin.Login.View.ILoginView;
import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity implements ILoginView {


    private EditText edtemail;
    private EditText edtpassword;
    private Button btnlogin;
    private ILoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Init Views
        this.btnlogin = (Button) findViewById(R.id.btn_login);
        this.edtpassword = (EditText) findViewById(R.id.edt_password);
        this.edtemail = (EditText) findViewById(R.id.edt_email);

        //Init Presenter
        loginPresenter = new LoginPresenter(this);

        //Events
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.onLogin(edtemail.getText().toString(),edtpassword.getText().toString());
            }
        });

    }


    @Override
    public void onLoginSuccess(String message) {
        Toasty.success(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginError(String message) {
        Toasty.error(getApplicationContext(),message,Toast.LENGTH_SHORT).show();

    }
}
