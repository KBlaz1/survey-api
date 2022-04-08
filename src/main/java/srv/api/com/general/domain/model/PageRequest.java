package srv.api.com.general.domain.model;

/**
 * Class contains page number and size
 */
public class PageRequest {

    /**
     * Page number
     */
    private int pageNumber;

    /**
     * Page size
     */
    private int pageSize;

    private PageRequest(int pageNumber, int pageSize) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }

    public static PageRequest create(int pageNumber, int pageSize) {
        return new PageRequest(pageNumber, pageSize);
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "PageRequest{" +
                "pageNumber=" + pageNumber +
                ", pageSize=" + pageSize +
                '}';
    }
}
