package org.zerock.stock.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.stock.domain.Stock;
import org.zerock.stock.repository.StockRepository;

@Service
public class PessimisticLockStockService {

    private final StockRepository stockRepository;

    public PessimisticLockStockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Transactional
    public void decrease(Long id, Long quantity){
        // Stock 조회
        Stock stock = stockRepository.findByIdWithPessimisticLock(id);

        // 재고를 감소시킨다.
        stock.decrease(quantity);

        // 갱신
        stockRepository.save(stock);
    }
}
