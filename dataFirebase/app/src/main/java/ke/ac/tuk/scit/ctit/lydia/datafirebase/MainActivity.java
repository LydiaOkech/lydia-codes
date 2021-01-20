package ke.ac.tuk.scit.ctit.lydia.datafirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private EditText names, phone,specialtys,statuss;
    private Button send;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        names= (EditText) findViewById(R.id.nameET);
        phone= (EditText) findViewById(R.id.phoneET);
        specialtys= (EditText) findViewById(R.id.specialtyET);
        statuss= (EditText) findViewById(R.id.statusET);
        send = (Button) findViewById(R.id.sendBT);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addVet();
            }
        });
    }

    private void addVet() {
        //getting the values to save
        String name = names.getText().toString().trim();
        String phoneNumber = phone.getText().toString().trim();
        String specialty = specialtys.getText().toString().trim();
        String status = "Active";


        //checking if the value is provided
        if (!TextUtils.isEmpty(name)) {

            //creating an Artist Object
            Vet vet = new Vet(name,phoneNumber,specialty,status);

            //Saving the Artist
           mDatabase.child("Vets").child(phoneNumber).setValue(vet);

            //displaying a success toast
            Toast.makeText(this, "Vet added", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(getApplicationContext(),Data.class);
            startActivity(intent);
            finish();
        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_LONG).show();
        }
    }
}