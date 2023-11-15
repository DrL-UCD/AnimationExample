package edu.ucdenver.salimlakhani.animationexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.Animatable;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import edu.ucdenver.salimlakhani.animationexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        animation = AnimationUtils.loadAnimation(this, R.anim.anim1);

        binding.actionButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        animation.setDuration(10000);
                        animation.setAnimationListener(
                                new Animation.AnimationListener(

                                ) {
                                    @Override
                                    public void onAnimationStart(Animation animation) {
                                        binding.messageTextView.setText("Running");
                                    }

                                    @Override
                                    public void onAnimationEnd(Animation animation) {
                                        binding.messageTextView.setText("Stopped");

                                    }

                                    @Override
                                    public void onAnimationRepeat(Animation animation) {

                                    }
                                }
                        );
                        binding.imageView.startAnimation(animation);
                    }
                }
        );
    }
}