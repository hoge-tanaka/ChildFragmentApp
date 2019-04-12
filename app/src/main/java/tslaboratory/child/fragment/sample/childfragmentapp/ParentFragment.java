package tslaboratory.child.fragment.sample.childfragmentapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ParentFragment extends Fragment {

    private View view;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_parent, container, false);

        // 子フラグメント１へ遷移
        view.findViewById(R.id.button_child_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getActivity().getSupportFragmentManager();//ParentFragment.this.getChildFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                Fragment fragment = new ChildFragment1();
                transaction.replace(R.id.container_fragment, fragment, "tagChildFragment1");
                // バックスタックに保存
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        // 子フラグメント２へ遷移
        view.findViewById(R.id.button_child_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = ParentFragment.this.getChildFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                Fragment fragment = new ChildFragment2();
                transaction.replace(R.id.container_fragment, fragment, "tagChildFragment2");
                // バックスタックに保存
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        return view;
    }
}
