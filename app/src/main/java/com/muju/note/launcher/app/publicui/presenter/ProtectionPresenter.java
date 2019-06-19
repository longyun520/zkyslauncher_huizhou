package com.muju.note.launcher.app.publicui.presenter;

import com.muju.note.launcher.app.home.db.AdvertsCodeDao;
import com.muju.note.launcher.app.publicui.contract.ProtectionContract;
import com.muju.note.launcher.base.BasePresenter;
import com.muju.note.launcher.util.log.LogFactory;

import org.litepal.LitePal;
import org.litepal.crud.callback.FindMultiCallback;

import java.util.List;

public class ProtectionPresenter extends BasePresenter<ProtectionContract.View> implements ProtectionContract
        .Presenter {
    private static final String TAG="ProtectionPresenter";
    /**
     * 获取轮播广告
     */
    @Override
    public void getLockBananaList(String code) {
        LitePal.where("code =?",code).findAsync(AdvertsCodeDao.class).listen(new FindMultiCallback<AdvertsCodeDao>() {
            @Override
            public void onFinish(List<AdvertsCodeDao> list) {
                LogFactory.l().i("list"+list.size());
                if (list == null || list.size() <= 0) {
                    mView.getLockBananaNull();
                    return;
                }
                mView.getLockBananaList(list);
            }
        });
    }


}
