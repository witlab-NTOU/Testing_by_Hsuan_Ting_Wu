package com.ehappy.testing;

import android.os.Bundle;

import com.qozix.tileview.TileView;

public class LargeImageTileViewActivity extends TileViewActivity {

    @Override
    public void onCreate( Bundle savedInstanceState ) {

        super.onCreate( savedInstanceState );

        // multiple references
        TileView tileView = getTileView();

        // let the image explode設定能放大的限度
        tileView.setScaleLimits( 0, 3 );

        // size of original image at 100% mScale
        tileView.setSize( 1103,781 );

        // detail levels
        tileView.addDetailLevel( 1.000f, "painting/1000/%d_%d.jpg");
        tileView.addDetailLevel( 0.500f, "painting/500/%d_%d.jpg");
        tileView.addDetailLevel( 0.250f, "painting/250/%d_%d.jpg");
        tileView.addDetailLevel( 0.125f, "painting/125/%d_%d.jpg");

        // set mScale to 0, but keep scaleToFit true, so it'll be as small as possible but still match the container
        tileView.setScale( 0 );

        // let's use 0-1 positioning...
        tileView.defineBounds( 0, 0, 1, 1 );

        // frame to center
        frameTo( 1, 0.5 );

        // render while panning
        tileView.setShouldRenderWhilePanning( true );

        // disallow going back to minimum scale while double-taping at maximum scale (for demo purpose)
        tileView.setShouldLoopScale( true );
    }
}

