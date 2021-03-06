/*
 * Copyright (c) 2020 WildFireChat. All rights reserved.
 */

package cn.wildfire.chat.kit;

import android.app.Application;

import cn.wildfire.chat.kit.group.GroupAnnouncement;
import cn.wildfire.chat.kit.net.SimpleCallback;


public interface AppServiceProvider {
    public interface UpdateGroupAnnouncementCallback {
        void onUiSuccess(GroupAnnouncement announcement);

        void onUiFailure(int code, String msg);
    }

    public interface GetGroupAnnouncementCallback {
        void onUiSuccess(GroupAnnouncement announcement);

        void onUiFailure(int code, String msg);
    }

    public void getGroupAnnouncement(String groupId, GetGroupAnnouncementCallback callback);

    public void updateGroupAnnouncement(String groupId, String announcement, UpdateGroupAnnouncementCallback callback);

    void showPCLoginActivity(String userId, String token, int platform);

    /**
     * 前置条件是已经调过{@link cn.wildfirechat.remote.ChatManager#init(Application, String)}
     *
     * @param callback
     */
    void uploadLog(SimpleCallback<String> callback);

    void changeName(String newName, SimpleCallback<Void> callback);
}
