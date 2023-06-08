package com.minegoldminegone.minegoldminegone.repository;

import org.springframework.stereotype.Service;
import com.minegoldminegone.minegoldminegone.model.FtSearchHistory;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Service
public interface FtSearchHistoryRepository extends JpaRepository<FtSearchHistory, String> {
  String queryFtSuggestSearchDto = 
    "SELECT "
    + "    id, "
    + "    search_text "
    + "FROM "
    + "    ft_search_history "
    + "ORDER BY id DESC "
    + "LIMIT :setlimit OFFSET :setoffset "
    + "; ";
  @Query(value = queryFtSuggestSearchDto, nativeQuery = true)
  public List<Object[]> fetchFtSuggestSearchDto(@Param("setlimit") int limit, @Param("setoffset") int offset);
}
