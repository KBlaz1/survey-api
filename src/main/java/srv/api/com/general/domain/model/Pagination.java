package srv.api.com.general.domain.model;

import javax.ws.rs.core.Link;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

/**
 * Class is used for creating links between pages
 */
public class Pagination {

    /**
     * Creates link between pages to form a pagination
     *
     * @param page    number of the page
     * @param size    size of the page
     * @param count   number of elements in the table
     * @param uriInfo the Uri info for the page
     * @return Hypermedia links
     */
    public static Link[] paginationLinks(int page, int size, long count, UriInfo uriInfo) {
        int firstPage = (count == 0) ? 0 : 1;
        int lastPage = (int) (count + size - 1) / size;
        int currentPage = Math.min(page, lastPage);
        int next = (currentPage == lastPage) ? lastPage : (page + 1);
        int previous = (page == firstPage) ? firstPage : (page >= lastPage) ? ((lastPage == firstPage) ? firstPage : lastPage - 1) : (page - 1);

        int[] navigationPages = {firstPage, lastPage, next, previous, currentPage};
        String[] navigationRel = {"first", "last", "next", "previous", "current"};
        Link[] links = new Link[5];

        for (int i = 0; i < 5; i++) {
            UriBuilder firstLinkBuilder = uriInfo.getAbsolutePathBuilder();
            firstLinkBuilder.queryParam("page", navigationPages[i]);
            firstLinkBuilder.queryParam("size", size);
            links[i] = Link.fromUri(firstLinkBuilder.build()).rel(navigationRel[i]).build();
        }

        return links;
    }

    /**
     * Finds the total number of pages
     *
     * @param size  size of the page
     * @param count number of elements
     * @return number of pages
     */
    public static int totalPages(int size, long count) {
        return (int) (count + size - 1) / size;
    }
}

