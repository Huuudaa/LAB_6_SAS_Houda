package com.example.lab_6_sas_houda.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.lab_6_sas_houda.R;
import com.example.lab_6_sas_houda.adapter.RecetteAdapter;
import com.example.lab_6_sas_houda.classes.Recette;
import com.example.lab_6_sas_houda.service.RecetteService;
import java.util.List;

public class ListeRecettesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_recettes);

        ListView lv = findViewById(R.id.lvRecettes);
        List<Recette> catalogue = RecetteService.getInstance().findAll();

        lv.setAdapter(new RecetteAdapter(this, catalogue));

        lv.setOnItemClickListener((parent, view, pos, id) -> {
            Intent intent = new Intent(this, DetailRecetteActivity.class);
            intent.putExtra("recette_id", id);
            startActivity(intent);
        });
    }
}