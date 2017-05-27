package io.bitcoinlab.xchange.korbit.service;

import io.bitcoinlab.xchange.korbit.dto.marketdata.KorbitOrderBook;
import io.bitcoinlab.xchange.korbit.dto.marketdata.KorbitTicker;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.currency.CurrencyPair;

import java.io.IOException;

/**
 *
 */
public class KorbitDataServiceRaw extends KorbitBaseService {
    /**
     * Constructor
     *
     * @param exchange
     */
    protected KorbitDataServiceRaw(Exchange exchange) {
        super(exchange);
    }


    public KorbitTicker getKorbitTicker(CurrencyPair currencyPair) throws IOException {
        return korbit.getTicker(currencyPair.base.getCurrencyCode().toLowerCase() + "_" + currencyPair.counter.getCurrencyCode().toLowerCase());
    }

    public KorbitOrderBook getKorbitOrderBook(CurrencyPair currencyPair) throws IOException {

        return korbit.getOrderBook(currencyPair.base.getCurrencyCode().toLowerCase() + "_" + currencyPair.counter.getCurrencyCode().toLowerCase());
    }

}
