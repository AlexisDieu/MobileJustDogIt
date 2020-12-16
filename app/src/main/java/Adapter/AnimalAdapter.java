package Adapter;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.helha.mobilejustdogit.R;

import java.time.LocalDate;
import java.util.List;

import Modele.Animal;

public class AnimalAdapter extends ArrayAdapter<Animal> {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View animalview = convertView;
        if(animalview == null){
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            animalview = layoutInflater.inflate(R.layout.list_animal, parent, false);
        }

        final Animal animal = getItem(position);

        itemToTextView(animalview,animal);

        return  animalview;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void itemToTextView(View animalview, Animal animal) {
        TextView name = animalview.findViewById(R.id.tv_name);
        TextView birthday = animalview.findViewById(R.id.tv_birthday);
        TextView color = animalview.findViewById(R.id.tv_color);
        TextView race = animalview.findViewById(R.id.tv_race);
        TextView type = animalview.findViewById(R.id.tv_typeAnimal);

        name.setText(animal.getNom());
        birthday.setText(FormatDate(animal.getDateNaissance()));
        color.setText(animal.getCouleur());
        race.setText(animal.getRace());
        type.setText(animal.getTypeAnimal());
    }

    public AnimalAdapter(@NonNull Context context, int resource, @NonNull List objects) {

        super(context, resource, objects);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String FormatDate(String date){
        String dateString = date.substring(0,10);
        LocalDate dateLocalDate = LocalDate.parse(dateString);

        String month = dateLocalDate.getMonth().toString();
        int day = dateLocalDate.getDayOfMonth();
        int year = dateLocalDate.getYear();

        String dateReturn = day + " "+ month.substring(0,3) + " "+year ;

        return dateReturn;
    }
}
