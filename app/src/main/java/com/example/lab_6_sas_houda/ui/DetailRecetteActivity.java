package com.example.lab_6_sas_houda.ui;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.example.lab_6_sas_houda.R;
import com.example.lab_6_sas_houda.classes.Recette;
import com.example.lab_6_sas_houda.service.RecetteService;

public class DetailRecetteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_recette);

        long id = getIntent().getLongExtra("recette_id", -1);
        Recette r = RecetteService.getInstance().findById(id);

        ImageView photo        = findViewById(R.id.imgDetail);
        TextView tvTitre       = findViewById(R.id.tvDetailTitre);
        TextView tvInfos       = findViewById(R.id.tvDetailInfos);
        TextView tvComposition = findViewById(R.id.tvComposition);
        TextView tvResume      = findViewById(R.id.tvResume);
        TextView tvPreparation = findViewById(R.id.tvPreparation);

        if (r != null) {
            photo.setImageResource(r.getPhotoRes());
            tvTitre.setText(r.getTitre());
            tvInfos.setText(r.getTempsPrep() + " • " + r.getTarif() + " €");
            tvComposition.setText(r.getComposition());
            tvResume.setText(r.getResume());
            tvPreparation.setText(r.getPreparation());
        } else {
            tvTitre.setText("Recette introuvable !");
        }
    }
}