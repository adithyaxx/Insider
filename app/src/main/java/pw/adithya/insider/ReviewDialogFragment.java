package pw.adithya.insider;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
// ...

public class ReviewDialogFragment extends DialogFragment {
    View VV;
    private EditText mEditText;
    ReviewLayoutActivity RLA = new ReviewLayoutActivity();
    public ReviewDialogFragment() {
        // Empty constructor is required for DialogFragment
        // Make sure not to add arguments to the constructor
        // Use `newInstance` instead as shown below
    }

    public static ReviewDialogFragment newInstance(String title) {
        ReviewDialogFragment frag = new ReviewDialogFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v =  inflater.inflate(R.layout.review_input_window, container);
        //v.findViewById(R.id.btnSubmit);
        Button b = (Button) v.findViewById(R.id.btnSubmit);
        b.setOnClickListener(mButtonClickListener);

        return v;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Get field from view
        mEditText = (EditText) view.findViewById(R.id.etReviewText);
        // Fetch arguments from bundle and set title
        //String title = getArguments().getString("title", "Enter Name");
        //getDialog().setTitle(title);

        // Show soft keyboard automatically and request focus to field
        mEditText.requestFocus();
        getDialog().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }

    private View.OnClickListener mButtonClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            View input_box = (View) v.getParent();
            //get input from input_box
            RatingBar ratingB = (RatingBar)input_box.findViewById(R.id.rb);
            float fsdvs = ratingB.getRating();
            EditText eT = (EditText)input_box.findViewById(R.id.etReviewText);
            String review = eT.getText().toString();
            android.support.v4.app.FragmentManager sdf = getFragmentManager();
            Fragment asd = sdf.findFragmentByTag("StickbuTAG");
            ReviewLayoutActivity rw = (ReviewLayoutActivity)asd;
            rw.addReview("J. D.",fsdvs,"30/4/17",review);
            dismiss();
            return;
        }
    };
}
