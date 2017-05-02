package pw.adithya.insider;

import android.app.Activity;
import android.app.Dialog;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ReviewLayoutActivity extends Fragment {
    ReviewDialogFragment currentOpenInput;
    View rootview, rootview2;
    Context myContext;
    ArrayList<Float> ratings = new ArrayList<Float>(10);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.review_layout, container, false);

        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);
        Locale.setDefault(Locale.ENGLISH);

        Button b = (Button) rootview.findViewById(R.id.btnReview);
        b.setOnClickListener(mButtonClickListener);

        TextView tv = (TextView) rootview.findViewById(R.id.tvText);
        tv.setText("Hamilton Ptd Ltd is a Chinese company that produces meat products such as beef, chicken and pork. Hamilton is known for their ham, which can be found in most Asian countries.\n\nPros/Cons: \nx Nursing Room \nx Fridge \nx Childcare \nx Gym \n- 30 toilets for women across 30 floors");

        addReview("R. T.",(float)2.0,"12/12/16","Sexual harassment is rampant in Hamilton. I have been groped so many times this past year that I am finally at the end of my rope. None of my attempts to report to the management have worked. In fact just last week, I was fired for “filing too many irrelevant complains”. Irrelevant. The management actually considers sexual harassment as irrelevant. Cue horror. I have filed a lawsuit, but I don’t think I have a legitimate chances of winning. My harasser was careful to do it when nobody else is around and now, it’s a game of “He says, she says”. To add on, right before I was fired, I was suddenly given all the bad shifts. Honestly, if this isn’t a classic example of retaliation by the management, I don’t know what is. Don’t bother applying for Hamilton, it does not care about its employees.");

        addReview("U. E.",(float)3.0,"12/11/16","I am quite sick of my boss. He is constantly criticising me just because he didn’t approve of me having a baby as a single woman. He even once pretended to look for an engagement ring on my hand. I repeatedly told him that his behaviour is outright discrimination and harassment but of course he didn’t listen.  And guess what happened after I complained to human resources? Well that boss of mine– who happens to be the COO of my company, fired me. The company even informed me that my claims were “without merit” since the said COO treated me “without regards to the employee’s gender, marital status, pregnancy or leave”. \n" +
                "Well, I suppose since he is the management, I should have predicted this. If an executive in the management can have such an appalling attitude, it tells you a lot about the company culture. I would avoid Hamilton if I were you.");

        return rootview;
    }

    @Override
    public void onAttach(Activity activity) {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
    }

    private View.OnClickListener mButtonClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            showEditDialog();

        }
    };

    public void dismissEditDialog(){
        if(currentOpenInput != null)
            currentOpenInput.dismiss();
    }

    private void showEditDialog() {
        FragmentManager fm = getActivity().getSupportFragmentManager();
        ReviewDialogFragment editNameDialogFragment = new ReviewDialogFragment();
        editNameDialogFragment.show(fm, "dialog");
    }



    public void addReview(String name, float rating, String date, String review){
        LayoutInflater vi = (LayoutInflater) getActivity().getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //LayoutInflater vi = LayoutInflater.from(ReviewLayoutActivity.this);
        View v = vi.inflate(R.layout.review_item, null);

        // fill in name
        TextView tvName = (TextView) v.findViewById(R.id.tvName);
        tvName.setText(name);

        // fill in name
        RatingBar rbRating = (RatingBar) v.findViewById(R.id.rating);
        rbRating.setRating(rating);
        ratings.add(rating);
        setAverageRating();
        // fill in tvDate
        TextView tvDate = (TextView) v.findViewById(R.id.tvDate);
        tvDate.setText(date);

        // fill in tvDate
        TextView tvReview = (TextView) v.findViewById(R.id.tvReview);
        tvReview.setText(review);

        // insert into main view
        ViewGroup insertPoint = (ViewGroup) rootview.findViewById(R.id.reviewHolder);
        insertPoint.addView(v, 0, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));

        //update rating in main view
    }

    public void setAverageRating(){
        float total = 0;
        for(int i = 0; i<ratings.size();i++){
            total += ratings.get(i);
        }
        float average = total/ratings.size();
        TextView bigRating = (TextView) rootview.findViewById(R.id.bigRating);
        bigRating.setText(String.format("%.1f",(float)average));
    }

}
