package io.bitcoinlab.xchange.korbit.service.marketdata;

import io.bitcoinlab.xchange.korbit.KorbitExchange;
import org.junit.Test;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.OrderBook;
import org.knowm.xchange.service.marketdata.MarketDataService;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 *
 */
public class OrderBookFetchIntegration {

    @Test
    public void orderBookFetchTestBTC() throws Exception {
        Exchange exchange = ExchangeFactory.INSTANCE.createExchange(KorbitExchange.class.getName());
        MarketDataService marketDataService = exchange.getMarketDataService();
        OrderBook orders = marketDataService.getOrderBook(new CurrencyPair("BTC", "KRW"));
        System.out.println(orders.toString());
        assertThat(orders).isNotNull();
    }

    @Test
    public void orderBookFetchTestETH() throws Exception {
        Exchange exchange = ExchangeFactory.INSTANCE.createExchange(KorbitExchange.class.getName());
        MarketDataService marketDataService = exchange.getMarketDataService();
        OrderBook orders = marketDataService.getOrderBook(new CurrencyPair("ETH", "KRW"));
        System.out.println(orders.toString());
        assertThat(orders).isNotNull();
    }
}
