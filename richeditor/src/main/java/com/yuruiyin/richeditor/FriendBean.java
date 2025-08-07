package com.yuruiyin.richeditor;


import android.os.Parcel;
import android.os.Parcelable;


public class FriendBean implements Comparable<FriendBean>, Parcelable {

    private String id;
    private int user_id;

    public FriendBean() {
    }

    @Override
    public String toString() {
        return "FriendBean{" +
                "id='" + id + '\'' +
                ", user_id=" + user_id +
                ", create_time=" + create_time +
                ", avatar='" + avatar + '\'' +
                ", avatar_frame='" + avatar_frame + '\'' +
                ", nickname='" + nickname + '\'' +
                ", motto='" + motto + '\'' +
                ", gender=" + gender +
                ", level=" + level +
                ", is_follow=" + is_follow +
                ", is_friend=" + is_friend +
                ", pinyin='" + pinyin + '\'' +
                ", firstLetter='" + firstLetter + '\'' +
                '}';
    }

    public FriendBean(String nickname, int user_id) {
        this.user_id = user_id;
        this.nickname = nickname;
    }

    protected FriendBean(Parcel in) {
        id = in.readString();
        user_id = in.readInt();
        create_time = in.readInt();
        avatar = in.readString();
        avatar_frame = in.readString();
        nickname = in.readString();
        motto = in.readString();
        gender = in.readInt();
        level = in.readInt();
        is_follow = in.readInt();
        is_friend = in.readInt();
        pinyin = in.readString();
        firstLetter = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeInt(user_id);
        dest.writeInt(create_time);
        dest.writeString(avatar);
        dest.writeString(avatar_frame);
        dest.writeString(nickname);
        dest.writeString(motto);
        dest.writeInt(gender);
        dest.writeInt(level);
        dest.writeInt(is_follow);
        dest.writeInt(is_friend);
        dest.writeString(pinyin);
        dest.writeString(firstLetter);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<FriendBean> CREATOR = new Creator<FriendBean>() {
        @Override
        public FriendBean createFromParcel(Parcel in) {
            return new FriendBean(in);
        }

        @Override
        public FriendBean[] newArray(int size) {
            return new FriendBean[size];
        }
    };

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    private int create_time;
    private String avatar;
    private String avatar_frame;
    private String nickname;
    private String motto;
    private int gender;
    private int level;
    private int is_follow;
    private int is_friend;

    public int getIs_friend() {
        return is_friend;
    }

    public void setIs_friend(int is_friend) {
        this.is_friend = is_friend;
    }

    public String getAvatar_frame() {
        return avatar_frame;
    }

    public void setAvatar_frame(String avatar_frame) {
        this.avatar_frame = avatar_frame;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCreate_time() {
        return create_time;
    }

    public void setCreate_time(int create_time) {
        this.create_time = create_time;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
        if (pinyin == null || pinyin.length() == 0) {
            firstLetter = "#";
        } else {
            firstLetter = pinyin.substring(0, 1).toUpperCase(); // 获取拼音首字母并转成大写
            if (!firstLetter.matches("[A-Z]")) { // 如果不在A-Z中则默认为“#”
                firstLetter = "#";
            }
        }
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getIs_follow() {
        return is_follow;
    }

    public void setIs_follow(int is_follow) {
        this.is_follow = is_follow;
    }

    private String pinyin; // 姓名对应的拼音
    private String firstLetter; // 拼音的首字母

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getFirstLetter() {
        return firstLetter;
    }

    public void setFirstLetter(String firstLetter) {
        this.firstLetter = firstLetter;
    }

    @Override
    public int compareTo(FriendBean another) {
        if (firstLetter.equals("#") && !another.getFirstLetter().equals("#")) {
            return 1;
        } else if (!firstLetter.equals("#") && another.getFirstLetter().equals("#")) {
            return -1;
        } else {
            return pinyin.compareToIgnoreCase(another.getPinyin());
        }
    }
}
