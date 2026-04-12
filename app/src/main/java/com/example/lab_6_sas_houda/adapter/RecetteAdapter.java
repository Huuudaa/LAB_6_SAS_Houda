package com.example.lab_6_sas_houda.adapter;

import android.content.Context;
import android.view.*;
        import android.widget.*;
        import com.example.lab_6_sas_houda.R;
import com.example.lab_6_sas_houda.classes.Recette;
import java.util.List;

public class RecetteAdapter extends BaseAdapter {

    private final Context contexte;
    private final List<Recette> catalogue;

    public RecetteAdapter(Context contexte, List<Recette> catalogue) {
        this.contexte = contexte;
        this.catalogue = catalogue;
    }

    @Override public int getCount() { return catalogue.size(); }
    @Override public Object getItem(int i) { return catalogue.get(i); }
    @Override public long getItemId(int i) { return catalogue.get(i).getId(); }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(contexte)
                    .inflate(R.layout.row_recette, parent, false);

        ImageView photo  = convertView.findViewById(R.id.imgRecette);
        TextView tvTitre = convertView.findViewById(R.id.tvTitre);
        TextView tvInfos = convertView.findViewById(R.id.tvInfos);

        Recette r = catalogue.get(position);
        photo.setImageResource(r.getPhotoRes());
        tvTitre.setText(r.getTitre());
        tvInfos.setText(r.getTempsPrep() + " • " + r.getTarif() + " €");

        return convertView;
    }
}