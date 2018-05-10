package com.davidpopayan.sena.myapplication.Fragmentos;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import com.davidpopayan.sena.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentVideoEspec extends Fragment {


    public FragmentVideoEspec() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        VideoView videoView;
        View view = inflater.inflate(R.layout.fragment_fragment_video_espec, container, false);
        videoView = view.findViewById(R.id.videoplay);

        Uri uri = Uri.parse("http://techslides.com/demos/sample-videos/small.mp4");
        videoView.setMediaController((new MediaController(getActivity())));
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();
        return view;
    }

}
