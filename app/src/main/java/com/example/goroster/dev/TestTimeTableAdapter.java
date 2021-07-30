package com.example.goroster.dev;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.goroster.R;

import java.util.List;

public class TestTimeTableAdapter extends RecyclerView.Adapter<TestTimeTableAdapter.ViewHolder>{
    Context context;
    List<TestRecycleViewTable> recycleViewTableList ;

    public TestTimeTableAdapter(Context context,List<TestRecycleViewTable> recycleViewTableList) {
        this.context = context;
        this.recycleViewTableList = recycleViewTableList;
    }

    @NonNull
    @Override
    public TestTimeTableAdapter.ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout_timetable,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  TestTimeTableAdapter.ViewHolder holder, int position) {
        if(recycleViewTableList != null && recycleViewTableList.size()>0){
            TestRecycleViewTable table = recycleViewTableList.get(position);
            holder.tableId_Name.setText(table.getName());
            holder.tableId_Mon.setText(table.getMon());
            holder.tableId_Tue.setText(table.getTue());
            holder.tableId_Wed.setText(table.getWed());
            holder.tableId_Thu.setText(table.getThu());
            holder.tableId_Fri.setText(table.getFri());
            holder.tableId_Sat.setText(table.getSat());
            holder.tableId_Sun.setText(table.getSun());
        }

    }

    @Override
    public int getItemCount() {
        return recycleViewTableList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tableId_Name,tableId_Mon,tableId_Tue,tableId_Wed,tableId_Thu,tableId_Fri,tableId_Sat,tableId_Sun;
        public ViewHolder(@NonNull  View itemView) {
            super(itemView);

            // haven't make id yet
            tableId_Name = itemView.findViewById(R.id.tableId_Name);
            tableId_Mon = itemView.findViewById(R.id.tableId_Mon);
            tableId_Tue = itemView.findViewById(R.id.tableId_Tue);
            tableId_Wed = itemView.findViewById(R.id.tableId_Wed);
            tableId_Thu = itemView.findViewById(R.id.tableId_Thu);
            tableId_Fri = itemView.findViewById(R.id.tableId_Fri);
            tableId_Sat = itemView.findViewById(R.id.tableId_Sat);
            tableId_Sun = itemView.findViewById(R.id.tableId_Sun);

        }
    }
}
