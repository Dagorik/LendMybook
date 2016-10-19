package com.lendmybook.dagorik.lendmybook.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dagorik on 17/10/2016.
 */

public class BookArray {

//    @SerializedName("array")
//    private List<BookArray> listaBook;

//    public List<BookArray> getListaBook() {
//        return listaBook;
//    }
//
//    public void setListaBook(List<BookArray> listaBook) {
//        this.listaBook = listaBook;
//    }


        //WITH SCHEMA POJO

    @SerializedName("id_base_book")
    private int idBaseBook;
    @SerializedName("title")
    private String title;
    @SerializedName("author")
    private String author;
    @SerializedName("description")
    private String description;
    @SerializedName("image_url")
    private String imageUrl;
    @SerializedName("isbn")
    private String isbn;
    @SerializedName("categories")
    private List<String> categories = new ArrayList<String>();

    /**
     *
     * @return
     * The idBaseBook
     */
    public int getIdBaseBook() {
        return idBaseBook;
    }

    /**
     *
     * @param idBaseBook
     * The id_base_book
     */
    public void setIdBaseBook(int idBaseBook) {
        this.idBaseBook = idBaseBook;
    }

    /**
     *
     * @return
     * The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The author
     */
    public String getAuthor() {
        return author;
    }

    /**
     *
     * @param author
     * The author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     *
     * @return
     * The description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     * The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     * The imageUrl
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     *
     * @param imageUrl
     * The image_url
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     *
     * @return
     * The isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     *
     * @param isbn
     * The isbn
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     *
     * @return
     * The categories
     */
    public List<String> getCategories() {
        return categories;
    }

    /**
     *
     * @param categories
     * The categories
     */
    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "BookArray{" +
                "idBaseBook=" + idBaseBook +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", isbn='" + isbn + '\'' +
                ", categories=" + categories +
                '}';
    }
}
