package com.ramish.f200433_3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class my_profile extends AppCompatActivity {
    ImageView dp;
    String userUid;
    private static final int GALLERY_REQUEST_CODE = 123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        userUid = sharedPreferences.getString("UID", null); // Retrieve the UID

        Toast.makeText(my_profile.this, userUid, Toast.LENGTH_LONG).show();
        dp=findViewById(R.id.profile_pic);



        dp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the gallery to select an image
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, GALLERY_REQUEST_CODE);


            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Uri imageUri = data.getData(); // Get the selected image's URI

        // After obtaining the image URL, set it in the ImageView
        ImageView profileImage = findViewById(R.id.profile_pic);
        profileImage.setImageURI(imageUri);

        // Get a reference to the Firebase Storage instance
        StorageReference storageRef = FirebaseStorage.getInstance().getReference();

        // Create a unique filename for the image (e.g., using a timestamp)
        String imageFileName = "images/" + System.currentTimeMillis() + ".jpg";
        StorageReference imageRef = storageRef.child(imageFileName);

        // Upload the image to Firebase Storage
        imageRef.putFile(imageUri)
                .addOnSuccessListener(taskSnapshot -> {
                    // Handle successful upload, e.g., get the download URL
                    imageRef.getDownloadUrl().addOnSuccessListener(uri -> {
                        String imageUrl = uri.toString();

                        // Now you can save 'imageUrl' in the Realtime Database
                        // In this example, we're saving it under the user's UID
                        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("users").child(userUid);
                        databaseReference.child("profile_picture").setValue(imageUrl);
                    });
                })
                .addOnFailureListener(e -> {
                    // Handle the upload failure
                });
    }

    public void open_search(View view){
        Intent intent=new Intent(
                my_profile.this,
                search.class);
        startActivity(intent);
    }
    public void Open_add_item(View view){
        Intent intent=new Intent(
                my_profile.this,
                add_item.class);
        startActivity(intent);
    }
    public void OpenChat(View view){
        Intent intent=new Intent(
                my_profile.this,
                inbox.class);
        startActivity(intent);
    }
    public void OpenProfile(View view){
        Intent intent=new Intent(
                my_profile.this,
                my_profile.class);
        startActivity(intent);
    }
    public void openHome(View view){
        Intent intent=new Intent(
                my_profile.this,
                dashboard.class);
        startActivity(intent);
    }
    public void OpenEditProfile(View view){
        Intent intent=new Intent(
                my_profile.this,
                edit_profiel.class);
        startActivity(intent);
    }
    public void OpenAllItem(View view){
        Intent intent=new Intent(
                my_profile.this,
                search_result.class);
        startActivity(intent);
    }
    public void OpenItemDetail(View view){
        Intent intent=new Intent(
                my_profile.this,
                ItemDescription1Activity.class);
        startActivity(intent);
    }
}