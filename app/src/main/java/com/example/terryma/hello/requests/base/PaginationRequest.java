package com.example.terryma.hello.requests.base;

/**
 * 分页请求对象
 * Created by terryma on 16/12/9.
 */

public class PaginationRequest extends OrderByRequest {

    public PaginationRequest() {
    }

    public PaginationRequest(PaginationRequest request) {
        this.setIsPageable(request.getIsPageable());
        this.setCurrentPage(request.getCurrentPage());
        this.setRecordsPerPage(request.getRecordsPerPage());
        this.setOrderByField(request.getOrderByField());
        this.setOrderByMethod(request.getOrderByMethod());
    }

    /**
     * 是否分页
     */
    private boolean isPageable = true;

    /**
     * 当前页码
     */
    private int currentPage = 1;

    /**
     * 每页记录数
     */
    private int recordsPerPage = 20;

    public boolean getIsPageable() {
        return isPageable;
    }

    public void setIsPageable(boolean pageable) {
        isPageable = pageable;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getRecordsPerPage() {
        return recordsPerPage;
    }

    public void setRecordsPerPage(int recordsPerPage) {
        this.recordsPerPage = recordsPerPage;
    }
}
