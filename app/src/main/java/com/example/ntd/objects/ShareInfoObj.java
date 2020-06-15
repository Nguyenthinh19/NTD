package com.example.ntd.objects;

import org.json.JSONObject;

/**
 * Created by TuanLA on 5/29/2017.
 */
public class ShareInfoObj extends BaseObject {
    private String url;
    private String image;
    private String title;
    private String description;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void parseJsonToObject(JSONObject jsonObject) {
        try {
            setUrl(jsonObject.getString("url"));
            setImage(jsonObject.getString("image"));
            setTitle(jsonObject.getString("title"));
            setDescription(jsonObject.getString("description"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
