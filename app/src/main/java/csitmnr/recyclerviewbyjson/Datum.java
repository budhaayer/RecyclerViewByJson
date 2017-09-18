
package csitmnr.recyclerviewbyjson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("intro")
    @Expose
    private String intro;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("date_en")
    @Expose
    private String dateEn;
    @SerializedName("date_np")
    @Expose
    private String dateNp;

    public Datum(Integer id, String title, String image, String intro, String author, String dateEn, String dateNp) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.intro = intro;
        this.author = author;
        this.dateEn = dateEn;
        this.dateNp = dateNp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDateEn() {
        return dateEn;
    }

    public void setDateEn(String dateEn) {
        this.dateEn = dateEn;
    }

    public String getDateNp() {
        return dateNp;
    }

    public void setDateNp(String dateNp) {
        this.dateNp = dateNp;
    }

}
