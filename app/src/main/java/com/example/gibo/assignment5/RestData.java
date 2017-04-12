package com.example.gibo.assignment5;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by gi bo on 2017-04-06.
 */

public class RestData implements Parcelable {

    private String name;
    private String phone_num;
    private String menu1,menu2,menu3;
    private String hp;
    private String day;
    private String cate_num;

    public RestData(String name, String phone_num, String menu1, String menu2, String menu3,
                    String hp, String day, String cate_num){
        this.name = name;
        this.phone_num = phone_num;
        this.menu1 = menu1;
        this.menu2 = menu2;
        this.menu3 = menu3;
        this.hp = hp;
        this.day = day;
        this.cate_num = cate_num;
    }

    protected RestData(Parcel in) {
        name = in.readString();
        phone_num = in.readString();
        menu1 = in.readString();
        menu2 = in.readString();
        menu3 = in.readString();
        hp = in.readString();
        day = in.readString();
        cate_num = in.readString();
    }

    public String getname() { return this.name;}

    public String getPhone_num() { return this.phone_num;}

    public String getMenu1() { return this.menu1;}

    public String getMenu2() { return this.menu2;}

    public String getMenu3() { return this.menu3;}

    public String getHp() { return this.hp;}

    public String getDay() { return this.day;}

    public String getCate_num() { return this.cate_num;}

    public void setcate(String cate_num){
        this.cate_num = cate_num;
    }

    public static final Creator<RestData> CREATOR = new Creator<RestData>() {
        @Override
        public RestData createFromParcel(Parcel in) {
            return new RestData(in);
        }

        @Override
        public RestData[] newArray(int size) {
            return new RestData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(phone_num);
        dest.writeString(menu1);
        dest.writeString(menu2);
        dest.writeString(menu3);
        dest.writeString(hp);
        dest.writeString(day);
        dest.writeString(cate_num);
    }
}
