package tslaboratory.child.fragment.sample.childfragmentapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 親フラグメントへ遷移
        findViewById(R.id.button_parent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                ParentFragment parentFragment = new ParentFragment();
                transaction.replace(R.id.container, parentFragment, "tagParentFragment");
                // バックスタックに保存
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }

    @Override
    public void onBackPressed() {

        for (Fragment fragment : getSupportFragmentManager().getFragments()) {
            if (fragment != null) {
                // ChildFragmentManagerにバックスタックがあるならポップする
                FragmentManager fm = fragment.getChildFragmentManager();
                int count = fm.getBackStackEntryCount();
                if (count > 0) {
                    fm.popBackStack();
                    return;
                }
            }
        }

        // MainActivityかParentFragmentが表示されているなら通常の戻るボタン
        super.onBackPressed();
    }
}
