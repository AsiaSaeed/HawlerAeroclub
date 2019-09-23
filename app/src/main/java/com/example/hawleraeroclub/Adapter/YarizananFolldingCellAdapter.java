package com.example.hawleraeroclub.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.hawleraeroclub.Model.Player;
import com.example.hawleraeroclub.R;
import com.ramotion.foldingcell.FoldingCell;

import java.util.HashSet;
import java.util.List;

public class YarizananFolldingCellAdapter extends ArrayAdapter<Player> {

    public YarizananFolldingCellAdapter(@NonNull Context context, int resource, @NonNull List<Player> objects) {
        super(context, resource, objects);
    }

    private HashSet<Integer> unfoldedIndexes = new HashSet<>();
    private View.OnClickListener defaultRequestBtnClickListener;

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // get item for selected view
        Player player = getItem(position);
        // if cell is exists - reuse it, if not - create the new one from resource
        FoldingCell cell =(FoldingCell) convertView;
        ViewHolder viewHolder;
        if (cell == null) {
            viewHolder = new ViewHolder();
            LayoutInflater vi = LayoutInflater.from(getContext());
            cell =(FoldingCell) vi.inflate(R.layout.cell_yarizanan, parent, false);
            // binding view parts to view holder
            viewHolder.nameTv = cell.findViewById(R.id.name_player_tv);
            viewHolder.nameTvH = cell.findViewById(R.id.name_tv_cyc);
            viewHolder.birthDate = cell.findViewById(R.id.birth_day_tv_cyc);
            viewHolder.bloodType = cell.findViewById(R.id.blood_type_tv_cyc);
            viewHolder.workTypeTv = cell.findViewById(R.id.work_tv_cyc);
            viewHolder.playerIV = cell.findViewById(R.id.im_cyc);
            viewHolder.playerIVH = cell.findViewById(R.id.iv_cyh);
            viewHolder.phoneNumber = cell.findViewById(R.id.phone_tv_cyc);
            cell.setTag(viewHolder);
        } else {
            // for existing cell set valid valid state(without animation)
            if (unfoldedIndexes.contains(position)) {
                cell.unfold(true);
            } else {
                cell.fold(true);
            }
            viewHolder = (ViewHolder) cell.getTag();
        }

        if (null == player)
            return cell;

        // bind data from selected element to view through view holder
        viewHolder.nameTv.setText(player.getName());
        viewHolder.nameTvH.setText(player.getName());
        viewHolder.birthDate.setText(String.valueOf(player.getBirthDate()));
        viewHolder.workTypeTv.setText(player.getWorkType());
        viewHolder.bloodType.setText(player.getBloodType());
        viewHolder.playerIV.setImageResource(player.getImageResource());
        viewHolder.playerIVH.setImageResource(player.getImageResource());
        viewHolder.phoneNumber.setText(String.valueOf(player.getPhoneNumber()));

        return cell;
    }

    // simple methods for register cell state changes
    public void registerToggle(int position) {
        if (unfoldedIndexes.contains(position))
            registerFold(position);
        else
            registerUnfold(position);
    }

    public void registerFold(int position) {
        unfoldedIndexes.remove(position);
    }

    public void registerUnfold(int position) {
        unfoldedIndexes.add(position);
    }

    public View.OnClickListener getDefaultRequestBtnClickListener() {
        return defaultRequestBtnClickListener;
    }

    public void setDefaultRequestBtnClickListener(View.OnClickListener defaultRequestBtnClickListener) {
        this.defaultRequestBtnClickListener = defaultRequestBtnClickListener;
    }

    // View lookup cache
    private static class ViewHolder {
        TextView nameTv;
        TextView nameTvH;
        TextView workTypeTv;
        TextView birthDate;
        TextView bloodType;
        ImageView playerIV;
        ImageView playerIVH;
        TextView phoneNumber;
    }
}
