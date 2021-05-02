package sg.edu.np.madapplication.madapplication.madpractical.s10203319;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private User user;

    private TextView text_name;
    private TextView text_description;
    private Button button_follow;
    private Button button_message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.text_name = findViewById(R.id.name);
        this.text_description = findViewById(R.id.desc);
        this.button_follow = findViewById(R.id.follow);
        this.button_message = findViewById(R.id.msg);

        User NewUser = new User("Damien", "Captain of the school basketball team, enjoy coding and math.",  1, false);
        this.setUser(NewUser);
        this.button_follow.setOnClickListener(v -> {
            this.user.setFollowed(!this.user.isfollowed());
            this.updateUserFollowState();
        });
    }



    private void setUser(User user) {
        this.user = user;
        this.updateUserInfo();
        this.updateUserFollowState();
    }

    private void updateUserInfo() {
        this.text_name.setText(user.getName());
        this.text_description.setText(user.getDescription());
    }

    private void updateUserFollowState() {
        if(this.user.isfollowed()){
            this.button_follow.setText("UNFOLLOW");
        }
        else{
            this.button_follow.setText("FOLLOW");
        }
    }
}