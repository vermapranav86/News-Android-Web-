/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PKGJava;

/**
 *
 * @author sawan
 */
public class NewsData {

    public String urlToImage = "";
    public String title = "";
    public String autor = "";
    public String url = "";
    public String date = "";

    public NewsData(String urlToImage,
            String title,
            String autor,
            String url,
            String date) {
        if (urlToImage == null) {
            urlToImage = "https://st.depositphotos.com/1006899/3776/i/950/depositphotos_37765339-stock-photo-news.jpg";
        }
        if (title == null) {
            title = " ";
        }
        if (autor == null) {
            autor = "Internet";
        }
        if (date == null) {
            date = "TODAY";
        }
        if (url == null) {
            url = "https://st.depositphotos.com/1006899/3776/i/950/depositphotos_37765339-stock-photo-news.jpg";
        }
        this.autor = autor;
        this.date = date;
        this.title = title;
        this.url = url;
        this.urlToImage = urlToImage;
    }

}
