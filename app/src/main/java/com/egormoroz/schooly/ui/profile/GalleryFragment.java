//package com.egormoroz.schooly.ui.profile;
//
//import android.Manifest;
//import android.content.pm.PackageManager;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.core.app.ActivityCompat;
//import androidx.core.content.ContextCompat;
//import androidx.fragment.app.Fragment;
//import androidx.recyclerview.widget.GridLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.egormoroz.schooly.MainActivity;
//import com.egormoroz.schooly.R;
//import com.google.android.material.bottomnavigation.BottomNavigationView;
//
//import java.util.List;
//
//public class GalleryFragment extends Fragment {
//
//    public static GalleryFragment newInstance() {
//        return new GalleryFragment();
//    }
//    RecyclerView recyclerView;
//    com.egormoroz.ui.profile.RecyclerViewAdapter recyclerViewAdapter;
//    List<String> images;
//    TextView gallery_number;
//
//    private static final int MY_READ_PERMISSION_CODE = 101;
//
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
//                             @Nullable Bundle savedInstanceState){
//        View root =inflater.inflate(R.layout.fragment_gallery,container,false);
//        BottomNavigationView bnv = getActivity().findViewById(R.id.bottomNavigationView);
//        bnv.setVisibility(bnv.GONE);
//        return root;
//    }
//
//    @Override
//    public void onViewCreated(@Nullable View view,@NonNull Bundle bundleSavedInstsnce){
//        super.onViewCreated(view,bundleSavedInstsnce);
//        gallery_number = view.findViewById(R.id.gallery_number);
//        recyclerView =view.findViewById(R.id.recycleView);
//
//        if (ContextCompat.checkSelfPermission(GalleryFragment.this,
//                Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(GalleryFragment.this,
//                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, MY_READ_PERMISSION_CODE);
//        } else {
//            loadImages();
//        }
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_gallery);
//
//        gallery_number = findViewById(R.id.gallery_number);
//        recyclerView = findViewById(R.id.recycleView);
//
//        if (ContextCompat.checkSelfPermission(GalleryFragment.this,
//                Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(GalleryFragment.this,
//                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, MY_READ_PERMISSION_CODE);
//        } else {
//            loadImages();
//        }
//    }
//
//    private void loadImages() {
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
//        images = Images.listOfImages(this);
//        recyclerViewAdapter = new RecyclerViewAdapter(this, images, new RecyclerViewAdapter.PhotoListener() {
//            @Override
//            public void onPhotoClick(String path) {
//                Toast.makeText(MainActivity.this, "" + path, Toast.LENGTH_SHORT).show();
//            }
//        });
//        recyclerView.setAdapter(recyclerViewAdapter);
//        gallery_number.setText("Photos (" + images.size() + ")");
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//
//        if(requestCode == MY_READ_PERMISSION_CODE) {
//            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                Toast.makeText(this, "Read external storage permission granted", Toast.LENGTH_SHORT).show();
//                loadImages();
//            } else {
//                Toast.makeText(this, "Read external storage permission denied", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }
//}
//
//
