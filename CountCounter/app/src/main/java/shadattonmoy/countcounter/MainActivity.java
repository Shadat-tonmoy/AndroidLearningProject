package shadattonmoy.countcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scoreTeamA = 0;
    int scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Display the score of Team A
    public void displayTeamAScore(int score)
    {
        TextView scoreA = (TextView) findViewById(R.id.scoreTeamA);
        scoreA.setText(Integer.toString(score));
    }

    //Display the score of Team B
    public void displayTeamBScore(int score)
    {
        TextView scoreB = (TextView) findViewById(R.id.scoreTeamB);
        scoreB.setText(Integer.toString(score));
    }

    //Add Three Points to Team A
    public void addThreeToA(View v)
    {
        scoreTeamA+=3;
        displayTeamAScore(scoreTeamA);
    }

    //Add Two Points to Team A
    public void addTwoToA(View v)
    {
        scoreTeamA+=2;
        displayTeamAScore(scoreTeamA);
    }

    //Add One Point to Team A
    public void addOneToA(View v)
    {
        scoreTeamA+=1;
        displayTeamAScore(scoreTeamA);
    }

    //Add Three Points to Team B
    public void addThreeToB(View v)
    {
        scoreTeamB+=3;
        displayTeamBScore(scoreTeamB);
    }

    //Add Two Points to Team B
    public void addTwoToB(View v)
    {
        scoreTeamB+=2;
        displayTeamBScore(scoreTeamB);
    }

    //Add One Point to Team B
    public void addOneToB(View v)
    {
        scoreTeamB+=1;
        displayTeamBScore(scoreTeamB);
    }

    //Reset Score of all team
    public void reset(View v)
    {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayTeamAScore(scoreTeamA);
        displayTeamBScore(scoreTeamB);
    }
}
