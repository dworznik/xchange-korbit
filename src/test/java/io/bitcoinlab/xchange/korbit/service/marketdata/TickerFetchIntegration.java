package io.bitcoinlab.xchange.korbit.service.marketdata;

import io.bitcoinlab.xchange.korbit.KorbitExchange;
import org.junit.Test;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.service.marketdata.MarketDataService;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 *
 */
public class TickerFetchIntegration {

    @Test
    public void tickerFetchTestBTC() throws Exception {
        Exchange exchange = ExchangeFactory.INSTANCE.createExchange(KorbitExchange.class.getName());
        MarketDataService marketDataService = exchange.getMarketDataService();
        Ticker ticker = marketDataService.getTicker(new CurrencyPair("BTC", "KRW"));
        System.out.println(ticker.toString());
        assertThat(ticker).isNotNull();
    }

    @Test
    public void tickerFetchTestETH() throws Exception {
        Exchange exchange = ExchangeFactory.INSTANCE.createExchange(KorbitExchange.class.getName());
        MarketDataService marketDataService = exchange.getMarketDataService();
        Ticker ticker = marketDataService.getTicker(new CurrencyPair("ETH", "KRW"));
        System.out.println(ticker.toString());
        assertThat(ticker).isNotNull();
    }
}
