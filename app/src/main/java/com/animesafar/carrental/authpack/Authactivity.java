package com.animesafar.carrental.authpack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.animesafar.carrental.R;
import com.animesafar.carrental.mainpage.Mainpage;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class Authactivity extends AppCompatActivity implements View.OnClickListener {

    GoogleSignInClient mGoogleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authactivity);

        findViewById(R.id.sign_in_button).setOnClickListener(this);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.sign_in_button:
                signIn();
                break;
            // ...
        }



    }
    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, 2000);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == 2000) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }
    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount acct1 = GoogleSignIn.getLastSignedInAccount(this);
if(acct1 == null){

    GoogleSignInAccount acct = completedTask.getResult(ApiException.class);

    // Signed in successfully, show authenticated UI.
    if (acct != null) {
        String personName = acct.getDisplayName();
        String personGivenName = acct.getGivenName();
        String personFamilyName = acct.getFamilyName();
        String personEmail = acct.getEmail();
        String personId = acct.getId();
        Uri personPhoto = acct.getPhotoUrl();
        Toast.makeText(this , personEmail+" "+personName+" "+personGivenName+" "+personId+" "+personFamilyName+" "+personPhoto,Toast.LENGTH_LONG).show();

    }

}else{
    String personName = acct1.getDisplayName();
    String personGivenName = acct1.getGivenName();
    String personFamilyName = acct1.getFamilyName();
    String personEmail = acct1.getEmail();
    String personId = acct1.getId();
    Uri personPhoto = acct1.getPhotoUrl();
    Toast.makeText(this , personEmail+" "+personName+" "+personGivenName+" "+personId+" "+personFamilyName+" "+personPhoto,Toast.LENGTH_LONG).show();
startActivity(new Intent(this , Mainpage.class));
}
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.

            Toast.makeText(this , e.getStatusCode()+" failed",Toast.LENGTH_LONG).show();


        }
    }

    private void updateUI(GoogleSignInAccount account){

        Toast.makeText(this , account.getId()+" "+account.getDisplayName()+" "+account.getAccount()+" "+account.getEmail(),Toast.LENGTH_LONG).show();


    }


}