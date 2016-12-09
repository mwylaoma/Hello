package com.example.terryma.hello.response.base;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * Created by terryma on 16/12/9.
 */

public class Page<T> implements Serializable {
    private List<T> data;
    private int currentPage;
    private int recordsPerPage;
    private int totalPages;
    private int totalRecords;

    public Page() {
    }

    public Page(List<T> data, int currentPage, int recordsPerPage, int totalPages, int totalRecords) {
        this.data = data;
        this.currentPage = currentPage;
        this.recordsPerPage = recordsPerPage;
        this.totalPages = totalPages;
        this.totalRecords = totalRecords;
    }

    public static <T> Page<T> blankPage(int currentPage, int recordsPerPage) {
        return new Page(Collections.EMPTY_LIST, currentPage, recordsPerPage, 0, 0);
    }

    public List<T> getData() {
        return this.data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getRecordsPerPage() {
        return this.recordsPerPage;
    }

    public void setRecordsPerPage(int recordsPerPage) {
        this.recordsPerPage = recordsPerPage;
    }

    public int getTotalPages() {
        return this.totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalRecords() {
        return this.totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public boolean getHasNext() {
        return this.totalPages > this.currentPage;
    }
}
