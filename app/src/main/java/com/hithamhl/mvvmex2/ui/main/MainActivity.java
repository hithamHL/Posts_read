package com.hithamhl.mvvmex2.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.hithamhl.mvvmex2.R;
import com.hithamhl.mvvmex2.adapter.PostAdapter;
import com.hithamhl.mvvmex2.databinding.ActivityMainBinding;
import com.hithamhl.mvvmex2.pojo.PostModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;
    PostAdapter postAdapter;
    MainViewModel mainViewModel;
    ArrayList<PostModel> postModelArrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);

        mainViewModel= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainViewModel.class);


        mainBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        postAdapter=new PostAdapter(this,postModelArrayList);
        mainViewModel.getPost().observe(this, new Observer<List<PostModel>>() {
            @Override
            public void onChanged(List<PostModel> postModels) {

                postAdapter.setPostlist(postModels);
                mainBinding.progressBar.setVisibility(View.GONE);
            }
        });


        mainBinding.recyclerView.setAdapter(postAdapter);





    }
}
