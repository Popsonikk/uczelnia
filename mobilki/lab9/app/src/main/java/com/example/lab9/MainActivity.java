package com.example.lab9;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.NotNull;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Button logout,add;
    private EditText edit;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add=findViewById(R.id.add);
        edit=findViewById(R.id.edit);
        logout=findViewById(R.id.logout);
        listView=findViewById(R.id.Listview);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(MainActivity.this, "Wylogowano", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this,StartActivity.class));
                finish();
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt_name=edit.getText().toString();
                if(txt_name.isEmpty())
                    Toast.makeText(MainActivity.this, "Puste pole", Toast.LENGTH_SHORT).show();
                else
                    FirebaseDatabase.getInstance().getReference().setValue(txt_name);
                }
        });

       final ArrayList<String> list= new ArrayList<>();
       final ArrayAdapter adapter=new ArrayAdapter(this,R.layout.list_item,list);
       listView.setAdapter(adapter);
        DatabaseReference reference= FirebaseDatabase.getInstance().getReference();
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot:dataSnapshot.getChildren())
                {
                    Informacje info= snapshot.getValue(Informacje.class);
                    String txt= info.getName()+ " : "+ info.getEmail();
                    list.add(txt);
                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        FirebaseFirestore db= FirebaseFirestore.getInstance();
      /*  HashMap<String,Object> city= new HashMap<>();
        city.put("Name","Lublin");
        city.put("State","Lubelskie");
        city.put("Country","Polska");
        db.collection("cities").document("WSPA").set(city).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Wartosc dodana", Toast.LENGTH_SHORT).show();
                }
            }
        });*/
      HashMap <String, Object> data= new HashMap<>();
       /*  data.put("Capital",false);
        db.collection("cities").document("WSPA").set(data, SetOptions.merge()).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful())
                    Toast.makeText(MainActivity.this, "Wartosc dodana", Toast.LENGTH_SHORT).show();
            }
        });*/
       /* data.put("name","Tokio");
        data.put("Capital","Japan");
        db.collection("cities").add(data).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull Task<DocumentReference> task) {
                if(task.isSuccessful())
                    Toast.makeText(MainActivity.this, "Wartosc dodana", Toast.LENGTH_SHORT).show();
            }
        });*/
      /*  DocumentReference docRef=FirebaseFirestore.getInstance().collection("cities").document("NY");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()){
                    DocumentSnapshot doc= task.getResult();
                    if(doc.exists())
                        Log.d("Document",doc.getData().toString());
                    else
                        Log.d("Document","No data");
                }
            }
        });*/
        FirebaseFirestore.getInstance().collection("cities").whereEqualTo("capital",true).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    for(QueryDocumentSnapshot doc:task.getResult())
                        Log.d("Document",doc.getId()+"=>"+doc.getData());
                }
            }
        });
        final ArrayList<Miasto> miasta= new ArrayList<>();
        FirebaseFirestore.getInstance().collection("cities").whereEqualTo("capital",true).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    for(QueryDocumentSnapshot doc:task.getResult()){
                        Log.d("Document",doc.getId()+"=>"+doc.getData());
                        Map<String,Object> city=doc.getData();
                        Boolean capital=(Boolean) city.get("capital");
                        String county=(String) city.get("country");
                        String name=(String) city.get("name");
                        Long population=(Long) city.get("population");
                        Log.d("Document",capital.toString());
                        Log.d("Document",county.toString());
                        Log.d("Document",name.toString());
                        Log.d("Document",population.toString());
                        miasta.add(new Miasto(capital,county,name,population));
                    }
                }
            }
        });

    }
}