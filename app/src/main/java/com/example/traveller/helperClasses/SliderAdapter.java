package com.example.traveller.helperClasses;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.example.traveller.R;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    int[] images = {

            R.drawable.slider1,
            R.drawable.select_slider2,
            R.drawable.captures_lider3,
            R.drawable.share_slider4
    };

    int[] headings = {

            R.string.slider_heading1,
            R.string.slider_heading2,
            R.string.slider_heading3,
            R.string.slider_heading4

    };

    int[] description = {

            R.string.slider_desc1,
            R.string.slider_desc2,
            R.string.slider_desc3,
            R.string.slider_desc4

    };

    @Override
    public int getCount() {
        return headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService ( Context.LAYOUT_INFLATER_SERVICE );
        View view = layoutInflater.inflate ( R.layout.slides_layout,container, false );

        //Hooks
        ImageView imageView = view.findViewById (  R.id.slider_image);
        TextView heading = view.findViewById (  R.id.slider_hedding);
        TextView dec = view.findViewById (  R.id.slider_desc);
        //Hooks
        imageView.setImageResource ( images[position] );
         heading.setText( headings[position] );
        dec.setText ( description[position] );

        container.addView ( view );
        return view ;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        // super.destroyItem ( container, position, object );
        container.removeView (( ConstraintLayout )object);
    }
}
