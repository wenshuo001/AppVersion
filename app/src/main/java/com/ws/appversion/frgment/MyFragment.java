package com.ws.appversion.frgment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ws.appversion.R;
import com.ws.appversion.bean.AppVersionBean;


/**
 * Created by gavin
 * Created date 17/8/3
 */

public class MyFragment extends Fragment {

    RecyclerView mRv;
    RecyclerView.Adapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(
                R.layout.fragment_list, container, false);
        mRv = view.findViewById(R.id.rv);
        initView();
        return view;
    }

    private void initView() {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mRv.setLayoutManager(manager);


        mAdapter = new RecyclerView.Adapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view, parent, false);
                return new Holder(view);
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
                Holder holder = (Holder) viewHolder;
                holder.mTextView.setText("current position: " + position);
            }

            @Override
            public int getItemCount() {
                return 30;
            }
        };
        mRv.setAdapter(mAdapter);


    }

    static class Holder extends RecyclerView.ViewHolder {
        TextView mTextView;
        public Holder(View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.tv);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}
