package io.bitcoinlab.xchange.korbit.service;

import io.bitcoinlab.xchange.korbit.KorbitAdapters;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.OrderBook;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.dto.marketdata.Trades;
import org.knowm.xchange.exceptions.ExchangeException;
import org.knowm.xchange.exceptions.NotAvailableFromExchangeException;
import org.knowm.xchange.exceptions.NotYetImplementedForExchangeException;
import org.knowm.xchange.service.marketdata.MarketDataService;

import java.io.IOException;

/**
 *
 */
public class KorbitDataService extends KorbitDataServiceRaw implements MarketDataService {


    /**
     * Constructor
     *
     * @param exchange
     */
    public KorbitDataService(Exchange exchange) {
        super(exchange);
    }

    @Override
    public Ticker getTicker(CurrencyPair currencyPair, Object... args) throws ExchangeException, NotAvailableFromExchangeException, NotYetImplementedForExchangeException, IOException {
        return KorbitAdapters.adaptTicker(getKorbitTicker(currencyPair), currencyPair);
    }

    @Override
    public OrderBook getOrderBook(CurrencyPair currencyPair, Object... args) throws ExchangeException, NotAvailableFromExchangeException, NotYetImplementedForExchangeException, IOException {
        return KorbitAdapters.adaptOrderBook(getKorbitOrderBook(currencyPair), currencyPair);
    }

    @Override
    public Trades getTrades(CurrencyPair currencyPair, Object... args) throws ExchangeException, NotAvailableFromExchangeException, NotYetImplementedForExchangeException, IOException {
        throw new UnsupportedOperationException("Not implemented");
    }
}
