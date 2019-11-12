package ssm.domain;

public class Page {

    private int totalCounts;//一共多少条
    private int pageSize=6;//页面显示行数
    private int currentPage=1;//当前页面
    private int pageCount;//页面总数
    private int beginIndex;//查询开始值

    public Page(int totalCounts) {
        this.totalCounts = totalCounts;
    }

    public int getTotalCounts() {
        return totalCounts;
    }
    public void setTotalCounts(int totalCounts) {
        this.totalCounts = totalCounts;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public int getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    public int getPageCount() {
        return pageCount;
    }
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    public int getBeginIndex() {
        return beginIndex;
    }
    public void setBeginIndex(int beginIndex) {
        this.beginIndex = beginIndex;
    }

    @Override
    public String toString() {
        return "Page [pageSize=" + pageSize + ", currentPage=" + currentPage + ", pageCount=" + pageCount
                + ", beginIndex=" + beginIndex + ", totalCounts=" + totalCounts + "]";
    }
}
