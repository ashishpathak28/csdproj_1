package com.example.csdproj_1;

public class pic_data {

    int img_res;
    String img_caption;

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    String Description;

    public pic_data(int img_res, String img_caption,String description) {
        this.img_res = img_res;
        this.img_caption = img_caption;
        this.Description = description;
    }

    public int getImg_res() {
        return img_res;
    }

    public void setImg_res(int img_res) {
        this.img_res = img_res;
    }

    public String getImg_caption() {
        return img_caption;
    }

    public void setImg_caption(String img_caption) {
        this.img_caption = img_caption;
    }
}
