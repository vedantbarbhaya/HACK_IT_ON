package com.example.vedantbarbhaya.swachh_bangalore;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

public class HomeActivity extends AppCompatActivity  {

    private static final String TAG = "MainActivity";
    private static final int ERROR_DIALOG_REQUEST = 9001;
    MapsActivity mps;
    EditText editname,editemail,editphno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if(isServicesOK()) {
            init();
        }
    }
    private void init()
    {
        Button button = findViewById(R.id.Homebut);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,MapsActivity.class);
                mps = new MapsActivity();
                editname = findViewById(R.id.t1);
                editphno = findViewById(R.id.t2);
                editemail = findViewById(R.id.t3);
                intent.putExtra("editName", editname.getText().toString());
                intent.putExtra("editPhno", editphno.getText().toString());
                intent.putExtra("editEmail", editemail.getText().toString());
                startActivity(intent);
            }
        });
    }
    public boolean isServicesOK() {
        Log.d(TAG, "isServicesOK: checking google services version");
        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this);

        if (available == ConnectionResult.SUCCESS) {
            //everything is ok
            Log.d(TAG, "isServicesOK: google play services is working ");
            return true;
        } else if (GoogleApiAvailability.getInstance().isUserResolvableError(available)) {
            //if error is resolvable
            Log.d(TAG, "isServicesOK: an error has occured but we can fix it");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(this, available, ERROR_DIALOG_REQUEST);
            dialog.show();
        } else {
            Toast.makeText(this, "you cant make map requests", Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}
