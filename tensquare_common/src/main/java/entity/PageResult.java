package entity;

import java.util.List;

/**
 * 分页结果集
 * @param <T>
 */
public class PageResult<T> {

    private Long total;//总记录数
    private List<T> rows;//总条数(具体)

    public PageResult(Long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
