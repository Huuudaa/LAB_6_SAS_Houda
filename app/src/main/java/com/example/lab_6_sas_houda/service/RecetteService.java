package com.example.lab_6_sas_houda.service;

import com.example.lab_6_sas_houda.classes.Recette;
import com.example.lab_6_sas_houda.dao.IDao;
import com.example.lab_6_sas_houda.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecetteService implements IDao<Recette> {

    private static RecetteService INSTANCE;
    private final List<Recette> catalogue = new ArrayList<>();

    private RecetteService() {
        initialiser();
    }

    public static RecetteService getInstance() {
        if (INSTANCE == null) INSTANCE = new RecetteService();
        return INSTANCE;
    }

    private void initialiser() {
        catalogue.add(new Recette("BARBECUED CHICKEN PIZZA", 3.0,
                R.drawable.pizza1, "35 min",
                "- 2 boneless skinless chicken breast halves\n- 1 cup barbecue sauce...",
                "So fast and so easy with refrigerated pizza crust.",
                "STEP 1: Griller le poulet.\nSTEP 2: Garnir et cuire."));

        catalogue.add(new Recette("BRUSCHETTA PIZZA", 5.0,
                R.drawable.pizza2, "35 min",
                "- 1/2 pound reduced-fat bulk pork sausage\n- 1 prebaked 12-inch pizza crust...",
                "You might need a knife and fork for this hearty pizza!",
                "STEP 1: Cuire la saucisse.\nSTEP 2: Garnir et enfourner."));

        catalogue.add(new Recette("SPINACH PIZZA", 2.0,
                R.drawable.pizza3, "25 min",
                "- 1 package pizza crust mix\n- 1/2 cup Alfredo sauce...",
                "This tasty pizza is so easy to prepare.",
                "STEP 1: Préparer la pâte.\nSTEP 2: Garnir et cuire."));

        catalogue.add(new Recette("DEEP-DISH SAUSAGE PIZZA", 8.0,
                R.drawable.pizza4, "45 min",
                "- 1 package active dry yeast\n- 2/3 cup warm water...",
                "My Grandma made the tastiest snacks for us.",
                "STEP 1: Préparer la pâte.\nSTEP 2: Monter et cuire."));

        catalogue.add(new Recette("HOMEMADE PIZZA", 4.0,
                R.drawable.pizza5, "50 min",
                "- 1 package active dry yeast\n- 1 teaspoon sugar...",
                "A hearty, zesty main dish with a crisp, golden crust.",
                "STEP 1: Dissoudre la levure.\nSTEP 2: Garnir et cuire."));

        catalogue.add(new Recette("PESTO CHICKEN PIZZA", 3.0,
                R.drawable.pizza6, "50 min",
                "- 2 teaspoons active dry yeast\n- 1 cup warm water...",
                "This is the only pizza I make now. We love it!",
                "STEP 1: Préparer la pâte.\nSTEP 2: Cuire le poulet.\nSTEP 3: Assembler."));

        catalogue.add(new Recette("LOADED MEXICAN PIZZA", 3.0,
                R.drawable.pizza7, "30 min",
                "- 1 can black beans\n- 1 medium red onion...",
                "My husband is a picky eater, but this healthy pizza has lots of flavor.",
                "STEP 1: Préparer les haricots.\nSTEP 2: Garnir et cuire."));

        catalogue.add(new Recette("BACON CHEESEBURGER PIZZA", 2.0,
                R.drawable.pizza8, "20 min",
                "- 1/2 pound ground beef\n- 1 small onion...",
                "Kids of all ages love pizza and cheeseburgers!",
                "STEP 1: Cuire le boeuf.\nSTEP 2: Garnir et enfourner."));

        catalogue.add(new Recette("PIZZA MARGHERITA", 1.0,
                R.drawable.pizza9, "30 min",
                "- 3 teaspoons active dry yeast\n- 1 cup warm water...",
                "A classic Pizza Margherita showing the Italian flag colors.",
                "STEP 1: Préparer la pâte.\nSTEP 2: Garnir et cuire."));

        catalogue.add(new Recette("PEPPERONI-SAUSAGE STUFFED PIZZA", 5.0,
                R.drawable.pizza10, "45 min",
                "- 1 package active dry yeast\n- 1-1/4 cups warm water...",
                "For 30 years, friends have been telling me to open a pizzeria.",
                "STEP 1: Préparer la pâte.\nSTEP 2: Farcir et cuire."));
    }

    @Override
    public Recette create(Recette r) {
        catalogue.add(r);
        return r;
    }

    @Override
    public Recette update(Recette r) {
        for (int i = 0; i < catalogue.size(); i++) {
            if (catalogue.get(i).getId() == r.getId()) {
                catalogue.set(i, r);
                return r;
            }
        }
        return null;
    }

    @Override
    public boolean delete(long id) {
        return catalogue.removeIf(x -> x.getId() == id);
    }

    @Override
    public Recette findById(long id) {
        for (Recette r : catalogue)
            if (r.getId() == id) return r;
        return null;
    }

    @Override
    public List<Recette> findAll() {
        return Collections.unmodifiableList(catalogue);
    }
}