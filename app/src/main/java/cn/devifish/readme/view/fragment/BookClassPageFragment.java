package cn.devifish.readme.view.fragment;

import cn.devifish.readme.R;
import cn.devifish.readme.view.base.BaseMainPageFragment;

/**
 * Created by zhang on 2017/2/22.
 *
 * @author zhang
 */

public class BookClassPageFragment extends BaseMainPageFragment {

    private final static String mTitle = "分类";

    public BookClassPageFragment() {super.setPageTitle(mTitle);}

    @Override
    protected int bindLayout() {return R.layout.page_class_main;}

    @Override
    protected void initVar() {}

    @Override
    protected void initView() {}
}