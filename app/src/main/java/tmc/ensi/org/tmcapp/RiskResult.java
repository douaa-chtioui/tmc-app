package tmc.ensi.org.tmcapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import tmc.ensi.org.tmcapp.model.ApplicationModel;
import tmc.ensi.org.tmcapp.model.Gender;
import tmc.ensi.org.tmcapp.model.Profile;

public class RiskResult extends AppCompatActivity {
    private TextView score ,smockingtv , smockingdetailstv ,weighttv , weightdetailstv ;
    private float res ;
    private float weight ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_risk_result);
        score = findViewById(R.id.tv_score);
        smockingtv = findViewById(R.id.tv_smoking);
        smockingdetailstv = findViewById(R.id.tv_smokingdetails);
        weighttv = findViewById(R.id.tv_weight);
        weightdetailstv = findViewById(R.id.tv_weightdetails);
        String sc = getIntent().getStringExtra("score");
        res = Float.parseFloat (sc) ;
        final Profile profile = ApplicationModel.get().getCurrentUser().getProfile();
        weight = profile.getWeight() / (profile.getHeight() * profile.getHeight() ) ;
        score.setText(ApplicationModel.get().getCurrentUser().getFirstname()+", selon vos informations votre risque d'une maladie cardiovasculaire est : "+sc);
        if (profile != null) {
            if (profile.isSmoker()) {
                smockingtv.setText("VOUS FUMEZ :(");
                smockingdetailstv.setText("le tabac est un important facteur de risque cardiovasculaire.Il favorise notamment la formation de plaques de graisse(athérome) dans les artères, susceptibles de les boucher en se détachant.");
            } else if (!profile.isSmoker()){ smockingtv.setText("FELICITATIONS, VOUS NE FUMEZ PAS!");
                smockingdetailstv.setText("Vous ne fumez pas et préservez ainsi la santé de votre coeur et celle de vos proches." ); }
            if (weight < 18.5)
            {
                weighttv.setText("Vous êtes trop maigre");
                weightdetailstv.setText("La maigreur se caractérise par un indice de masse corporelle inférieur à 18. La dénutrition est un état précaire qui résulte de la réduction excessive des apports énergétiques et des apports protéiques.");
            }
            else if (weight < 25) {
                weighttv.setText("Votre corpulence est normale");
                weightdetailstv.setText("Felicitation!");
            }else {
                weighttv.setText("Vous êtes en surpoids");
                weightdetailstv.setText("Felicitation!");
            }
        }
    }
}
