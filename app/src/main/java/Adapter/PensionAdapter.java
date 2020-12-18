package Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.helha.mobilejustdogit.R;

import java.util.List;

import Modele.Pension;

public class PensionAdapter extends ArrayAdapter<Pension> {


    public PensionAdapter(@NonNull Context context, int resource, @NonNull List<Pension> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View pensionView = convertView;
        if(pensionView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            pensionView = layoutInflater.inflate(R.layout.list_pension, parent, false);
        }

        final Pension pension = getItem(position);

        itemToTextView(pensionView,pension);

        return  pensionView;
    }

    private void itemToTextView(View animalview, Pension pension) {
        TextView name = animalview.findViewById(R.id.tv_animal_name_name);
        TextView startingDate = animalview.findViewById(R.id.tv_starting_date_date);
        TextView endingDate = animalview.findViewById(R.id.tv_ending_date_date);
        TextView price = animalview.findViewById(R.id.tv_price_price);
        ImageView images = animalview.findViewById(R.id.tv_images_images);
        String e =  pension.getAnimal().getTypeAnimal();

        name.setText(pension.getAnimal().getNom());
        if(e.equals("Chat"))
        {
            images.setImageResource(R.mipmap.cat_image_foreground);

        }
        else
        {
            images.setImageResource(R.mipmap.ic_launcher_foreground);
            Log.d("myTag", pension.getAnimal().getTypeAnimal());
        }

        startingDate.setText(pension.getDateEntree());
        endingDate.setText(pension.getDateSortie());
        price.setText(pension.getPrix()+"€");

    }
}
