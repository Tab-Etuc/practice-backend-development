package tw.edu.ntub.imd.birc.practice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResult<T> {
    @com.fasterxml.jackson.annotation.JsonProperty("content")
    private List<T> data;
    @com.fasterxml.jackson.annotation.JsonProperty("totalElements")
    private long totalDataCount;
    @com.fasterxml.jackson.annotation.JsonProperty("totalPages")
    private int totalPage;

    public static <T> PageResult<T> of(List<T> data, long totalDataCount, int totalPage) {
        return new PageResult<>(data, totalDataCount, totalPage);
    }
}
