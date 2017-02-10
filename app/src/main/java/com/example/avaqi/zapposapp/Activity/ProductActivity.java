package com.example.avaqi.zapposapp.Activity;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.PathMeasure;
import android.graphics.Path;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.avaqi.zapposapp.R;
import com.example.avaqi.zapposapp.databinding.ActivityProductBinding;
import com.example.avaqi.zapposapp.model.Item;
import com.squareup.picasso.Picasso;

/**
 * Created by Avaqi on 2017/2/8.
 */

public class ProductActivity extends AppCompatActivity {
    private ImageView itemPic;
    private ImageView cart;
    private CardView cd;
    private RelativeLayout toprl;
    private PathMeasure mPathMeasure;
    private float[] mCurrentPosition = new float[2];
    private TextView count;
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //binding data with UI
        ActivityProductBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_product);
        itemPic= (ImageView) findViewById(R.id.itemPic);
        initView();
        Intent intent=getIntent();
        Item item= (Item) intent.getSerializableExtra("Product");
        binding.setItem(item);
        Picasso.with(getApplicationContext()).load(item.getThumbnail()).into(itemPic);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addCart(itemPic);
                Snackbar.make(view, "Item added!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    private void initView() {
        cart = (ImageView) findViewById(R.id.cart);
        cd = (CardView) findViewById(R.id.card_view2);
        count = (TextView) findViewById(R.id.count);
        toprl = (RelativeLayout) findViewById(R.id.toprl);
    }
    /**
     * draw bezier curve from imageView to the cart as the animation
     */
    private void addCart( ImageView iv) {
        final ImageView goods = new ImageView(ProductActivity.this);
        goods.setImageDrawable(iv.getDrawable());
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(100, 100);
        cd.addView(goods, params);

        int[] parentLocation = new int[2];
        cd.getLocationInWindow(parentLocation);

        int startLoc[] = new int[2];
        iv.getLocationInWindow(startLoc);

        int endLoc[] = new int[2];
        cart.getLocationInWindow(endLoc);

        float startX = startLoc[0] - parentLocation[0] + iv.getWidth() / 2;
        float startY = startLoc[1] - parentLocation[1] + iv.getHeight() / 2;

        float toX = endLoc[0] - parentLocation[0] + cart.getWidth() / 5;
        float toY = endLoc[1] - parentLocation[1];

        Path path = new Path();
        path.moveTo(startX, startY);
        path.quadTo((startX + toX) / 2, startY, toX, toY);
        mPathMeasure = new PathMeasure(path, false);

        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, mPathMeasure.getLength());
        valueAnimator.setDuration(1000);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (Float) animation.getAnimatedValue();

                mPathMeasure.getPosTan(value, mCurrentPosition, null);
                goods.setTranslationX(mCurrentPosition[0]);
                goods.setTranslationY(mCurrentPosition[1]);
            }
        });

        valueAnimator.start();

        valueAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                i++;
                count.setText(String.valueOf(i));
                cd.removeView(goods);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }


}
