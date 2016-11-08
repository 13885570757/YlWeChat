package cn.ucai.superwechat.net;

import android.content.Context;

import java.io.File;

import cn.ucai.superwechat.I;
import cn.ucai.superwechat.bean.Result;
import cn.ucai.superwechat.utils.MD5;

/**
 * Created by Administrator on 2016/11/1.
 */
public class NetDao {

    /**
     * 注册
     *
     * @param mContext
     * @param username
     * @param usernick
     * @param password
     * @param listener
     */
    public static void register(Context mContext, String username, String usernick, String password, OkHttpUtils.OnCompleteListener<Result> listener) {
        OkHttpUtils<Result> utils = new OkHttpUtils<>(mContext);
        utils.setRequestUrl(I.REQUEST_REGISTER)
                .addParam(I.User.USER_NAME, username)
                .addParam(I.User.NICK, usernick)
                .addParam(I.User.PASSWORD, MD5.getMessageDigest(password))
                .targetClass(Result.class)
                .post()
                .execute(listener);
    }

    /**
     * 取消注册
     *
     * @param mContext
     * @param username
     * @param listener
     */
    public static void unregister(Context mContext, String username, OkHttpUtils.OnCompleteListener<Result> listener) {
        OkHttpUtils<Result> utils = new OkHttpUtils<>(mContext);
        utils.setRequestUrl(I.REQUEST_UNREGISTER)
                .addParam(I.User.USER_NAME, username)
                .targetClass(Result.class)
                .execute(listener);
    }

    /**
     * 登录请求
     *
     * @param context
     * @param username
     * @param password
     * @param listener
     */
    public static void login(Context context, String username,
                             String password, OkHttpUtils.OnCompleteListener<String> listener) {
        OkHttpUtils<String> utils = new OkHttpUtils<>(context);
        utils.setRequestUrl(I.REQUEST_LOGIN)
                .addParam(I.User.USER_NAME, username)
                .addParam(I.User.PASSWORD, MD5.getMessageDigest(password))
                .targetClass(String.class)
                .execute(listener);
    }

    /**
     * 修改昵称
     *
     * @param mContext
     * @param userName
     * @param userNick
     * @param listener
     */
    public static void updateUserNick(Context mContext, String userName, String userNick, OkHttpUtils.OnCompleteListener<String> listener) {
        OkHttpUtils<String> utils = new OkHttpUtils<>(mContext);
        utils.setRequestUrl(I.REQUEST_UPDATE_USER_NICK)
                .addParam(I.User.USER_NAME, userName)
                .addParam(I.User.NICK, userNick)
                .targetClass(String.class)
                .execute(listener);

    }

    /**
     * 同步用户信息
     *
     * @param mContext
     * @param userName
     * @param listener
     */
    public static void syncUser(Context mContext, String userName, OkHttpUtils.OnCompleteListener<String> listener) {
        OkHttpUtils<String> utils = new OkHttpUtils<>(mContext);
        utils.setRequestUrl(I.REQUEST_FIND_USER)
                .addParam(I.User.USER_NAME, userName)
                .targetClass(String.class)
                .execute(listener);

    }

    /**
     * 修改头像
     *
     * @param
     */
    public static void updateAvatar(Context mContext, String userName, File file, OkHttpUtils.OnCompleteListener<String> listener) {
        OkHttpUtils<String> utils = new OkHttpUtils<>(mContext);
        utils.setRequestUrl(I.REQUEST_UPDATE_AVATAR)
                .addParam(I.NAME_OR_HXID, userName)
                .addParam(I.AVATAR_TYPE, I.AVATAR_TYPE_USER_PATH)
                .addFile2(file)
                .targetClass(String.class)
                .post()
                .execute(listener);
    }

    /**
     * 搜索联系人
     *
     * @param context
     * @param username
     * @param listener
     */
    public static void searchUser(Context context, String username, OkHttpUtils.OnCompleteListener<String> listener) {
        OkHttpUtils<String> utils = new OkHttpUtils<>(context);
        utils.setRequestUrl(I.REQUEST_FIND_USER)
                .addParam(I.User.USER_NAME, username)
                .targetClass(String.class)
                .execute(listener);
    }

    /**
     * 服务器上传好友关系
     * @param context
     * @param username
     * @param cusername
     * @param listener
     */
    public static void addContact(Context context,String username,String cusername,OkHttpUtils.OnCompleteListener<String>listener) {
        OkHttpUtils<String> utils = new OkHttpUtils<>(context);
        utils.setRequestUrl(I.REQUEST_ADD_CONTACT)
                .addParam(I.Contact.USER_NAME,username)
                .addParam(I.Contact.CU_NAME,cusername)
                .targetClass(String.class)
                .execute(listener);
    }
}
