package com.example.ntd.objects;

import org.json.JSONObject;

public class JobPlaceObj extends BaseObject{
    private String job_place_assoc_id;
    private String job_id;
    private String place_id;
    private String detail_address;
    private String geo_latitude;
    private String geo_longitude;
    private String province_name;
    private String district_name;
    private String address_google;
    private String place_name;
    private String place_image;
    private String status;

    public String getJob_place_assoc_id() {
        return job_place_assoc_id;
    }

    public void setJob_place_assoc_id(String job_place_assoc_id) {
        this.job_place_assoc_id = job_place_assoc_id;
    }

    public String getJob_id() {
        return job_id;
    }

    public void setJob_id(String job_id) {
        this.job_id = job_id;
    }

    public String getPlace_id() {
        return place_id;
    }

    public void setPlace_id(String place_id) {
        this.place_id = place_id;
    }

    public String getDetail_address() {
        return detail_address;
    }

    public void setDetail_address(String detail_address) {
        this.detail_address = detail_address;
    }

    public String getGeo_latitude() {
        return geo_latitude;
    }

    public void setGeo_latitude(String geo_latitude) {
        this.geo_latitude = geo_latitude;
    }

    public String getGeo_longitude() {
        return geo_longitude;
    }

    public void setGeo_longitude(String geo_longitude) {
        this.geo_longitude = geo_longitude;
    }

    public String getProvince_name() {
        return province_name;
    }

    public void setProvince_name(String province_name) {
        this.province_name = province_name;
    }

    public String getDistrict_name() {
        return district_name;
    }

    public void setDistrict_name(String district_name) {
        this.district_name = district_name;
    }

    public String getAddress_google() {
        return address_google;
    }

    public void setAddress_google(String address_google) {
        this.address_google = address_google;
    }

    public String getPlace_name() {
        return place_name;
    }

    public void setPlace_name(String place_name) {
        this.place_name = place_name;
    }

    public String getPlace_image() {
        return place_image;
    }

    public void setPlace_image(String place_image) {
        this.place_image = place_image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public void parseJsonToObject(JSONObject jsonObject) {
        try {
            setJob_place_assoc_id(jsonObject.getString("job_place_assoc_id"));
            setJob_id(jsonObject.getString("job_id"));
            setPlace_id(jsonObject.getString("place_id"));
            setDetail_address(jsonObject.getString("detail_address"));
            setGeo_latitude(jsonObject.getString("geo_latitude"));
            setGeo_longitude(jsonObject.getString("geo_longitude"));
            setProvince_name(jsonObject.getString("province_name"));
            setDistrict_name(jsonObject.getString("district_name"));
            setAddress_google(jsonObject.getString("address_google"));
            setPlace_name(jsonObject.getString("place_name"));
            setPlace_image(jsonObject.getString("place_image"));
            setStatus(jsonObject.getString("status"));
        }catch (Exception e){
       //     HopeLog.e(e);
        }
    }
}
