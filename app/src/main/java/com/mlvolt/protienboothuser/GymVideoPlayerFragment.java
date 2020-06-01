package com.mlvolt.protienboothuser;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleObserver;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class GymVideoPlayerFragment extends Fragment {


    YouTubePlayer youTubePlayer;
    public GymVideoPlayerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gym_video_player, container, false);

        youTubePlayer = view.findViewById(R.id.Youtube_player_video);
        getLifecycle().addObserver((LifecycleObserver) youTubePlayer);

        youTubePlayer.addListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(YouTubePlayer youTubePlayer) {
                super.onReady(youTubePlayer);
                String videoId = "X_9VoqR5ojM";
                youTubePlayer.loadVideo(videoId, 1);
            }
        });


        return view;


    }
}
