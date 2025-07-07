package org.zerock.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zerock.stock.domain.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

}
