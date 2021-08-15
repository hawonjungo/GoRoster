package com.example.goroster.dev;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.goroster.R;
import com.example.goroster.Timetable;
import com.example.goroster.data.EmpDatabase;
import com.example.goroster.emp.Employee;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    Context context;
    private List<Employee> listEmp;
    RecyclerView rvTable;



    public CustomAdapter(Context context, List<Employee> listEmp,RecyclerView rvTable){
        this.context = context;
        this.listEmp = listEmp;
        this.rvTable = rvTable;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       LayoutInflater inflater = LayoutInflater.from(context);
       View view = inflater.inflate(R.layout.item_layout_timetable,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(listEmp != null && listEmp.size() >0){
            Employee employee = listEmp.get(position);
            holder.tvName.setText(employee.getName());
            holder.tvMon.setText(employee.getMonAvailable());
            holder.tvTue.setText(employee.getTueAvailable());
            holder.tvWed.setText(employee.getWebAvailable());
            holder.tvThu.setText(employee.getThuAvailable());
            holder.tvFri.setText(employee.getFriAvailable());
            holder.tvSat.setText(employee.getSatAvailable());
            holder.tvSun.setText(employee.getSunAvailable());
        }
    }

    @Override
    public int getItemCount() {
        return listEmp.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private TextView tvMon;
        private TextView tvTue;
        private TextView tvWed;
        private TextView tvThu;
        private TextView tvFri;
        private TextView tvSat;
        private TextView tvSun;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tableId_Name);
            tvMon = itemView.findViewById(R.id.tableId_Mon);
            tvTue = itemView.findViewById(R.id.tableId_Tue);
            tvWed = itemView.findViewById(R.id.tableId_Wed);
            tvThu = itemView.findViewById(R.id.tableId_Thu);
            tvFri = itemView.findViewById(R.id.tableId_Fri);
            tvSat = itemView.findViewById(R.id.tableId_Sat);
            tvSun = itemView.findViewById(R.id.tableId_Sun);
        }

    }
}
