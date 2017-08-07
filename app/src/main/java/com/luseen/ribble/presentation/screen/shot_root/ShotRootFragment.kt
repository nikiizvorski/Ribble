package com.luseen.ribble.presentation.screen.shot_root


import android.os.Bundle
import android.view.View
import com.luseen.ribble.R
import com.luseen.ribble.presentation.adapter.ShotPagerAdapter
import com.luseen.ribble.presentation.base_mvp.base.BaseFragment
import com.luseen.ribble.presentation.screen.shot.ShotRootContract
import com.luseen.ribble.presentation.widget.CustomTabLayout
import kotlinx.android.synthetic.main.fragment_shot_root.*
import javax.inject.Inject


class ShotRootFragment : BaseFragment<ShotRootContract.View, ShotRootContract.Presenter>(), ShotRootContract.View {

    @Inject
    protected lateinit var shotRootPresenter: ShotRootPresenter

    @Inject
    protected lateinit var shotPagerAdapter: ShotPagerAdapter

    companion object {
        fun newInstance(): ShotRootFragment = ShotRootFragment()
    }

    override fun initPresenter(): ShotRootContract.Presenter = shotRootPresenter

    override fun layoutResId(): Int = R.layout.fragment_shot_root

    override fun injectDependencies() = activityComponent.inject(this)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPagerAdapter()
    }

    fun setUpPagerAdapter() {
        shotViewPager.adapter = shotPagerAdapter
        tabLayout.setupWithViewPager(shotViewPager)
        tabLayout.tabMode = CustomTabLayout.MODE_FIXED
        tabLayout.setSelectedTabIndicatorHeight(20)
        shotViewPager.setCurrentItem(1)
    }
}
