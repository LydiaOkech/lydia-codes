package ke.ac.tuk.scit.ctit.lydia.datafirebase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Data extends AppCompatActivity {

    private Button inse, pande, con;
    private ListView listView;
    List<Vet> vets;
    Context mContext;

    DatabaseReference mDatabase;
    String TAG ="Data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        inse = (Button) findViewById(R.id.insemination);
        pande = (Button) findViewById(R.id.pandemic);
        con = (Button) findViewById(R.id.consultation);
        listView = (ListView) findViewById(R.id.listview);



        vets = new ArrayList<Vet>();
        mDatabase = FirebaseDatabase.getInstance().getReference("Vets");
        inse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getVets();

            }
        });

        con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeData();
            }
        });
    }

    private void changeData() {
        String status = "InActive";
        String phoneNumber = "0715879813";
        String name = "";
        String specialty = "";

        mDatabase.getRef().child(phoneNumber).child("status").setValue(status);


/*String id = "0715888813";
String statuses="InActive";
        firebase.database().ref("Vets/" + id).set({
                status:statuses}, (error) => {
            if (error) {
                // The write failed...
            } else {
                // Data saved successfully!
            }
        });*/
    }

    private void getVets() {

        mDatabase.orderByChild("specialty").equalTo("Insemination").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //clearing the previous artist list
                vets.clear();

                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting artist
                    Vet vet = postSnapshot.getValue(Vet.class);
                    //adding artist to the list
                    vets.add(vet);
                }

                //creating adapter
                Vetslist artistAdapter = new Vetslist(Data.this, vets);
                //attaching adapter to the listview
                listView.setAdapter(artistAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
   }

    }
